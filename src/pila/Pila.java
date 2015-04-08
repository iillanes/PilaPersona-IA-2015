package pila;

/**
 * Created by jaime on 08-04-2015.
 */
public class Pila<T> {
    private Nodo<T> cima;

    public Pila() {
        cima = null;
    }

    public void apilar(T nuevo) {

        Nodo<T> nuevoElem = new Nodo<T>(nuevo);
        Nodo<T> aux;

        if (cima == null) {
            cima = nuevoElem;
        } else {
            aux = cima;
            cima = nuevoElem;
            cima.setEnlace(aux);
        }
    }

    public Nodo desapilar() throws ExcepcionPilaVacia {
        if (cima != null) {
            Nodo aux = cima;
            cima = cima.getEnlace();
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

        return sb.toString();
    }

    public boolean esVacia() {
        if (cima == null) {
            return true;
        } else {
            return false;
        }

    }

    public String invertir() {
        Pila pilaAuz = new Pila();
        try {
            while (!esVacia()) {
                Nodo nodoTemp = this.desapilar();
                pilaAuz.apilar(nodoTemp);
            }
            return pilaAuz.toString();

        } catch (ExcepcionPilaVacia excepcionPilaVacia) {
            return null;
        }


    }
}
