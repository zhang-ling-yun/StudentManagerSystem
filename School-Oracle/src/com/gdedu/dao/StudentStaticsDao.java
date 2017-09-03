package com.gdedu.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.gdedu.model.StudentStaticsView;
import com.gdedu.util.JdbcUtil;
import com.gdedu.util.OracleHelper;

/**
 *
 * 项目名称：School-Oracle 类名称：StudentStaticsDao 类描述： 创建人：ASUS 创建时间：2017年7月10日
 * 下午5:39:40 修改人：ASUS 修改时间：2017年7月10日 下午5:39:40 修改备注：
 * 
 * @version
 *
 */
public class StudentStaticsDao {
	//根据学号返回一个或多个StudentStaticsView视图对象
	public static List<StudentStaticsView> queryStudentStaticsView(String sno){
		List<StudentStaticsView> list=new ArrayList<StudentStaticsView>();
		ResultSet rs=null;
		Object[]paramters=new Object[]{sno+"%"};
		String sql="select sno,sname,totalcredit from studentStaticsView where sno like ?";		
		try {
			rs=OracleHelper.query(sql, paramters);
			while(rs.next()){
				StudentStaticsView studentStaticsView=new StudentStaticsView();
				studentStaticsView.setSno(rs.getString("sno"));
				studentStaticsView.setSname(rs.getString("sname"));
				studentStaticsView.setTotalCredit(rs.getInt("totalcredit"));
				list.add(studentStaticsView);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.free(OracleHelper.getConn(), OracleHelper.getPreparedStatement(), rs);
		}
		return list;
	}
}
