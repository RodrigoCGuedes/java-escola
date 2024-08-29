package escola;

import excecao.NotaInvalidaExcecao;
import excecao.HistoricoVazioExcecao;
import interfaces.Membro;
import comparadores.CriterioValorCrescente;
import comparadores.CriterioValorDecrescente;
import comparadores.CriterioAlfabeticoCrescente;
import comparadores.CriterioAlfabeticoDecrescente;
import lista.ListaGenerica;

public class Aluno extends Pessoa implements Membro, Comparable<Aluno> {

	private Matricula matricula;
	private ListaGenerica<Disciplina> historico;

	public Aluno(Pessoa pessoa) {
		super(new Pessoa(pessoa));
		this.matricula = new Matricula();
		this.historico = new ListaGenerica<>();
	}

	public Aluno(Aluno aluno) throws NotaInvalidaExcecao {
		super(aluno.getPessoa());
		this.matricula = new Matricula(aluno.getMatricula());
		this.historico = aluno.historicoCrescente();
	}

	public String getMatricula() {
		return this.matricula.get();
	}

	public Disciplina getDisciplina(String id) throws NotaInvalidaExcecao {
		for (Disciplina contador : this.historico.getArray()) {
			if (contador.getId().equals(id)) {
				return new Disciplina(contador);
			}
		}
		return null;
	}

	public Character getConceito() throws HistoricoVazioExcecao {
		if (!(this.historico.tamanho() > 0))
			return Conceito.calculaConceito(calculaIRA());
		return null;
	}

	public boolean insereDisciplina(Disciplina disciplina) throws NotaInvalidaExcecao {
		if (disciplina == null) {
			return false;
		}
		historico.adicionar(new Disciplina(disciplina));
		return true;
	}

	public boolean insereDisciplina(String nome, String descricao) {
		if (descricao == null) {
			return false;
		}
		historico.adicionar(new Disciplina(nome, descricao));
		return true;
	}

	public boolean removeDisciplina(String id) {
		for (Disciplina contador : historico.getArray()) {
			if (contador.getId().equals(id)) {
				historico.remover(contador);
				return true;
			}
		}
		return false;
	}

	public ListaGenerica<Disciplina> historicoAlfabeticoCrescente() throws NotaInvalidaExcecao {
		return new ListaGenerica<>(historico.ordenar(new CriterioAlfabeticoCrescente()));
	}

	public ListaGenerica<Disciplina> historicoAlfabeticoDecrescente() throws NotaInvalidaExcecao {
		return new ListaGenerica<>(historico.ordenar(new CriterioAlfabeticoDecrescente()));
	}

	public ListaGenerica<Disciplina> historicoCrescente() throws NotaInvalidaExcecao {
		return new ListaGenerica<>(historico.ordenar(new CriterioValorCrescente()));
	}

	public ListaGenerica<Disciplina> historicoDecrescente() throws NotaInvalidaExcecao {
		return new ListaGenerica<>(historico.ordenar(new CriterioValorDecrescente()));
	}

	public String exibirNotasCrescente() throws NotaInvalidaExcecao {
		String resultado = "";
		for (Disciplina disciplina : historicoCrescente().getArray()) {
			resultado += "\n\n" + disciplina + ":";
			for (Avaliacao avaliacao : disciplina.getAvaliacoesCrescente()) {
				resultado += "\n\t" + avaliacao;
			}
		}
		return resultado;
	}

	public String exibirNotasDecrescente() throws NotaInvalidaExcecao {
		String resultado = "";
		for (Disciplina disciplina : historicoDecrescente().getArray()) {
			resultado += "\n\n" + disciplina + ":";
			for (Avaliacao avaliacao : disciplina.getAvaliacoesDecrescente()) {
				resultado += "\n\t" + avaliacao;
			}
		}
		return resultado;
	}

	public String exibirAlfabeticoCrescente() throws NotaInvalidaExcecao {
		String resultado = "";
		for (Disciplina disciplina : historicoAlfabeticoCrescente().getArray()) {
			resultado += "\n\n" + disciplina + ":";
			for (Avaliacao avaliacao : disciplina.getAvaliacoesCrescente()) {
				resultado += "\n\t" + avaliacao;
			}
		}
		return resultado;
	}

	public String exibirAlfabeticoDecrescente() throws NotaInvalidaExcecao {
		String resultado = "";
		for (Disciplina disciplina : historicoAlfabeticoDecrescente().getArray()) {
			resultado += "\n\n" + disciplina + ":";
			for (Avaliacao avaliacao : disciplina.getAvaliacoesDecrescente()) {
				resultado += "\n\t" + avaliacao;
			}
		}
		return resultado;
	}

	public float calculaIRA() throws HistoricoVazioExcecao {
		if (this.historico.tamanho() == 0)
			throw new HistoricoVazioExcecao(getMatricula());
		float soma = 0;
		for (Disciplina contador : this.historico.getArray()) {
			soma += contador.calculaMedia();
		}
		return soma / this.historico.tamanho();
	}

	@Override
	public int compareTo(Aluno aluno) {
		try {
			float ira1 = calculaIRA();
			float ira2 = aluno.calculaIRA();

			if (ira1 > ira2) {
				return 1;
			}
			if (ira1 < ira2) {
				return -1;
			}
			return 0;

		} catch (HistoricoVazioExcecao e) {
			System.out.println(e);
			return 0;
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null) {
			return false;
		}
		if (o.getClass() != this.getClass()) {
			return false;
		}

		Aluno aluno = (Aluno) o;

		if (getMatricula().equals(aluno.getMatricula())) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return getMatricula() != null ? getMatricula().hashCode() : 0;
	}

	@Override
	public String nomeTratamento() {
		if (getGenero()) {
			return "Aluno " + getNome();
		}
		return "Aluna " + getNome();
	}

	@Override
	public String toString() {
		try {
			return getMatricula() + " --> " + nomeTratamento() + "\n" + getPessoa() + "\nIRA:" + calculaIRA()
					+ "\nConceito:" + getConceito();
		} catch (HistoricoVazioExcecao e) {
			return getMatricula() + " --> " + nomeTratamento() + "\n" + getPessoa();
		}
	}

}
