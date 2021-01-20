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

import model.bean.filme;
import model.dao.filmeDAO;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowEvent;

public class JFlistarFilmes extends JFrame {

	private JPanel contentPane;
	private JTable tblFilmes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFlistarFilmes frame = new JFlistarFilmes();
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
	public JFlistarFilmes() {
		addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent e) {
				readJTable();
			}
			public void windowLostFocus(WindowEvent e) {
			}
		});
		setTitle("Listar filmes");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 691, 421);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 655, 284);
		contentPane.add(scrollPane);
		
		tblFilmes = new JTable();
		tblFilmes.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"idFilme", "T\u00EDtulo", "Categoria", "Tempo", "Sinopse"
			}
		));
		scrollPane.setViewportView(tblFilmes);
		
		JButton btnCadastrar = new JButton("Cadastrar filme");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFcadastrarFilme cf = new JFcadastrarFilme();
				cf.setVisible(true);
			}
		});
		btnCadastrar.setBounds(10, 330, 139, 23);
		contentPane.add(btnCadastrar);
		
		JButton btnAlterar = new JButton("Alterar filme");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(tblFilmes.getSelectedRow()!= -1) {
					JFAtualizarFilme af = new JFAtualizarFilme(
							(int)tblFilmes.getValueAt(tblFilmes.getSelectedRow(), 0));
					af.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "Selecione um filme!");
				}
				readJTable();
			}
		});
		btnAlterar.setBounds(186, 330, 111, 23);
		contentPane.add(btnAlterar);
		
		JButton btnExcluir = new JButton("Excluir filme");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(tblFilmes.getSelectedRow() != -1) {
					
					int opcao = JOptionPane.showConfirmDialog(null, "Deseja excluir o filme selecionado?"
							,"Exclus�o",JOptionPane.YES_NO_OPTION);
					if (opcao == 0) {
						filmeDAO dao = new filmeDAO();
						filme f = new filme();
						f.setIdFilme((int) tblFilmes.getValueAt(tblFilmes.getSelectedRow(), 0));
						dao.delete(f);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Selecione um filme!");
				}
				readJTable();
			}
		});
		btnExcluir.setBounds(526, 330, 139, 23);
		contentPane.add(btnExcluir);
		
		JButton btnNewButton = new JButton("Cancelar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setBounds(360, 330, 89, 23);
		contentPane.add(btnNewButton);
		
		readJTable();
	}
	
	public void readJTable() {
		DefaultTableModel modelo = (DefaultTableModel) tblFilmes.getModel();
		modelo.setNumRows(0);
		filmeDAO fdao = new filmeDAO();
		for(filme f : fdao.read()) {
			modelo.addRow(new Object[] {
					f.getIdFilme(),
					f.getTitulo(),
					f.getCategoria(),
					f.getTempo(),
					f.getSinopse()
			});
		}
		
	}
}