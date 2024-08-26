package escola;

import java.time.LocalDate;

public class Matricula {
	
	private String matricula;
	
	private static int ultimoNumero = 1;
	private static int anoInicial = 2024;
	
	public Matricula() {
		this.matricula = geraMatricula();
	}
	
	public Matricula(String matricula) {
		this.matricula = matricula;
	}
	
	private String geraMatricula() {
		if (LocalDate.now().getYear() != Matricula.anoInicial) {
			Matricula.anoInicial = LocalDate.now().getYear();
			Matricula.ultimoNumero = 1;
		}
		return matricula = Matricula.anoInicial + "-" + Matricula.ultimoNumero++;
	}
	
	public String get() {
		return this.matricula;
	}
	
	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if(o == null) return false;
		if(o.getClass() != this.getClass()) return false;
		
		Matricula m = (Matricula) o;
		
		if (this.matricula == m.get()) return true;
		
		return false;
	}
	
	@Override
	public int hashCode() {
		return this.matricula.hashCode();
	}
}
