package com.gdedu.model;

/**
 *
 * 项目名称：java-oracle 类名称：TCView 类描述： 创建人：ASUS 创建时间：2017年7月8日 上午10:03:13 修改人：ASUS
 * 修改时间：2017年7月8日 上午10:03:13 修改备注：
 * 
 * @version
 *
 */
public class TCView {
	private String cno;
	private String cname;
	private String tno;
	private String tname;
	private int ccredit;
	public TCView(){}
	public TCView(String cno, String cname, String tno, String tname, int ccredit) {
		this.cno = cno;
		this.cname = cname;
		this.tno = tno;
		this.tname = tname;
		this.ccredit = ccredit;
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
	public int getCcredit() {
		return ccredit;
	}
	public void setCcredit(int ccredit) {
		this.ccredit = ccredit;
	}	
}
