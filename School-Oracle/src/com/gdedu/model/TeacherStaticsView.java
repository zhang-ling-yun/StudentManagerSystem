package com.gdedu.model;

/**
 *
 * ��Ŀ���ƣ�java-oracle �����ƣ�TeacherStatics �������� �����ˣ�ASUS ����ʱ�䣺2017��7��8�� ����10:39:16
 * �޸��ˣ�ASUS �޸�ʱ�䣺2017��7��8�� ����10:39:16 �޸ı�ע��
 * 
 * @version
 *
 */
public class TeacherStaticsView {
	private String tjobtitle;
	private String tsalary;
	private int tcount;
	public TeacherStaticsView(){}
	public TeacherStaticsView(String tjobtitle, String tsalary, int tcount) {
		this.tjobtitle = tjobtitle;
		this.tsalary = tsalary;
		this.tcount = tcount;
	}
	public String getTjobtitle() {
		return tjobtitle;
	}
	public void setTjobtitle(String tjobtitle) {
		this.tjobtitle = tjobtitle;
	}
	public String getTsalary() {
		return tsalary;
	}
	public void setTsalary(String tsalary) {
		this.tsalary = tsalary;
	}
	public int getTcount() {
		return tcount;
	}
	public void setTcount(int tcount) {
		this.tcount = tcount;
	}
	
}
