package escola;

import java.util.HashMap;

import comparadores.CriterioValorCrescente;
import comparadores.CriterioValorDecrescente;
import excecao.AlunoNaoAtualizadoExcecao;
import excecao.AlunoNaoInseridoExcecao;
import excecao.HistoricoVazioExcecao;
import excecao.IRAInvalidoExcecao;
import lista.ListaGenerica;

public class Ranking {

	private HashMap<Conceito, Character> ranking;

	public Ranking() {
		this.ranking = new HashMap<>();
	}

	public Ranking(HashMap<Conceito, Character> ranking) {
		this.ranking = ranking;
	}

	public Ranking(Ranking ranking) {
		this.ranking = new HashMap<>(ranking.getRanking());
	}

	private HashMap<Conceito, Character> getRanking() {
		return this.ranking;
	}

	public boolean inserir(Aluno aluno) throws AlunoNaoInseridoExcecao, IRAInvalidoExcecao, HistoricoVazioExcecao {
		Conceito conceito = new Conceito(aluno.getMatricula(), aluno.calculaIRA());

		if (!ranking.containsKey(conceito)) {
			if (conceito.getConceito() != null) {
				ranking.put(conceito, conceito.getConceito());
				return true;
			}
		}
		throw new AlunoNaoInseridoExcecao(aluno.getMatricula());
	}

	public boolean inserir(ListaGenerica<Aluno> alunos) throws AlunoNaoInseridoExcecao, HistoricoVazioExcecao, IRAInvalidoExcecao {
		for (Aluno aluno : alunos.getArray()) {
			if (!inserir(aluno)) {
				throw new AlunoNaoInseridoExcecao(aluno.getMatricula());
			}
		}
		return true;
	}

	public boolean atualizar(Aluno aluno) throws AlunoNaoAtualizadoExcecao, HistoricoVazioExcecao, IRAInvalidoExcecao {
		String matricula = aluno.getMatricula();
		Conceito conceito = new Conceito(matricula, aluno.calculaIRA());
		Character c = conceito.getConceito();

		if (this.ranking.containsKey(conceito)) {
			if (c != null) {
				ranking.put(conceito, c);
				return true;
			}
		}
		throw new AlunoNaoAtualizadoExcecao(matricula);
	}

	public boolean atualizar(ListaGenerica<Aluno> alunos) throws AlunoNaoAtualizadoExcecao, HistoricoVazioExcecao, IRAInvalidoExcecao {
		for (Aluno aluno : alunos.getArray()) {
			if (!atualizar(aluno)) {
				throw new AlunoNaoAtualizadoExcecao(aluno.getMatricula());
			}
		}
		return true;
	}

	public Character getConceitoAluno(Aluno aluno) throws HistoricoVazioExcecao, IRAInvalidoExcecao {
		Conceito conceito = new Conceito(aluno.getMatricula(), aluno.calculaIRA());

		if (ranking.containsKey(conceito))
			return ranking.get(conceito);
		return null;
	}

	public String rankingCrescente() {
		ListaGenerica<Conceito> conceitos = new ListaGenerica<>();
		String resultado = "";

		for (Conceito conceito : ranking.keySet()) {
			conceitos.adicionar(conceito);
		}
		
		ListaGenerica<Conceito> copia = conceitos.ordenar(new CriterioValorCrescente());

		for (Conceito conceito : copia) {
			resultado += "\n" + conceito + " : " + ranking.get(conceito);
		}

		return resultado;
	}

	public String rankingDecrescente() {
		ListaGenerica<Conceito> conceitos = new ListaGenerica<>();
		String resultado = "";

		for (Conceito conceito : ranking.keySet()) {
			conceitos.adicionar(conceito);
		}

		ListaGenerica<Conceito> copia = conceitos.ordenar(new CriterioValorDecrescente());

		for (Conceito conceito : copia) {
			resultado += "\n" + conceito + " : " + ranking.get(conceito);
		}

		return resultado;
	}

	public String toString() {
		return this.rankingDecrescente();
	}

}
