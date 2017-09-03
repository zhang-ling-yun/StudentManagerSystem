package com.gdedu.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.gdedu.model.Teacher;
import com.gdedu.util.JdbcUtil;
import com.gdedu.util.OracleHelper;

/**
 *
 * ��Ŀ���ƣ�School-Oracle �����ƣ�TeacherDao �������� �����ˣ�ASUS ����ʱ�䣺2017��7��10�� ����9:24:09
 * �޸��ˣ�ASUS �޸�ʱ�䣺2017��7��10�� ����9:24:09 �޸ı�ע��
 * 
 * @version
 *
 */
public class TeacherDao {

	//ͨ���̹��ŷ���һ��������ʦ����
	//�����ȡ��ʦ������û�н���ȡ����ͻ�ȡһ���ֿ�����ȡ����ͻ�ȡһ��ʹ��ͬһ������
	public static List<String> queryTeacherNames(String tno){
		List<String>list=new ArrayList<String>();
		ResultSet rs=null;
		String sql="select tname from teacher where tno like ?";
		Object[]paramters=new Object[]{tno+"%"};
		try {
			rs=OracleHelper.query(sql, paramters);
			while (rs.next()) {
				list.add(rs.getString("tname"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.free(OracleHelper.getConn(), OracleHelper.getPreparedStatement(), rs);
		}
		return list;
	}
	//ͨ����ʦ�������ض��Teacher����
	public static List<Teacher> queryTeacher(String tname){
		List<Teacher>list=new ArrayList<Teacher>();
		ResultSet rs=null;
		String sql="select tno,tname,tjobtitle,tsalary,tpwd from teacher where tname like ?";
		Object[]paramters=new Object[]{tname+"%"};
		try {
			rs=OracleHelper.query(sql, paramters);
			while (rs.next()) {
				Teacher teacher=new Teacher();
				teacher.setTno(rs.getString("tno"));
				teacher.setTname(rs.getString("tname"));
				teacher.setTjobtitle(rs.getString("tjobtitle"));
				teacher.setTsalary(rs.getInt("tsalary"));
				teacher.setTpwd(rs.getString("tpwd"));
				list.add(teacher);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.free(OracleHelper.getConn(), OracleHelper.getPreparedStatement(), rs);
		}
		return list;
	}
	//ͨ����ʦ�������ؽ̹���
	public static Object getTnoByTname(String tname){
		Object result = null;
		String sql="select tno from teacher where tname=?";
		Object[]paramters=new Object[]{tname};
		try {
			result=OracleHelper.getSingle(sql, paramters);
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		return result;
	}
	//����һ����ʦ����
	public static boolean insertTeacher(Teacher teacher){		
		boolean result=true; //true��ʾ�����ݷ���,false��ʾû�����ݷ��ػ���ֻ�Ƿ��ظ��µ���Ŀ
		String sql="insert into teacher(tno,tname,tjobtitle,tsalary,tpwd) values (?,?,?,?,?)";
	    Object[]paramters=new Object[]{teacher.getTno(),teacher.getTname(),teacher.getTjobtitle(),teacher.getTsalary(),teacher.getTpwd()};		
		try {
			result=OracleHelper.insert(sql, paramters);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.free(OracleHelper.getConn(), OracleHelper.getPreparedStatement(), null);
		}
	    return result;
	}
	//ɾ��һ����ʦ����
	public static boolean deleteTeacher(String tno){
		boolean result=true;
		String sql="delete from teacher where tno=?";
		Object[]paramters=new Object[]{tno};
		try {
			result=OracleHelper.delete(sql, paramters);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.free(OracleHelper.getConn(), OracleHelper.getPreparedStatement(), null);
		} 
		return result;
	}
	//����һ����ʦ����
	public static int updateTeacher(Teacher teacher){
		int result=0;
		String sql="update teacher set tname=?,tjobtitle=?,tsalary=?,tpwd=? where tno=?";
		Object[]paramters=new Object[]{teacher.getTname(),teacher.getTjobtitle(),teacher.getTsalary(),teacher.getTpwd(),teacher.getTno()};
		try {
			result=OracleHelper.update(sql, paramters);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
