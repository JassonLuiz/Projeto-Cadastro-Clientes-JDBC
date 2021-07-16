package Model;

public class Contato {
	
	private Long idContato;
	private String email;
	private String ddd;
	private String telefone;
	private Cliente cliente;
	
	
	public Long getIdContato() {
		return idContato;
	}
	public void setIdContato(Long idContato) {
		this.idContato = idContato;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDdd() {
		return ddd;
	}
	public void setDdd(String ddd) {
		this.ddd = ddd;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	@Override
	public String toString() {
		return "Contato [idContato=" + idContato + ", email=" + email + ", ddd=" + ddd + ", telefone=" + telefone
				+ ", cliente=" + cliente + "]";
	}
}
