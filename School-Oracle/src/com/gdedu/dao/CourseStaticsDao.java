package com.gdedu.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gdedu.model.CourseStaticsView;
import com.gdedu.util.JdbcUtil;
import com.gdedu.util.OracleHelper;

/**
 *
 * 项目名称：School-Oracle 类名称：CourseStaticsDao 类描述： 创建人：ASUS 创建时间：2017年7月10日
 * 下午5:27:38 修改人：ASUS 修改时间：2017年7月10日 下午5:27:38 修改备注：
 * 
 * @version
 *
 */
public class CourseStaticsDao {

	//查询CourseStaticsView视图，返回多个CourseStaticsView对象
	public static List<CourseStaticsView> queryCourseStaticsView(){
		List<CourseStaticsView> list=new ArrayList<CourseStaticsView>();
		ResultSet rs=null;
		String sql="select cno,cname,avgGrade,maxGrade,minGrade from courseStaticsView";
		try {
			rs=OracleHelper.query(sql,null);
			while(rs.next()){
				CourseStaticsView courseStaticsView=new CourseStaticsView();
				courseStaticsView.setCno(rs.getString("cno"));
				courseStaticsView.setCname(rs.getString("cname"));
				courseStaticsView.setAvgGrade(rs.getDouble("avgGrade"));
				courseStaticsView.setMaxGrade(rs.getDouble("maxGrade"));
				courseStaticsView.setMinGrade(rs.getDouble("minGrade"));
				list.add(courseStaticsView);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.free(OracleHelper.getConn(), OracleHelper.getPreparedStatement(), rs);
		}
		return list;
	}
}
