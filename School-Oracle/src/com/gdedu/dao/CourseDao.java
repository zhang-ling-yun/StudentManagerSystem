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
 * ��Ŀ���ƣ�School-Oracle �����ƣ�CourseDao �������� �����ˣ�ASUS ����ʱ�䣺2017��7��10�� ����9:48:10
 * �޸��ˣ�ASUS �޸�ʱ�䣺2017��7��10�� ����9:48:10 �޸ı�ע��
 * 
 * @version
 *
 */
public class CourseDao {
	//ͨ���γ������ض���γ̶���
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

	//����һ���γ̶��󲢷���һ��booleanֵ(true��ʾ�����ݷ���,false��ʾû�����ݷ��ػ���ֻ�Ƿ��ظ��µ���Ŀ)
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

	//ͨ���γ̺�����ɾ��һ���γ̶��󲢷���һ��booleanֵ
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

	//����һ���γ̶��󣬷��ظ��µ�������0��ʾû�и���
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
