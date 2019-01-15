package yongs.temp.vo;

import java.io.Serializable;
import java.sql.Timestamp;

public class FileInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	private String seq;
	private String name;
	private String size;
	private Integer count;
	private String uploader;
	private Timestamp date;	
	
	public FileInfo(String seq, String name, String size, Integer count, String uploader, Timestamp date) {
		this.seq = seq;
		this.name = name;
		this.size = size;
		this.count = count;
		this.uploader = uploader;
		this.date = date;			
	}
	
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getUploader() {
		return uploader;
	}
	public void setUploader(String uploader) {
		this.uploader = uploader;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
}
