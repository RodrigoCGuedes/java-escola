package escola;

public class Avaliacao {
	
	// --> Atributos
	
	private String id;
	private String descricao;
	private float valor;

	private static int ultimoId = 1;
	
	// --> Construtores

	public Avaliacao(String descricao, float valor) {
		this.id = geraId();
		this.descricao = descricao;
		this.valor = valor;
	}

	public Avaliacao(Avaliacao avaliacao) {
		this.id = avaliacao.geraId();
		this.descricao = avaliacao.getDescricao();
		this.valor = avaliacao.getValor();
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
	
	public String toString() {
		return this.id + " -> " + descricao + ": " + valor;
	}

}
