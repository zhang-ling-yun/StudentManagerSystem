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
 * 项目名称：School-Oracle 类名称：SCViewDao 类描述： 创建人：ASUS 创建时间：2017年7月10日 下午4:47:16
 * 修改人：ASUS 修改时间：2017年7月10日 下午4:47:16 修改备注：
 * 
 * @version
 *
 */
public class SCViewDao {

	//这个函数可以根据传进来的学生姓名查询SCView视图并返回一个或多个SCView对象
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

	//通过学生号和课程名称查询SCView视图，返回学生还未选修的所有课程，用SCView对象保存
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

	//通过学号和课程名称返回已经选修的课程，用SCView来保存对象
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

	//更新SCView视图，通过SCView对象中的信息修改对应学生的成绩
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

	//删除学生的一条选课信息
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

	//插入学生选修信息，成绩默认为0
	public static boolean insertSCView(SCView scView) {
		boolean result = true; // true表示有数据返回,false表示没有数据返回或者只是返回更新的数目
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
