package yongs.temp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import yongs.temp.vo.FileInfo;

public interface FileInfoMapper {
	public List<FileInfo> selectFileInfos();
	public String selectMaxSeq();
	public FileInfo selectFileInfo(@Param("seq") String seq);
	public void insertFileInfo(@Param("fileInfo") FileInfo fileInfo);
	public void updateCount(@Param("seq") String seq);
	public void deleteFileInfo(@Param("seq") String seq);	
}
