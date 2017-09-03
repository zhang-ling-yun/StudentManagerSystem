package com.gdedu.managerView;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import com.gdedu.dao.CourseDao;
import com.gdedu.model.Course;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;

/**
 *
 * 项目名称：java-oracle 类名称：QueryCourse 类描述： 创建人：ASUS 创建时间：2017年7月8日 上午9:45:15
 * 修改人：ASUS 修改时间：2017年7月8日 上午9:45:15 修改备注：
 * 
 * @version
 *
 */
public class QueryCourse extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField courseName;
	private JTable queryTable;
	private DefaultTableModel dtm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QueryCourse frame = new QueryCourse();
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
	public QueryCourse() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 636, 474);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JButton deleteButton = new JButton("\u5220\u9664\u5F53\u524D\u884C");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = queryTable.getSelectedRow();
				if (row < 0 || row >= queryTable.getRowCount()) {
					return;
				}
				@SuppressWarnings("rawtypes")
				Vector course = (Vector) dtm.getDataVector().elementAt(row);
				boolean result = CourseDao.deleteCourse((String) course.get(0));
				if (!result) {
					JOptionPane.showMessageDialog(null, "删除成功!");
				} else {
					JOptionPane.showMessageDialog(null, "删除失败，请重试!");
					return;
				}
				dtm.removeRow(row);
			}
		});

		JButton updateButton = new JButton("\u4FEE\u6539\u5F53\u524D\u884C");
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = queryTable.getSelectedRow();
				if (row < 0 || row >= queryTable.getRowCount()) {
					return;
				}
				try {

					@SuppressWarnings("rawtypes")
					Vector vector = (Vector) dtm.getDataVector().elementAt(row);
					Course course = new Course();
					course.setCno((String) vector.get(0));
					course.setCname((String) vector.get(1));
					if (vector.get(2) instanceof Integer) {
						course.setCcredit((Integer) vector.get(2));
					} else {
						course.setCcredit(Integer.valueOf((String) vector.get(2)));
					}
					course.setTno((String) vector.get(3));
					int result = CourseDao.updateCourse(course);
					if (result != 0) {
						JOptionPane.showMessageDialog(null, "更新成功!");
					} else {
						JOptionPane.showMessageDialog(null, "更新失败，请重试!");
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
					return;
				}
			}
		});

		JLabel courseJLabel = new JLabel("\u8BF7\u8F93\u5165\u60A8\u8981\u67E5\u627E\u7684\u8BFE\u7A0B\u540D\u79F0:");

		courseName = new JTextField();
		courseName.setColumns(10);

		JButton queryButton = new JButton("\u67E5\u8BE2");
		queryButton.addActionListener(new ActionListener() {
			@SuppressWarnings("unchecked")
			public void actionPerformed(ActionEvent e) {
				while (dtm.getRowCount() > 0) {
					dtm.removeRow(dtm.getRowCount() - 1);
				}
				List<Course> list = CourseDao.queryCourse(courseName.getText());
				for (Course course : list) {
					@SuppressWarnings("rawtypes")
					Vector vector = new Vector();
					vector.add(course.getCno());
					vector.add(course.getCname());
					vector.add(course.getCcredit());
					vector.add(course.getTno());
					dtm.addRow(vector);
				}
			}
		});

		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(
				Alignment.TRAILING,
				gl_contentPane.createSequentialGroup().addContainerGap(15, Short.MAX_VALUE).addGroup(gl_contentPane
						.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addGap(50)
								.addComponent(courseJLabel, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
								.addGap(4)
								.addComponent(courseName, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
								.addGap(26)
								.addComponent(queryButton, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE))
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 585, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup().addGap(177).addComponent(deleteButton)
								.addGap(82).addComponent(updateButton)))
						.addContainerGap()));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addGap(29).addGap(14)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addGap(4).addComponent(courseJLabel))
						.addGroup(gl_contentPane.createSequentialGroup().addGap(1).addComponent(courseName,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(queryButton))
				.addGap(24).addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE)
				.addGap(18)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(deleteButton, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup().addGap(1).addComponent(updateButton,
								GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)))
				.addContainerGap(39, Short.MAX_VALUE)));

		queryTable = new JTable();
		String[] headStrings = new String[] { "课程号", "课程名", "学分数", "教工号" };
		dtm = new DefaultTableModel(headStrings, 0);
		queryTable.setModel(dtm);
		scrollPane.setViewportView(queryTable);
		contentPane.setLayout(gl_contentPane);
	}

}
