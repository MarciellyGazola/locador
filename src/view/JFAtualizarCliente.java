package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import model.bean.cliente;
import model.dao.clienteDAO;

public class JFAtualizarCliente extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtEndereco;
	private JTextField txtCPF;
	private JTextField txtEstadoCivil;
	
	private static int IdCliente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFAtualizarCliente frame = new JFAtualizarCliente(IdCliente);
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
	public JFAtualizarCliente(int IdCliente) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAtualizar = new JLabel("Atualizar Cliente");
		lblAtualizar.setBounds(55, 5, 305, 20);
		lblAtualizar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAtualizar.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblAtualizar);
		
		clienteDAO fdao = new clienteDAO();
		cliente f = fdao.read(IdCliente);
		
		JLabel lblID = new JLabel("ID do cliente");
		lblID.setBounds(300, 10, 87, 14);
		contentPane.add(lblID);
		
		JLabel lblId = new JLabel("New label");
		lblId.setBounds(383, 10, 46, 14);
		contentPane.add(lblId);
		
		JLabel lblNomeCompleto = new JLabel("Nome Completo");
		lblNomeCompleto.setBounds(10, 36, 153, 14);
		contentPane.add(lblNomeCompleto);

		txtNome = new JTextField();
		txtNome.setBounds(95, 36, 329, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblEndereco = new JLabel("Endere\u00E7o");
		lblEndereco.setBounds(10, 72, 94, 14);
		contentPane.add(lblEndereco);
		
		txtEndereco = new JTextField();
		txtEndereco.setBounds(95, 69, 329, 20);
		contentPane.add(txtEndereco);
		txtEndereco.setColumns(10);
		
		JLabel lblCPF = new JLabel("CPF");
		lblCPF.setBounds(10, 109, 46, 14);
		contentPane.add(lblCPF);
		
		txtCPF = new JTextField();
		txtCPF.setBounds(95, 106, 329, 20);
		contentPane.add(txtCPF);
		txtCPF.setColumns(10);
		
		JLabel lblEstadoCivil = new JLabel("Estado Civil");
		lblEstadoCivil.setBounds(10, 147, 94, 14);
		contentPane.add(lblEstadoCivil);
		
		txtEstadoCivil = new JTextField();
		txtEstadoCivil.setBounds(95, 144, 329, 20);
		contentPane.add(txtEstadoCivil);
		txtEstadoCivil.setColumns(10);
		
		lblId.setText(String.valueOf(f.getIdCliente()));
		txtNome.setText(f.getNome());
		txtCPF.setText(f.getCPF());
		txtEndereco.setText(f.getEndereco());
		txtEstadoCivil.setText(f.getEstadoCivil());
		
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cliente f = new cliente();
				clienteDAO dao = new clienteDAO();
				f.setIdCliente(Integer.parseInt(lblId.getText()));
				f.setNome(txtNome.getText());
				f.setEndereco(txtEndereco.getText());
				f.setCPF(txtCPF.getText());
				f.setEstadoCivil(txtEstadoCivil.getText());
				dao.update(f);
			}
		});
		
		btnAtualizar.setBounds(10, 209, 112, 23);
		contentPane.add(btnAtualizar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(179, 209, 89, 23);
		contentPane.add(btnCancelar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(335, 209, 89, 23);
		contentPane.add(btnLimpar);
		
		
	}

}
