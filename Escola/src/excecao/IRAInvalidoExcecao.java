package excecao;

public class IRAInvalidoExcecao extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	private String mensagem;
	
	public IRAInvalidoExcecao(String matricula) {
		this.mensagem = "Ira inválido - matricula: " + matricula;
	}
	
	public String toString() {
		return mensagem;
	}
}
