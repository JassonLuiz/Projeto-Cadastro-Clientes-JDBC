package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import JDBCUtil.ConnectionJDBC;
import Model.Contato;

public class ContatoDao {

	public void save(Contato contato) throws SQLException, ClassNotFoundException {
		String sql = "INSERT INTO CONTATO (EMAIL, DDD, NUMERO, ID_CLIENTE) VALUES (?, ?, ?, ?)";
		Connection conexao;

		try {
			conexao = ConnectionJDBC.getConexao();
			PreparedStatement cnt = conexao.prepareStatement(sql);

			cnt.setString(1, contato.getEmail());
			cnt.setString(2, contato.getDdd());
			cnt.setString(3, contato.getTelefone());
			cnt.setLong(4, contato.getCliente().getIdCliente());

			cnt.execute();

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	public void delete(Long idContato) throws SQLException, ClassNotFoundException {
		String sql = "DELETE FROM CONTATO WHERE ID_CONTATO=?";
		Connection conexao;

		try {
			conexao = ConnectionJDBC.getConexao();
			PreparedStatement cnt = conexao.prepareStatement(sql);

			cnt.setLong(1, idContato);

			cnt.execute();

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public List<Contato> listAll() throws SQLException, ClassNotFoundException {
		String sql = "SELECT * FROM CONTATO";
		Connection conexao;

		List<Contato> listContatos = new ArrayList<Contato>();

		try {
			conexao = ConnectionJDBC.getConexao();
			PreparedStatement cnt = conexao.prepareStatement(sql);
			ResultSet resultado = cnt.executeQuery();

			while (resultado.next()) {

				Contato contato = new Contato();

				contato.setIdContato(resultado.getLong("ID_CONTATO"));
				contato.setEmail(resultado.getString("EMAIL"));
				contato.setDdd(resultado.getString("DDD"));
				contato.setTelefone(resultado.getString("TELEFONE"));

				listContatos.add(contato);
			}

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		return listAll();
	}

	public void atualizar(Contato contato) throws SQLException, ClassNotFoundException {
		String sql = "UPDATE CONTATO SET EMAIL=?, DDD=?, TELEFONE=? WHERE ID_CONTATO=?";
		Connection conexao;

		try {
			conexao = ConnectionJDBC.getConexao();
			PreparedStatement cnt = conexao.prepareStatement(sql);

			cnt.setString(1, contato.getEmail());
			cnt.setString(2, contato.getDdd());
			cnt.setString(3, contato.getTelefone());
			cnt.setLong(5, contato.getIdContato());

			cnt.execute();

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	public void buscId(Long idContato) throws SQLException, ClassNotFoundException {
		String sql = "SELECT * FROM CONTATO WHERE ID_CONTATO=?";
		Connection conexao;
		
		try {
			conexao = ConnectionJDBC.getConexao();
			PreparedStatement cnt = conexao.prepareStatement(sql);

			cnt.setLong(1, idContato);

			System.out.println(cnt);

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
