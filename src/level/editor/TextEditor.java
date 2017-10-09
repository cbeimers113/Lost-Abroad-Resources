package level.editor;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

public class TextEditor extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;

	/**
	 * Create the frame.
	 */
	public TextEditor(Component putBeside) {
		setTitle("Text Editor");
		setBounds(putBeside.getX() + putBeside.getWidth(), putBeside.getY(), 0, 0);
		setPreferredSize(new Dimension(400, 165));
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setVisible(true);
		setResizable(false);
		pack();
		getContentPane().setLayout(null);

		JLabel lblLanguage = new JLabel("Language:");
		lblLanguage.setBounds(12, 13, 370, 16);
		getContentPane().add(lblLanguage);

		JSeparator separator = new JSeparator();
		separator.setBounds(22, 42, 360, 2);
		getContentPane().add(separator);

		textField = new JTextField();
		textField.setBounds(54, 57, 328, 22);
		getContentPane().add(textField);
		textField.setColumns(10);

		JLabel lblText = new JLabel("Text:");
		lblText.setBounds(12, 60, 30, 16);
		getContentPane().add(lblText);

		JButton btnSet = new JButton("Set");
		btnSet.setBounds(12, 92, 173, 25);
		getContentPane().add(btnSet);

		JButton btnClose = new JButton("Close");
		btnClose.setBounds(209, 92, 173, 25);
		getContentPane().add(btnClose);
	}
}
