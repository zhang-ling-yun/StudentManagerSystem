package com.gdedu.util;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * 项目名称：School-Oracle 类名称：OracleHelper 类描述： 创建人：ASUS 创建时间：2017年7月9日 上午9:34:59
 * 修改人：ASUS 修改时间：2017年7月9日 上午9:34:59 修改备注：
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
	* @Description: 获取单一的结果，如MAX/MIN等...
	* @param @param sql  SQL语句
	* @param @param paramters  传入的参数
	* @return Object  返回类型
	* @author rain 
	* @date 2017年8月16日 下午8:09:38 
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
	* @Description: 通过参数查询返回结果集ResultSet给外部处理
	* @param @param SQL语句
	* @param @param paramters 传入参数,无参数是可以用null表示
	* @return ResultSet  返回类型
	* @author  rain
	* @date 2017年8月16日 下午8:11:35 
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
	* @Description: 通过参数更新并返回更新的条数
	* @param @param SQL语句
	* @param @param paramters 传入参数,无参数是可以用null表示
	* @return int  返回类型
	* @author  rain
	* @date 2017年8月16日 下午8:11:35 
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
	* @Description: 通过参数插入数据并返回插入成功与否，数据库返回默认false表示插入成功
	* @param @param SQL语句
	* @param @param paramters 传入参数,无参数是可以用null表示
	* @return ResultSet  返回类型
	* @author  rain
	* @date 2017年8月16日 下午8:11:35 
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
	* @Description: 插入数据并返回主键值
	* @param @param sql
	* @param @param paramters  传入参数,无参数是可以用null表示
	* @return Object    返回类型
	* @author rain 
	* @date 2017年8月16日 下午8:17:32 
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
	* @Description: 通过参数删除数据并返回成功与否，数据库返回默认false表示插入成功
	* @param @param SQL语句
	* @param @param paramters 传入参数,无参数是可以用null表示
	* @return ResultSet  返回类型
	* @author  rain
	* @date 2017年8月16日 下午8:11:35 
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
    * @Description: 调用存储过程并返回单一的结果 
    * @param @param procedureSql 调用存储过程的语句
    * @param @param inParamters  传入参数，如果没有可以用null表示
    * @param @param outparamter  传出参数，如果没有可以用null表示
    * @return Object    返回类型
    * @author rain 
    * @date 2017年8月16日 下午8:18:27 
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
    * @Description: 调用存储过程并返回CallableStatement对象给外部处理
    * @param @param procedureSql 调用存储过程的语句
    * @param @param inParamters  传入参数，如果没有可以用null表示
    * @param @param outparamters  传出参数，如果没有可以用null表示
    * @return CallableStatement    返回类型
    * @author rain 
    * @date 2017年8月16日 下午8:18:27 
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
	* @Description: 通过存储过程去更新数据
	* @param @param procedureSql
	* @param @param parameters 传入参数，如果不存在可以用null表示
	* @param @throws SQLException    入参
	* @return int    返回类型
	* @author rain 
	* @date 2017年8月16日 下午8:21:37 
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
	* @Description: 获取preparedStatement对象 
	* @param @param sql
	* @param @throws SQLException    入参
	* @return void    返回类型
	* @author rain 
	* @date 2017年8月16日 下午8:22:51 
	* @version V1.0
	 */
	private static void getPreparedStatement(String sql) throws SQLException {
		conn = JdbcUtil.getConnection();
		preparedStatement = conn.prepareStatement(sql);
	}

	/**
	 * 
	* @Title: getCallableStatement 
	* @Description: 获取callableStatement对象 
	* @param @param sql
	* @param @throws SQLException    入参
	* @return void    返回类型
	* @author rain 
	* @date 2017年8月16日 下午8:22:51 
	* @version V1.0
	 */
	private static void getCallableStatement(String procedureSql) throws SQLException {
		conn = JdbcUtil.getConnection();
		callableStatement = conn.prepareCall(procedureSql);
	}

	// 这里声明这两个函数为public是为了在这里面申请资源在外面释放
	public static Connection getConn() {
		return conn;
	}

	public static PreparedStatement getPreparedStatement() {
		return preparedStatement;
	}
}
