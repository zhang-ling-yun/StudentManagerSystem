package com.gdedu.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.gdedu.model.SCView;
import com.gdedu.util.JdbcUtil;
import com.gdedu.util.OracleHelper;

/**
 *
 * ��Ŀ���ƣ�School-Oracle �����ƣ�SCViewDao �������� �����ˣ�ASUS ����ʱ�䣺2017��7��10�� ����4:47:16
 * �޸��ˣ�ASUS �޸�ʱ�䣺2017��7��10�� ����4:47:16 �޸ı�ע��
 * 
 * @version
 *
 */
public class SCViewDao {

	//����������Ը��ݴ�������ѧ��������ѯSCView��ͼ������һ������SCView����
	public static List<SCView> querySCViewBySname(String sname) {
		List<SCView> list = new ArrayList<SCView>();
		ResultSet rs = null;
		String sql = "select *from SCView where sname like ?";
		Object[] paramters = new Object[] { sname + "%" };
		try {
			rs = OracleHelper.query(sql, paramters);
			while (rs.next()) {
				SCView scView = new SCView();
				scView.setCno(rs.getString("cno"));
				scView.setCname(rs.getString("cname"));
				scView.setSno(rs.getString("sno"));
				scView.setSname(rs.getString("sname"));
				scView.setTname(rs.getString("tname"));
				scView.setCcredit(rs.getInt("ccredit"));
				scView.setGrade(rs.getInt("grade"));
				list.add(scView);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.free(OracleHelper.getConn(), OracleHelper.getPreparedStatement(), rs);
		}
		return list;
	}

	//ͨ��ѧ���źͿγ����Ʋ�ѯSCView��ͼ������ѧ����δѡ�޵����пγ̣���SCView���󱣴�
	public static List<SCView> queryHadNotSelectedCourse(String sno, String cname) {
		List<SCView> list = new ArrayList<SCView>();
		ResultSet rs = null;
		String sql = "select cno,cname,ccredit,tname from course,teacher where cno in (select cno from course minus select cno from SCView where sno=? ) and course.tno=teacher.tno and cname like ?";
		Object[] paramters = new Object[] { sno, cname + "%" };
		try {
			rs = OracleHelper.query(sql, paramters);
			while (rs.next()) {
				SCView scView = new SCView();
				scView.setCno(rs.getString("cno"));
				scView.setCname(rs.getString("cname"));
				scView.setCcredit(rs.getInt("ccredit"));
				scView.setTname(rs.getString("tname"));
				list.add(scView);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.free(OracleHelper.getConn(), OracleHelper.getPreparedStatement(), rs);
		}
		return list;
	}

	//ͨ��ѧ�źͿγ����Ʒ����Ѿ�ѡ�޵Ŀγ̣���SCView���������
	public static List<SCView> queryHadSelectedCourse(String sno, String cname) {
		List<SCView> list = new ArrayList<SCView>();
		ResultSet rs = null;
		String sql = "select cno,cname,ccredit,grade from SCView where sno=? and cname like ?";
		Object[] paramters = new Object[] { sno, cname + "%" };
		try {
			rs = OracleHelper.query(sql, paramters);
			while (rs.next()) {
				SCView scView = new SCView();
				scView.setCno(rs.getString("cno"));
				scView.setCname(rs.getString("cname"));
				scView.setCcredit(rs.getInt("ccredit"));
				scView.setGrade(rs.getInt("grade"));
				list.add(scView);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.free(OracleHelper.getConn(), OracleHelper.getPreparedStatement(), rs);
		}
		return list;
	}

	//����SCView��ͼ��ͨ��SCView�����е���Ϣ�޸Ķ�Ӧѧ���ĳɼ�
	public static int updateSCView(SCView scView) {
		int result = 0;
		String sql = "update SCView set grade=? where sno=? and cno=?";
		Object[] paramters = new Object[] { scView.getGrade(), scView.getSno(), scView.getCno() };
		try {
			result = OracleHelper.update(sql, paramters);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.free(OracleHelper.getConn(), OracleHelper.getPreparedStatement(), null);
		}
		return result;
	}

	//ɾ��ѧ����һ��ѡ����Ϣ
	public static boolean deleteSCView(SCView scView) {
		boolean result = true;
		String sql = "delete from SCView where sno=? and cno=?";
		Object[] paramters = new Object[] { scView.getSno(), scView.getCno() };
		try {
			result = OracleHelper.delete(sql, paramters);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.free(OracleHelper.getConn(), OracleHelper.getPreparedStatement(), null);
		}
		return result;
	}

	//����ѧ��ѡ����Ϣ���ɼ�Ĭ��Ϊ0
	public static boolean insertSCView(SCView scView) {
		boolean result = true; // true��ʾ�����ݷ���,false��ʾû�����ݷ��ػ���ֻ�Ƿ��ظ��µ���Ŀ
		String sql = "insert into sc(sno,cno,grade) values(?,?,0)";
		Object[] paramters = new Object[] { scView.getSno(), scView.getCno() };
		try {
			result = OracleHelper.insert(sql, paramters);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.free(OracleHelper.getConn(), OracleHelper.getPreparedStatement(), null);
		}
		return result;
	}
}
