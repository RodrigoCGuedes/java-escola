package escola;

public class Membro {
	
	// -- Atributos
	
	private String nome;
	private String telefone;
	private String email;
	
	// --> Contrutores
	
	public Membro(String nome, String telefone, String email) {
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
	}
	
	public Membro(Membro membro) {
		this.nome = membro.nome;
		this.telefone = membro.telefone;
		this.email = membro.email;
	}
	
	// --> Métodos
	
	public String getNome() {
		return this.nome;
	}
	
	public String getTelefone() {
		return this.telefone;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public String toString() {
		return "Nome: " + nome + " - Telefone: " + telefone + " - E-mail: " + email;
	}
	
}
