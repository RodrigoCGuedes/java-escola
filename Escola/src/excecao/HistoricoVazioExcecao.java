package excecao;

public class HistoricoVazioExcecao extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	private String mensagem;
	
	public HistoricoVazioExcecao(String matricula) {
		this.mensagem = "Erro - Histórico vazio -> Matricula: " + matricula;
	}
	
	public String toString() {
		return this.mensagem;
	}
}
