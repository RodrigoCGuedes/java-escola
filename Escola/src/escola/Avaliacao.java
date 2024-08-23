package escola;

import excecao.NotaInvalidaExcecao;

public class Avaliacao {
	
	// --> Atributos
	
	private String id;
	private String descricao;
	private float valor;

	private static int ultimoId = 1;
	
	// --> Construtores

	public Avaliacao(String descricao, float valor) throws NotaInvalidaExcecao {
		this.id = geraId();
		this.descricao = descricao;
		setValor(valor);
	}

	public Avaliacao(Avaliacao avaliacao) throws NotaInvalidaExcecao {
		this.id = avaliacao.geraId();
		this.descricao = avaliacao.getDescricao();
		setValor(avaliacao.getValor());
	}
	
	// --> Métodos

	private String geraId() {
		return "A" + Avaliacao.ultimoId++;
	}

	public String getId() {
		return this.id;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public float getValor() {
		return this.valor;
	}
	
	public boolean setValor(float valor) throws NotaInvalidaExcecao{
		if(valor < 0 || valor > 100) {
			throw new NotaInvalidaExcecao(getId());
		}
		this.valor = valor;
		return true;
	}
	
	public String toString() {
		return this.id + " -> " + descricao + ": " + valor;
	}

}
