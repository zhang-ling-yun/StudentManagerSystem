package com.gdedu.managerView;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import com.gdedu.dao.TeacherDao;
import com.gdedu.model.Teacher;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;

/**
 *
 * 项目名称：java-oracle 类名称：QueryTeacher 类描述： 创建人：ASUS 创建时间：2017年7月8日 上午9:26:49
 * 修改人：ASUS 修改时间：2017年7月8日 上午9:26:49 修改备注：
 * 
 * @version
 *
 */
public class QueryTeacher extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tname;
	private JTable queryTable;
	private DefaultTableModel dtm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QueryTeacher frame = new QueryTeacher();
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
	public QueryTeacher() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 638, 453);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel tnameJLabel = new JLabel("\u8BF7\u8F93\u5165\u60A8\u8981\u67E5\u627E\u7684\u6559\u5E08\u59D3\u540D:");
		
		tname = new JTextField();
		tname.setColumns(10);
		
		JButton queryButton = new JButton("\u67E5\u8BE2");
		queryButton.addActionListener(new ActionListener() {
			@SuppressWarnings("unchecked")
			public void actionPerformed(ActionEvent e) {
				while (dtm.getRowCount() > 0) {
					dtm.removeRow(dtm.getRowCount() - 1);
				}
				List<Teacher> teachers = TeacherDao.queryTeacher(tname.getText());
				for (Teacher teacher : teachers) {
					@SuppressWarnings("rawtypes")
					Vector vector = new Vector();
					vector.add(teacher.getTno());
					vector.add(teacher.getTname());
					vector.add(teacher.getTjobtitle());
					vector.add(teacher.getTsalary());
					vector.add(teacher.getTpwd());
					dtm.addRow(vector);
				}
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton deleteButton = new JButton("\u5220\u9664\u5F53\u524D\u884C");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = queryTable.getSelectedRow();
				if (row < 0 || row >= queryTable.getRowCount()) {
					return;
				}
				@SuppressWarnings("rawtypes")
				Vector teacher = (Vector) dtm.getDataVector().elementAt(row);
				boolean result = TeacherDao.deleteTeacher((String)teacher.get(0));
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
					Teacher teacher=new Teacher();
					teacher.setTno((String) vector.get(0));
					teacher.setTname((String) vector.get(1));
					teacher.setTjobtitle((String) vector.get(2));				
					if (vector.get(3) instanceof Integer) {
						teacher.setTsalary((Integer)vector.get(3));
					} else {
						teacher.setTsalary(Integer.valueOf((String)vector.get(3)));
					}				
					teacher.setTpwd((String) vector.get(4));
					int result = TeacherDao.updateTeacher(teacher);
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
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(194, Short.MAX_VALUE)
					.addComponent(deleteButton)
					.addGap(82)
					.addComponent(updateButton)
					.addGap(150))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(67)
					.addComponent(tnameJLabel, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(tname, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
					.addGap(26)
					.addComponent(queryButton, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(117, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(17, Short.MAX_VALUE)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 585, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(37)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(tnameJLabel)
						.addComponent(tname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(queryButton))
					.addPreferredGap(ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(updateButton, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(deleteButton, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		
		queryTable = new JTable();
		String[] headStrings = new String[] { "工号", "姓名", "职称", "工资","密码" };
		dtm = new DefaultTableModel(headStrings, 0);
		queryTable.setModel(dtm);
		scrollPane.setViewportView(queryTable);
		contentPane.setLayout(gl_contentPane);
	}
}
