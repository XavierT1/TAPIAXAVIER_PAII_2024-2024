package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Container extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public Container() {
		setTitle("App Institute");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 300);
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);

		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

		contentPane.add(Box.createVerticalGlue());

		JButton btnSchedule = new JButton("Schedule");
		JButton btnStudent = new JButton("Student");
		JButton btnSubject = new JButton("Subject");
		JButton btnTeacher = new JButton("Teacher");
		JButton btnExit = new JButton("Exit");

		btnSchedule.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnStudent.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnSubject.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnTeacher.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnExit.setAlignmentX(Component.CENTER_ALIGNMENT);

		btnSchedule.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PanelSchedule scheduleWindow = new PanelSchedule();
				scheduleWindow.setVisible(true);
				setVisible(false);
			}
		});

		btnStudent.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PanelStudent studentWindow = new PanelStudent();
				studentWindow.setVisible(true);
				setVisible(false);
			}
		});

		btnSubject.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PanelSubject subjectWindow = new PanelSubject();
				subjectWindow.setVisible(true);
				setVisible(false);
			}
		});

		btnTeacher.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PanelTeacher teacherWindow = new PanelTeacher();
				teacherWindow.setVisible(true);
				setVisible(false);
			}
		});

		btnExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		contentPane.add(btnSchedule);
		contentPane.add(Box.createRigidArea(new Dimension(0, 10)));
		contentPane.add(btnStudent);
		contentPane.add(Box.createRigidArea(new Dimension(0, 10)));
		contentPane.add(btnSubject);
		contentPane.add(Box.createRigidArea(new Dimension(0, 10)));
		contentPane.add(btnTeacher);
		contentPane.add(Box.createRigidArea(new Dimension(0, 40)));
		contentPane.add(btnExit);

		contentPane.add(Box.createVerticalGlue());
	}

}
