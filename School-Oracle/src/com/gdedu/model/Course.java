package com.gdedu.model;

/**
 *
 * 项目名称：java-oracle 类名称：Course 类描述： 创建人：ASUS 创建时间：2017年7月8日 上午9:48:31 修改人：ASUS
 * 修改时间：2017年7月8日 上午9:48:31 修改备注：
 * 
 * @version
 *
 */
public class Course {
	private String cno;
	private String cname;
	private int ccredit;
	private String tno;
	public Course(){}
	public Course(String cno, String cname, int ccredit, String tno) {
		this.cno = cno;
		this.cname = cname;
		this.ccredit = ccredit;
		this.tno = tno;
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
	public int getCcredit() {
		return ccredit;
	}
	public void setCcredit(int ccredit) {
		this.ccredit = ccredit;
	}
	public String getTno() {
		return tno;
	}
	public void setTno(String tno) {
		this.tno = tno;
	}
	
}
