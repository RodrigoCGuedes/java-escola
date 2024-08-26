package comparadores;

import java.util.Comparator;
import interfaces.Alfabetica;

public class CriterioAlfabeticaCrescente implements Comparator<Alfabetica> {

    @Override
    public int compare(Alfabetica a1, Alfabetica a2) {
        return a1.getNome().compareTo(a2.getNome());
    }
}
