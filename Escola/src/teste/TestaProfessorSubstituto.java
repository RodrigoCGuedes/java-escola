package teste;

import escola.Pessoa;
import escola.ProfessorSubstituto;

public class TestaProfessorSubstituto {

	public static void main(String[] args) {

		// Testando Construtores

		System.out.println("\n --> Testando Construtores\n");

		Pessoa pessoa = new Pessoa("Rodrigo", true, "98822-3344", "rodrigo@gmail.com");
		ProfessorSubstituto professor1 = new ProfessorSubstituto(pessoa, "Sistemas de Informação", 160);
		ProfessorSubstituto professor2 = new ProfessorSubstituto(pessoa, "Sistemas de Informação", 160);
		
		System.out.println(professor1);
		System.out.println("\n" + professor2);
		
		// Testando Encapsulamento

		System.out.println("\n --> Testando Encapsulamento\n");

		pessoa = null;
		System.out.println("Tentando apagar dados pessoais tornando " + pessoa);

		int aulasMensais = professor1.getAulasMensais();
		aulasMensais += 1000;
		System.out.println("Tentando injetar em aulasMensais: " + aulasMensais);

		String departamento = professor1.getDepartamento();
		departamento += " ERRO ";
		System.out.println("Tentando injetar em departamento: " + departamento);
		
		float valorHora = professor1.getValorHora();
		valorHora += 1000;
		System.out.println("Tentando injetar em valorHora: " + valorHora);
		
		System.out.println("\n" + professor1);

	}

}
