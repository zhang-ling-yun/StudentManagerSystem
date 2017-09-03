package com.gdedu.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.gdedu.model.TeacherStaticsView;
import com.gdedu.util.JdbcUtil;
import com.gdedu.util.OracleHelper;

/**
 *
 * 项目名称：School-Oracle 类名称：TeacherStaticsDao 类描述： 创建人：ASUS 创建时间：2017年7月10日
 * 下午5:49:22 修改人：ASUS 修改时间：2017年7月10日 下午5:49:22 修改备注：
 * 
 * @version
 *
 */
public class TeacherStaticsDao {
	//查询teacherStaticsView视图返回多个teacherStaticsView对象
	public static List<TeacherStaticsView> queryTeacherStaticsView(){
		List<TeacherStaticsView> list=new ArrayList<TeacherStaticsView>();
		ResultSet rs=null;
		String sql="select tjobtitle,tsalary,tcount from teacherStaticsView";
		try {
			rs=OracleHelper.query(sql,null);
			while(rs.next()){
				TeacherStaticsView teacherStaticsView=new TeacherStaticsView();
				teacherStaticsView.setTjobtitle(rs.getString("tjobtitle"));
				teacherStaticsView.setTsalary(rs.getString("tsalary"));
				teacherStaticsView.setTcount(rs.getInt("tcount"));
				list.add(teacherStaticsView);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.free(OracleHelper.getConn(), OracleHelper.getPreparedStatement(), rs);
		}
		return list;
	}
}
