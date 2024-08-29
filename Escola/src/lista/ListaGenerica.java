package lista;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class ListaGenerica<T> implements Iterable<T> {
    private List<T> itens;

    public ListaGenerica() {
        this.itens = new ArrayList<>();
    }
    
    public ListaGenerica(ListaGenerica<T> lista) {
        this.itens = new ArrayList<>(lista.itens);
    }

    public boolean adicionar(T item) {
    	if(item != null) {
    		itens.add(item);
    		return true;
    	}
    	return false;
    }

    public boolean remover(T item) {
        if(itens.remove(item)) {
        	return true;
        }
        return false;
    }
    
    public void remover(int index) {
    	itens.remove(index);
    }

    public List<T> getArray() {
        return new ArrayList<>(itens);
    }

    public T buscar(int index) {
        if (index >= 0 && index < itens.size()) {
            return itens.get(index);
        } else {
            throw new IndexOutOfBoundsException("Índice fora do alcance.");
        }
    }

    public int tamanho() {
        return itens.size();
    }

    public boolean contem(T item) {
        return itens.contains(item);
    }
    
    public ListaGenerica<T> ordenar(Comparator<? super T> comparador) {
		ListaGenerica<T> copia = new ListaGenerica<>(this);
		Collections.sort(copia.itens, comparador);
		return copia;
	}
    
    @Override
	public Iterator<T> iterator() {
		return itens.iterator();
	}
    
    public String toString() {
    	String resultado = "";
    	for(int i = 0; i < itens.size(); i++) {
    		resultado += itens.get(i) + "\n";
    	}
    	return resultado;
    }
}
