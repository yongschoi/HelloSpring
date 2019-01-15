package yongs.temp.biz;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yongs.temp.mapper.FileInfoMapper;
import yongs.temp.vo.FileInfo;

@Service("fileInfoManager")
public class FileInfoManager {
	private static final Logger logger = LoggerFactory.getLogger(FileInfoManager.class);

	@Autowired
	private FileInfoMapper fileInfoMapper;

	public void insertFileInfo(String name, String size, String uploader) {
		// seq 구하기
		String seq = fileInfoMapper.selectMaxSeq();
		if(seq == null) seq = "10000";
		
		seq = String.valueOf(Integer.parseInt(seq) + 1);
    	Date date = new Date();
    	long time = date.getTime();
        	
        FileInfo fileInfo = new FileInfo(seq, name, size, 0, uploader, new Timestamp(time));		
		fileInfoMapper.insertFileInfo(fileInfo);
	}
	
	public List<FileInfo> selectFileInfos() {
		return fileInfoMapper.selectFileInfos();
	}
	
	public FileInfo selectFileInfo(String seq) {
		return fileInfoMapper.selectFileInfo(seq);
	}
	
	public void updateCount(String seq) {
		fileInfoMapper.updateCount(seq);
	}
	
	public void deleteFileInfo(String seq) {
		fileInfoMapper.deleteFileInfo(seq);
	}
}