package com.gdedu.managerView;

import java.awt.EventQueue;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.gdedu.dao.CourseDao;
import com.gdedu.dao.TeacherDao;
import com.gdedu.model.Course;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 *
 * 项目名称：School-Oracle 类名称：InsertCourse 类描述： 创建人：ASUS 创建时间：2017年7月10日 上午9:59:51
 * 修改人：ASUS 修改时间：2017年7月10日 上午9:59:51 修改备注：
 * 
 * @version
 *
 */
public class InsertCourse extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField cno;
	private JTextField cname;
	private JTextField ccredit;
	private JLabel tnoJLabel;
	@SuppressWarnings("rawtypes")
	private JComboBox tno;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@SuppressWarnings("unchecked")
			public void run() {
				try {
					InsertCourse frame = new InsertCourse();
					List<String> list = TeacherDao.queryTeacherNames("");
					for (String string : list) {
						frame.tno.addItem(string);
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
	@SuppressWarnings("rawtypes")
	public InsertCourse() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 326, 347);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel cnoJLabel = new JLabel("\u8BFE\u7A0B\u53F7:");
		cnoJLabel.setBounds(71, 38, 54, 22);
		contentPane.add(cnoJLabel);

		cno = new JTextField();
		cno.setBounds(135, 39, 94, 21);
		contentPane.add(cno);
		cno.setColumns(10);

		JLabel cnameJLabel = new JLabel("\u8BFE\u7A0B\u540D:");
		cnameJLabel.setBounds(71, 97, 54, 15);
		contentPane.add(cnameJLabel);

		cname = new JTextField();
		cname.setBounds(135, 94, 94, 21);
		contentPane.add(cname);
		cname.setColumns(10);

		JLabel ccreditJLabel = new JLabel("\u5B66\u5206:");
		ccreditJLabel.setBounds(71, 150, 54, 15);
		contentPane.add(ccreditJLabel);

		ccredit = new JTextField();
		ccredit.setBounds(135, 147, 94, 21);
		contentPane.add(ccredit);
		ccredit.setColumns(10);

		tnoJLabel = new JLabel("\u4EFB\u8BFE\u8001\u5E08:");
		tnoJLabel.setBounds(71, 202, 54, 15);
		contentPane.add(tnoJLabel);

		JButton button = new JButton("\u63D2\u5165");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String tname = (String) tno.getSelectedItem();
					String tno = (String) TeacherDao.getTnoByTname(tname);
					Course course = new Course();
					course.setCno(cno.getText());
					course.setCname(cname.getText());
					course.setCcredit(Integer.parseInt(ccredit.getText()));
					course.setTno(tno);
					boolean result = CourseDao.insertCourse(course);
					if (!result) {
						JOptionPane.showMessageDialog(null, "插入成功!");
					} else {
						JOptionPane.showMessageDialog(null, "插入失败，请重试!");
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
					return;
				}
			}
		});
		button.setBounds(97, 253, 104, 28);
		contentPane.add(button);

		tno = new JComboBox();
		tno.setBounds(135, 199, 94, 21);
		contentPane.add(tno);
	}
}
