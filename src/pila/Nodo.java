package pila;

import persona.Persona;

/**
 * Created by jaime on 08-04-2015.
 */
public class Nodo {

    private Persona dato;
    private Persona enlace;

    //constructor
    Nodo(Persona nueva) {
        this.dato = nueva;
        this.enlace = null;
    }
}
