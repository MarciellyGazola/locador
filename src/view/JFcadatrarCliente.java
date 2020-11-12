package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class JFcadatrarCliente extends JFrame {

	private JPanel content;
	private final JLabel Name = new JLabel("Lancheria Taberna Moderna - Cadastro do Cliente");
	private JTextField txtNome;
	private JTextField txtCPF;
	private JPasswordField passwordFieldSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFcadatrarCliente frame = new JFcadatrarCliente();
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
	public JFcadatrarCliente() {
		setBackground(new Color(255, 165, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		content = new JPanel();
		content.setBackground(Color.WHITE);
		content.setForeground(Color.BLACK);
		content.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(content);
		content.setLayout(null);
		
		JButton btnAcessoAoSistema = new JButton("Acessar o cardápio");
		btnAcessoAoSistema.setForeground(new Color(255, 140, 0));
		btnAcessoAoSistema.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 12));
		btnAcessoAoSistema.setBackground(new Color(255, 215, 0));
		btnAcessoAoSistema.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnAcessoAoSistema.setBounds(10, 227, 145, 23);
		content.add(btnAcessoAoSistema);
		Name.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 12));
		Name.setBounds(10, 11, 309, 31);
		content.add(Name);
		Name.setBackground(new Color(255, 69, 0));
		Name.setForeground(new Color(255, 69, 0));
		
		JLabel lblNome = new JLabel("Nome completo");
		lblNome.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 12));
		lblNome.setBounds(10, 53, 98, 14);
		content.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 11));
		txtNome.setBounds(111, 53, 165, 20);
		content.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblCPF = new JLabel("CPF");
		lblCPF.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 12));
		lblCPF.setBounds(10, 106, 59, 14);
		content.add(lblCPF);
		
		txtCPF = new JTextField();
		txtCPF.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 11));
		txtCPF.setBounds(111, 103, 165, 20);
		content.add(txtCPF);
		txtCPF.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 11));
		lblSenha.setBounds(10, 163, 59, 14);
		content.add(lblSenha);
		
		JButton btnCancela = new JButton("Limpar campos");
		btnCancela.setForeground(new Color(255, 140, 0));
		btnCancela.setBackground(new Color(255, 215, 0));
		btnCancela.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
		btnCancela.setBounds(305, 228, 119, 23);
		content.add(btnCancela);
		
		JButton btnConcluirCadastro = new JButton("Efetuar cadastro");
		btnConcluirCadastro.setForeground(new Color(255, 140, 0));
		btnConcluirCadastro.setBackground(new Color(255, 215, 0));
		btnConcluirCadastro.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
		btnConcluirCadastro.setBounds(165, 228, 130, 23);
		content.add(btnConcluirCadastro);
		
		passwordFieldSenha = new JPasswordField();
		passwordFieldSenha.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 11));
		passwordFieldSenha.setBounds(111, 160, 165, 20);
		content.add(passwordFieldSenha);
	}
}
