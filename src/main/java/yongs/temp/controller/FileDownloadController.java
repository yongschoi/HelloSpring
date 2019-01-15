package yongs.temp.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import yongs.temp.biz.FileInfoManager;
import yongs.temp.vo.FileInfo;

@Controller
public class FileDownloadController {
	private static final Logger logger = LoggerFactory.getLogger(FileDownloadController.class);
	private static final String DOWNLOAD_PATH = "D:\\tmp\\upload";

    @Autowired
    FileInfoManager fileInfoManager;
    
	// GET: Show upload form page.
	@RequestMapping(value = "/file/list", method = RequestMethod.GET)
	public String fileList(Model model) {
		List<FileInfo> fileList = fileInfoManager.selectFileInfos();		
		model.addAttribute("fileList", fileList);
		
		return "file/list";
	}

	@RequestMapping(value = "/file/delete", method = RequestMethod.POST)
	public String fileDelete(HttpServletRequest req) {
		String[] target = req.getParameterValues("delete");
		
		for(int idx=0; idx <target.length; idx++) {
			// 물리적으로 파일 삭제
			String fileName = fileInfoManager.selectFileInfo(target[idx]).getName();
			File file = new File(DOWNLOAD_PATH + File.separator + fileName);
			logger.debug("file ==================> " + fileName);
			logger.debug("getAbsolutePath ==================> " + file.getAbsolutePath());
			if(file.exists())
				file.delete();
			// 파일 정보 삭제
			fileInfoManager.deleteFileInfo(target[idx]);	
		}
		return "redirect:" + "/file/list";
	}
	
    @RequestMapping("/file/download/{seq}")
    public void downloader(HttpServletRequest request, HttpServletResponse response, @PathVariable("seq") String seq)  throws Exception {
    	// 파일 경로 가져오기
    	FileInfo fileInfo = fileInfoManager.selectFileInfo(seq);
    	String fileName = fileInfo.getName();
    	logger.debug("fileName ==========> " + fileName);
        String encodedFileName = getEncodedFileName(fileName, getBrowser(request));
        logger.debug("encodedFileName ==========> " + encodedFileName);

    	// download count 업데이트
    	fileInfoManager.updateCount(seq);
        try {
            File file = new File(DOWNLOAD_PATH + File.separator + fileName);
            logger.debug("file ::: " + file);
 
            if (file.exists()) {
                response.setContentType("application/octet-stream");
                response.setHeader("Content-Disposition", "attachment; fileName=\"" + encodedFileName +"\";");
                response.setHeader("Content-Transfer-Encoding", "binary");
                response.setContentLength((int) file.length());
                
                OutputStream os = response.getOutputStream();
                FileInputStream fis = new FileInputStream(file);
                byte[] buffer = new byte[4096];
                int b = -1;
 
                while ((b = fis.read(buffer)) != -1) {
                    os.write(buffer, 0, b);
                }
 
                fis.close();
                os.close();
            } else {
            	logger.debug("Requested " + fileName + " file not found!!");
            }
        } catch (IOException e) {
        	logger.error("Error:- " + e.getMessage());
        }
    }
    
    private String getBrowser(HttpServletRequest request) { 
    	String header = request.getHeader("User-Agent"); 
    	logger.debug("header ==========> " + header);
    	if (header.indexOf("MSIE") > -1) { 
    		return "MSIE"; 
    	} else if (header.indexOf("Chrome") > -1) { 
    		return "Chrome"; 
    	} else if (header.indexOf("Opera") > -1) { 
    		return "Opera"; 
    	} else if (header.indexOf("Trident/7.0") > -1){ 
    		//IE 11 이상 //IE 버전 별 체크 >> Trident/6.0(IE 10) , Trident/5.0(IE 9) , Trident/4.0(IE 8) 
    		return "MSIE"; 
    	} 
    	
    	return "Firefox"; 
    }
    
    private String getEncodedFileName(String filename, String browser) throws Exception { 
    	String encodedFilename = null;
    	logger.debug("browser ==========> " + browser);
    	if (browser.equals("MSIE")) { 
    		encodedFilename = URLEncoder.encode(filename, "UTF-8").replaceAll("\\+", "%20"); 
    	} else if (browser.equals("Firefox")) { 
    		// encodedFilename = "\"" + new String(filename.getBytes("UTF-8"), "8859_1") + "\""; 
    		// 57.x 버전에서는 " " 없어야 함.
    		encodedFilename = new String(filename.getBytes("UTF-8"), "8859_1"); 
        } else if (browser.equals("Opera")) { 
    		encodedFilename = "\"" + new String(filename.getBytes("UTF-8"), "8859_1") + "\""; 
    	} else if (browser.equals("Chrome") ) { 
    		StringBuffer sb = new StringBuffer(); 
    		for (int i = 0; i < filename.length(); i++) { 
    			char c = filename.charAt(i); 
    			if (c > '~') { 
    				sb.append(URLEncoder.encode("" + c, "UTF-8")); 
    			} else { 
    				sb.append(c); 
    			} 
    		} 
    		encodedFilename = sb.toString(); 
    	} else { 
    		throw new RuntimeException("Not supported browser"); 
    	} 
     	
    	return encodedFilename; 
    }
}