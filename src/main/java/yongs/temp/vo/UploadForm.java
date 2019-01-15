package yongs.temp.vo;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class UploadForm {
    private String description;  
    // Upload files.
    private CommonsMultipartFile[] fileDatas;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public CommonsMultipartFile[] getFileDatas() {
		return fileDatas;
	}

	public void setFileDatas(CommonsMultipartFile[] fileDatas) {
		this.fileDatas = fileDatas;
	}
}
