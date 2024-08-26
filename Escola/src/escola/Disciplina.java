package escola;

import java.util.ArrayList;
import java.util.Collections;
import excecao.NotaInvalidaExcecao;
import interfaces.Alfabetica;
import interfaces.Valor;
import comparadores.CriterioValorCrescente;
import comparadores.CriterioValorDecrescente;

public class Disciplina implements Alfabetica, Valor {
	
	// --> Atributos
	
	private String id;
	private String nome;
	private String descricao;
	private ArrayList<Avaliacao> avaliacoes;

	private static int ultimoId = 1;
	
	// --> Construtores

	public Disciplina(String nome, String descricao) {
		this.id = geraId();
		this.nome = nome;
		this.descricao = descricao;
		this.avaliacoes = new ArrayList<>();
	}

	public Disciplina(Disciplina disciplina) throws NotaInvalidaExcecao {
		this.id = disciplina.getId();
		this.nome = disciplina.getNome();
		this.descricao = disciplina.getDescricao();
		this.avaliacoes = disciplina.getAvaliacoesCrescente();
	}

	// --> Métodos
	
	private String geraId() {
		return "D" + Disciplina.ultimoId++;
	}

	public String getId() {
		return this.id;
	}
	
	public String getNome() {
		return this.nome;
	}

	public String getDescricao() {
		return this.descricao;
	}
	
	public float getValor() {
		return calculaMedia();
	}

	public Avaliacao getAvaliacao(String id) throws NotaInvalidaExcecao {
		for (Avaliacao contador : this.avaliacoes) {
			if (contador.getId().equals(id)) {
				return new Avaliacao(contador);
			}
		}
		return null;
	}

	public ArrayList<Avaliacao> getAvaliacoesCrescente() throws NotaInvalidaExcecao {
		ArrayList<Avaliacao> copia = new ArrayList<>();
		for (Avaliacao contador : this.avaliacoes) {
			copia.add(new Avaliacao(contador));
		}
		Collections.sort(copia, new CriterioValorCrescente());
		return copia;
	}
	
	public ArrayList<Avaliacao> getAvaliacoesDecrescente() throws NotaInvalidaExcecao {
		ArrayList<Avaliacao> copia = new ArrayList<>();
		for (Avaliacao contador : this.avaliacoes) {
			copia.add(new Avaliacao(contador));
		}
		Collections.sort(copia, new CriterioValorDecrescente());
		return copia;
	}

	public boolean insereAvaliacao(Avaliacao avaliacao) {
		if (avaliacao == null) {
			return false;
		}
		this.avaliacoes.add(avaliacao);
		return true;
	}

	public boolean insereAvaliacao(String descricao, float valor) throws NotaInvalidaExcecao {
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
		return this.id + " -> " + this.nome + "\n - " + this.descricao;
	}

}
