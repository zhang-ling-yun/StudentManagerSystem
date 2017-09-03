package com.gdedu.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.gdedu.model.Student;
import com.gdedu.util.JdbcUtil;
import com.gdedu.util.OracleHelper;

/**
 *
 * ��Ŀ���ƣ�School-Oracle �����ƣ�StudentDao �������� �����ˣ�ASUS ����ʱ�䣺2017��7��9�� ����3:38:45
 * �޸��ˣ�ASUS �޸�ʱ�䣺2017��7��9�� ����3:38:45 �޸ı�ע��
 * 
 * @version
 *
 */
public class StudentDao {
	//ͨ��ѧ�ŷ���һ��ѧ������
	public static Student queryStudentBySno(String sno){
		ResultSet rs=null;
		String sql="select sno,sname,ssex,sage,spwd from student where sno=?";
		Student result=null;
		Object[]paramters=new Object[]{sno};
		try {
			rs=OracleHelper.query(sql, paramters);
			if (rs.next()) {
				result=new Student();
				result.setSno(rs.getString("sno"));
				result.setSname(rs.getString("sname"));
				result.setSage(rs.getInt("sage"));
				result.setSsex(rs.getString("ssex"));
				result.setSpwd(rs.getString("spwd"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.free(OracleHelper.getConn(), OracleHelper.getPreparedStatement(), null);
		}
		return result;
	}
	//����ѧ���������ض��ѧ������
	public static List<Student> queryStudents(String sname){
		List<Student>list=new ArrayList<Student>();
		ResultSet rs=null;
		String sql="select sno,sname,ssex,sage,spwd from student where sname like ?";
		Object[]paramters=new Object[]{sname+"%"};
		try {
			rs=OracleHelper.query(sql, paramters);
			while (rs.next()) {
				Student student=new Student();
				student.setSno(rs.getString("sno"));
				student.setSname(rs.getString("sname"));
				student.setSsex(rs.getString("ssex"));
				student.setSage((rs.getInt("sage")));
				student.setSpwd(rs.getString("spwd"));
				list.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.free(OracleHelper.getConn(), OracleHelper.getPreparedStatement(), rs);
		}
		return list;
	}
	//����һ��ѧ������(true��ʾ�����ݷ���,false��ʾû�����ݷ��ػ���ֻ�Ƿ��ظ��µ���Ŀ)
	public static boolean insertStudent(Student student){		
		boolean result=true; 
		String sql="insert into student(sno,sname,ssex,sage,spwd) values (?,?,?,?,?)";
	    Object[]paramters=new Object[]{student.getSno(),student.getSname(),student.getSsex(),student.getSage(),student.getSpwd()};		
		try {
			result=OracleHelper.insert(sql, paramters);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.free(OracleHelper.getConn(), OracleHelper.getPreparedStatement(), null);
		}
	    return result;
	}
	//����ѧ��ɾ��һ��ѧ������
	public static boolean deleteStudent(String sno){
		boolean result=true;
		String sql="delete from student where sno=?";
		Object[]paramters=new Object[]{sno};
		try {
			result=OracleHelper.delete(sql, paramters);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.free(OracleHelper.getConn(), OracleHelper.getPreparedStatement(), null);
		} 
		return result;
	}
	//����һ��ѧ������
	public static int updateStudent(Student student){
		int result=0;
		String sql="update student set sname=?,ssex=?,sage=?,spwd=? where sno=?";
		Object[]paramters=new Object[]{student.getSname(),student.getSsex(),student.getSage(),student.getSpwd(),student.getSno()};
		try {
			result=OracleHelper.update(sql, paramters);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
