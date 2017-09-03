package com.gdedu.util;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * ��Ŀ���ƣ�School-Oracle �����ƣ�OracleHelper �������� �����ˣ�ASUS ����ʱ�䣺2017��7��9�� ����9:34:59
 * �޸��ˣ�ASUS �޸�ʱ�䣺2017��7��9�� ����9:34:59 �޸ı�ע��
 * 
 * @version
 *
 */
public class OracleHelper {
	private static Connection conn = null;
	private static PreparedStatement preparedStatement = null;
	private static CallableStatement callableStatement = null;

	/**
	 * 
	* @Title: getSingle 
	* @Description: ��ȡ��һ�Ľ������MAX/MIN��...
	* @param @param sql  SQL���
	* @param @param paramters  ����Ĳ���
	* @return Object  ��������
	* @author rain 
	* @date 2017��8��16�� ����8:09:38 
	* @version V1.0
	 */
	public static Object getSingle(String sql, Object[] paramters) throws SQLException {
		Object result = null;
		ResultSet rs = null;
		try {
			getPreparedStatement(sql);
			if (paramters != null) {
				for (int i = 0; i < paramters.length; i++) {
					preparedStatement.setObject(i + 1, paramters[i]);
				}
			}
			rs = preparedStatement.executeQuery();
			if (rs.next()) {
				result = rs.getObject(1);
			}
		} catch (SQLException e) {
			throw new SQLException(e);
		}
		return result;
	}

	/**
	 * 
	* @Title: query 
	* @Description: ͨ��������ѯ���ؽ����ResultSet���ⲿ����
	* @param @param SQL���
	* @param @param paramters �������,�޲����ǿ�����null��ʾ
	* @return ResultSet  ��������
	* @author  rain
	* @date 2017��8��16�� ����8:11:35 
	* @version V1.0
	 */
	public static ResultSet query(String sql, Object[] paramters) throws SQLException {
		ResultSet rs = null;
		try {
			getPreparedStatement(sql);
			if (paramters != null) {
				for (int i = 0; i < paramters.length; i++) {
					preparedStatement.setObject(i + 1, paramters[i]);
				}
			}
			rs = preparedStatement.executeQuery();
		} catch (SQLException e) {
			throw new SQLException(e);
		}
		return rs;
	}

	/**
	 * 
	* @Title: update 
	* @Description: ͨ���������²����ظ��µ�����
	* @param @param SQL���
	* @param @param paramters �������,�޲����ǿ�����null��ʾ
	* @return int  ��������
	* @author  rain
	* @date 2017��8��16�� ����8:11:35 
	* @version V1.0
	 */
	public static int update(String sql, Object[] paramters) throws SQLException {
		int result = 0;
		try {
			getPreparedStatement(sql);
			if (paramters != null) {
				for (int i = 0; i < paramters.length; i++) {
					preparedStatement.setObject(i + 1, paramters[i]);
				}
			}
			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			throw new SQLException(e);
		}
		return result;
	}

	/**
	 * 
	* @Title: insert 
	* @Description: ͨ�������������ݲ����ز���ɹ�������ݿⷵ��Ĭ��false��ʾ����ɹ�
	* @param @param SQL���
	* @param @param paramters �������,�޲����ǿ�����null��ʾ
	* @return ResultSet  ��������
	* @author  rain
	* @date 2017��8��16�� ����8:11:35 
	* @version V1.0
	 */
	public static boolean insert(String sql, Object[] paramters) throws SQLException {
		boolean result = true;
		try {
			getPreparedStatement(sql);
			if (paramters != null) {
				for (int i = 0; i < paramters.length; i++) {
					preparedStatement.setObject(i + 1, paramters[i]);
				}
			}
			result = preparedStatement.execute();
		} catch (SQLException e) {
			throw new SQLException(e);
		}
		return result;
	}
	
	/**
	 * 
	* @Title: insertWithReturnPrimeKey 
	* @Description: �������ݲ���������ֵ
	* @param @param sql
	* @param @param paramters  �������,�޲����ǿ�����null��ʾ
	* @return Object    ��������
	* @author rain 
	* @date 2017��8��16�� ����8:17:32 
	* @version V1.0
	 */
	public static Object insertWithReturnPrimeKey(String sql, Object[] paramters) throws SQLException {
		ResultSet rs = null;
		Object result = null;
		try {
			conn = JdbcUtil.getConnection();
			preparedStatement = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			if (paramters != null) {
				for (int i = 0; i < paramters.length; i++) {
					preparedStatement.setObject(i + 1, paramters[i]);
				}
			}
			preparedStatement.execute();
			rs = preparedStatement.getGeneratedKeys();
			if (rs.next()) {
				result = rs.getObject(1);
			}
		} catch (SQLException e) {
			throw new SQLException(e);
		}
		return result;
	}

