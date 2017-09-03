package com.gdedu.model;

/**
 *
 * 项目名称：java-oracle 类名称：SC 类描述： 创建人：ASUS 创建时间：2017年7月8日 上午10:19:17 修改人：ASUS
 * 修改时间：2017年7月8日 上午10:19:17 修改备注：
 * 
 * @version
 *
 */
public class SCView {
	private String sno;
	private String sname;
	private String cno;
	private String cname;
	private String tname;
	private int grade;
	private int ccredit;
	public SCView(){}
	public SCView(String sno, String sname, String cno, String cname, String tname, int grade, int ccredit) {
		this.sno = sno;
		this.sname = sname;
		this.cno = cno;
		this.cname = cname;
		this.tname = tname;
		this.grade = grade;
		this.ccredit = ccredit;
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
	public String getCno() {
		return cno;
	}
	public void setCno(String cno) {
		this.cno = cno;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public int getCcredit() {
		return ccredit;
	}
	public void setCcredit(int ccredit) {
		this.ccredit = ccredit;
	}
	
}
