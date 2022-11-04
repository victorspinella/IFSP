package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuFuncionario extends JFrame {

	private JPanel contentPane;


	/**
	 * Create the frame.
	 */
	public MenuFuncionario() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnGuiche = new JButton("Guich\u00EA");
		btnGuiche.setBounds(127, 71, 79, 27);
		btnGuiche.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(btnGuiche);
		
		JPanel panel = new JPanel();
		panel.setBounds(259, 23, 1, 1);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnManterFuncionario = new JButton("Manter Funcion\u00E1rio");
		btnManterFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnManterFuncionario.setBounds(127, 147, 208, 27);
		contentPane.add(btnManterFuncionario);
		
		JButton btnManterServico = new JButton("Manter Servi\u00E7o");
		btnManterServico.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnManterServico.setBounds(127, 192, 208, 27);
		contentPane.add(btnManterServico);
		
		JButton btnManterCategoria = new JButton("Manter Categoria");
		btnManterCategoria.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnManterCategoria.setBounds(127, 34, 208, 27);
		contentPane.add(btnManterCategoria);
		
		JButton btnControleManual = new JButton("Controle Manual");
		btnControleManual.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnControleManual.setBounds(127, 108, 208, 27);
		contentPane.add(btnControleManual);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuPrincipal menuPrincipal = new MenuPrincipal();
				menuPrincipal.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnVoltar.setBounds(127, 229, 79, 27);
		contentPane.add(btnVoltar);
	}

}
