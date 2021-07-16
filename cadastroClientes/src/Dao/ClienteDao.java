package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import JDBCUtil.ConnectionJDBC;
import Model.Cliente;

public class ClienteDao {

	public void save(Cliente cliente) throws SQLException, ClassNotFoundException {

		String sql = "INSERT INTO CLIENTE (NOME, CPF, SEXO, ANO_NASC) VALUES (?, ?, ?, ?)";
		Connection conexao;

		try {
			conexao = ConnectionJDBC.getConexao();
			PreparedStatement clt = conexao.prepareStatement(sql);

			clt.setString(1, cliente.getNome());
			clt.setString(2, cliente.getCpf());
			clt.setString(3, cliente.getSexo());
			clt.setString(4, cliente.getAnoNasc());

			clt.execute();

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	public void delete(Long idCliente) throws SQLException, ClassNotFoundException {
		String sql = "DELETE FROM CLIENTE WHERE ID_CLIENTE=?";
		Connection conexao;

		try {

			conexao = ConnectionJDBC.getConexao();
			PreparedStatement clt = conexao.prepareStatement(sql);

			clt.setLong(1, idCliente);

			clt.execute();

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	public List<Cliente> listAll() throws SQLException, ClassNotFoundException {

		String sql = "SELECT * FROM CLIENTE";
		Connection conexao;

		List<Cliente> listClientes = new ArrayList<Cliente>();

		try {
			conexao = ConnectionJDBC.getConexao();
			PreparedStatement clt = conexao.prepareStatement(sql);
			ResultSet resultado = clt.executeQuery();

			while (resultado.next()) {
				Cliente cliente = new Cliente();

				cliente.setIdCliente(resultado.getLong("ID_CLIENTE"));
				cliente.setNome(resultado.getString("NOME"));
				cliente.setCpf(resultado.getString("CPF"));
				cliente.setSexo(resultado.getString("SEXO"));
				cliente.setAnoNasc(resultado.getString("ANO_NASC"));

				listClientes.add(cliente);

			}

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		return listAll();
	}

	public void atualize(Cliente cliente) throws SQLException, ClassNotFoundException {
		String sql = "UPDATE CLIENTE SET NOME=?, CPF=?, SEXO=?, ANO_NAS=? WHERE ID_CLIENTE=?";
		Connection conexao;

		try {
			conexao = ConnectionJDBC.getConexao();
			PreparedStatement clt = conexao.prepareStatement(sql);

			clt.setString(1, cliente.getNome());
			clt.setString(2, cliente.getCpf());
			clt.setString(3, cliente.getSexo());
			clt.setString(4, cliente.getAnoNasc());
			clt.setLong(5, cliente.getIdCliente());

			clt.execute();

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
	
	public void buscId(Long idCliente) {
		String sql = "SELECT * FROM CLIENTE WHERE ID_CLIENTE=?";
		Connection conexao;
		
		try {
			conexao = ConnectionJDBC.getConexao();
			PreparedStatement clt = conexao.prepareStatement(sql);
			
		    clt.setLong(1, idCliente);
		    
		    System.out.println(clt);
			
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
