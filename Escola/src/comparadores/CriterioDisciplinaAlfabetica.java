package comparadores;

import java.util.Comparator;
import escola.Disciplina;

public class CriterioDisciplinaAlfabetica implements Comparator<Disciplina> {

    @Override
    public int compare(Disciplina d1, Disciplina d2) {
        return d1.getNome().compareTo(d2.getNome());
    }
}
