package com.gdedu.model;

/**
 *
 * ��Ŀ���ƣ�java-oracle �����ƣ�StudentStaticsView �������� �����ˣ�ASUS ����ʱ�䣺2017��7��8��
 * ����10:43:51 �޸��ˣ�ASUS �޸�ʱ�䣺2017��7��8�� ����10:43:51 �޸ı�ע��
 * 
 * @version
 *
 */
public class StudentStaticsView {
	private String sno;
	private String sname;
	private Integer totalCredit;
	private String cno;
	private String cname;
	private int credit;
	private int grade;
	public StudentStaticsView(){}
	public StudentStaticsView(String sno, String sname, int totalCredit, String cno, String cname, int credit,
			int grade) {
		this.sno = sno;
		this.sname = sname;
		this.totalCredit = totalCredit;
		this.cno = cno;
		this.cname = cname;
		this.credit = credit;
		this.grade = grade;
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
	public Integer getTotalCredit() {
		return totalCredit;
	}
	public void setTotalCredit(int totalCredit) {
		this.totalCredit = totalCredit;
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
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	
}
