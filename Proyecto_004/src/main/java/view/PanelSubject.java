package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
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

import controller.SubjectDAO;
import model.Subject;

public class PanelSubject extends JFrame {

	private static final long serialVersionUID = 1L;
	private final SubjectDAO subjectDAO;

	public PanelSubject() {
		setTitle("Subject");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(270, 290); // Ajustado para dar más espacio vertical
		setLocationRelativeTo(null);

		subjectDAO = new SubjectDAO();

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
				createSubject();
			}
		});

		btnRead.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				readSubject();
			}
		});

		btnUpdate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				updateSubject();
			}
		});

		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				deleteSubject();
			}
		});

		add(mainPanel);
	}

	private void createSubject() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1, 0));
		panel.add(new JLabel("Name:"));
		JTextField nameField = new JTextField(10);
		panel.add(nameField);

		panel.add(new JLabel("Description:"));
		JTextField descriptionField = new JTextField(10);
		panel.add(descriptionField);

		panel.add(new JLabel("Level:"));
		JTextField levelField = new JTextField(10);
		panel.add(levelField);

		int result = JOptionPane.showConfirmDialog(this, panel, "Create Subject", JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.PLAIN_MESSAGE);

		if (result == JOptionPane.OK_OPTION) {
			String name = nameField.getText();
			String description = descriptionField.getText();
			int level = Integer.parseInt(levelField.getText());
			Subject subject = new Subject();
			subject.setName(name);
			subject.setDescription(description);
			subject.setLevel(level);
			subjectDAO.saveSubject(subject);
		}
	}

	private void readSubject() {
		String input = JOptionPane.showInputDialog(this, "Insert Id of a Subject:");

		if (input != null && !input.isEmpty()) {
			try {
				int subjectId = Integer.parseInt(input);
				Subject subject = subjectDAO.getSubject(subjectId);

				if (subject != null) {
					JPanel panel = new JPanel();
					panel.setLayout(new GridLayout(4, 1));

					panel.add(new JLabel("ID: " + subject.getId()));
					panel.add(new JLabel("Name: " + subject.getName()));
					panel.add(new JLabel("Description: " + subject.getDescription()));
					panel.add(new JLabel("Level: " + subject.getLevel()));

					JOptionPane.showMessageDialog(this, panel, "Subject details are displayed here.",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(this,
							"No subject was found with the provided ID. Do you want to try again?", "Subject Not Found",
							JOptionPane.ERROR_MESSAGE);
				}
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(this, "Please enter a valid integer ID for the subject.", "Invalid ID",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	private void updateSubject() {
		String input = JOptionPane.showInputDialog(this, "Insert ID of the Subject to update:");

		if (input != null && !input.isEmpty()) {
			try {
				int subjectId = Integer.parseInt(input);

				Subject subjectToUpdate = subjectDAO.getSubject(subjectId);

				if (subjectToUpdate != null) {
					String newName = JOptionPane.showInputDialog(this, "Name:");
					String newDescription = JOptionPane.showInputDialog(this, "Description:");
					String newLevelInput = JOptionPane.showInputDialog(this, "Level:");

					if (newLevelInput != null && !newLevelInput.isEmpty()) {
						int newLevel = Integer.parseInt(newLevelInput);

						subjectToUpdate.setName(newName);
						subjectToUpdate.setDescription(newDescription);
						subjectToUpdate.setLevel(newLevel);

						subjectDAO.updateSubject(subjectToUpdate);

						JOptionPane.showMessageDialog(this, "The Subject has been successfully updated.", "Success!",
								JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(this, "Please enter a new valid level.", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(this, "No subject found with ID: " + subjectId, "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(this, "Subject ID and new level must be integers.", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	private void deleteSubject() {
		String input = JOptionPane.showInputDialog(this, "Insert ID of the Subject to delete:");

		if (input != null && !input.isEmpty()) {
			try {
				int subjectId = Integer.parseInt(input);

				int confirm = JOptionPane.showConfirmDialog(this,
						"Are you sure you want to delete Subject with ID " + subjectId + "?", "Confirm Deletion",
						JOptionPane.YES_NO_OPTION);

				if (confirm == JOptionPane.YES_OPTION) {
					subjectDAO.deleteSubject(subjectId);

					JOptionPane.showMessageDialog(this, "The subject has been successfully deleted.", "Success!",
							JOptionPane.INFORMATION_MESSAGE);
				}
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(this, "Subject ID must be an integer.", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

}
