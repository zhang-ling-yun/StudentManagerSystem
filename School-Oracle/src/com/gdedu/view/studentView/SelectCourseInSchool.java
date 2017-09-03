package com.gdedu.view.studentView;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import com.gdedu.dao.Login;
import com.gdedu.dao.SCViewDao;
import com.gdedu.model.SCView;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;

/**
 *
 * 项目名称：School-Oracle 类名称：SelectCourseInSchool 类描述： 创建人：ASUS 创建时间：2017年7月8日
 * 下午8:20:01 修改人：ASUS 修改时间：2017年7月8日 下午8:20:01 修改备注：
 * 
 * @version
 *
 */
public class SelectCourseInSchool extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private DefaultTableModel dtm;
	private JTextField courseName;
	private JTable queryTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelectCourseInSchool frame = new SelectCourseInSchool();
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
	public SelectCourseInSchool() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 611, 382);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel courseJLabel = new JLabel("\u8BF7\u8F93\u5165\u60A8\u8981\u67E5\u627E\u7684\u8BFE\u7A0B\u540D\u79F0:");
		courseJLabel.setBounds(95, 34, 159, 15);
		contentPane.add(courseJLabel);
		
		courseName = new JTextField();
		courseName.setColumns(10);
		courseName.setBounds(258, 31, 161, 21);
		contentPane.add(courseName);
		
		JButton queryButton = new JButton("\u67E5\u8BE2");
		queryButton.addActionListener(new ActionListener() {
			@SuppressWarnings("unchecked")
			public void actionPerformed(ActionEvent e) {
				while (dtm.getRowCount() > 0) {
					dtm.removeRow(dtm.getRowCount() - 1);
				}
				List<SCView> list = SCViewDao.queryHadNotSelectedCourse(Login.username,courseName.getText());
				for (SCView scView : list) {
					@SuppressWarnings("rawtypes")
					Vector vector = new Vector();
					vector.add(scView.getCno());
					vector.add(scView.getCname());
					vector.add(scView.getCcredit());
					vector.add(scView.getTname());
					dtm.addRow(vector);
				}
			}
		});
		queryButton.setBounds(445, 30, 71, 23);
		contentPane.add(queryButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 62, 585, 226);
		contentPane.add(scrollPane);
		
		queryTable = new JTable();
		scrollPane.setViewportView(queryTable);
		
		JButton insertButton = new JButton("\u9009\u4FEE\u5F53\u524D\u884C\u8BFE\u7A0B");
		insertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = queryTable.getSelectedRow();
				if (row < 0 || row >= queryTable.getRowCount()) {
					return;
				}				
				@SuppressWarnings("rawtypes")
				Vector vector = (Vector) dtm.getDataVector().elementAt(row);
				SCView scView=new SCView();
				scView.setSno(Login.username);
				scView.setCno((String)vector.get(0));
				boolean result = SCViewDao.insertSCView(scView);
				if (!result) {
					JOptionPane.showMessageDialog(null, "插入成功!");
				} else {
					JOptionPane.showMessageDialog(null, "插入失败，请重试!");
				}
			}
		});
		insertButton.setBounds(239, 298, 141, 35);
		contentPane.add(insertButton);
		String[] headStrings = new String[] { "课程号", "课程名", "学分数", "任课教师" };
		dtm = new DefaultTableModel(headStrings, 0);
		queryTable.setModel(dtm);
		scrollPane.setViewportView(queryTable);
	}
}
