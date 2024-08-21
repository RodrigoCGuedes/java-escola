package teste;

import java.util.ArrayList;

import escola.Aluno;
import escola.Disciplina;
import escola.Pessoa;
import excecao.NotaNegativaExcecao;

public class TestaAluno {

	public static void main(String[] args) throws NotaNegativaExcecao {
		
		// Testando Construtores
		
		System.out.println("\n --> Testando Construtores\n");

		Aluno aluno1 = new Aluno(new Pessoa("Rodrigo", true, "98822-3344", "rodrigo@gmail.com"));
		Aluno aluno2 = new Aluno(aluno1);
		
		System.out.println(aluno1);
		System.out.println(aluno2);
		
		// Testando inserção e impressão de Disciplinas

		System.out.println("\n --> Testando inserção e impressão de Disciplinas e Histórico\n");
		
		Disciplina disciplina1 = new Disciplina("Algoritimos");
		disciplina1.insereAvaliacao("1°Prova", 10);
		disciplina1.insereAvaliacao("2°Prova", 5);
		
		Disciplina disciplina2 = new Disciplina("Estrutura de Dados");
		disciplina2.insereAvaliacao("1°Prova", 10);
		disciplina2.insereAvaliacao("2°Prova", 5);
		
		aluno1.insereDisciplina(disciplina1);
		aluno1.insereDisciplina(disciplina2);
		
		System.out.println("Histórico: " + aluno1.exibirHistorico());
		
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

		ArrayList<Disciplina> historico = aluno1.getHistorico();
		historico.clear();
		System.out.println("Tentando remover todas disciplinas.");

		System.out.println("\nResultado:\n\n" + aluno1);
		System.out.println("Histórico:" + aluno1.exibirHistorico());
		
		
	}

}
