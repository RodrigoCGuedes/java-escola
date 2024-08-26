package escola;

import java.util.ArrayList;
import java.util.HashMap;
import comparadores.CriterioValorDecrescente;
import excecao.AlunoNaoAtualizadoExcecao;
import excecao.AlunoNaoInseridoExcecao;
import excecao.HistoricoVazioExcessao;

public class Ranking {

	HashMap<Conceito, Character> ranking;

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

	public boolean inserir(Aluno aluno) throws AlunoNaoInseridoExcecao, HistoricoVazioExcessao {
		Conceito conceito = new Conceito(aluno.getMatricula(), aluno.calculaIRA());

		if (!ranking.containsKey(conceito)) {
			if (conceito.getConceito() != null) {
				ranking.put(conceito, conceito.getConceito());
				return true;
			}
		}
		throw new AlunoNaoInseridoExcecao(aluno.getMatricula());
	}

	public boolean inserir(ArrayList<Aluno> alunos) throws AlunoNaoInseridoExcecao, HistoricoVazioExcessao {
		for (Aluno aluno : alunos) {
			if (!inserir(aluno)) {
				throw new AlunoNaoInseridoExcecao(aluno.getMatricula());
			}
		}
		return true;
	}

	public boolean atualizar(Aluno aluno) throws AlunoNaoAtualizadoExcecao, HistoricoVazioExcessao {
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

	public boolean atualizar(ArrayList<Aluno> alunos) throws AlunoNaoAtualizadoExcecao, HistoricoVazioExcessao {
		for (Aluno aluno : alunos) {
			if (!atualizar(aluno)) {
				throw new AlunoNaoAtualizadoExcecao(aluno.getMatricula());
			}
		}
		return true;
	}

	public Character getConceitoAluno(Aluno aluno) throws HistoricoVazioExcessao {
		Conceito conceito = new Conceito(aluno.getMatricula(), aluno.calculaIRA());

		if (ranking.containsKey(conceito))
			return ranking.get(conceito);
		return null;
	}

	public String toString() {
		ArrayList<Conceito> conceitos = new ArrayList<>();
		String resultado = "";
		
		for(Conceito conceito : ranking.keySet()) {
			conceitos.add(conceito);
		}
		
		conceitos.sort(new CriterioValorDecrescente());
		
		for(Conceito conceito : conceitos) {
			resultado += "\n" + conceito + " : " + ranking.get(conceito);
		}
		
		return resultado;
	}
}
