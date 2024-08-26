package escola;

import interfaces.Valor;

public class Conceito implements Comparable<Conceito>, Valor {

	private String matricula;
	private float ira;
	private Character conceito;

	public Conceito(String matricula, float ira) {
		this.matricula = matricula;
		this.ira = ira;
		this.conceito = Conceito.calculaConceito(ira);
	}

	public String getMatricula() {
		return this.matricula;
	}

	public float getIRA() {
		return this.ira;
	}
	
	public static Character calculaConceito(float ira) {
		Character ch = 'C';
		if (ira >= 9) ch = 'A';
		if (ira < 9 && ira > 7) ch = 'B';
		return ch;
	}

	public Character getConceito() {
		return this.conceito;
	}
	
	public float getValor() {
		return this.ira;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null)
			return false;
		if (o.getClass() != this.getClass())
			return false;

		Conceito conceito = (Conceito) o;

		if (this.matricula.equals(conceito.getMatricula()))
			return true;

		return false;
	}

	@Override
	public int hashCode() {
		return this.matricula != null ? this.matricula.hashCode() : 0;
	}

	@Override
	public int compareTo(Conceito conceito) {
		return Float.compare(this.ira, conceito.getIRA());
	}

	@Override
	public String toString() {
		return this.matricula + "--> IRA: " + this.ira;
	}
}
