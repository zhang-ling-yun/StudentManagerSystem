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
 * ��Ŀ���ƣ�java-oracle �����ƣ�StudentMenu �������� �����ˣ�ASUS ����ʱ�䣺2017��7��6�� ����10:15:06
 * �޸��ˣ�ASUS �޸�ʱ�䣺2017��7��6�� ����10:15:06 �޸ı�ע��
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
				int result=JOptionPane.showConfirmDialog(null, "ȷ���˳�ϵͳ?","�˳�ϵͳ",JOptionPane.YES_NO_OPTION);
				if (result==JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
		
		mb=new MenuBar();
		information=new Menu("ѧ��������Ϣ����");
		selectCourse=new Menu("ѡ�ι���");
		credit=new Menu("ѧ�ֹ���");
		
		queryInformationItem=new MenuItem("��ѯ������Ϣ");
		queryInformationItem.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				//QueryPersonalInformation queryPersonalInformation=new QueryPersonalInformation();
				//queryPersonalInformation.main(null);
				QueryPersonalInformation.main(null);
			}
		});
		
		selectCourseItem=new MenuItem("ȫУ��ѡ�޿�");//��ʾ��û��ѡ�Ŀγ�,List<Course>,ֱ��ʹ��QueryCourse���弴��
		selectCourseItem.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				//SelectCourseInSchool selectCourseInSchool=new SelectCourseInSchool();
				//selectCourseInSchool.main(null);
				SelectCourseInSchool.main(null);
			}
		});
		queryHadSelectCourseItem=new MenuItem("��ѯ��ѡ�γ�");//��ʾ��ѡ�޵Ŀγ�,List<Course>
		queryHadSelectCourseItem.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				//QueryHadSelectedCourse queryHadSelectedCourse=new QueryHadSelectedCourse();
				//queryHadSelectedCourse.main(null);
				QueryHadSelectedCourse.main(null);
			}
		});
		
		queryCreditItem=new MenuItem("��ѯ����ѧ��");
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
