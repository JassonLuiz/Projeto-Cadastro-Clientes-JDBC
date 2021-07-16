package Model;

public class Cliente {
	
	private Long idCliente;
	private String nome;
	private String cpf;
	private String sexo;
	private String anoNasc;
	
	
	public Long getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getAnoNasc() {
		return anoNasc;
	}
	public void setAnoNasc(String anoNasc) {
		this.anoNasc = anoNasc;
	}
	
	
	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", nome=" + nome + ", cpf=" + cpf + ", sexo=" + sexo + ", anoNasc="
				+ anoNasc + "]";
	}
	
}
