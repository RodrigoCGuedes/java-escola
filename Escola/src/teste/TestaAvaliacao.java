package teste;

import escola.Avaliacao;

public class TestaAvaliacao {

	public static void main(String[] args) {

		// Testando Construtores

		System.out.println("\n --> Testando Construtores\n");

		Avaliacao avaliacao1 = new Avaliacao("1°Prova", 8);
		System.out.println(avaliacao1);

		Avaliacao avaliacao2 = new Avaliacao(avaliacao1);
		System.out.println(avaliacao2);

		// Testando Encapsulamento

		System.out.println("\n --> Testando Encapsulamento\n");

		String descricao = avaliacao1.getDescricao();
		descricao += " ERRO ";
		System.out.println("Tentando injetar em descricao: " + descricao);

		float valor = avaliacao1.getValor();
		valor += 1000;
		System.out.println("Tentando injetar em valor: " + valor);

		String id = avaliacao1.getId();
		id += " ERRO ";
		System.out.println("Tentando injetar em id: " + id);

		System.out.println("\n" + avaliacao1);

	}

}
