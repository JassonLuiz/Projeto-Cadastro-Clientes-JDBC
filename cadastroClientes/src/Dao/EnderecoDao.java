package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import JDBCUtil.ConnectionJDBC;
import Model.Endereco;

public class EnderecoDao {
	
	public void save(Endereco endereco) throws SQLException, ClassNotFoundException{
		String sql = "INSERT INTO ENDERECO (CEP, RUA, NUMERO, BAIRRO, CIDADE, ESTADO, ID_CLIENTE) VALUES (?, ?, ?, ?, ?, ?, ?)";
		Connection conexao;
		
		try {
			conexao = ConnectionJDBC.getConexao();
			PreparedStatement end = conexao.prepareStatement(sql);
			
			end.setString(1, endereco.getCep());
			end.setString(2, endereco.getRua());
			end.setString(3, endereco.getNumero());
			end.setString(4, endereco.getBairro());
			end.setString(5, endereco.getCidade());
			end.setString(6, endereco.getEstado());
			end.setLong(7, endereco.getCliente().getIdCliente());
			
			end.execute();
			
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void delete(Long idEndereco) throws SQLException, ClassNotFoundException{
		String sql = "DELETE FROM ENDERECO WHERE ID_ENDERECO=?";
		Connection conexao;
		
		try {
			conexao = ConnectionJDBC.getConexao();
			PreparedStatement end = conexao.prepareStatement(sql);
			
			end.setLong(1, idEndereco);
			
			end.execute();
			
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public List<Endereco> listAll(){
		String sql = "SELECT * FROM ENDERECO";
		Connection conexao;
		
		List<Endereco> listEnderecos = new ArrayList<Endereco>();
		
		try {
			conexao = ConnectionJDBC.getConexao();
			PreparedStatement end = conexao.prepareStatement(sql);
			ResultSet resultado = end.executeQuery();
			
			while(resultado.next()) {
				
				Endereco endereco = new Endereco();
				
				endereco.setIdEndereco(resultado.getLong("ID_ENDERECO"));
				endereco.setCep(resultado.getString("CEP"));
				endereco.setRua(resultado.getString("RUA"));
				endereco.setNumero(resultado.getString("NUMERO"));
				endereco.setBairro(resultado.getString("BAIRRO"));
				endereco.setCidade(resultado.getString("CIDADE"));
				endereco.setEstado(resultado.getString("ESTADO"));
				
				listEnderecos.add(endereco);
			}
			
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return listAll();
	}
	
	public void atualizar(Endereco endereco) throws SQLException, ClassNotFoundException {
			String sql = "UPDATE ENDERECO SET CEP=?, RUA=?, NUMERO=?, BAIRRO=?, CIDADE=?, ESTADO=? WHERE ID_ENDERECO=?";
			Connection conexao;
			
			try {
				conexao = ConnectionJDBC.getConexao();
				PreparedStatement end = conexao.prepareStatement(sql);
				
				end.setString(1, endereco.getCep());
				end.setString(2, endereco.getRua());
				end.setString(3, endereco.getNumero());
				end.setString(4, endereco.getBairro());
				end.setString(5, endereco.getCidade());
				end.setString(6, endereco.getEstado());
				end.setLong(7, endereco.getIdEndereco());
				
			} catch (SQLException | ClassNotFoundException e) {
					e.printStackTrace();
			}
			
	   }
	
	public void buscId(Long idEndereco) {
		String sql = "SELECT * FROM CONTATO WHERE ID_ENDERECO=?";
		Connection conexao;
		
		try {
			conexao = ConnectionJDBC.getConexao();
			PreparedStatement end = conexao.prepareStatement(sql);
			
			end.setLong(1, idEndereco);
			
			System.out.println(end);
			
		} catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
		}
	}
	

}
