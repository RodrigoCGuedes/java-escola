package teste;

import escola.ProfessorEfetivo;
import java.time.LocalDate;
import escola.Membro;
import escola.Regime;

public class TestaProfessorEfetivo {

	public static void main(String[] args) {

		// Testando Construtores

		System.out.println("\n --> Testando Construtores\n");

		Membro pessoa = new Membro("Rodrigo", "98831-5133", "rodrigo@gmail.com");
		Regime regime = new Regime("40 Horas", 10000);

		ProfessorEfetivo professor1 = new ProfessorEfetivo(pessoa, "Sistemas de Informação", regime, LocalDate.now());
		ProfessorEfetivo professor2 = new ProfessorEfetivo(professor1);

		System.out.println(professor1);
		System.out.println("\n" + professor2);

		// Testando Encapsulamento

		System.out.println("\n --> Testando Encapsulamento\n");

		pessoa = null;
		System.out.println("Tentando apagar dados pessoais tornando " + pessoa);

		regime = null;
		System.out.println("Tentando apagar o regime tornando " + regime);

		String departamento = professor1.getDepartamento();
		departamento += " ERRO ";
		System.out.println("Tentando injetar em departamento: " + departamento);
		
		System.out.println("\n" + professor1);
	}

}
