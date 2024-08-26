package excecao;

public class AlunoNaoAtualizadoExcecao extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	private String mensagem;
	
	public AlunoNaoAtualizadoExcecao(String matricula) {
		this.mensagem = "Aluno não atualizado -> Matricula: " + matricula;
	}
	
	public String toString() {
		return this.mensagem;
	}
}
