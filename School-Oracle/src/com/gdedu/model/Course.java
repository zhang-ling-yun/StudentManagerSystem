package com.gdedu.model;

/**
 *
 * ��Ŀ���ƣ�java-oracle �����ƣ�Course �������� �����ˣ�ASUS ����ʱ�䣺2017��7��8�� ����9:48:31 �޸��ˣ�ASUS
 * �޸�ʱ�䣺2017��7��8�� ����9:48:31 �޸ı�ע��
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
