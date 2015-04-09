package pila;

import persona.Persona;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

/**
 * Created by jaime on 08-04-2015.
 */
public class Pila<T> {
    private Nodo<T> cima;

    public int getTotalElementos() {
        return totalElementos;
    }

    private int totalElementos = 0;

    public Pila() {
        cima = null;
    }



    public void apilar(T nuevo) {

        Nodo<T> nuevoElem = new Nodo<T>(nuevo);
        Nodo<T> aux;

        if (cima == null) {
            cima = nuevoElem;
            totalElementos++;
        } else {
            aux = cima;
            cima = nuevoElem;
            cima.setEnlace(aux);
            totalElementos++;
        }
    }

    public Nodo desapilar() throws ExcepcionPilaVacia {
        if (cima != null) {
            Nodo aux = cima;
            cima = cima.getEnlace();
            totalElementos--;
            return aux;
        } else {
            throw new ExcepcionPilaVacia();
        }
    }



    public Nodo verTop() {
        return cima;
    }

    @Override
    public String toString() {

        ArrayList<Persona> arrayListPersona = new ArrayList<Persona>();
        StringBuilder stringBuilder = new StringBuilder();

        while (this.esVacia() == false) {
            try {
                Nodo<Persona> nodoTemp = this.desapilar();
                Persona personaTemp = nodoTemp.dato;
                arrayListPersona.add(personaTemp);

            } catch (ExcepcionPilaVacia excepcionPilaVacia) {
                excepcionPilaVacia.getMessage();
            }
        }

        ListIterator<Persona> listIterator = arrayListPersona.listIterator();

        T personaTemp2;
        while (listIterator.hasNext()) {
            personaTemp2 = (T)listIterator.next();
            stringBuilder.append(personaTemp2.toString());
            this.apilar(personaTemp2);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
        /*


        StringBuilder sb = new StringBuilder();
        Pila pilaTemp = this;


        try {
            while (pilaTemp.cima != null) {
                Nodo nodo = pilaTemp.desapilar();
                sb.append(nodo.dato.toString());
                sb.append("\n");
            }

        } catch (ExcepcionPilaVacia excepcionPilaVacia) {
            excepcionPilaVacia.getMessage();
        }

        return sb.toString();*/
    }

    public boolean esVacia() {
        if (cima == null) {
            return true;
        } else {
            return false;
        }

    }

    public Pila invertir() {
        ArrayList<Persona> arrPer = new ArrayList<Persona>();

        while (this.esVacia() == false) {

            try {
                Nodo<Persona> nodoTemp = this.desapilar();
                Persona personaTemp = nodoTemp.dato;
                arrPer.add(personaTemp);
            } catch (ExcepcionPilaVacia excepcionPilaVacia) {
                excepcionPilaVacia.getMessage();
            }
        }

        ListIterator<Persona> listIterator = arrPer.listIterator();
        Pila pilaInvertida = new Pila();

        while (listIterator.hasNext()) {
            Persona personaTemp = listIterator.next();
            pilaInvertida.apilar(personaTemp);
        }

        /**
         * la pila original (this) fue completamente despilada, en esta etapa está vacia, entonces 
         * hay que apilar otra vez con los elementos que están en el arraylist, los elementos del arraylist son recuperados de fin a inicio
         */
        T personaTemp2;
        while (listIterator.hasPrevious()) {
            personaTemp2 = (T)listIterator.previous();
            this.apilar(personaTemp2);
        }
        return pilaInvertida;

    }
}
