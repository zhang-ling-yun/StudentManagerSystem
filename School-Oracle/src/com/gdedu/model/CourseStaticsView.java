package com.gdedu.model;

/**
 *
 * 项目名称：java-oracle 类名称：CourseStaticsView 类描述： 创建人：ASUS 创建时间：2017年7月8日
 * 上午10:41:17 修改人：ASUS 修改时间：2017年7月8日 上午10:41:17 修改备注：
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
