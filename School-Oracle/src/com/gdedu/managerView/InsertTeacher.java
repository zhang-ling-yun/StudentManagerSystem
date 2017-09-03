package com.gdedu.managerView;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.gdedu.dao.TeacherDao;
import com.gdedu.model.Teacher;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 *
 * 项目名称：java-oracle 类名称：InsertTeacher 类描述： 创建人：ASUS 创建时间：2017年7月8日 上午9:36:54
 * 修改人：ASUS 修改时间：2017年7月8日 上午9:36:54 修改备注：
 * 
 * @version
 *
 */
public class InsertTeacher extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tno;
	private JTextField tname;
	private JTextField tjobtitle;
	private JTextField tsalary;
	private JTextField tpwd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InsertTeacher frame = new InsertTeacher();
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
	public InsertTeacher() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 363, 411);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel tnoJLabel = new JLabel("\u5DE5 \u53F7:");
		
		tno = new JTextField();
		tno.setColumns(10);
		
		JLabel tnameJLabel = new JLabel("\u59D3 \u540D:");
		
		tname = new JTextField();
		tname.setColumns(10);
		
		JLabel tjobtitleJLabel = new JLabel("\u804C \u79F0:");
		
		tjobtitle = new JTextField();
		tjobtitle.setColumns(10);
		
		JLabel tsalaryJLabel = new JLabel("\u5DE5 \u8D44:");
		
		tsalary = new JTextField();
		tsalary.setColumns(10);
		
		JLabel tpwdJLabel = new JLabel("\u5BC6 \u7801:");
		
		tpwd = new JTextField();
		tpwd.setColumns(10);
		
		JButton insertButton = new JButton("\u63D2\u5165");
		insertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {					
					Teacher teacher=new Teacher(tno.getText(), tname.getText(), tjobtitle.getText(),Integer.parseInt(tsalary.getText()), tpwd.getText());
					boolean result=TeacherDao.insertTeacher(teacher);
					if (!result) {
						JOptionPane.showMessageDialog(null, "插入成功!");
					}else{
						JOptionPane.showMessageDialog(null, "插入失败，请重试!");
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
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(81)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(tnoJLabel, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
							.addGap(20)
							.addComponent(tno, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(tnameJLabel, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
							.addGap(20)
							.addComponent(tname, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(tjobtitleJLabel, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
							.addGap(20)
							.addComponent(tjobtitle, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(tsalaryJLabel, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
							.addGap(20)
							.addComponent(tsalary, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(tpwdJLabel, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
							.addGap(20)
							.addComponent(tpwd, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(46)
							.addComponent(insertButton, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(94, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(27)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(tnoJLabel))
						.addComponent(tno, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(21)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(tnameJLabel))
						.addComponent(tname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(22)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(tjobtitleJLabel))
						.addComponent(tjobtitle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(tsalaryJLabel))
						.addComponent(tsalary, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(tpwdJLabel))
						.addComponent(tpwd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(32)
					.addComponent(insertButton, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(63, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

}
