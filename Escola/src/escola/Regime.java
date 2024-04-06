package escola;

public class Regime {
	
	// --> Atributos
	
	private String descricao;
	private float salario;
	
	// --> Construtores
	
	public Regime(String descricao, float salario) {
		this.descricao = descricao;
		this.salario = salario;
	}
	
	public Regime(Regime regime) {
		this.descricao = regime.getDescricao();
		this.salario = regime.getSalario();
	}
	
	// --> Métodos

	private String getDescricao() {
		return this.descricao;
	}

	private float getSalario() {
		return this.salario;
	}
	
	public String toString() {
		return "Regime: " + descricao + " - " + "Salario: " + salario;
	}
}
