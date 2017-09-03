package com.gdedu.view.studentView;

import java.awt.EventQueue;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.gdedu.dao.Login;
import com.gdedu.dao.StudentStaticsDao;
import com.gdedu.model.StudentStaticsView;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
*
* 项目名称：School-Oracle
* 类名称：TotalCredits
* 类描述：
* 创建人：ASUS
* 创建时间：2017年7月8日 下午8:37:00
* 修改人：ASUS
* 修改时间：2017年7月8日 下午8:37:00
* 修改备注：
* @version
*
*/
@SuppressWarnings("serial")
public class TotalCredits extends JFrame {

	private JPanel contentPane;
	private JTextField sno;
	private JTextField sname;
	private JTextField totalCredit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TotalCredits frame = new TotalCredits();
					List<StudentStaticsView> list=StudentStaticsDao.queryStudentStaticsView(Login.username);
					for (StudentStaticsView studentStaticsView : list) {
						frame.sno.setText(studentStaticsView.getSno());
						frame.sname.setText(studentStaticsView.getSname());
						frame.totalCredit.setText(studentStaticsView.getTotalCredit().toString());
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
	public TotalCredits() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 338, 217);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel snoJLabel = new JLabel("\u5B66 \u53F7\uFF1A");
		snoJLabel.setBounds(75, 25, 42, 15);
		
		sno = new JTextField();
		sno.setBounds(127, 25, 106, 21);
		sno.setEditable(false);
		sno.setColumns(10);
		
		JLabel snameJLabel = new JLabel("\u59D3 \u540D:");
		snameJLabel.setBounds(75, 67, 36, 15);
		
		sname = new JTextField();
		sname.setEditable(false);
		sname.setBounds(127, 64, 104, 21);
		sname.setColumns(10);
		
		JLabel label = new JLabel("\u603B\u5B66\u5206:");
		label.setBounds(75, 106, 42, 15);
		
		totalCredit = new JTextField();
		totalCredit.setEditable(false);
		totalCredit.setBounds(127, 103, 106, 21);
		totalCredit.setColumns(10);
		contentPane.setLayout(null);
		contentPane.add(snoJLabel);
		contentPane.add(sno);
		contentPane.add(snameJLabel);
		contentPane.add(sname);
		contentPane.add(label);
		contentPane.add(totalCredit);
	}

}
