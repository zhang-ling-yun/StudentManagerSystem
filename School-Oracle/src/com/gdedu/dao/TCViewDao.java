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
 * 项目名称：School-Oracle 类名称：TCViewDao 类描述： 创建人：ASUS 创建时间：2017年7月10日 上午11:14:48
 * 修改人：ASUS 修改时间：2017年7月10日 上午11:14:48 修改备注：
 * 
 * @version
 *
 */
public class TCViewDao {
	//通过课程名返回一个或多个TCView视图对象
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
