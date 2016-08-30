package mx.unam.ciencias.edd;

import java.util.NoSuchElementException;

/**
 * Clase abtracta para estructuras lineales restringidas a
 * operaciones mete/saca/mira, todas ocupando una lista subyaciente.
 */
public abstract class MeteSaca<T> {

    /* Clase Nodo protegida para uso interno de sus clases
     * herederas. */
    protected class Nodo<T> {
        public T elemento;
        public Nodo<T> siguiente;

        public Nodo(T elemento) {
            this.elemento = elemento;
        }
    }

    /* Primer elemento de la estructura. */
    protected Nodo<T> cabeza;
    /* Último elemento de la lista. */
    protected Nodo<T> rabo;
    /* Número de elementos en la estructura. */
    protected int elementos;

    /**
     * Agrega un elemento al extremo de la estructura.
     * @param elemento el elemento a agregar.
     */
    public abstract void mete(T elemento);

    /**
     * Elimina el elemento en un extremo de la estructura y lo
     * regresa.
     * @return el elemento en un extremo de la estructura.
     * @throws NoSuchElementException si la estructura está vacía.
     */
    public T saca() {
        if(this.cabeza == null){
	    throw new  NoSuchElementException("Lista vacía.");
	}
	T el = cabeza.elemento;
	cabeza = cabeza.siguiente;
	if(cabeza == null){
	    rabo = null;
	  }
	elementos--;
	return el;
    }

    /**
     * Nos permite ver el elemento en un extremo de la estructura,
     * sin sacarlo de la misma.
     * @return el elemento en un extremo de la estructura.
     * @throws NoSuchElementException si la estructura está vacía.
     */
    public T mira() {
    if (cabeza == null)
            throw new NoSuchElementException("Lista vacía.");
	 return cabeza.elemento; 
        
    }

    /**
     * Nos dice si la estructura está vacía.
     * @return <tt>true</tt> si la estructura no tiene elementos,
     *         <tt>false</tt> en otro caso.
     */
    public boolean esVacia() {
        if(cabeza == null && rabo == null){
	    return true;
	}
	return cabeza == null;
    }
    
    @Override public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass())
            return false;
        @SuppressWarnings("unchecked") MeteSaca<T> m = (MeteSaca<T>)o;
	Nodo t1 = cabeza;
        Nodo t2 = m.cabeza;
        while (t1 != null && t2 != null) {
            if (!t1.elemento.equals(t2.elemento))
                return false;
            t1 = t1.siguiente;
            t2 = t2.siguiente;
        }
        if (t1 != null || t2 != null) //diferentes logintudes
            return false;
        return true;
    }
}
