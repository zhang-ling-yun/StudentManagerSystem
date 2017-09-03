package com.gdedu.managerView;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import com.gdedu.dao.StudentDao;
import com.gdedu.model.Student;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;

/**
 *
 * 项目名称：School-Oracle 类名称：QueryStudent 类描述： 创建人：ASUS 创建时间：2017年7月7日 上午11:26:28
 * 修改人：ASUS 修改时间：2017年7月7日 上午11:26:28 修改备注：
 * 
 * @version
 *
 */
public class QueryStudent extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField inputName;
	private JTable queryTable;
	private DefaultTableModel dtm;
	public static Student student;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QueryStudent frame = new QueryStudent();
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
	public QueryStudent() {
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 650, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel NameJLabel = new JLabel("\u8BF7\u8F93\u5165\u60A8\u8981\u67E5\u627E\u7684\u5B66\u751F\u59D3\u540D:");

		inputName = new JTextField();
		inputName.setColumns(10);

		JButton queryButton = new JButton("\u67E5\u8BE2");
		queryButton.addActionListener(new ActionListener() {
			@SuppressWarnings("unchecked")
			public void actionPerformed(ActionEvent e) {
				while (dtm.getRowCount() > 0) {
					dtm.removeRow(dtm.getRowCount() - 1);
				}
				List<Student> students = StudentDao.queryStudents(inputName.getText());
				for (Student stu : students) {
					@SuppressWarnings("rawtypes")
					Vector vector = new Vector();
					vector.add(stu.getSno());
					vector.add(stu.getSname());
					vector.add(stu.getSsex());
					vector.add(stu.getSage());
					vector.add(stu.getSpwd());
					dtm.addRow(vector);
				}
			}
		});

		JScrollPane scrollPane = new JScrollPane();

		JButton deleteButton = new JButton("\u5220\u9664\u5F53\u524D\u884C");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int row = queryTable.getSelectedRow();
				if (row < 0 || row >= queryTable.getRowCount()) {
					return;
				}
				@SuppressWarnings("rawtypes")
				Vector student = (Vector) dtm.getDataVector().elementAt(row);
				boolean result = StudentDao.deleteStudent((String) student.get(0));
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
		updateButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int row = queryTable.getSelectedRow();
				if (row < 0 || row >= queryTable.getRowCount()) {
					return;
				}
				try {
					@SuppressWarnings("rawtypes")
					Vector vector = (Vector) dtm.getDataVector().elementAt(row);
					Student student = new Student();
					student.setSno((String) vector.get(0));
					student.setSname((String) vector.get(1));
					student.setSsex((String) vector.get(2));
					if (vector.get(3) instanceof Integer) {
						student.setSage((Integer) vector.get(3));
					} else {
						student.setSage(Integer.valueOf((String) vector.get(3)));
					}
					student.setSpwd((String) vector.get(4));
					int result = StudentDao.updateStudent(student);
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

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
						.createSequentialGroup().addGap(68)
						.addComponent(NameJLabel, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE).addGap(4)
						.addComponent(inputName, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE).addGap(18)
						.addComponent(queryButton, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup().addGap(19).addComponent(scrollPane,
								GroupLayout.PREFERRED_SIZE, 585, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup().addGap(182).addComponent(deleteButton)
								.addGap(68).addComponent(updateButton)))
				.addContainerGap(20, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addGap(24).addComponent(NameJLabel))
						.addGroup(gl_contentPane.createSequentialGroup().addGap(21).addComponent(inputName,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup().addGap(20).addComponent(queryButton)))
				.addGap(18).addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE)
				.addGap(18)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(deleteButton, GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup().addGap(1).addComponent(updateButton,
								GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)))
				.addContainerGap()));

		queryTable = new JTable();
		queryTable.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		queryTable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		String[] headStrings = new String[] { "学号", "姓名", "性别", "年龄", "密码" };
		dtm = new DefaultTableModel(headStrings, 0);
		queryTable.setModel(dtm);
		scrollPane.setViewportView(queryTable);
		contentPane.setLayout(gl_contentPane);
	}
}
