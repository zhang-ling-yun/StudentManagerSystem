package com.gdedu.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.gdedu.model.Course;
import com.gdedu.util.JdbcUtil;
import com.gdedu.util.OracleHelper;

/**
 *
 * 项目名称：School-Oracle 类名称：CourseDao 类描述： 创建人：ASUS 创建时间：2017年7月10日 上午9:48:10
 * 修改人：ASUS 修改时间：2017年7月10日 上午9:48:10 修改备注：
 * 
 * @version
 *
 */
public class CourseDao {
	//通过课程名返回多个课程对象
	public static List<Course> queryCourse(String cname) {
		List<Course> list = new ArrayList<Course>();
		ResultSet rs = null;
		String sql = "select cno,cname,ccredit,tno from course where cname like ?";
		Object[] paramters = new Object[] { cname + "%" };
		try {
			rs = OracleHelper.query(sql, paramters);
			while (rs.next()) {
				Course course = new Course();
				course.setCno(rs.getString("cno"));
				course.setCname(rs.getString("cname"));
				course.setCcredit(rs.getInt("ccredit"));
				course.setTno(rs.getString("tno"));
				list.add(course);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.free(OracleHelper.getConn(), OracleHelper.getPreparedStatement(), rs);
		}
		return list;
	}

	//插入一个课程对象并返回一个boolean值(true表示有数据返回,false表示没有数据返回或者只是返回更新的数目)
	public static boolean insertCourse(Course course) {
		boolean result = true; 
		String sql = "insert into Course(cno,cname,ccredit,tno) values (?,?,?,?)";
		Object[] paramters = new Object[] { course.getCno(), course.getCname(), course.getCcredit(), course.getTno() };
		try {
			result = OracleHelper.insert(sql, paramters);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.free(OracleHelper.getConn(), OracleHelper.getPreparedStatement(), null);
		}
		return result;
	}

	//通过课程号主键删除一个课程对象并返回一个boolean值
	public static boolean deleteCourse(String cno) {
		boolean result = true;
		String sql = "delete from course where cno=?";
		Object[] paramters = new Object[] { cno };
		try {
			result = OracleHelper.delete(sql, paramters);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.free(OracleHelper.getConn(), OracleHelper.getPreparedStatement(), null);
		}
		return result;
	}

	//更新一个课程对象，返回更新的条数，0表示没有更新
	public static int updateCourse(Course course) {
		int result = 0;
		String sql = "update course set cname=?,ccredit=?,tno=? where cno=?";
		try {
			Object[] paramters = new Object[] { course.getCname(), course.getCcredit(), course.getTno(),
					course.getCno() };
			result = OracleHelper.update(sql, paramters);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
