package com.gdedu.model;

/**
 *
 * 项目名称：java-oracle 类名称：TeacherStatics 类描述： 创建人：ASUS 创建时间：2017年7月8日 上午10:39:16
 * 修改人：ASUS 修改时间：2017年7月8日 上午10:39:16 修改备注：
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
