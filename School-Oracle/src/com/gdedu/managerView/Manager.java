package com.gdedu.managerView;

import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * ��Ŀ���ƣ�java-oracle �����ƣ�Manager �������� �����ˣ�ASUS ����ʱ�䣺2017��7��6�� ����10:58:26 �޸��ˣ�ASUS
 * �޸�ʱ�䣺2017��7��6�� ����10:58:26 �޸ı�ע��
 * 
 * @version
 *
 */
public class Manager extends JFrame{
	private static final long serialVersionUID = 1L;
	private MenuBar mb;
	private Menu studentManage;
	private Menu teacherManage;
	private Menu courseManage;
	private Menu insertGrade;
	private Menu informationStatics;
	private MenuItem queryStudentItem;
	private MenuItem addStudentItem;	
	private MenuItem queryTeacherItem;
	private MenuItem addTeacherItem;	
	private MenuItem queryCourseItem;
	private MenuItem addCourseItem;
	private MenuItem queryTeachCourseItem;	
	private MenuItem courseStaticsItem;
	private MenuItem studentStaticsItem;
	private MenuItem teacherStaticsItem;
	private MenuItem insertGradeItem;	
	public Manager(String title){		
		super(title);
		//����ȫ��
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				int result=JOptionPane.showConfirmDialog(null, "ȷ���˳�ϵͳ?","�˳�ϵͳ",JOptionPane.YES_NO_OPTION);
				if (result==JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});		
		mb=new MenuBar();
		studentManage=new Menu("ѧ������");
		teacherManage=new Menu("��ʦ����");
		courseManage=new Menu("�γ̹���");
		insertGrade=new Menu("�ɼ�¼��");
		informationStatics=new Menu("��Ϣͳ��");
		
		queryStudentItem = new MenuItem("ѧ����ѯ");
		queryStudentItem.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				//QueryStudent queryStudent=new QueryStudent();
				//queryStudent.main(null);
				QueryStudent.main(null);
			}
		});
		addStudentItem=new MenuItem("���ѧ��");
		addStudentItem.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				//InsertStudent insertStudent=new InsertStudent();
				//insertStudent.main(null);
				InsertStudent.main(null);
			}
		});
		
		queryTeacherItem=new MenuItem("��ʦ��ѯ");
		queryTeacherItem.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				//QueryTeacher queryTeacher=new QueryTeacher();
				//queryTeacher.main(null);
				QueryTeacher.main(null);
			}
		});
		addTeacherItem=new MenuItem("��ӽ�ʦ");
		addTeacherItem.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				//InsertTeacher insertTeacher=new InsertTeacher();
				//insertTeacher.main(null);
				InsertTeacher.main(null);
			}
		});
		
		queryCourseItem=new MenuItem("�γ̲�ѯ");
		queryCourseItem.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				//QueryCourse queryCourse=new QueryCourse();
				//queryCourse.main(null);
				QueryCourse.main(null);
			}
		});
		addCourseItem=new MenuItem("��ӿγ�");
		addCourseItem.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				//QueryCourse queryCourse=new QueryCourse();
				//queryCourse.main(null);
				InsertCourse.main(null);
			}
		});
		
		queryTeachCourseItem=new MenuItem("��ʦ�ڿβ�ѯ");
		queryTeachCourseItem.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//CourseTeacherQuery courseTeacherQuery=new CourseTeacherQuery();
				//courseTeacherQuery.main(null);
				QueryCourseTeacher.main(null);
			}
		});
		
		insertGradeItem=new MenuItem("�ɼ���ѯ");	
		insertGradeItem.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent arg0) {
			    //QueryGrade queryGrade=new QueryGrade();
			    //queryGrade.main(null);
				QueryGrade.main(null);
			}
		});
		courseStaticsItem=new MenuItem("�γ���Ϣͳ��");
		courseStaticsItem.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent arg0) {
			   //CourseStatics courseStatics=new CourseStatics();
			   //courseStatics.main(null);
				CourseStatics.main(null);
			}
		});
		teacherStaticsItem=new MenuItem("��ʦ��Ϣͳ��");
		teacherStaticsItem.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent arg0) {
			   //TeacherStatics teacherStatics=new TeacherStatics();
			   //teacherStatics.main(null);
				TeacherStatics.main(null);
			}
		});
		studentStaticsItem=new MenuItem("ѧ����Ϣͳ��");
		studentStaticsItem.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent arg0) {
			   //StudentStatics studentStatics=new StudentStatics();
			   //studentStatics.main(null);
				StudentStatics.main(null);
			}
		});
		
		studentManage.add(queryStudentItem);
		studentManage.add(addStudentItem);		
		teacherManage.add(queryTeacherItem);
		teacherManage.add(addTeacherItem);		
		courseManage.add(queryCourseItem);
		courseManage.add(addCourseItem);
		courseManage.add(queryTeachCourseItem);	
		informationStatics.add(courseStaticsItem);
		informationStatics.add(studentStaticsItem);
		informationStatics.add(teacherStaticsItem);
		insertGrade.add(insertGradeItem);
		mb.add(studentManage);
		mb.add(teacherManage);
		mb.add(courseManage);
		mb.add(insertGrade);		
		mb.add(informationStatics);		
		setMenuBar(mb);
		setVisible(true);			
	}
		
}
