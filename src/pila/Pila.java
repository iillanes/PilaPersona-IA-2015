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
            cima.setEnlace(cima.getEnlace());
            return aux;
        } else {
            throw new ExcepcionPilaVacia();
        }
    }

    public Nodo verTop() {
        return cima;
    }

}
