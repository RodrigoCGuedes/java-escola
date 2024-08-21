package escola;

import java.time.LocalDate;
import java.util.ArrayList;
import excecao.NotaNegativaExcecao;
import interfaces.Membro;

public class Aluno extends Pessoa implements Membro{

	// --> Atributos

	private String matricula;
	private ArrayList<Disciplina> historico;

	private static int ultimoNumero = 1;
	private static int anoInicial = 2024;

	// --> Construtores

	public Aluno(Pessoa pessoa) {
		super(new Pessoa(pessoa));
		this.matricula = geraMatricula();
		this.historico = new ArrayList<>();
	}

	public Aluno(Aluno aluno) throws NotaNegativaExcecao {
		super(aluno.getPessoa());
		this.matricula = aluno.geraMatricula();
		this.historico = aluno.getHistorico();
	}

	// --> Métodos

	private String geraMatricula() {
		if (LocalDate.now().getYear() != Aluno.anoInicial) {
			Aluno.anoInicial = LocalDate.now().getYear();
			Aluno.ultimoNumero = 1;
		}
		return matricula = Aluno.anoInicial + "-" + Aluno.ultimoNumero++;
	}

	public String getMatricula() {
		return this.matricula;
	}

	public ArrayList<Disciplina> getHistorico() throws NotaNegativaExcecao {
		ArrayList<Disciplina> copia = new ArrayList<>();
		for (Disciplina contador : this.historico) {
			copia.add(new Disciplina(contador));
		}
		return copia;
	}

	public Disciplina getDisciplina(String id) throws NotaNegativaExcecao {
		for (Disciplina contador : this.historico) {
			if (contador.getId().equals(id)) {
				return new Disciplina(contador);
			}
		}
		return null;
	}

	public boolean insereDisciplina(Disciplina disciplina) throws NotaNegativaExcecao {
		if (disciplina == null) {
			return false;
		}
		historico.add(new Disciplina(disciplina));
		return true;
	}

	public boolean insereDisciplina(String descricao) {
		if (descricao == null) {
			return false;
		}
		historico.add(new Disciplina(descricao));
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

	public String exibirHistorico() {
		String resultado = "";
		for (Disciplina contador : this.historico) {
			resultado += "\n" + contador;
		}
		return resultado;
	}

	public float calculaIRA() {
		float soma = 0;
		for (Disciplina contador : this.historico) {
			soma += contador.calculaMedia();
		}
		return soma / this.historico.size();
	}
	
	@Override
	public String nomeTratamento() {
		if(getGenero()) {
			return "Aluno " + getNome();
		}
		return "Aluna " + getNome();
	}

	public String toString() {
		return this.matricula + " --> " + nomeTratamento() + "\n" + getPessoa();
	}

}
