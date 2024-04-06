package escola;

import java.time.LocalDate;

public class ProfessorEfetivo {
	
	private Membro pessoa;
	private String departamento;
	private Regime regime;
	private LocalDate dataAdmissao;
	
	public ProfessorEfetivo(Membro pessoa, String departamento, Regime regime, LocalDate dataAdmissao) {
		this.pessoa = pessoa;
		this.departamento = departamento;
		this.regime = regime;
		this.dataAdmissao = dataAdmissao;
	}
	
	public ProfessorEfetivo(ProfessorEfetivo professor) {
		this.pessoa = professor.getPessoa();
		this.departamento = professor.getDepartamento();
		this.regime = professor.getRegime();
		this.dataAdmissao = professor.getDataAdmissao();
	}
	
	public Membro getPessoa() {
		return new Membro(pessoa);
	}
	
	public String getDepartamento() {
		return this.departamento;
	}
	
	public Regime getRegime() {
		return new Regime(regime);
	}
	
	public LocalDate getDataAdmissao() {
		return LocalDate.of(dataAdmissao.getYear(), dataAdmissao.getMonth(), dataAdmissao.getDayOfMonth());
	}
	
	public String toString() {
		return pessoa + "\n" + departamento + " - " + regime + "\nData de admissão: " + dataAdmissao;
	}
}	
