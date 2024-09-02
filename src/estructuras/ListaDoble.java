package estructuras;
import datos.Alumno;

public class ListaDoble {

    private NodoDE list;

    public ListaDoble() {
        this.list = null;
    }

    public NodoDE inicio() {
        return list;
    }

    public boolean listaVacia() {
        return list == null;
    }

    public void insertarP(NodoDE x) {
        if (!listaVacia()) {
            x.setPs(list);
            list.setPa(x);
        }
        this.list = x;
    }

    public void insertarM(NodoDE ant, NodoDE x) {
        x.setPa(ant);
        x.setPs(ant.getPs());
        ant.getPs().setPa(x);
        ant.setPs(x);
    }

    public void insertarF(NodoDE ant, NodoDE x) {
        x.setPa(ant);
        ant.setPs(x);
    }

    public void quitarP() {
        list = list.getPs();
        list.setPa(null);
    }

    public void quitarM(NodoDE p) {
        (p.getPs()).setPa(p.getPa());
        (p.getPa()).setPs(p.getPs());
    }

    public void quitarF(NodoDE ant) {
        ant.setPs(null);
    }

    public void insertarElemento(Alumno dato) {
        NodoDE e = new NodoDE();
        e.setElemento(dato); // se crea nodo a insertar

        if (!listaVacia()) {
            NodoDE p = inicio();
            NodoDE ant = null;
            int b = 0;
            while (p != null && b == 0) {
                b = p.comparar(dato); // se comparan los nodos
                if (b == 0) {
                    ant = p;
                    p = p.getPs();
                }
            }
            if (b != 2) { // el dato no existe en la lista
                if (p == null) {
                    insertarF(ant, e);
                } else {
                    if (p == inicio()) {
                        insertarP(e);
                    } else {
                        insertarM(ant, e);
                    }
                }
            } else {
                System.out.println("EXISTE");
            }
        } else { // La lista esta vacia
            insertarP(e);
        }
    }

    public Alumno eliminarElemento(Alumno dato) {
        if (listaVacia()) {
            System.out.println("Lista Vacia");
            return null;
        } else {
            NodoDE p = inicio();
            NodoDE ant = null;
            int b = 0;
            while (p != null && b == 0) {
                b = p.comparar(dato); // se comparan los nodos
                if (b == 0) {
                    ant = p;
                    p = p.getPs();
                }   // sale del ciclo cuando llega al
            }       // final o cuando encuentra el nodo
            if (b == 2) {
                if (p == inicio()) {
                    quitarP();   // elimina al principio
                } else {
                    if (p.getPs() == null) {
                        quitarF(ant);  // elimina al final
                    } else {
                        quitarM(p);  // elimina en el medio
                    }
                }
                return p.getElemento();
            } else {
                System.out.println("NO EXISTE");
                return null;
            }
        }
    } }

