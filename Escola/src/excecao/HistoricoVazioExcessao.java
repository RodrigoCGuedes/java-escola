package excecao;

public class HistoricoVazioExcessao extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	private String mensagem;
	
	public HistoricoVazioExcessao(String matricula) {
		this.mensagem = "Erro - Histórico vazio -> Matricula: " + matricula;
	}
	
	public String toString() {
		return this.mensagem;
	}
}
