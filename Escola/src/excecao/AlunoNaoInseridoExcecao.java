package excecao;

public class AlunoNaoInseridoExcecao extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	private String mensagem;
	
	public AlunoNaoInseridoExcecao(String matricula) {
		this.mensagem = "Aluno não inserido -> Matricula: " + matricula;
	}
	
	public String toString() {
		return this.mensagem;
	}
}
