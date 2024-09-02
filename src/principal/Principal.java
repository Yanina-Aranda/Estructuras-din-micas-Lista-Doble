package principal;

import datos.Alumno;
import entradaDatos.EntradaSalida;
import estructuras.*;

public class Principal {

    private ListaDoble lde;
    private Alumno alumno;

    public Principal() {
        this.lde = new ListaDoble();
        this.alumno = new Alumno();
    }

    public void menu() {
        int op = 0;
        do {
            EntradaSalida.mostrarMensaje("\n***** Menu Lista Doble *****");
            EntradaSalida.mostrarMensaje("1- Insertar");
            EntradaSalida.mostrarMensaje("2- Eliminar");
            EntradaSalida.mostrarMensaje("3- Modificar");
            EntradaSalida.mostrarMensaje("4- Imprimir ");
            EntradaSalida.mostrarMensaje("5- Buscar");
            EntradaSalida.mostrarMensaje("6- Imprimir en Reversa");
            EntradaSalida.mostrarMensaje("0- Salir");
            EntradaSalida.mostrarMensaje("- Ingrese la opcion");
            op = EntradaSalida.leerInt();
            switch (op) {
                case 1:
                    generarLista();
                    break;
                case 2:
                    borrar();
                    break;
                case 3:
                    modificarElemento();
                    break;
                case 4:
                    imprimirLista();
                    break;
                case 5:
                    buscarElemento();
                    break;
                case 6:
                    imprimirReversa();
                    break;
                case 0:
                    break;

            }
        } while (op != 0);
    }

    public void generarLista() {
        EntradaSalida.mostrarMensaje("\nGENERAR LISTA");
        char op = 'S';
        while (op != 'N' && op != 'n') {
            alumno = new Alumno();
            alumno.cargarDatos();
            lde.insertarElemento(alumno);
            EntradaSalida.mostrarMensaje("Desea Continuar?");
            op = EntradaSalida.leerChar();
        }
    }

    public void imprimirLista() {
        if (verificarVacia()) {
            EntradaSalida.mostrarMensaje("\nIMPRIMIR LISTA");
            EntradaSalida.mostrarMensaje("\nDNI            Nombre                        Condicion");
            NodoDE p = lde.inicio();
            while (p != null) {
                p.mostrarDatos();
                p = p.getPs();
            }
        }
    }

    public void borrar() {
        if (verificarVacia()) {
            EntradaSalida.mostrarMensaje("\nELIMINAR ELEMENTO DE LISTA");
            char op = 'S';
            while (op != 'N' && op != 'n') {
                alumno = new Alumno();
                alumno.cargarDNI();
                Alumno res = lde.eliminarElemento(alumno);
                if (res != null) {
                    EntradaSalida.mostrarMensaje("Elemento eliminado");
                }
                EntradaSalida.mostrarMensaje("Desea Continuar?");
                op = EntradaSalida.leerChar();
            }
        }
    }

    public void buscarElemento() {
        if (verificarVacia()) {
            boolean b = false;
            alumno = new Alumno();
            alumno.cargarDNI();
            NodoDE p = lde.inicio();
            while (p != null && !b) {
                Alumno e = new Alumno();
                e = p.getElemento();
                if (alumno.getDni() == e.getDni()) {
                    b = true;
                    e.mostrarDatos(0);
                }
                p = p.getPs();
            }
            if (!b) {
                EntradaSalida.mostrarMensaje("Inexistente");
            }
        }
    }

    public void modificarElemento() {
        if (verificarVacia()) {
            EntradaSalida.mostrarMensaje("\nMODIFICAR LISTA");
            boolean b = false;
            alumno = new Alumno();
            alumno.cargarDNI();
            NodoDE p = lde.inicio();
            while (p != null && !b) {
                Alumno e = p.getElemento();
                if ((alumno.comparar(e)) == 2) { // son iguales
                    b = true;
                    e.mostrarDatos(0);
                    EntradaSalida.mostrarMensaje("Desea modificar?");
                    char op = EntradaSalida.leerChar();
                    if (op == 'S' || op == 's') {
                        e.modificarDatos();
                    }
                }
                p = p.getPs();
            }
            if (!b) {
                EntradaSalida.mostrarMensaje("Inexistente");
            }
        }
    }

    public void imprimirReversa() {
        if (verificarVacia()) {
            EntradaSalida.mostrarMensaje("\nIMPRIMIR LISTA EN REVERSA");
            EntradaSalida.mostrarMensaje("\nDNI            Nombre                        Condicion");
            NodoDE p = lde.inicio();
            while (p.getPs() != null) {
                p = p.getPs();
            }

            while (p != null) {
                p.mostrarDatos();
                p = p.getPa();
            }
        }
    }

    public boolean verificarVacia() {
        if (lde.listaVacia()) {
            EntradaSalida.mostrarMensaje("LISTA VACIA...");
            return false;
        } else {
            return true;
        }
    }

    public static void main(String[] args) {
        Principal app = new Principal();
        app.menu();
    }
}
