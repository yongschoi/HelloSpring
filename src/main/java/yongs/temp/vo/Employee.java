package yongs.temp.vo;

import java.io.Serializable;

public class Employee implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String seq;
	private String name;
	private String birthdate;
	private String sex;
	private String telephone;
	private String address;
	private String postal;
	private String joblevelCode;
	private String departmentCode;
	private String skillCode;
	
	public Employee(String seq,
					String name,
					String birthdate,
					String sex,
					String telephone,
					String address,
					String postal,
					String joblevelCode,
					String departmentCode,
					String skillCode) {
		
		this.seq = seq;
		this.name = name;
		this.birthdate = birthdate;
		this.sex = sex;
		this.telephone = telephone;
		this.address = address;
		this.postal = postal;
		this.joblevelCode = joblevelCode;
		this.departmentCode = departmentCode;
		this.skillCode = skillCode;	
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
	public String getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPostal() {
		return postal;
	}
	public void setPostal(String postal) {
		this.postal = postal;
	}
	public String getJoblevelCode() {
		return joblevelCode;
	}
	public void setJoblevelCode(String joblevelCode) {
		this.joblevelCode = joblevelCode;
	}
	public String getDepartmentCode() {
		return departmentCode;
	}
	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}
	public String getSkillCode() {
		return skillCode;
	}
	public void setSkillCode(String skillCode) {
		this.skillCode = skillCode;
	}
}
