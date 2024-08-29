package comparadores;

import java.util.Comparator;
import interfaces.Alfabetico;

public class CriterioAlfabeticoDecrescente implements Comparator<Alfabetico> {

    @Override
    public int compare(Alfabetico a1, Alfabetico a2) {
        return a2.getNome().compareTo(a1.getNome());
    }
}
