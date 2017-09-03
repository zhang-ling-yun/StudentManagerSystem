package com.gdedu.test;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import com.gdedu.util.JdbcUtil;
import com.gdedu.util.OracleHelper;

/**
 *
 * ��Ŀ���ƣ�School-Oracle �����ƣ�DBConnectTest �������� �����ˣ�ASUS ����ʱ�䣺2017��7��9�� ����12:03:56
 * �޸��ˣ�ASUS �޸�ʱ�䣺2017��7��9�� ����12:03:56 �޸ı�ע��
 * 
 * @version
 *
 */
public class DBConnectTest {

	public static void main(String[] args) {
		try {
			Connection connection=JdbcUtil.getConnection();
			if (connection==null) {
				System.out.println("���ݿ�����ʧ��!");
			} else{
				System.out.println("���ݿ����ӳɹ�!");
			}		
			//���Դ洢����
			String procedureSql= "{call getMaxSalary(?)}";
			CallableStatement ca=OracleHelper.callableQuery(procedureSql, null, new Integer[]{Types.INTEGER});
			System.out.println(ca.getObject(1));
			
			String procedureSql1= "{call getMaxSalary(?)}";
			Object object=OracleHelper.callableGetSingle(procedureSql1, null, new Integer(Types.INTEGER));
			System.out.println(object);
			//1.��½����
			//BigDecimal result=(BigDecimal) Login.loginByManager("t001", "123456");
			//System.out.println(result);
			//2.��ѯѧ����Ϣ��ѯ
			//StudentDao.queryStudents("��");
			//3.����ѧ��
			//Student student=new Student("2", "����", "��", 21, "123456");
			//System.out.println(StudentDao.insertStudent(student));
			//4.ɾ��ѧ��
			//System.out.println(StudentDao.deleteStudent("1"));
			//5.����ѧ��
			//Student student=new Student("3", "����", "��", 21, "123456");
			//System.out.println(StudentDao.updateStudent(student));
			//6.��ѯ��ʦ
			//System.out.println(TeacherDao.queryStudents("��"));
			//7.��ѯ�γ�
			//System.out.println(CourseDao.queryCourse(""));
			//8.��ѯ���н�ʦ����
			//System.out.println(TeacherDao.queryTeacherNames());
			//9.��ѯTCView
			//System.out.println(TCViewDao.queryTCViewByCname("��"));
			//10.��ѯ�ɼ�
			//System.out.println(SCViewDao.querySCViewBySname("��"));
			//11.��ѯ�γ���ͼ
			//System.out.println(CourseStaticsDao.queryCourseStaticsView());
			//12.��ѯѧ����ͼ
			//System.out.println(StudentStaticsDao.queryCourseStaticsView());
			//13.��ѯѧ��������Ϣ
			//System.out.println(StudentDao.queryStudentBySno("1506300052"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
