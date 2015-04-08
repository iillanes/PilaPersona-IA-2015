package pila;

import persona.Persona;

/**
 * Created by jaime on 08-04-2015.
 */
public class Nodo<T> {

    public T dato;
    private Nodo enlace;

    public Nodo(T dato) {
        this.dato = dato;
        enlace = null;
    }

    public void setEnlace(Nodo enlace) {
        this.enlace = enlace;
    }

    public Nodo getEnlace() {
        return enlace;
    }



    @Override
    public String toString() {
        return dato.toString();
    }

}
