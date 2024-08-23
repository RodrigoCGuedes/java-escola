package comparadores;

import java.util.Comparator;
import escola.Pessoa;

public class CriterioPessoaAlfabetica<T extends Pessoa> implements Comparator<T> {

    @Override
    public int compare(T p1, T p2) {
        return p1.getNome().compareTo(p2.getNome());
    }
}
