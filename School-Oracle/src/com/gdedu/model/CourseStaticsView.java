package com.gdedu.model;

/**
 *
 * ��Ŀ���ƣ�java-oracle �����ƣ�CourseStaticsView �������� �����ˣ�ASUS ����ʱ�䣺2017��7��8��
 * ����10:41:17 �޸��ˣ�ASUS �޸�ʱ�䣺2017��7��8�� ����10:41:17 �޸ı�ע��
 * 
 * @version
 *
 */
public class CourseStaticsView {
	private String cno;
	private String cname;
	private Double avgGrade;
	private Double maxGrade;
	private Double minGrade;
    public CourseStaticsView(){}
	public CourseStaticsView(String cno, String cname, Double avgGrade, Double maxGrade, Double minGrade) {
		this.cno = cno;
		this.cname = cname;
		this.avgGrade = avgGrade;
		this.maxGrade = maxGrade;
		this.minGrade = minGrade;
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
	public Double getAvgGrade() {
		return avgGrade;
	}
	public void setAvgGrade(Double avgGrade) {
		this.avgGrade = avgGrade;
	}
	public Double getMaxGrade() {
		return maxGrade;
	}
	public void setMaxGrade(Double maxGrade) {
		this.maxGrade = maxGrade;
	}
	public Double getMinGrade() {
		return minGrade;
	}
	public void setMinGrade(Double minGrade) {
		this.minGrade = minGrade;
	}	
}
