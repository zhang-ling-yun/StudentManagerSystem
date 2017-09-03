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
 * ��Ŀ���ƣ�School-Oracle �����ƣ�CourseStaticsDao �������� �����ˣ�ASUS ����ʱ�䣺2017��7��10��
 * ����5:27:38 �޸��ˣ�ASUS �޸�ʱ�䣺2017��7��10�� ����5:27:38 �޸ı�ע��
 * 
 * @version
 *
 */
public class CourseStaticsDao {

	//��ѯCourseStaticsView��ͼ�����ض��CourseStaticsView����
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
