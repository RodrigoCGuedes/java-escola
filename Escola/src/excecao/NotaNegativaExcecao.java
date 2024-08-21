package excecao;

public class NotaNegativaExcecao extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	private String mensagem;
	
	public NotaNegativaExcecao(String id) {
		this.mensagem = "Nota negativa no aluno -> ID: " + id;
	}
	
	public String toString() {
		return this.mensagem;
	}
}
