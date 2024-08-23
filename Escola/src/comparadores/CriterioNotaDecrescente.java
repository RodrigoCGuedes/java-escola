package comparadores;

import java.util.Comparator;
import escola.Avaliacao;

public class CriterioNotaDecrescente implements Comparator<Avaliacao> {

	@Override
	public int compare(Avaliacao a1, Avaliacao a2) {
		if(a1.getValor() < a2.getValor()) return 1;
		if(a1.getValor() > a2.getValor()) return -1;
		return 0;
	}
}
