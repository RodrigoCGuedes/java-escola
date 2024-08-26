package escola;

import interfaces.Alfabetica;

public class Pessoa implements Alfabetica{

	// -- Atributos

	private String nome;
	private boolean genero;
	private String telefone;
	private String email;

	// --> Contrutores

	public Pessoa(String nome, boolean genero, String telefone, String email) {
		this.nome = nome;
		this.genero = genero;
		this.telefone = telefone;
		this.email = email;
	}

	public Pessoa(Pessoa pessoa) {
		this.nome = pessoa.getNome();
		this.genero = pessoa.getGenero();
		this.telefone = pessoa.getTelefone();
		this.email = pessoa.getEmail();
	}

	// --> Métodos

	public String getNome() {
		return this.nome;
	}

	public boolean getGenero() {
		return this.genero;
	}

	public String getTelefone() {
		return this.telefone;
	}

	public String getEmail() {
		return this.email;
	}

	public Pessoa getPessoa() {
		return new Pessoa(this.nome, this.genero, this.telefone, this.email);
	}

	public String toString() {
		return "Telefone: " + this.telefone + "\nE-mail: " + this.email;
	}

}
