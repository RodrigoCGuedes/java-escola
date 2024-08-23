package teste;

import java.util.ArrayList;

import escola.Aluno;
import escola.Disciplina;
import escola.Pessoa;
import excecao.NotaInvalidaExcecao;

public class TestaAluno {

	public static void main(String[] args) throws NotaInvalidaExcecao {
		
		// Testando Construtores
		
		System.out.println("\n --> Testando Construtores\n");

		Aluno aluno1 = new Aluno(new Pessoa("Rodrigo", true, "98822-3344", "rodrigo@gmail.com"));
		Aluno aluno2 = new Aluno(aluno1);
		
		System.out.println(aluno1);
		System.out.println(aluno2);
		
		// Testando inserção e impressão de Disciplinas

		System.out.println("\n --> Testando inserção e impressão de Disciplinas e Histórico\n");
		
		Disciplina disciplina1 = new Disciplina("Cálculo I", "Núclo de Exatas.");
		disciplina1.insereAvaliacao("1°Prova", (float)8.22);
		disciplina1.insereAvaliacao("2°Prova", 3);
		
		Disciplina disciplina2 = new Disciplina("Algoritimos", "Núclo de Computação.");
		disciplina2.insereAvaliacao("1°Prova", 10);
		disciplina2.insereAvaliacao("2°Prova", 5);
		
		Disciplina disciplina3 = new Disciplina("Estrutura de Dados", "Núclo de Computação.");
		disciplina3.insereAvaliacao("1°Prova", 10);
		disciplina3.insereAvaliacao("2°Prova", 2);
		
		Disciplina disciplina4 = new Disciplina("Banco de Dados", "Núclo de Computação.");
		disciplina4.insereAvaliacao("1°Prova", 3);
		disciplina4.insereAvaliacao("2°Prova", 7);
		
		aluno1.insereDisciplina(disciplina1);
		aluno1.insereDisciplina(disciplina2);
		aluno1.insereDisciplina(disciplina3);
		aluno1.insereDisciplina(disciplina4);
		
		// Testando relação de histórico.
		
		System.out.println("Histórico crescente: \n" + aluno1.exibirNotasCrescente());
		
		System.out.println("\nHistórico decrescente: \n" + aluno1.exibirNotasDecrescente());
		
		// Testando calculo do IRA

		System.out.println("\n --> Testando calculo do IRA\n");
		
		System.out.println("IRA: " + aluno1.calculaIRA());
		
		// Testando Encapsulamento
		
		System.out.println("\n --> Testando Encapsulamento\n");

		String matricula = aluno1.getMatricula();
		matricula += " ERRO ";
		System.out.println("Tentando injetar em matricula: " + matricula);

		Pessoa pessoa = aluno1.getPessoa();
		pessoa = null;
		System.out.println("Tentando apagar dados pessoais tornando " + pessoa);

		ArrayList<Disciplina> historico = aluno1.getHistoricoAlfabetica();
		historico.clear();
		System.out.println("Tentando remover todas disciplinas.");

		System.out.println("\nResultado:\n\n" + aluno1);
		System.out.println("\nHistórico:" + aluno1.exibirNotasCrescente());
		
		
	}

}
