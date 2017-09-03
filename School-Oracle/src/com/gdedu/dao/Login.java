package com.gdedu.dao;

import java.math.BigDecimal;
import java.sql.SQLException;
import com.gdedu.util.OracleHelper;

/**
 *
 * 项目名称：java-oracle 类名称：Login 类描述： 创建人：ASUS 创建时间：2017年7月6日 下午11:53:51 修改人：ASUS
 * 修改时间：2017年7月6日 下午11:53:51 修改备注：
 * 
 * @version
 *
 */
public class Login {
	//登录的用户名
	public static String username;
	//通过教工号和教工密码判断是否是管理员
	public static int loginByManager(String tno,String password){
		int result=0;
		Object object=null;
		String sql="select tmanager from teacher where tno=? and tpwd=?";
		Object []paramters=new Object[]{tno,password};
		try {
			object=OracleHelper.getSingle(sql, paramters);
			if (object!=null) {
				result=((BigDecimal)object).intValue();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	//通过学生号和学生密码判断是否存在此人，result为空表示不存在
	public static Object loginByPublic(String sno,String password){
		Object result=null;
		String sql="select sno from student where sno=? and spwd=?";
		Object []paramters=new Object[]{sno,password};
		try {
			result=OracleHelper.getSingle(sql, paramters);
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		return result;
	}
}
