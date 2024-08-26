package comparadores;

import java.util.Comparator;
import interfaces.Alfabetica;

public class CriterioAlfabeticaDecrescente implements Comparator<Alfabetica> {

    @Override
    public int compare(Alfabetica a1, Alfabetica a2) {
        return a2.getNome().compareTo(a1.getNome());
    }
}
