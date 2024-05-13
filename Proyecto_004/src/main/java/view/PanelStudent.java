package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.ScheduleDAO;
import controller.StudentDAO;
import model.Student;

public class PanelStudent extends JFrame {

	private static final long serialVersionUID = 1L;
	private final StudentDAO studentDAO;

	public PanelStudent() {
		setTitle("Student");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(270, 290); // Ajustado para dar más espacio vertical
		setLocationRelativeTo(null);

		studentDAO = new StudentDAO();

		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(Color.WHITE);
		mainPanel.setLayout(new GridLayout(0, 1)); // Cambiado a GridLayout para apilar los elementos verticalmente

		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setBackground(Color.WHITE);
		buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.Y_AXIS));

		buttonsPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Puedes ajustar los números según el
																					// espacio que desees
		JButton btnCreate = new JButton("Create");
		JButton btnRead = new JButton("Read");
		JButton btnUpdate = new JButton("Update");
		JButton btnDelete = new JButton("Delete");
		JButton btnBack = new JButton("Back");

		btnCreate.setAlignmentX(Component.CENTER_ALIGNMENT); // Centra el botón horizontalmente
		btnRead.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnUpdate.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnDelete.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnBack.setAlignmentX(Component.CENTER_ALIGNMENT);

		buttonsPanel.add(btnCreate);
		buttonsPanel.add(Box.createRigidArea(new Dimension(0, 20))); // Espacio entre botones
		buttonsPanel.add(btnRead);
		buttonsPanel.add(Box.createRigidArea(new Dimension(0, 20)));
		buttonsPanel.add(btnUpdate);
		buttonsPanel.add(Box.createRigidArea(new Dimension(0, 20)));
		buttonsPanel.add(btnDelete);
		buttonsPanel.add(Box.createRigidArea(new Dimension(0, 20)));
		buttonsPanel.add(btnBack);
		mainPanel.add(buttonsPanel);

		btnBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				Container container = new Container();
				container.setVisible(true);
			}
		});

		btnCreate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				createStudent();
			}
		});

		btnRead.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				readStudent();
			}
		});

		btnUpdate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				updateStudent();
			}
		});

		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				deleteStudent();
			}
		});
		add(mainPanel);
	}

	private void createStudent() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1, 0));
		panel.add(new JLabel("Name:"));
		JTextField nameField = new JTextField(10);
		panel.add(nameField);

		panel.add(new JLabel("Last Name:"));
		JTextField lastNameField = new JTextField(10);
		panel.add(lastNameField);

		panel.add(new JLabel("Age:"));
		JTextField ageField = new JTextField(10);
		panel.add(ageField);

		int result = JOptionPane.showConfirmDialog(this, panel, "Create Student", JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.PLAIN_MESSAGE);

		if (result == JOptionPane.OK_OPTION) {
			String name = nameField.getText();
			String lastName = lastNameField.getText();
			int age = Integer.parseInt(ageField.getText());
			Student student = new Student();
			student.setName(name);
			student.setLastName(lastName);
			student.setAge(age);
			studentDAO.saveStudent(student);
		}
	}

	private void readStudent() {
		String input = JOptionPane.showInputDialog(this, "Insert Id of a Student:");

		if (input != null && !input.isEmpty()) {
			try {
				int studentId = Integer.parseInt(input);
				Student student = studentDAO.getStudent(studentId);

				if (student != null) {
					JPanel panel = new JPanel();
					panel.setLayout(new GridLayout(4, 1));

					panel.add(new JLabel("ID: " + student.getId()));
					panel.add(new JLabel("Name: " + student.getName()));
					panel.add(new JLabel("Last Name: " + student.getLastName()));
					panel.add(new JLabel("Age: " + student.getAge()));

					JOptionPane.showMessageDialog(this, panel, "Details of Student", JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(this, "No student was found with the provided ID.", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(this, "Student ID must be an integer.", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	private void updateStudent() {
		String input = JOptionPane.showInputDialog(this, "Insert ID of the student to update:");

		if (input != null && !input.isEmpty()) {
			try {
				int studentId = Integer.parseInt(input);

				Student studentToUpdate = studentDAO.getStudent(studentId);

				if (studentToUpdate != null) {
					
					String newName = JOptionPane.showInputDialog(this, "Name:");
					String newLastName = JOptionPane.showInputDialog(this, "Last Name:");
					String newAgeInput = JOptionPane.showInputDialog(this, "Age:");

					if (newAgeInput != null && !newAgeInput.isEmpty()) {
						int newAge = Integer.parseInt(newAgeInput);

						studentToUpdate.setName(newName);
						studentToUpdate.setLastName(newLastName);
						studentToUpdate.setAge(newAge);

						studentDAO.updateStudent(studentToUpdate);

						JOptionPane.showMessageDialog(this, "The student has been successfully updated.", "Success!",
								JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(this, "Please enter a new valid age.", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(this, "No student found with ID: " + studentId, "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(this, "Student ID and new age must be integers.", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	private void deleteStudent() {
		String input = JOptionPane.showInputDialog(this, "Insert ID of the student to delete:");

		if (input != null && !input.isEmpty()) {
			try {
				int studentId = Integer.parseInt(input);

				int confirm = JOptionPane.showConfirmDialog(this,
						"Are you sure you want to delete student with ID " + studentId + "?", "Confirm Deletion",
						JOptionPane.YES_NO_OPTION);

				if (confirm == JOptionPane.YES_OPTION) {
					studentDAO.deleteStudent(studentId);

					JOptionPane.showMessageDialog(this, "The student has been successfully deleted.", "Success!",
							JOptionPane.INFORMATION_MESSAGE);
				}
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(this, "Student ID must be an integer.", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

}
