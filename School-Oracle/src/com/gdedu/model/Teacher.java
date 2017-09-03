package com.gdedu.model;

/**
 *
 * ��Ŀ���ƣ�java-oracle �����ƣ�Teacher �������� �����ˣ�ASUS ����ʱ�䣺2017��7��8�� ����9:23:51 �޸��ˣ�ASUS
 * �޸�ʱ�䣺2017��7��8�� ����9:23:51 �޸ı�ע��
 * 
 * @version
 *
 */
public class Teacher {
	private String tno;
	private String tname;
	private String tjobtitle;
	private int tsalary;
	private String tpwd;
	public Teacher(){}
	public Teacher(String tno, String tname, String tjobtitle, int tsalary, String tpwd) {
		this.tno = tno;
		this.tname = tname;
		this.tjobtitle = tjobtitle;
		this.tsalary = tsalary;
		this.tpwd = tpwd;
	}
	public String getTno() {
		return tno;
	}
	public void setTno(String tno) {
		this.tno = tno;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getTjobtitle() {
		return tjobtitle;
	}
	public void setTjobtitle(String tjobtitle) {
		this.tjobtitle = tjobtitle;
	}
	public int getTsalary() {
		return tsalary;
	}
	public void setTsalary(int tsalary) {
		this.tsalary = tsalary;
	}
	public String getTpwd() {
		return tpwd;
	}
	public void setTpwd(String tpwd) {
		this.tpwd = tpwd;
	}		       
	
}
