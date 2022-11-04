package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTabbedPane;

public class TelaChamada extends JFrame {

	private JPanel contentPane;



	/**
	 * Create the frame.
	 */
	public TelaChamada() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 0));
		panel.setBounds(28, 10, 176, 83);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblSenha = new JLabel("C23");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblSenha.setBounds(10, 10, 156, 63);
		panel.add(lblSenha);
	}
}
