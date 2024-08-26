package escola;

import java.util.ArrayList;
import java.util.Collections;
import excecao.NotaInvalidaExcecao;
import excecao.HistoricoVazioExcessao;
import interfaces.Membro;
import comparadores.CriterioValorCrescente;
import comparadores.CriterioValorDecrescente;
import comparadores.CriterioAlfabeticaCrescente;
import comparadores.CriterioAlfabeticaDecrescente;

public class Aluno extends Pessoa implements Membro, Comparable<Aluno>{

	// --> Atributos

	private Matricula matricula;
	private ArrayList<Disciplina> historico;

	// --> Construtores

	public Aluno(Pessoa pessoa) {
		super(new Pessoa(pessoa));
		this.matricula = new Matricula();
		this.historico = new ArrayList<>();
	}

	public Aluno(Aluno aluno) throws NotaInvalidaExcecao {
		super(aluno.getPessoa());
		this.matricula = new Matricula(aluno.getMatricula());
		this.historico = aluno.historicoCrescente();
	}

	// --> Métodos

	public String getMatricula() {
		return this.matricula.get();
	}

	public Disciplina getDisciplina(String id) throws NotaInvalidaExcecao {
		for (Disciplina contador : this.historico) {
			if (contador.getId().equals(id)) {
				return new Disciplina(contador);
			}
		}
		return null;
	}

	public Character getConceito() throws HistoricoVazioExcessao {
		if(!this.historico.isEmpty()) return Conceito.calculaConceito(calculaIRA());
		return null;
	}

	public boolean insereDisciplina(Disciplina disciplina) throws NotaInvalidaExcecao {
		if (disciplina == null) {
			return false;
		}
		historico.add(new Disciplina(disciplina));
		return true;
	}

	public boolean insereDisciplina(String nome, String descricao) {
		if (descricao == null) {
			return false;
		}
		historico.add(new Disciplina(nome, descricao));
		return true;
	}

	public boolean removeDisciplina(String id) {
		for (Disciplina contador : historico) {
			if (contador.getId().equals(id)) {
				this.historico.remove(contador);
				return true;
			}
		}
		return false;
	}
	
	public ArrayList<Disciplina> historicoAlfabeticoCrescente() throws NotaInvalidaExcecao {
		ArrayList<Disciplina> copia = new ArrayList<>();
		for (Disciplina contador : this.historico) {
			copia.add(new Disciplina(contador));
		}
		Collections.sort(copia, new CriterioAlfabeticaCrescente());
		return copia;
	}
	
	public ArrayList<Disciplina> historicoAlfabeticoDecrescente() throws NotaInvalidaExcecao {
		ArrayList<Disciplina> copia = new ArrayList<>();
		for (Disciplina contador : this.historico) {
			copia.add(new Disciplina(contador));
		}
		Collections.sort(copia, new CriterioAlfabeticaDecrescente());
		return copia;
	}

	public ArrayList<Disciplina> historicoCrescente() throws NotaInvalidaExcecao {
		ArrayList<Disciplina> copia = new ArrayList<>();
		for (Disciplina contador : this.historico) {
			copia.add(new Disciplina(contador));
		}
		Collections.sort(copia, new CriterioValorCrescente());
		return copia;
	}
	
	public ArrayList<Disciplina> historicoDecrescente() throws NotaInvalidaExcecao {
		ArrayList<Disciplina> copia = new ArrayList<>();
		for (Disciplina contador : this.historico) {
			copia.add(new Disciplina(contador));
		}
		Collections.sort(copia, new CriterioValorDecrescente());
		return copia;
	}

	public String exibirNotasCrescente() throws NotaInvalidaExcecao {
		String resultado = "";
		for (Disciplina disciplina : historicoCrescente()) {
			resultado += "\n\n" + disciplina + ":";
			for (Avaliacao avaliacao : disciplina.getAvaliacoesCrescente()) {
				resultado += "\n\t" + avaliacao;
			}
		}
		return resultado;
	}

	public String exibirNotasDecrescente() throws NotaInvalidaExcecao {
		String resultado = "";
		for (Disciplina disciplina : historicoDecrescente()) {
			resultado += "\n\n" + disciplina + ":";
			for (Avaliacao avaliacao : disciplina.getAvaliacoesDecrescente()) {
				resultado += "\n\t" + avaliacao;
			}
		}
		return resultado;
	}
	
	public String exibirAlfabeticoCrescente() throws NotaInvalidaExcecao {
		String resultado = "";
		for (Disciplina disciplina : historicoAlfabeticoCrescente()) {
			resultado += "\n\n" + disciplina + ":";
			for (Avaliacao avaliacao : disciplina.getAvaliacoesCrescente()) {
				resultado += "\n\t" + avaliacao;
			}
		}
		return resultado;
	}

	public String exibirAlfabeticoDecrescente() throws NotaInvalidaExcecao {
		String resultado = "";
		for (Disciplina disciplina : historicoAlfabeticoDecrescente()) {
			resultado += "\n\n" + disciplina + ":";
			for (Avaliacao avaliacao : disciplina.getAvaliacoesDecrescente()) {
				resultado += "\n\t" + avaliacao;
			}
		}
		return resultado;
	}

	public float calculaIRA() throws HistoricoVazioExcessao {
		if(this.historico.isEmpty()) throw new HistoricoVazioExcessao(getMatricula());
		float soma = 0;
		for (Disciplina contador : this.historico) {
			soma += contador.calculaMedia();
		}
		return soma / this.historico.size();
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
			
		} catch (HistoricoVazioExcessao e) {
			System.out.println(e);
			return 0;
		}
	}
	
	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if(o == null) return false;
		if(o.getClass() != this.getClass()) return false;
		
		Aluno aluno = (Aluno) o;
		
		if (getMatricula().equals(aluno.getMatricula())) return true;
		
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

	public String toString() {
		try {
			return getMatricula() + " --> " + nomeTratamento() + "\n" + getPessoa() + "\nIRA:" + calculaIRA() + "\nConceito:" + getConceito();
		} catch (HistoricoVazioExcessao e) {
			System.out.println(e);
			return "";
		}
	}

}
