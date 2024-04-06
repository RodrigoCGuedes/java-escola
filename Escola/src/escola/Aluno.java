package escola;

import java.time.LocalDate;
import java.util.ArrayList;

public class Aluno {

	// --> Atributos

	private String matricula;
	private Membro pessoa;
	private ArrayList<Disciplina> historico;

	private static int ultimoNumero = 1;
	private static int anoInicial = 2024;

	// --> Construtores

	public Aluno(Membro dadosPessoais) {
		this.matricula = geraMatricula();
		this.pessoa = dadosPessoais;
		this.historico = new ArrayList<>();
	}

	public Aluno(Aluno aluno) {
		this.matricula = geraMatricula();
		this.pessoa = aluno.getPessoa();
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

	public Membro getPessoa() {
		return new Membro(this.pessoa);
	}

	public ArrayList<Disciplina> getHistorico() {
		ArrayList<Disciplina> copia = new ArrayList<>();
		for (Disciplina contador : this.historico) {
			copia.add(new Disciplina(contador));
		}
		return copia;
	}

	public Disciplina getDisciplina(String id) {
		for (Disciplina contador : this.historico) {
			if (contador.getId().equals(id)) {
				return new Disciplina(contador);
			}
		}
		return null;
	}

	public boolean insereDisciplina(Disciplina disciplina) {
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

	public String toString() {
		return matricula + " --> " + this.pessoa;
	}

}
