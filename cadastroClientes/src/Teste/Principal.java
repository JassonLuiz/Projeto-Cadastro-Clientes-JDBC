package Teste;

import java.sql.SQLException;

import Dao.ClienteDao;
import Dao.ContatoDao;
import Dao.EnderecoDao;
import Model.Cliente;
import Model.Contato;
import Model.Endereco;

public class Principal {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Cliente cliente = new Cliente();
		cliente.setNome("Jasson");
		cliente.setCpf("85287169418");
		cliente.setSexo("M");
		cliente.setAnoNasc("26011999");
		ClienteDao clienteDAO = new ClienteDao();
		clienteDAO.save(cliente);

		

	}

}
