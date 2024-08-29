package comparadores;

import java.util.Comparator;
import interfaces.Alfabetico;

public class CriterioAlfabeticoCrescente implements Comparator<Alfabetico> {

    @Override
    public int compare(Alfabetico a1, Alfabetico a2) {
        return a1.getNome().compareTo(a2.getNome());
    }
}
