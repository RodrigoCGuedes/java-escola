package teste;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Random;
import escola.Aluno;
import escola.Ranking;
import escola.Disciplina;
import escola.Pessoa;
import excecao.AlunoNaoInseridoExcecao;
import excecao.HistoricoVazioExcessao;
import excecao.NotaInvalidaExcecao;

public class TestaRanking {

	public static void main(String[] args) throws NotaInvalidaExcecao, AlunoNaoInseridoExcecao {

		Ranking ranking = new Ranking();

		Aluno aluno1 = new Aluno(new Pessoa("Rodrigo", true, "98822-3344", "rodrigo@gmail.com"));
		Aluno aluno2 = new Aluno(new Pessoa("Vinícius", true, "98833-4455", "vinicius@gmail.com"));
		Aluno aluno3 = new Aluno(new Pessoa("Lucas", true, "98844-5566", "lucas@gmail.com"));

		Aluno aluno4 = new Aluno(new Pessoa("Nota 10", true, "91010-1010", "nota10@gmail.com"));

		Random nota = new Random(Instant.now().toEpochMilli());

		Disciplina disciplina = new Disciplina("Materia 1", "Núclo Qualquer");
		disciplina.insereAvaliacao("1°Prova", 8);
		aluno1.insereDisciplina(disciplina);

		for (int i = 0; i < 5; i++) {
			disciplina = new Disciplina("Materia " + i, "Núclo Qualquer");
			disciplina.insereAvaliacao(i + "°Prova", nota.nextFloat() * 10);
			disciplina.insereAvaliacao((i + 1) + "°Prova", nota.nextFloat() * 10);
			aluno2.insereDisciplina(disciplina);
		}

		for (int i = 0; i < 5; i++) {
			disciplina = new Disciplina("Materia " + i, "Núclo Qualquer");
			disciplina.insereAvaliacao(i + "°Prova", nota.nextFloat() * 10);
			disciplina.insereAvaliacao((i + 1) + "°Prova", nota.nextFloat() * 10);
			aluno3.insereDisciplina(disciplina);
		}

		disciplina = new Disciplina("Materia 1", "Núclo Qualquer");
		disciplina.insereAvaliacao("1°Prova", 10);
		aluno4.insereDisciplina(disciplina);

		System.out.println("\n" + aluno1);
		System.out.println("\n" + aluno2);
		System.out.println("\n" + aluno3);
		System.out.println("\n" + aluno4);

		ArrayList<Aluno> alunos = new ArrayList<>();

		alunos.add(aluno1);
		alunos.add(aluno2);
		alunos.add(aluno3);
		alunos.add(aluno4);

		try {
			ranking.inserir(alunos);
		} catch (Exception e) {
			System.out.println(e);
		}

		System.out.println(ranking);
		
		try {
			System.out.println("\nConceito do aluno1: " + ranking.getConceitoAluno(aluno1));
		} catch (HistoricoVazioExcessao e) {
			System.out.println(e);
		}
		
		System.out.println("\n --> Tentado inserir aluno já existente: ");
		
		try {
			ranking.inserir(aluno1);
		} catch(Exception e) {
			System.out.println(e);
		}
		
		System.out.println("\n --> Tentado atualizar aluno não existente: ");
		
		try {
			ranking.atualizar(new Aluno(new Pessoa("João Ninguém", true, "111", "joao@gmail.com")));
		} catch(Exception e) {
			System.out.println(e);
		}
		
	}

}
