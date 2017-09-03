package com.gdedu.view.studentView;

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
 * 项目名称：java-oracle 类名称：StudentMenu 类描述： 创建人：ASUS 创建时间：2017年7月6日 上午10:15:06
 * 修改人：ASUS 修改时间：2017年7月6日 上午10:15:06 修改备注：
 * 
 * @version
 *
 */
@SuppressWarnings("serial")
public class StudentManager extends JFrame implements ActionListener{
	private MenuBar mb;
	private Menu information;
	private Menu selectCourse;
	private Menu credit;
	private MenuItem queryInformationItem;
	private MenuItem selectCourseItem;
	private MenuItem queryHadSelectCourseItem;	
	private MenuItem queryCreditItem;
	public StudentManager(String title){
		super(title);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setLocation(100, 100);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				int result=JOptionPane.showConfirmDialog(null, "确认退出系统?","退出系统",JOptionPane.YES_NO_OPTION);
				if (result==JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
		
		mb=new MenuBar();
		information=new Menu("学生个人信息管理");
		selectCourse=new Menu("选课管理");
		credit=new Menu("学分管理");
		
		queryInformationItem=new MenuItem("查询个人信息");
		queryInformationItem.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				//QueryPersonalInformation queryPersonalInformation=new QueryPersonalInformation();
				//queryPersonalInformation.main(null);
				QueryPersonalInformation.main(null);
			}
		});
		
		selectCourseItem=new MenuItem("全校性选修课");//显示还没有选的课程,List<Course>,直接使用QueryCourse窗体即可
		selectCourseItem.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				//SelectCourseInSchool selectCourseInSchool=new SelectCourseInSchool();
				//selectCourseInSchool.main(null);
				SelectCourseInSchool.main(null);
			}
		});
		queryHadSelectCourseItem=new MenuItem("查询已选课程");//显示已选修的课程,List<Course>
		queryHadSelectCourseItem.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				//QueryHadSelectedCourse queryHadSelectedCourse=new QueryHadSelectedCourse();
				//queryHadSelectedCourse.main(null);
				QueryHadSelectedCourse.main(null);
			}
		});
		
		queryCreditItem=new MenuItem("查询已修学分");
		queryCreditItem.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				//TotalCredits totalCredits=new TotalCredits();
				//totalCredits.main(null);
				TotalCredits.main(null);
			}
		});
		
		
		information.add(queryInformationItem);
		
		selectCourse.add(selectCourseItem);
		selectCourse.add(queryHadSelectCourseItem);
		
		credit.add(queryCreditItem);
		
		mb.add(information);
		mb.add(selectCourse);
		mb.add(credit);
		
		setMenuBar(mb);
		setVisible(true);					
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand()=="") {
			
		}
	}

}
