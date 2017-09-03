package com.gdedu.dao;

import java.math.BigDecimal;
import java.sql.SQLException;
import com.gdedu.util.OracleHelper;

/**
 *
 * ��Ŀ���ƣ�java-oracle �����ƣ�Login �������� �����ˣ�ASUS ����ʱ�䣺2017��7��6�� ����11:53:51 �޸��ˣ�ASUS
 * �޸�ʱ�䣺2017��7��6�� ����11:53:51 �޸ı�ע��
 * 
 * @version
 *
 */
public class Login {
	//��¼���û���
	public static String username;
	//ͨ���̹��źͽ̹������ж��Ƿ��ǹ���Ա
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
	
	//ͨ��ѧ���ź�ѧ�������ж��Ƿ���ڴ��ˣ�resultΪ�ձ�ʾ������
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
