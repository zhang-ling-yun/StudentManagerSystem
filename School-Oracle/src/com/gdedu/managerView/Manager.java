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
 * 项目名称：java-oracle 类名称：Manager 类描述： 创建人：ASUS 创建时间：2017年7月6日 上午10:58:26 修改人：ASUS
 * 修改时间：2017年7月6日 上午10:58:26 修改备注：
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
		//设置全屏
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				int result=JOptionPane.showConfirmDialog(null, "确认退出系统?","退出系统",JOptionPane.YES_NO_OPTION);
				if (result==JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});		
		mb=new MenuBar();
		studentManage=new Menu("学生管理");
		teacherManage=new Menu("教师管理");
		courseManage=new Menu("课程管理");
		insertGrade=new Menu("成绩录入");
		informationStatics=new Menu("信息统计");
		
		queryStudentItem = new MenuItem("学生查询");
		queryStudentItem.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				//QueryStudent queryStudent=new QueryStudent();
				//queryStudent.main(null);
				QueryStudent.main(null);
			}
		});
		addStudentItem=new MenuItem("添加学生");
		addStudentItem.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				//InsertStudent insertStudent=new InsertStudent();
				//insertStudent.main(null);
				InsertStudent.main(null);
			}
		});
		
		queryTeacherItem=new MenuItem("教师查询");
		queryTeacherItem.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				//QueryTeacher queryTeacher=new QueryTeacher();
				//queryTeacher.main(null);
				QueryTeacher.main(null);
			}
		});
		addTeacherItem=new MenuItem("添加教师");
		addTeacherItem.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				//InsertTeacher insertTeacher=new InsertTeacher();
				//insertTeacher.main(null);
				InsertTeacher.main(null);
			}
		});
		
		queryCourseItem=new MenuItem("课程查询");
		queryCourseItem.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				//QueryCourse queryCourse=new QueryCourse();
				//queryCourse.main(null);
				QueryCourse.main(null);
			}
		});
		addCourseItem=new MenuItem("添加课程");
		addCourseItem.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				//QueryCourse queryCourse=new QueryCourse();
				//queryCourse.main(null);
				InsertCourse.main(null);
			}
		});
		
		queryTeachCourseItem=new MenuItem("教师授课查询");
		queryTeachCourseItem.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//CourseTeacherQuery courseTeacherQuery=new CourseTeacherQuery();
				//courseTeacherQuery.main(null);
				QueryCourseTeacher.main(null);
			}
		});
		
		insertGradeItem=new MenuItem("成绩查询");	
		insertGradeItem.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent arg0) {
			    //QueryGrade queryGrade=new QueryGrade();
			    //queryGrade.main(null);
				QueryGrade.main(null);
			}
		});
		courseStaticsItem=new MenuItem("课程信息统计");
		courseStaticsItem.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent arg0) {
			   //CourseStatics courseStatics=new CourseStatics();
			   //courseStatics.main(null);
				CourseStatics.main(null);
			}
		});
		teacherStaticsItem=new MenuItem("教师信息统计");
		teacherStaticsItem.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent arg0) {
			   //TeacherStatics teacherStatics=new TeacherStatics();
			   //teacherStatics.main(null);
				TeacherStatics.main(null);
			}
		});
		studentStaticsItem=new MenuItem("学生信息统计");
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
