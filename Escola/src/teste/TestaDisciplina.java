package teste;

import java.util.ArrayList;

import escola.Avaliacao;
import escola.Disciplina;
import excecao.NotaInvalidaExcecao;

public class TestaDisciplina {

	public static void main(String[] args) throws NotaInvalidaExcecao{

		// Testando Construtores

		System.out.println("\n --> Testando Construtores\n");
		
		Disciplina disciplina1 = new Disciplina("Calculo I", "Núcleo de Ciencias Exatas");

		System.out.println(disciplina1);
		
		Disciplina disciplina2;
		try {
			disciplina2 = new Disciplina(disciplina1);
			System.out.println(disciplina2);
		} catch (NotaInvalidaExcecao e) {
			System.out.println(e);
		}

		// Testando inserção e impressão de Avaliacões

		System.out.println("\n --> Testando inserção e impressão de Avaliacões\n");

		try {
			disciplina1.insereAvaliacao(new Avaliacao("1°Prova", 9));
			disciplina1.insereAvaliacao(new Avaliacao("2°Prova", 10));
			disciplina1.insereAvaliacao(new Avaliacao("3°Prova", 9));
			
			// Testando exceção NotaNegativaExcecao
			disciplina1.insereAvaliacao(new Avaliacao("4°Prova", -1));
		} catch (Exception e) {
			System.out.println(e);
		}

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

		try {
			ArrayList<Avaliacao> avaliacoes = disciplina1.getAvaliacoesCrescente();
			avaliacoes.clear();
		} catch (Exception e) {
			System.out.println(e);
		}

		System.out.println("Tentando remover todas avaliacões.");

		System.out.println("\nResultado:\n" + disciplina1);
		System.out.println(disciplina1.exibirAvaliacoes());

	}

}
