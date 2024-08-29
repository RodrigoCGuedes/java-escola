package escola;

import interfaces.Membro;

public abstract class Professor extends Pessoa implements Membro {

	private String departamento;

	public Professor(Pessoa pessoa, String departamento) {
		super(pessoa);
		this.departamento = departamento;
	}

	public Professor(Professor professor) {
		super(professor);
		this.departamento = professor.getDepartamento();
	}

	public String getDepartamento() {
		return this.departamento;
	}

	public String nomeTratamento() {
		if (getGenero()) {
			return "Sr. " + getNome();
		}
		return "Sra. " + getNome();
	}

	public abstract float calculaSalario();

	public String toString() {
		return nomeTratamento() + " - " + this.departamento;
	}
}
