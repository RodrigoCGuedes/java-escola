package escola;

import comparadores.CriterioValorCrescente;
import comparadores.CriterioValorDecrescente;
import excecao.NotaInvalidaExcecao;
import interfaces.Alfabetico;
import interfaces.Valor;
import lista.ListaGenerica;

public class Disciplina implements Alfabetico, Valor {

	// --> Atributos

	private String id;
	private String nome;
	private String descricao;
	private ListaGenerica<Avaliacao> avaliacoes;

	private static int ultimoId = 1;

	// --> Construtores

	public Disciplina(String nome, String descricao) {
		this.id = geraId();
		this.nome = nome;
		this.descricao = descricao;
		this.avaliacoes = new ListaGenerica<>();
	}

	public Disciplina(Disciplina disciplina) throws NotaInvalidaExcecao {
		this.id = disciplina.getId();
		this.nome = disciplina.getNome();
		this.descricao = disciplina.getDescricao();
		this.avaliacoes = new ListaGenerica<>(disciplina.getAvaliacoesCrescente());
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
		for (Avaliacao contador : this.avaliacoes.getArray()) {
			if (contador.getId().equals(id)) {
				return new Avaliacao(contador);
			}
		}
		return null;
	}

	public ListaGenerica<Avaliacao> getAvaliacoesCrescente() throws NotaInvalidaExcecao {
		return new ListaGenerica<Avaliacao>(this.avaliacoes.ordenar(new CriterioValorCrescente()));
	}

	public ListaGenerica<Avaliacao> getAvaliacoesDecrescente() throws NotaInvalidaExcecao {
		return new ListaGenerica<Avaliacao>(this.avaliacoes.ordenar(new CriterioValorDecrescente()));
	}

	public boolean insereAvaliacao(Avaliacao avaliacao) {
		if (avaliacao == null) {
			return false;
		}
		return this.avaliacoes.adicionar(avaliacao);
	}

	public boolean insereAvaliacao(String descricao, float valor) throws NotaInvalidaExcecao {
		if (descricao == null) {
			return false;
		}
		return this.avaliacoes.adicionar(new Avaliacao(descricao, valor));
	}

	public boolean removeAvaliacao(String id) {
		for (Avaliacao contador : avaliacoes.getArray()) {
			if (contador.getId().equals(id)) {
				return this.avaliacoes.remover(contador);
			}
		}
		return false;
	}

	public float calculaMedia() {
		float resultado = 0;
		int totalAvaliacoes = this.avaliacoes.tamanho();
		for (Avaliacao contador : this.avaliacoes.getArray()) {
			resultado += contador.getValor();
		}
		return totalAvaliacoes > 0 ? resultado / totalAvaliacoes : 0;
	}

	public String exibirAvaliacoes() {
		StringBuilder resultado = new StringBuilder();
		for (Avaliacao contador : this.avaliacoes.getArray()) {
			resultado.append(contador).append("\n");
		}
		return resultado.toString();
	}

	@Override
	public String toString() {
		return this.id + " -> " + this.nome + "\n - " + this.descricao;
	}
}
