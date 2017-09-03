package com.gdedu.managerView;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import com.gdedu.dao.StudentStaticsDao;
import com.gdedu.model.StudentStaticsView;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * ��Ŀ���ƣ�java-oracle �����ƣ�StudentStatics �������� �����ˣ�ASUS ����ʱ�䣺2017��7��8�� ����10:54:43
 * �޸��ˣ�ASUS �޸�ʱ�䣺2017��7��8�� ����10:54:43 �޸ı�ע��
 * 
 * @version
 *
 */
public class StudentStatics extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable queryTable;
	private DefaultTableModel dtm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@SuppressWarnings("unchecked")
			public void run() {
				try {
					StudentStatics frame = new StudentStatics();
					while (frame.dtm.getRowCount() > 0) {
						frame.dtm.removeRow(frame.dtm.getRowCount() - 1);
					}
					List<StudentStaticsView> list = StudentStaticsDao.queryStudentStaticsView("");
					for (StudentStaticsView studentStaticsView : list) {
						@SuppressWarnings("rawtypes")
						Vector vector = new Vector();
						vector.add(studentStaticsView.getSno());
						vector.add(studentStaticsView.getSname());
						vector.add(studentStaticsView.getTotalCredit());
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
	public StudentStatics() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 607, 422);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.NORTH);
		queryTable = new JTable();
		queryTable.setEnabled(false);
		String[] headStrings = new String[] { "ѧ��", "����", "������ѧ��" };
		dtm = new DefaultTableModel(headStrings, 0);
		queryTable.setModel(dtm);
		scrollPane.setViewportView(queryTable);
	}

}
