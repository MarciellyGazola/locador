package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import model.bean.filme;
import model.dao.filmeDAO;

public class JFAtualizarFilme extends JFrame {

	private JPanel contentPane;
	private JTextField txtTitulo;
	private JTextField textCategoria;
	private JTextField txtSinopse;
	
	private static int IdFilme;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFAtualizarFilme frame = new JFAtualizarFilme(IdFilme);
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
	public JFAtualizarFilme(int IdFilme) {
		setTitle("Alterar Filme");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 461, 473);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblAtualizar = new JLabel("Atualizar Filme");
		lblAtualizar.setBounds(5, 5, 424, 20);
		lblAtualizar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAtualizar.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblAtualizar);
		
		filmeDAO fdao = new filmeDAO();
		filme f = fdao.read(IdFilme);
		
		JLabel lblID = new JLabel("ID do filme");
		lblID.setBounds(320, 10, 87, 14);
		contentPane.add(lblID);
		
		JLabel lblId = new JLabel("New label");
		lblId.setBounds(383, 10, 46, 14);
		contentPane.add(lblId);
		
		JLabel lblTitulo = new JLabel("T\u00EDtulo");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTitulo.setBounds(5, 23, 46, 14);
		contentPane.add(lblTitulo);
		
		txtTitulo = new JTextField();
		txtTitulo.setBounds(5, 45, 424, 20);
		contentPane.add(txtTitulo);
		txtTitulo.setColumns(10);
		
		JLabel lblSinopse = new JLabel("Sinopse");
		lblSinopse.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSinopse.setBounds(5, 76, 46, 14);
		contentPane.add(lblSinopse);
		
		txtSinopse = new JTextField();
		txtSinopse.setBounds(5, 101, 424, 123);
		contentPane.add(txtSinopse);
		txtSinopse.setColumns(10);
		
		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCategoria.setBounds(5, 235, 63, 14);
		contentPane.add(lblCategoria);
		
		textCategoria = new JTextField();
		textCategoria.setBounds(5, 260, 424, 20);
		contentPane.add(textCategoria);
		textCategoria.setColumns(10);
		
		JLabel lblTempo = new JLabel("Tempo");
		lblTempo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTempo.setBounds(5, 291, 46, 14);
		contentPane.add(lblTempo);
	
		JSpinner spTempo = new JSpinner();
		spTempo.setBounds(5, 316, 73, 37);
		contentPane.add(spTempo);
		
		JLabel lblImagem = new JLabel("Imagem");
		lblImagem.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblImagem.setBounds(165, 291, 46, 14);
		contentPane.add(lblImagem);
		
		JLabel lblAudio = new JLabel("\u00C1udio");
		lblAudio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAudio.setBounds(320, 291, 46, 14);
		contentPane.add(lblAudio);
		
		JRadioButton btn2d = new JRadioButton("2D");
		btn2d.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btn2d.setBounds(165, 316, 109, 23);
		contentPane.add(btn2d);
		
		JRadioButton btn3d = new JRadioButton("3D");
		btn3d.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btn3d.setBounds(165, 347, 109, 23);
		contentPane.add(btn3d);
		
		ButtonGroup imagem = new ButtonGroup();
		imagem.add(btn2d);
		imagem.add(btn3d);
		
		JRadioButton btnDublado = new JRadioButton("Dublado");
		btnDublado.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnDublado.setBounds(320, 316, 109, 23);
		contentPane.add(btnDublado);
		
		JRadioButton btnLegendado = new JRadioButton("Legendado");
		btnLegendado.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnLegendado.setBounds(320, 347, 109, 23);
		contentPane.add(btnLegendado);
		
		ButtonGroup audio = new ButtonGroup();
		audio.add(btnDublado);
		audio.add(btnLegendado);
		
		lblId.setText(String.valueOf(f.getIdFilme()));
		txtTitulo.setText(f.getTitulo());
		txtSinopse.setText(f.getSinopse());
		textCategoria.setText(f.getCategoria());
		spTempo.setValue(f.getTempo());
		if(f.isImagem3d() == true) {
			btn3d.setSelected(true);
		}else if (f.isImagem3d() == false) {
			btn2d.setSelected(true);
		}
		if(f.isDublado() == true) {
			btnDublado.setSelected(true);
		}else if (f.isDublado() == false) {
			btnLegendado.setSelected(true);
		}
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				filme f = new filme();
				filmeDAO dao = new filmeDAO();
				f.setIdFilme(Integer.parseInt(lblId.getText()));
				f.setTitulo(txtTitulo.getText());
				f.setSinopse(txtSinopse.getText());
				f.setCategoria(textCategoria.getText());
				f.setTempo(Integer.parseInt(spTempo.getValue().toString()));
				if(btn2d.isSelected()) {
					f.setImagem3d(false);
				}else if (btn3d.isSelected()) {
					f.setImagem3d(true);
				}
				if(btnDublado.isSelected()) {
					f.setDublado(true);
				}else if (btnLegendado.isSelected()) {
					f.setDublado(false);
				}
				dao.update(f);
			}
				
		});
		btnAtualizar.setBounds(5, 377, 109, 23);
		contentPane.add(btnAtualizar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(320, 377, 109, 23);
		contentPane.add(btnLimpar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(165, 377, 109, 23);
		contentPane.add(btnCancelar);
		
	}
}