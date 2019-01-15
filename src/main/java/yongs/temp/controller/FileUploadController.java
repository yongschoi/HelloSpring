package yongs.temp.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;

import yongs.temp.biz.FileInfoManager;
import yongs.temp.vo.UploadForm;
import yongs.temp.vo.User;

@Controller
public class FileUploadController {
	private static final Logger logger = LoggerFactory.getLogger(FileUploadController.class);
	private static final String UPLOAD_PATH = "D:\\tmp\\upload";
	
    @Autowired
    FileInfoManager fileInfoManager;

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		Object target = dataBinder.getTarget();
		if (target == null) {
			return;
		}
		logger.debug("Target=" + target);

		if (target.getClass() == UploadForm.class) {

			// Register to handle the conversion between the multipart object
			// and byte array.
			dataBinder.registerCustomEditor(byte[].class, new ByteArrayMultipartFileEditor());
		}
	}

	// GET: Show upload form page.
	@RequestMapping(value = "/file/uploadOneFile", method = RequestMethod.GET)
	public String uploadOneFileHandler(Model model) {
		UploadForm myUploadForm = new UploadForm();
		model.addAttribute("uploadForm", myUploadForm);
		return "file/uploadOneFile";
	}

	// GET: Show upload form page.
	@RequestMapping(value = "/file/uploadMultiFile", method = RequestMethod.GET)
	public String uploadMultiFileHandler(Model model) {

		UploadForm myUploadForm = new UploadForm();
		model.addAttribute("uploadForm", myUploadForm);

		// Forward to "/WEB-INF/pages/uploadMultiFile.jsp".
		return "file/uploadMultiFile";
	}

	// POST: Do Upload
	@RequestMapping(value = "/file/uploadMultiFile", method = RequestMethod.POST)
	public String uploadMultiFileHandlerPOST(HttpServletRequest request, 
											 Model model,
											 @ModelAttribute("uploadForm") UploadForm myUploadForm) {

		return this.doUpload(request, model, myUploadForm);
	}

	// POST: Do Upload
	@RequestMapping(value = "/file/uploadOneFile", method = RequestMethod.POST)
	public String uploadOneFileHandlerPOST(HttpServletRequest request, 
										   Model model,
										   @ModelAttribute("uploadForm") UploadForm myUploadForm) {
		
		return this.doUpload(request, model, myUploadForm);

	}

	private String doUpload(HttpServletRequest request, Model model, UploadForm myUploadForm) {
		String description = myUploadForm.getDescription();
		logger.debug("Description: " + description);

		// Root Directory.
		// String uploadRootPath = request.getServletContext().getRealPath("upload");
		String uploadRootPath = UPLOAD_PATH;
		logger.debug("uploadRootPath=" + uploadRootPath);

		File uploadRootDir = new File(uploadRootPath);
		//
		// Create directory if it not exists.
		if (!uploadRootDir.exists()) {
			uploadRootDir.mkdirs();
		}
		CommonsMultipartFile[] fileDatas = myUploadForm.getFileDatas();
		//
		List<File> uploadedFiles = new ArrayList<File>();
		for (CommonsMultipartFile fileData : fileDatas) {
			// Client File Name
			String name = fileData.getOriginalFilename();
			// File Size
			String size = String.valueOf(fileData.getSize());
			// Uploader
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("SESSION_USER");
			String uploader = user.getUserName();
					
			logger.debug("File Name = " + name);
			logger.debug("File Size = " + size);
			logger.debug("Uploader = " + uploader);
				
			// 파일 정보 DB에 저장
			fileInfoManager.insertFileInfo(name, size, uploader);
			
			if (name != null && name.length() > 0) {
				try {
					// Create the file on server
					File serverFile = new File(uploadRootDir.getAbsolutePath() + File.separator + name);

					// Stream to write data to file in server.
					BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
					stream.write(fileData.getBytes());
					stream.close();
		
					uploadedFiles.add(serverFile);
					logger.debug("Write file: " + serverFile);
				} catch (Exception e) {
					logger.debug("Error Write file: " + name);
				}
			}
		}
		model.addAttribute("description", description);
		model.addAttribute("uploadedFiles", uploadedFiles);
		return "file/uploadResult";
	}
}