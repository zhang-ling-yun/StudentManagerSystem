package com.gdedu.managerView;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.gdedu.dao.StudentDao;
import com.gdedu.model.Student;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 *
 * 项目名称：java-oracle 类名称：InsertStudent 类描述： 创建人：ASUS 创建时间：2017年7月8日 上午9:19:10
 * 修改人：ASUS 修改时间：2017年7月8日 上午9:19:10 修改备注：
 * 
 * @version
 *
 */
public class InsertStudent extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField sno;
	private JTextField sname;
	private JTextField sex;
	private JTextField sage;
	private JTextField spwd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InsertStudent frame = new InsertStudent();
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
	public InsertStudent() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 327, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel snoJLabel = new JLabel("\u5B66 \u53F7:");
		snoJLabel.setBounds(66, 27, 36, 15);
		contentPane.add(snoJLabel);

		sno = new JTextField();
		sno.setColumns(10);
		sno.setBounds(122, 24, 106, 21);
		contentPane.add(sno);

		JLabel snameJLabel = new JLabel("\u59D3 \u540D:");
		snameJLabel.setBounds(66, 69, 36, 15);
		contentPane.add(snameJLabel);

		sname = new JTextField();
		sname.setColumns(10);
		sname.setBounds(122, 66, 106, 21);
		contentPane.add(sname);

		JLabel sexJLabel = new JLabel("\u6027 \u522B:");
		sexJLabel.setBounds(66, 112, 36, 15);
		contentPane.add(sexJLabel);

		sex = new JTextField();
		sex.setColumns(10);
		sex.setBounds(122, 109, 106, 21);
		contentPane.add(sex);

		JLabel sageJLabel = new JLabel("\u5E74 \u9F84:");
		sageJLabel.setBounds(66, 160, 36, 15);
		contentPane.add(sageJLabel);

		sage = new JTextField();
		sage.setColumns(10);
		sage.setBounds(122, 157, 106, 21);
		contentPane.add(sage);

		JLabel spwdJLabel = new JLabel("\u5BC6 \u7801:");
		spwdJLabel.setBounds(66, 210, 36, 15);
		contentPane.add(spwdJLabel);

		spwd = new JTextField();
		spwd.setColumns(10);
		spwd.setBounds(122, 207, 106, 21);
		contentPane.add(spwd);

		JButton insertButton = new JButton("\u63D2\u5165");
		insertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {					
					Student student=new Student(sno.getText(), sname.getText(), sex.getText(),Integer.parseInt(sage.getText()), spwd.getText());
					boolean result=StudentDao.insertStudent(student);
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
		insertButton.setBounds(112, 260, 75, 36);
		contentPane.add(insertButton);
	}

}
