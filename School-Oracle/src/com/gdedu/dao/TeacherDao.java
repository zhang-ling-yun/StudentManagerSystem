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
 * 项目名称：School-Oracle 类名称：TeacherDao 类描述： 创建人：ASUS 创建时间：2017年7月10日 上午9:24:09
 * 修改人：ASUS 修改时间：2017年7月10日 上午9:24:09 修改备注：
 * 
 * @version
 *
 */
public class TeacherDao {

	//通过教工号返回一个或多个教师姓名
	//这里获取教师的姓名没有将获取多个和获取一个分开，获取多个和获取一个使用同一个函数
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
	//通过教师姓名返回多个Teacher对象
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
	//通过教师姓名返回教工号
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
	//插入一个教师对象
	public static boolean insertTeacher(Teacher teacher){		
		boolean result=true; //true表示有数据返回,false表示没有数据返回或者只是返回更新的数目
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
	//删除一个教师对象
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
	//更新一个教师对象
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
