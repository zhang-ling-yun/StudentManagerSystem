package com.gdedu.managerView;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import com.gdedu.dao.TeacherStaticsDao;
import com.gdedu.model.TeacherStaticsView;
import javax.swing.JScrollPane;

/**
 *
 * 项目名称：java-oracle 类名称：TeacherStatics 类描述： 创建人：ASUS 创建时间：2017年7月8日 上午10:58:11
 * 修改人：ASUS 修改时间：2017年7月8日 上午10:58:11 修改备注：
 * 
 * @version
 *
 */
public class TeacherStatics extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private DefaultTableModel dtm;
	private JTable queryTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@SuppressWarnings("unchecked")
			public void run() {
				try {
					TeacherStatics frame = new TeacherStatics();
					while(frame.dtm.getRowCount()>0){
						frame.dtm.removeRow(frame.dtm.getRowCount()-1);
					}
					List<TeacherStaticsView>list=TeacherStaticsDao.queryTeacherStaticsView();
					for (TeacherStaticsView teacherStaticsView : list) {
						@SuppressWarnings("rawtypes")
						Vector vector=new Vector();
						vector.add(teacherStaticsView.getTjobtitle());
						vector.add(teacherStaticsView.getTsalary());
						vector.add(teacherStaticsView.getTcount());						
						frame.dtm.addRow(vector);
					}
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TeacherStatics() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 607, 427);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		queryTable = new JTable();
		queryTable.setEnabled(false);
		scrollPane.setViewportView(queryTable);
		String[] headStrings = new String[] { "职称", "平均工资", "该职称教师总人数" };
		dtm = new DefaultTableModel(headStrings, 0);
		queryTable.setModel(dtm);
	}

}
