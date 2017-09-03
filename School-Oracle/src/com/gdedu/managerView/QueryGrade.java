package com.gdedu.managerView;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import com.gdedu.dao.SCViewDao;
import com.gdedu.model.SCView;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;

/**
 *
 * 项目名称：java-oracle 类名称：QueryGrade 类描述： 创建人：ASUS 创建时间：2017年7月8日 上午10:22:07
 * 修改人：ASUS 修改时间：2017年7月8日 上午10:22:07 修改备注：
 * 
 * @version
 *
 */
public class QueryGrade extends JFrame {
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
					QueryGrade frame = new QueryGrade();
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
	public QueryGrade() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 636, 462);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel gradeJLabel = new JLabel("\u8BF7\u8F93\u5165\u60A8\u8981\u67E5\u627E\u7684\u5B66\u751F\u59D3\u540D:");

		inputText = new JTextField();
		inputText.setColumns(10);

		JButton queryButton = new JButton("\u67E5\u8BE2");
		queryButton.addActionListener(new ActionListener() {
			@SuppressWarnings("unchecked")
			public void actionPerformed(ActionEvent e) {
				while (dtm.getRowCount() > 0) {
					dtm.removeRow(dtm.getRowCount() - 1);
				}
				List<SCView> list = SCViewDao.querySCViewBySname(inputText.getText());
				for (SCView scView : list) {
					@SuppressWarnings("rawtypes")
					Vector vector = new Vector();
					vector.add(scView.getSno());
					vector.add(scView.getSname());
					vector.add(scView.getCno());
					vector.add(scView.getCname());
					vector.add(scView.getTname());
					vector.add(scView.getCcredit());
					vector.add(scView.getGrade());
					dtm.addRow(vector);
				}
			}
		});

		JScrollPane scrollPane = new JScrollPane();

		JButton insertButton = new JButton("\u5F55\u5165\u5F53\u524D\u884C\u6210\u7EE9");
		insertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = queryTable.getSelectedRow();
				if (row < 0 || row >= queryTable.getRowCount()) {
					return;
				}
				try {

					@SuppressWarnings("rawtypes")
					Vector vector = (Vector) dtm.getDataVector().elementAt(row);
					SCView scView = new SCView();
					scView.setSno((String) vector.get(0));
					scView.setCno((String) vector.get(2));
					if (vector.get(6) instanceof Integer) {
						scView.setGrade((Integer) vector.get(6));
					} else {
						scView.setGrade(Integer.valueOf((String) vector.get(6)));
					}
					int result = SCViewDao.updateSCView(scView);
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
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING).addGroup(gl_contentPane
				.createSequentialGroup().addContainerGap(15, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
						.createSequentialGroup()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
								.createSequentialGroup().addGap(86)
								.addComponent(gradeJLabel, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(inputText, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
								.addGap(39)
								.addComponent(queryButton, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE))
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 585, GroupLayout.PREFERRED_SIZE))
						.addContainerGap())
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
								.addComponent(insertButton, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
								.addGap(197)))));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap(30, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(inputText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(gradeJLabel).addComponent(queryButton))
						.addGap(25)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(insertButton, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addGap(18)));

		queryTable = new JTable();
		String[] headStrings = new String[] { "学号", "姓名", "课程号", "课程名", "授课教师", "课程学分", "成绩" };
		dtm = new DefaultTableModel(headStrings, 0);
		queryTable.setModel(dtm);
		scrollPane.setViewportView(queryTable);
		contentPane.setLayout(gl_contentPane);
	}

}
