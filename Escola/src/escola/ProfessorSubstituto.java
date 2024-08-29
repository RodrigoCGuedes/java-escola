package escola;

import interfaces.Membro;

public class ProfessorSubstituto extends Professor implements Membro {

	// --> Atributos

	private int aulasMensais;
	private static float valorHora = 40;

	// --> Construtores

	public ProfessorSubstituto(Pessoa pessoa, String departamento, int aulasMensais) {
		super(new Pessoa(pessoa), departamento);
		this.aulasMensais = aulasMensais;
	}

	public ProfessorSubstituto(ProfessorSubstituto professor) {
		super(professor);
		this.aulasMensais = professor.getAulasMensais();
	}

	// --> Métodos

	public int getAulasMensais() {
		return this.aulasMensais;
	}

	public float getValorHora() {
		return ProfessorSubstituto.valorHora;
	}

	public ProfessorSubstituto getProfessorSubstituto() {
		return new ProfessorSubstituto(new Pessoa(getPessoa()), getDepartamento(), this.aulasMensais);
	}

	public boolean setValorHora(float valor) {
		if (valor >= 0) {
			ProfessorSubstituto.valorHora = valor;
			return true;
		}
		return false;
	}

	public float calculaSalario() {
		return this.aulasMensais * ProfessorSubstituto.valorHora;
	}

	public String toString() {
		return "Professor Substituto --> " + nomeTratamento() + "\n" + getPessoa() + "\n --> " + getDepartamento()
				+ "\nAulas Mensais: " + aulasMensais + " - Valor Hora: " + valorHora + "\nSalario: " + calculaSalario();
	}

}
