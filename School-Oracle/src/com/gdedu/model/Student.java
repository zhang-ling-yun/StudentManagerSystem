package com.gdedu.model;

/**
 *
 * 项目名称：java-oracle 类名称：Student 类描述： 创建人：ASUS 创建时间：2017年7月7日 上午9:21:14 修改人：ASUS
 * 修改时间：2017年7月7日 上午9:21:14 修改备注：
 * 
 * @version
 *
 */
public class Student {
	private String sno;
	private String sname;
	private String ssex;
	private Integer sage;
	private String spwd;
	public Student(){}
	public Student(String sno, String sname, String ssex, Integer sage, String spwd) {
		this.sno = sno;
		this.sname = sname;
		this.ssex = ssex;
		this.sage = sage;
		this.spwd = spwd;
	}
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	public String getSname() {
		return sname;
	}	
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSsex() {
		return ssex;
	}
	public void setSsex(String ssex) {
		this.ssex = ssex;
	}
	public Integer getSage() {
		return sage;
	}
	public void setSage(Integer sage) {
		this.sage = sage;
	}
	public String getSpwd() {
		return spwd;
	}
	public void setSpwd(String spwd) {
		this.spwd = spwd;
	}
	@Override
	public String toString() {
		return "Student [sno=" + sno + ", sname=" + sname + ", ssex=" + ssex + ", sage=" + sage + ", spwd=" + spwd
				+ "]";
	}
}
