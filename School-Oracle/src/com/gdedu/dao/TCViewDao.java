package com.gdedu.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.gdedu.model.TCView;
import com.gdedu.util.JdbcUtil;
import com.gdedu.util.OracleHelper;

/**
 *
 * ��Ŀ���ƣ�School-Oracle �����ƣ�TCViewDao �������� �����ˣ�ASUS ����ʱ�䣺2017��7��10�� ����11:14:48
 * �޸��ˣ�ASUS �޸�ʱ�䣺2017��7��10�� ����11:14:48 �޸ı�ע��
 * 
 * @version
 *
 */
public class TCViewDao {
	//ͨ���γ�������һ������TCView��ͼ����
	public static List<TCView> queryTCViewByCname(String cname){
		List<TCView>list=new ArrayList<TCView>();
		ResultSet rs=null;
		String sql="select cno,cname,tno,tname,ccredit from TCView where cname like ?";
		Object[]paramters=new Object[]{cname+"%"};
		try {
			rs=OracleHelper.query(sql, paramters);
			while (rs.next()) {
				TCView tcView=new TCView();
				tcView.setCno(rs.getString("cno"));
				tcView.setCname(rs.getString("cname"));
				tcView.setCcredit(rs.getInt("ccredit"));
				tcView.setTno(rs.getString("tno"));
				tcView.setTname(rs.getString("tname"));
				list.add(tcView);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.free(OracleHelper.getConn(), OracleHelper.getPreparedStatement(), rs);
		}
		return list;
	}			
	
}
