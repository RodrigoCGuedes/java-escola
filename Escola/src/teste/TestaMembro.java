package teste;

import escola.Pessoa;

public class TestaMembro {

	public static void main(String[] args) {

		// Testando Construtores

		System.out.println("\n --> Testando Construtores\n");

		Pessoa membro1 = new Pessoa("Rodrigo", true, "98822-3344", "rodrigo@gmail.com");
		Pessoa membro2 = new Pessoa(membro1);

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
