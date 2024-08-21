package teste;

import escola.Regime;

public class TestaRegime {

	public static void main(String[] args) {

		// Testando Construtores

		System.out.println("\n --> Testando Construtores\n");

		Regime regime1 = new Regime("40 Horas", 10000);
		Regime regime2 = new Regime(regime1);

		System.out.println(regime1);
		System.out.println(regime2);

		// Testando Encapsulamento

		System.out.println("\n --> Testando Encapsulamento\n");

		String descricao = regime1.getDescricao();
		descricao += " ERRO ";
		System.out.println("Tentando injetar em descricao: " + descricao);

		float salario = regime1.getSalario();
		salario += 1111;
		System.out.println("Tentando injetar em salario: " + salario);

		System.out.println("\n" + regime1);

	}

}
