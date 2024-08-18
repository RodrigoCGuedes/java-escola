package escola;

import java.time.LocalDate;
import interfaces.Membro;

public class ProfessorEfetivo extends Professor implements Membro{

	private Regime regime;
	private LocalDate dataAdmissao;

	public ProfessorEfetivo(Pessoa pessoa, String departamento, Regime regime, LocalDate dataAdmissao) {
		super(new Pessoa(pessoa), departamento);
		this.regime = regime;
		this.dataAdmissao = dataAdmissao;
	}

	public ProfessorEfetivo(ProfessorEfetivo professor) {
		super(professor);
		this.regime = professor.getRegime();
		this.dataAdmissao = professor.getDataAdmissao();
	}

	public Regime getRegime() {
		return new Regime(regime);
	}

	public LocalDate getDataAdmissao() {
		return LocalDate.of(dataAdmissao.getYear(), dataAdmissao.getMonth(), dataAdmissao.getDayOfMonth());
	}

	public ProfessorEfetivo getProfessorSubstituto() {
		return new ProfessorEfetivo(new Pessoa(getPessoa()), getDepartamento(), this.regime, this.dataAdmissao);
	}

	public float calculaSalario() {
		return this.regime.getSalario();
	}

	public String toString() {
		return "Professor Efetivo --> " + nomeTratamento() + "\n" + getPessoa() + "\n" + getDepartamento() + " - "
				+ regime + "\nData de admissão: " + dataAdmissao + "\nSalario: " + calculaSalario();
	}
}
