package comparadores;

import java.util.Comparator;
import interfaces.Valor;

public class CriterioValorDecrescente implements Comparator<Valor> {

	@Override
	public int compare(Valor v1, Valor v2) {
		if(v1.getValor() < v2.getValor()) return 1;
		if(v1.getValor() > v2.getValor()) return -1;
		return 0;
	}
}
