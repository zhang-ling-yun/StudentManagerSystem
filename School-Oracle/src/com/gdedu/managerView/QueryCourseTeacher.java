package com.gdedu.managerView;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import com.gdedu.dao.CourseDao;
import com.gdedu.dao.TCViewDao;
import com.gdedu.model.TCView;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;

/**
 *
 * 项目名称：java-oracle 类名称：CourseTeacherQuery 类描述： 创建人：ASUS 创建时间：2017年7月8日
 * 上午9:53:16 修改人：ASUS 修改时间：2017年7月8日 上午9:53:16 修改备注：
 * 
 * @version
 *
 */
public class QueryCourseTeacher extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField inputText;
	private JTable queryTable;
	private DefaultTableModel dtm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QueryCourseTeacher frame = new QueryCourseTeacher();
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
	public QueryCourseTeacher() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 649, 470);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel courseOrTeacherJLabel = new JLabel(
				"\u8BF7\u8F93\u5165\u60A8\u8981\u67E5\u627E\u7684\u8BFE\u7A0B\u540D\u79F0:");
		courseOrTeacherJLabel.setBounds(102, 45, 165, 15);

		inputText = new JTextField();
		inputText.setBounds(285, 42, 185, 21);
		inputText.setColumns(10);

		JButton queryButton = new JButton("\u67E5\u8BE2");
		queryButton.setBounds(522, 41, 71, 23);
		queryButton.addActionListener(new ActionListener() {
			@SuppressWarnings("unchecked")
			public void actionPerformed(ActionEvent e) {
				while (dtm.getRowCount() > 0) {
					dtm.removeRow(dtm.getRowCount() - 1);
				}
				List<TCView> cList = TCViewDao.queryTCViewByCname(inputText.getText());
				for (TCView tcView : cList) {
					@SuppressWarnings("rawtypes")
					Vector vector = new Vector();
					vector.add(tcView.getCno());
					vector.add(tcView.getCname());
					vector.add(tcView.getTno());
					vector.add(tcView.getTname());
					vector.add(tcView.getCcredit());
					dtm.addRow(vector);
				}
			}
		});

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(33, 82, 585, 264);

		JButton delete = new JButton("\u5220\u9664\u5F53\u524D\u884C\u6388\u8BFE\u4FE1\u606F");
		delete.setBounds(287, 364, 165, 37);
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row=queryTable.getSelectedRow();
				if (row<0||row>=queryTable.getRowCount()) {
					return;
				}
				@SuppressWarnings("rawtypes")
				Vector TCView=(Vector) dtm.getDataVector().elementAt(row);
				boolean result=CourseDao.deleteCourse((String)TCView.get(0));
				if (!result) {
					JOptionPane.showMessageDialog(null, "删除成功!");
				} else {
					JOptionPane.showMessageDialog(null, "删除失败，请重试!");
					return;
				}
				dtm.removeRow(row);
			}
		});		

		queryTable = new JTable();
		String[] headStrings = new String[] { "课程号", "课程名", "工号", "教师姓名", "课程学分" };
		dtm = new DefaultTableModel(headStrings, 0);
		queryTable.setModel(dtm);
		scrollPane.setViewportView(queryTable);
		contentPane.setLayout(null);
		contentPane.add(delete);
		contentPane.add(courseOrTeacherJLabel);
		contentPane.add(inputText);
		contentPane.add(queryButton);
		contentPane.add(scrollPane);
	}

}