	/**
	 * 
	* @Title: delete
	* @Description: ͨ������ɾ�����ݲ����سɹ�������ݿⷵ��Ĭ��false��ʾ����ɹ�
	* @param @param SQL���
	* @param @param paramters �������,�޲����ǿ�����null��ʾ
	* @return ResultSet  ��������
	* @author  rain
	* @date 2017��8��16�� ����8:11:35 
	* @version V1.0
	 */
	public static boolean delete(String sql, Object[] paramters) throws SQLException {
		boolean result = true;
		try {
			getPreparedStatement(sql);
			if (paramters != null) {
				for (int i = 0; i < paramters.length; i++) {
					preparedStatement.setObject(i + 1, paramters[i]);
				}
			}
			result = preparedStatement.execute();
		} catch (SQLException e) {
			throw new SQLException(e);
		}
		return result;
	}

    /**
     * 
    * @Title: callableGetSingle 
    * @Description: ���ô洢���̲����ص�һ�Ľ�� 
    * @param @param procedureSql ���ô洢���̵����
    * @param @param inParamters  ������������û�п�����null��ʾ
    * @param @param outparamter  �������������û�п�����null��ʾ
    * @return Object    ��������
    * @author rain 
    * @date 2017��8��16�� ����8:18:27 
    * @version V1.0
     */
	public static Object callableGetSingle(String procedureSql,Object[] inParamters, Integer outparamter) throws SQLException {
		Object result = null;
		int index=1;
		try {
			getCallableStatement(procedureSql);
			if (inParamters!=null) {				
				for (int i = 0; i < inParamters.length; i++) {
					callableStatement.setObject(i + 1, inParamters[i]);
				}
				index=inParamters.length+1;
			}
			if (outparamter!=null) {				
				callableStatement.registerOutParameter(index, outparamter);
			}
			callableStatement.executeUpdate();
			result = callableStatement.getObject(index);
		} catch (SQLException e) {
			throw new SQLException(e);
		}
		return result;
	}

	/**
     * 
    * @Title: callableGetSingle 
    * @Description: ���ô洢���̲�����CallableStatement������ⲿ����
    * @param @param procedureSql ���ô洢���̵����
    * @param @param inParamters  ������������û�п�����null��ʾ
    * @param @param outparamters  �������������û�п�����null��ʾ
    * @return CallableStatement    ��������
    * @author rain 
    * @date 2017��8��16�� ����8:18:27 
    * @version V1.0
     */
	public static CallableStatement callableQuery(String procedureSql, Object[] inParamters, Integer[] outPatameters)
			throws SQLException {
		try {
			getCallableStatement(procedureSql);
			if (inParamters != null) {
				for (int i = 0; i < inParamters.length; i++) {
					callableStatement.setObject(i + 1, inParamters[i]);
				}
			}
			if (outPatameters != null) {
				for (int i = 0; i < outPatameters.length; i++) {
					callableStatement.registerOutParameter(i + 1, outPatameters[i]);
				}
			}
			callableStatement.execute();				
		} catch (SQLException e) {
			throw new SQLException(e);
		}
		return callableStatement;
	}

	/**
	 * 
	* @Title: callableUpdate 
	* @Description: ͨ���洢����ȥ��������
	* @param @param procedureSql
	* @param @param parameters �����������������ڿ�����null��ʾ
	* @param @throws SQLException    ���
	* @return int    ��������
	* @author rain 
	* @date 2017��8��16�� ����8:21:37 
	* @version V1.0
	 */
	public static int callableUpdate(String procedureSql, Object[] parameters) throws SQLException {
		int result = 0;
		try {
			getCallableStatement(procedureSql);
			if (parameters!=null) {
				for (int i = 0; i < parameters.length; i++) {
					callableStatement.setObject(i + 1, parameters[i]);
				}				
			}
			result = callableStatement.executeUpdate();
		} catch (SQLException e) {
			throw new SQLException(e);
		}
		return result;
	}

	/**
	 * 
	* @Title: getPreparedStatement 
	* @Description: ��ȡpreparedStatement���� 
	* @param @param sql
	* @param @throws SQLException    ���
	* @return void    ��������
	* @author rain 
	* @date 2017��8��16�� ����8:22:51 
	* @version V1.0
	 */
	private static void getPreparedStatement(String sql) throws SQLException {
		conn = JdbcUtil.getConnection();
		preparedStatement = conn.prepareStatement(sql);
	}

	/**
	 * 
	* @Title: getCallableStatement 
	* @Description: ��ȡcallableStatement���� 
	* @param @param sql
	* @param @throws SQLException    ���
	* @return void    ��������
	* @author rain 
	* @date 2017��8��16�� ����8:22:51 
	* @version V1.0
	 */
	private static void getCallableStatement(String procedureSql) throws SQLException {
		conn = JdbcUtil.getConnection();
		callableStatement = conn.prepareCall(procedureSql);
	}

	// ������������������Ϊpublic��Ϊ����������������Դ�������ͷ�
	public static Connection getConn() {
		return conn;
	}

	public static PreparedStatement getPreparedStatement() {
		return preparedStatement;
	}
}
