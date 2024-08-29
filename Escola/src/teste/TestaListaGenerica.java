package teste;

import escola.Aluno;
import escola.Disciplina;
import escola.Pessoa;
import excecao.NotaInvalidaExcecao;
import lista.ListaGenerica;

public class TestaListaGenerica {

	public static void main(String[] args) {
		
		System.out.println(" --> Testando Aluno.\n");

		System.out.println(" --> Testando Inserção e Busca.\n");

		ListaGenerica<Aluno> listaAluno = new ListaGenerica<>();

		Aluno aluno1 = new Aluno(new Pessoa("Rodrigo", true, "98822-3344", "rodrigo@gmail.com"));
		Aluno aluno2 = new Aluno(new Pessoa("Vinícius", true, "98833-4455", "vinicius@gmail.com"));
		Aluno aluno3 = new Aluno(new Pessoa("Lucas", true, "98844-5566", "lucas@gmail.com"));

		listaAluno.adicionar(aluno1);
		listaAluno.adicionar(aluno2);
		listaAluno.adicionar(aluno3);

		for (int i = 0; i < listaAluno.tamanho(); i++) {
			System.out.println(listaAluno.buscar(i) + "\n");
		}

		System.out.println(" --> Testando Remoção.\n");

		listaAluno.remover(aluno3);
		listaAluno.remover(1);

		System.out.println(listaAluno);

		System.out.println(" --> Testando Contem.\n");

		if (listaAluno.contem(aluno1)) {
			System.out.println("Aluno encontrado!\n");
		}
		
		System.out.println(" --> Testando Disciplina.\n");

		System.out.println(" --> Testando Inserção e Busca.\n");

		ListaGenerica<Disciplina> listaDisciplina = new ListaGenerica<>();
		
		Disciplina disciplina1 = new Disciplina("Cálculo I", "Núclo de Exatas");
		try {
			disciplina1.insereAvaliacao("1°Prova", (float)8.22);
			disciplina1.insereAvaliacao("2°Prova", 3);
		} catch (NotaInvalidaExcecao e) {
			System.out.println(e);
		}
		
		Disciplina disciplina2 = new Disciplina("Algoritimos", "Núclo de Computação.");
		try {
			disciplina2.insereAvaliacao("1°Prova", 10);
			disciplina2.insereAvaliacao("2°Prova", 5);
		} catch (NotaInvalidaExcecao e) {
			System.out.println(e);
		}
		
		Disciplina disciplina3 = new Disciplina("Estrutura de Dados", "Núclo de Computação.");
		try {
			disciplina3.insereAvaliacao("1°Prova", 10);
			disciplina3.insereAvaliacao("2°Prova", 2);

		} catch (NotaInvalidaExcecao e) {
			System.out.println(e);
		}

		listaDisciplina.adicionar(disciplina1);
		listaDisciplina.adicionar(disciplina2);
		listaDisciplina.adicionar(disciplina3);

		for (int i = 0; i < listaDisciplina.tamanho(); i++) {
			System.out.println(listaDisciplina.buscar(i) + "\n");
		}

		System.out.println(" --> Testando Remoção.\n");

		listaDisciplina.remover(disciplina3);
		listaDisciplina.remover(1);

		System.out.println(listaDisciplina);

		System.out.println(" --> Testando Contem.\n");

		if (listaDisciplina.contem(disciplina1)) {
			System.out.println("Disciplina encontrado!");
		}
	}
}
