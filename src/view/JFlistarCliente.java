package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.bean.cliente;
import model.dao.clienteDAO;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JFlistarCliente extends JFrame {

	private JPanel contentPane;
	private JTable tblClientes;
	private JButton btnAlterar;
	private JButton btnExcluir;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFlistarCliente frame = new JFlistarCliente();
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
	public JFlistarCliente() {
		setTitle("Listar Clientes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 670, 424);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 634, 300);
		contentPane.add(scrollPane);
		
		tblClientes = new JTable();
		tblClientes.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"idCliente", "Nome", "CPF", "Endere\u00E7o", "Estado  Civil"
			}
		));
		scrollPane.setViewportView(tblClientes);
		
		JButton btnCadastrar = new JButton("Cadastrar Cliente");
		btnCadastrar.setBounds(10, 351, 150, 23);
		contentPane.add(btnCadastrar);
		
		btnAlterar = new JButton("Alterar cliente");
		btnAlterar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(tblClientes.getSelectedRow()!= -1) {
						JFAtualizarCliente af = new JFAtualizarCliente(
								(int)tblClientes.getValueAt(tblClientes.getSelectedRow(), 0));
						af.setVisible(true);
					}else {
						JOptionPane.showMessageDialog(null, "Selecione um cliente!");
					}
					readJTable();
				}
			});
		btnAlterar.setBounds(277, 351, 123, 23);
		contentPane.add(btnAlterar);
		
		btnExcluir = new JButton("Excluir cliente");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tblClientes.getSelectedRow() != -1) {
					
					int opcao = JOptionPane.showConfirmDialog(null, "Deseja excluir o filme selecionado?"
							,"Exclusão",JOptionPane.YES_NO_OPTION);
					if (opcao == 0) {
						clienteDAO dao = new clienteDAO();
						cliente f = new cliente();
						f.setIdCliente((int) tblClientes.getValueAt(tblClientes.getSelectedRow(), 0));
						dao.delete(f);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Selecione um filme!");
				}
				readJTable();
			}
		});
		btnExcluir.setBounds(494, 351, 150, 23);
		contentPane.add(btnExcluir);
		
		readJTable();
	}
	
	public void readJTable() {
		DefaultTableModel modelo = (DefaultTableModel) tblClientes.getModel();
		modelo.setNumRows(0);
		clienteDAO fdao = new clienteDAO();
		for(cliente f : fdao.read()) {
			modelo.addRow(new Object[] {
					f.getIdCliente(),
					f.getNome(),
					f.getCPF(),
					f.getEndereco(),
					f.getEstadoCivil()
			});
		}
		
	}
}
