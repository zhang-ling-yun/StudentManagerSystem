package com.gdedu.mainView;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import com.gdedu.dao.Login;
import com.gdedu.dao.StudentDao;
import com.gdedu.dao.TeacherDao;
import com.gdedu.managerView.Manager;
import com.gdedu.model.Student;
import com.gdedu.view.studentView.StudentManager;

/**
 *
 * ��Ŀ���ƣ�java-oracle �����ƣ�MainUI �������� �����ˣ�ASUS ����ʱ�䣺2017��7��6�� ����11:17:07 �޸��ˣ�ASUS
 * �޸�ʱ�䣺2017��7��6�� ����11:17:07 �޸ı�ע��
 * 
 * @version
 *
 */
public class MainUI extends JFrame {
	private static final long serialVersionUID = 1L;
	private JLabel usernameLabel;
	private JLabel passwordLabel;
	private JLabel checkLabel;

	private TextField username;
	private TextField password;

	private JCheckBox checkBox;

	private JButton submit;
	private JButton exit;

	private JPanel userPanel;
	private JPanel passPanel;
	private JPanel checkPanel;
	private JPanel buttonPanel;

	public MainUI(String title) {
		super(title);
		setSize(300, 300);
		// ������ʾ
		setLocationRelativeTo(null);
		Container container = getContentPane();
		container.setLayout(new GridLayout(4, 1));
		usernameLabel = new JLabel("�û���:");
		passwordLabel = new JLabel("��   ��:");
		checkLabel = new JLabel("����Ա��ݵ�¼");

		username = new TextField(20);
		password = new TextField(20);
		password.setEchoChar('*');

		checkBox = new JCheckBox();

		submit = new JButton("��¼");
		exit = new JButton("�˳�");

		userPanel = new JPanel();
		passPanel = new JPanel();
		buttonPanel = new JPanel();
		checkPanel = new JPanel();

		userPanel.add(usernameLabel);
		userPanel.add(username);
		passPanel.add(passwordLabel);
		passPanel.add(password);
		checkPanel.add(checkLabel);
		checkPanel.add(checkBox);
		buttonPanel.add(submit);
		buttonPanel.add(exit);

		container.add(userPanel);
		container.add(passPanel);
		container.add(checkPanel);
		container.add(buttonPanel);

		submit.addActionListener(new Submit());
		exit.addActionListener(new Exit());

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
	}

	class Submit implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (checkBox.isSelected()) {
				if (Login.loginByManager(username.getText(), password.getText()) != 0) {
					Login.username = username.getText();
					List<String> teacherUsername = TeacherDao.queryTeacherNames(Login.username);
					JOptionPane.showMessageDialog(null, "��ϲ����½�ɹ�");
					@SuppressWarnings("unused")
					Manager manager = new Manager("��ӭ��, " + teacherUsername.get(0));			
				} else {
					JOptionPane.showMessageDialog(null, "�û������������������Ϊ����!������!");
					System.exit(0);
				}
			} else if (Login.loginByPublic(username.getText(), password.getText()) != null) {
				Login.username = username.getText();
				Student student=StudentDao.queryStudentBySno(Login.username);
				JOptionPane.showMessageDialog(null, "��ϲ����½�ɹ�");
				@SuppressWarnings("unused")
				StudentManager studentManager = new StudentManager("��ӭ��, " + student.getSname());				
			} else {
				JOptionPane.showMessageDialog(null, "�û������������������Ϊ����!������!");
			}
		}
	}

	class Exit implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}

	}
}
