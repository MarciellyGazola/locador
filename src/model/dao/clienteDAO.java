package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import connection.ConnectionFactory;
import model.bean.cliente;

public class clienteDAO {

	public void create(cliente f) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("INSERT INTO CLIENTE (nome, cpf, endere�o, EstadoCivil) VALUES"
					+ "(?,?,?,?)");
			stmt.setString(1, f.getNome());
			stmt.setInt(2, f.getCPF());
			stmt.setString(3, f.getEndereco());
			stmt.setString(4, f.getEstadoCivil());
			
			stmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "Cliente Salvo com sucesso!");
		} catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao salvar: "+ e);
		}finally{
			ConnectionFactory.closeConnection(con, stmt);
		}
	}
	public List<cliente> read(){
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<cliente> clientes = new ArrayList<>();
		
		try {
			stmt = con.prepareStatement("SELECT * FROM cliente;");
			rs = stmt.executeQuery();
			while (rs.next()) {
				cliente f = new cliente();
				f.setIdCliente(rs.getInt("idCliente"));
				f.setNome(rs.getString("nome"));
				f.setCPF(rs.getInt("cpf"));
				f.setEndereco(rs.getString("endere�o"));
				f.setEstadoCivil(rs.getString("estadoCivil"));
				clientes.add(f);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao buscar as informa��es do BD: " + e);
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
		return clientes;
	}
	public cliente read(int idCliente) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		cliente f = new cliente();
		
		try {
			stmt = con.prepareStatement("SELECT * FROM cliente WHERE idCliente=? LIMIT 1;");
			stmt.setInt(1, idCliente);
			rs = stmt.executeQuery();
			if(rs != null && rs.next()) {
				f.setIdCliente(rs.getInt("idCliente"));
				f.setNome(rs.getString("nome"));
				f.setCPF(rs.getInt("CPF"));
				f.setEndereco(rs.getString("endere�o"));
				f.setEstadoCivil(rs.getString("estado civil"));
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
		return f;
	}
	
	
	public void update(cliente f) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("UPDATE cliente SET nome=?, CPF=?,"
					+ "endereco=?, estadoCivil=? WHERE idCliente=?;");
			stmt.setString(1, f.getNome());
			stmt.setInt(2, f.getCPF());
			stmt.setString(3, f.getEndereco());
			stmt.setString(4, f.getEstadoCivil());
			stmt.setInt(7, f.getIdCliente());
			stmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "Clientes atualizado com sucesso!");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao atualizar: "+ e);
		}finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}
	
}