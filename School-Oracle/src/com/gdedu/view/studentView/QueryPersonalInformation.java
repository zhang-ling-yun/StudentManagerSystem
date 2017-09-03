package com.gdedu.view.studentView;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.gdedu.dao.Login;
import com.gdedu.dao.StudentDao;
import com.gdedu.model.Student;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

/**
 *
 * 项目名称：School-Oracle 类名称：QueryPersonalInformation 类描述： 创建人：ASUS 创建时间：2017年7月8日
 * 下午8:09:17 修改人：ASUS 修改时间：2017年7月8日 下午8:09:17 修改备注：
 * 
 * @version
 *
 */
public class QueryPersonalInformation extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField sno;
	private JTextField sname;
	private JTextField sex;
	private JTextField sage;
	private JPasswordField spwd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QueryPersonalInformation frame = new QueryPersonalInformation();
					Student student=StudentDao.queryStudentBySno(Login.username);
					frame.sno.setText(student.getSno());
					frame.sname.setText(student.getSname());
					frame.sex.setText(student.getSsex());
					frame.sage.setText(student.getSage().toString());
					frame.spwd.setText(student.getSpwd());
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
	public QueryPersonalInformation() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 417, 375);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel snoJLabel = new JLabel("\u5B66 \u53F7:");
		snoJLabel.setBounds(101, 35, 36, 15);
		contentPane.add(snoJLabel);
		
		sno = new JTextField();
		sno.setEditable(false);
		sno.setColumns(10);
		sno.setBounds(157, 32, 106, 21);
		contentPane.add(sno);
		
		JLabel snameJLabel = new JLabel("\u59D3 \u540D:");
		snameJLabel.setBounds(101, 77, 36, 15);
		contentPane.add(snameJLabel);
		
		sname = new JTextField();
		sname.setColumns(10);
		sname.setBounds(157, 74, 106, 21);
		contentPane.add(sname);
		
		JLabel sexJLabel = new JLabel("\u6027 \u522B:");
		sexJLabel.setBounds(101, 120, 36, 15);
		contentPane.add(sexJLabel);
		
		sex = new JTextField();
		sex.setColumns(10);
		sex.setBounds(157, 117, 106, 21);
		contentPane.add(sex);
		
		JLabel ageJLabel = new JLabel("\u5E74 \u9F84:");
		ageJLabel.setBounds(101, 168, 36, 15);
		contentPane.add(ageJLabel);
		
		sage = new JTextField();
		sage.setColumns(10);
		sage.setBounds(157, 165, 106, 21);
		contentPane.add(sage);
		
		JLabel spwdJLabel = new JLabel("\u5BC6 \u7801:");
		spwdJLabel.setBounds(101, 218, 36, 15);
		contentPane.add(spwdJLabel);
		
		JButton button = new JButton("\u4FEE\u6539\u4E2A\u4EBA\u4FE1\u606F");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				Student student = new Student();
				student.setSno(sno.getText());
				student.setSname(sname.getText());
				student.setSsex(sex.getText());				
				student.setSage(Integer.parseInt(sage.getText()));
				student.setSpwd(new String(spwd.getPassword()));
				int result = StudentDao.updateStudent(student);
				if (result != 0) {
					JOptionPane.showMessageDialog(null, "更新成功!");
				} else {
					JOptionPane.showMessageDialog(null, "更新失败，请重试!");
				}
			}
		});
		button.setBounds(109, 267, 154, 32);
		contentPane.add(button);
		
		spwd = new JPasswordField();
		spwd.setBounds(157, 215, 106, 21);
		contentPane.add(spwd);
	}
}
