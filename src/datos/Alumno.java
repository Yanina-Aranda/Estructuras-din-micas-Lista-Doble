package datos;

import entradaDatos.EntradaSalida;
import java.io.PrintStream;

public class Alumno {

    private int dni;
    private String nombre;
    private char condicion;

    public Alumno(int dni, String nombre, char condicion) {
        this.dni = dni;
        this.nombre = nombre;
        this.condicion = condicion;
    }

    public Alumno() {
        this.dni = 0;
        this.nombre = "";
        this.condicion = ' ';
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public char getCondicion() {
        return condicion;
    }

    public void setCondicion(char condicion) {
        this.condicion = condicion;
    }

    public void mostrarDatos() {
        System.out.printf("%-15s%-30s%-20s\n", this.dni, this.nombre, this.condicion);
    }
    
    public void mostrarDatos(int x) {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return ("DNI: " + this.dni + " Nombre: " + this.nombre + " Condicion: " + this.condicion);
        
    }
    
    public void cargarDatos() {
        if (cargarDNI()) {
            if (cargarNombre()) {
                if (cargarCondicion()) {
                    EntradaSalida.mostrarMensaje("Se cargo Correctamente");
                } else {
                    EntradaSalida.mostrarMensaje("ERROR");
                }
            } else {
                EntradaSalida.mostrarMensaje("ERROR");
            }
        } else {
            EntradaSalida.mostrarMensaje("ERROR");
        }
    }

    public boolean cargarDNI() {
        EntradaSalida.mostrarMensaje("Ingrese el DNI: ");
        int var = EntradaSalida.leerInt();
        if (var > 0) {
            this.dni = var;
            return true;
        } else {
            return false;
        }
    }

    private boolean cargarNombre() {
        EntradaSalida.mostrarMensaje("Ingrese el Nombre: ");
        String var = EntradaSalida.leerString();
        this.nombre = var;
        return true;
    }

    private boolean cargarCondicion() {
        EntradaSalida.mostrarMensaje("Ingrese la Condicion: ");
        char var = EntradaSalida.leerChar();
        this.condicion = var;
        return true;
    }

    public void modificarDatos() {
        if (cargarNombre()) {
            if (cargarCondicion()) {
                EntradaSalida.mostrarMensaje("Se cargo Correctamente");
            } else {
                EntradaSalida.mostrarMensaje("ERROR");
            }
        } else {
            EntradaSalida.mostrarMensaje("ERROR");
        }
    }

    public int comparar(Alumno x) {
        if (x.getDni() == this.getDni()) {
            return 2; // los DNI de los alumnos son iguales
        } else {
            if (x.getDni() > this.getDni()) {
                return 0; // el DNI recibido como parametro es mayor
            } else {
                return 1; // el DNI recibido como parametro es menor
            }
        }
    }
}
