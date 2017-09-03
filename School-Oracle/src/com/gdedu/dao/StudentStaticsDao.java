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
 * ��Ŀ���ƣ�School-Oracle �����ƣ�StudentStaticsDao �������� �����ˣ�ASUS ����ʱ�䣺2017��7��10��
 * ����5:39:40 �޸��ˣ�ASUS �޸�ʱ�䣺2017��7��10�� ����5:39:40 �޸ı�ע��
 * 
 * @version
 *
 */
public class StudentStaticsDao {
	//����ѧ�ŷ���һ������StudentStaticsView��ͼ����
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
