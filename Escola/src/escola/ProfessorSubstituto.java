package escola;

public class ProfessorSubstituto {
	
	// --> Atributos

	private Membro pessoa;
	private String departamento;
	private int aulasMensais;
	private static float valorHora = 40;
	
	// --> Construtores

	public ProfessorSubstituto(Membro pessoa, String departamento, int aulasMensais) {
		this.pessoa = new Membro(pessoa);
		this.departamento = departamento;
		this.aulasMensais = aulasMensais;
	}

	public ProfessorSubstituto(ProfessorSubstituto professor) {
		this.pessoa = new Membro(professor.getPessoa());
		this.departamento = professor.getDepartamento();
		this.aulasMensais = professor.getAulasMensais();
	}
	
	// --> Métodos

	public Membro getPessoa() {
		return new Membro(pessoa);
	}

	public String getDepartamento() {
		return this.departamento;
	}

	public int getAulasMensais() {
		return this.aulasMensais;
	}
	
	public float getValorHora() {
		return ProfessorSubstituto.valorHora;
	}

	public String toString() {
		return pessoa + "\n --> " + departamento + "\nAulas Mensais: " + aulasMensais + " - Valor Hora: " + valorHora;
	}

}
