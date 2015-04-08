package pila;

import persona.Persona;

/**
 * Created by jaime on 08-04-2015.
 */
public class Nodo<T> {

    public T dato;
    public Nodo enlace;

    public Nodo(T dato) {
        this.dato = dato;
        enlace = null;
    }


    @Override
    public String toString() {
        return dato.toString();
    }

}
