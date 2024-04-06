package teste;

import java.util.ArrayList;

import escola.Avaliacao;
import escola.Disciplina;

public class TestaDisciplina {

	public static void main(String[] args) {

		// Testando Construtores

		System.out.println("\n --> Testando Construtores\n");

		Disciplina disciplina1 = new Disciplina("Calculo");
		Disciplina disciplina2 = new Disciplina(disciplina1);

		System.out.println(disciplina1);
		System.out.println(disciplina2);

		// Testando inserção e impressão de Avaliacões

		System.out.println("\n --> Testando inserção e impressão de Avaliacões\n");

		disciplina1.insereAvaliacao(new Avaliacao("1°Prova", 9));
		disciplina1.insereAvaliacao(new Avaliacao("2°Prova", 10));
		disciplina1.insereAvaliacao(new Avaliacao("3°Prova", 9));

		System.out.println(disciplina1);
		System.out.println(disciplina1.exibirAvaliacoes());

		// Testando calculo da média

		System.out.println(" --> Testando calculo da média\n");

		System.out.println("Média: " + disciplina1.calculaMedia());

		// Testando remoção de Avaliação

		System.out.println("\n --> Testando remoção Avaliacão\n");

		disciplina1.removeAvaliacao("A1");
		System.out.println(disciplina1);
		System.out.println(disciplina1.exibirAvaliacoes());

		// Testando Encapsulamento

		System.out.println(" --> Testando Encapsulamento\n");

		String id = disciplina1.getId();
		id += " ERRO ";
		System.out.println("Tentando injetar em id: " + id);

		String descricao = disciplina1.getDescricao();
		descricao += " ERRO ";
		System.out.println("Tentando injetar em descricao: " + descricao);

		ArrayList<Avaliacao> avaliacoes = disciplina1.getAvaliacoes();
		avaliacoes.clear();
		System.out.println("Tentando remover todas avaliacões.");

		System.out.println("\nResultado:\n" + disciplina1);
		System.out.println(disciplina1.exibirAvaliacoes());

	}

}
