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
 * ��Ŀ���ƣ�School-Oracle �����ƣ�TeacherStaticsDao �������� �����ˣ�ASUS ����ʱ�䣺2017��7��10��
 * ����5:49:22 �޸��ˣ�ASUS �޸�ʱ�䣺2017��7��10�� ����5:49:22 �޸ı�ע��
 * 
 * @version
 *
 */
public class TeacherStaticsDao {
	//��ѯteacherStaticsView��ͼ���ض��teacherStaticsView����
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
