package teste;

import escola.Membro;

public class TestaMembro {

	public static void main(String[] args) {

		// Testando Construtores

		System.out.println("\n --> Testando Construtores\n");

		Membro membro1 = new Membro("Rodrigo", "98831-5133", "rodrigo@gmail.com");
		Membro membro2 = new Membro(membro1);

		System.out.println(membro1);
		System.out.println(membro2);

		// Testando Encapsulamento

		System.out.println("\n --> Testando Encapsulamento\n");
		
		String nome = membro1.getNome();
		nome += " ERRO ";
		System.out.println("Tentando injetar em nome: " + nome);

		String telefone = membro1.getTelefone();
		telefone += " ERRO ";
		System.out.println("Tentando injetar em telefone: " + telefone);

		String email = membro1.getEmail();
		email += " ERRO ";
		System.out.println("Tentando injetar em email: " + email);

		System.out.println("\n" + membro1);

	}

}
