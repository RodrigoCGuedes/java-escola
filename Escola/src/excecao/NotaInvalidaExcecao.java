package excecao;

public class NotaInvalidaExcecao extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	private String mensagem;
	
	public NotaInvalidaExcecao(String id) {
		this.mensagem = "Nota invalida no aluno -> ID: " + id;
	}
	
	public String toString() {
		return this.mensagem;
	}
}
