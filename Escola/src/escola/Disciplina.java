package escola;

import java.util.ArrayList;

public class Disciplina {
	
	// --> Atributos
	
	private String id;
	private String descricao;
	private ArrayList<Avaliacao> avaliacoes;

	private static int ultimoId = 1;
	
	// --> Construtores

	public Disciplina(String descricao) {
		this.id = geraId();
		this.descricao = descricao;
		this.avaliacoes = new ArrayList<>();
	}

	public Disciplina(Disciplina disciplina) {
		this.id = geraId();
		this.descricao = disciplina.getDescricao();
		this.avaliacoes = disciplina.getAvaliacoes();
	}

	// --> Métodos
	
	private String geraId() {
		return "D" + Disciplina.ultimoId++;
	}

	public String getId() {
		return this.id;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public Avaliacao getAvaliacao(String id) {
		for (Avaliacao contador : this.avaliacoes) {
			if (contador.getId().equals(id)) {
				return new Avaliacao(contador);
			}
		}
		return null;
	}

	public ArrayList<Avaliacao> getAvaliacoes() {
		ArrayList<Avaliacao> copia = new ArrayList<>();
		for (Avaliacao contador : this.avaliacoes) {
			copia.add(new Avaliacao(contador));
		}
		return copia;
	}

	public boolean insereAvaliacao(Avaliacao avaliacao) {
		if (avaliacao == null) {
			return false;
		}
		this.avaliacoes.add(avaliacao);
		return true;
	}

	public boolean insereAvaliacao(String descricao, float valor) {
		if (descricao == null) {
			return false;
		}
		this.avaliacoes.add(new Avaliacao(descricao, valor));
		return true;
	}
	
	public boolean removeAvaliacao(String id) {
		for (Avaliacao contador : avaliacoes) {
			if (contador.getId().equals(id)) {
				this.avaliacoes.remove(contador);
				return true;
			}
		}
		return false;
	}

	public float calculaMedia() {
		float resultado = 0;
		for (Avaliacao contador : this.avaliacoes) {
			resultado += contador.getValor();
		}
		return resultado / this.avaliacoes.size();
	}

	public String exibirAvaliacoes() {
		String resultado = "";
		for (Avaliacao contador : this.avaliacoes) {
			resultado += contador + "\n";
		}
		return resultado;
	}

	public String toString() {
		return id + " -> " + descricao;
	}

}
