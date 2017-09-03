package com.gdedu.managerView;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import com.gdedu.dao.CourseStaticsDao;
import com.gdedu.model.CourseStaticsView;
import java.util.List;
import java.util.Vector;
import javax.swing.JScrollPane;

/**
 *
 * ��Ŀ���ƣ�java-oracle �����ƣ�CourseStatics �������� �����ˣ�ASUS ����ʱ�䣺2017��7��8�� ����10:48:44
 * �޸��ˣ�ASUS �޸�ʱ�䣺2017��7��8�� ����10:48:44 �޸ı�ע��
 * 
 * @version
 *
 */
public class CourseStatics extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable queryTable;
	private DefaultTableModel dtm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@SuppressWarnings({ "rawtypes", "unchecked" })
			public void run() {
				try {
					CourseStatics frame = new CourseStatics();
					while (frame.dtm.getRowCount() > 0) {
						frame.dtm.removeRow(frame.dtm.getRowCount() - 1);
					}
					List<CourseStaticsView> list = CourseStaticsDao.queryCourseStaticsView();
					for (CourseStaticsView courseStaticsView : list) {
						Vector vector = new Vector();
						vector.add(courseStaticsView.getCno());
						vector.add(courseStaticsView.getCname());
						vector.add(courseStaticsView.getAvgGrade());
						vector.add(courseStaticsView.getMaxGrade());
						vector.add(courseStaticsView.getMinGrade());
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
	public CourseStatics() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 579, 412);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);

		queryTable = new JTable();
		queryTable.setEnabled(false);
		String[] headStrings = new String[] { "�γ̺�", "�γ���", "ƽ����", "��߷�", "��ͷ�" };
		dtm = new DefaultTableModel(headStrings, 0);
		queryTable.setModel(dtm);
		scrollPane.setViewportView(queryTable);
	}

}
