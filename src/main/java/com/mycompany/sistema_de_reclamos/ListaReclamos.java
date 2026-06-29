/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistema_de_reclamos;

/**
 *
 * @author User
 */
public class ListaReclamos {
    private NodoLista cabeza;
    private int tamaño;

    public ListaReclamos() {
        this.cabeza = null;
        this.tamaño = 0;
    }

    public void agregarReclamo(Reclamo reclamo) {
        NodoLista nuevo = new NodoLista(reclamo);
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            NodoLista actual = cabeza;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevo);
        }
        tamaño++;
    }

    public Reclamo buscarSecuencial(int codigo) {
        NodoLista actual = cabeza;
        while (actual != null) {
            if (actual.getReclamo().getCodigoUnico() == codigo) {
                return actual.getReclamo();
            }
            actual = actual.getSiguiente();
        }
        return null;
    }

    public boolean eliminarReclamo(int codigo) {
        if (cabeza == null) return false;

        if (cabeza.getReclamo().getCodigoUnico() == codigo) {
            cabeza = cabeza.getSiguiente();
            tamaño--;
            return true;
        }

        NodoLista actual = cabeza;
        while (actual.getSiguiente() != null) {
            if (actual.getSiguiente().getReclamo().getCodigoUnico() == codigo) {
                actual.setSiguiente(actual.getSiguiente().getSiguiente());
                tamaño--;
                return true;
            }
            actual = actual.getSiguiente();
        }
        return false;
    }

    public void mostrarLista() {
        if (cabeza == null) {
            System.out.println("\n*** No hay reclamos registrados ***");
            return;
        }
        NodoLista actual = cabeza;
        while (actual != null) {
            System.out.println("  " + actual.getReclamo());
            actual = actual.getSiguiente();
        }
    }

    public Reclamo[] toArray() {
        Reclamo[] arreglo = new Reclamo[tamaño];
        NodoLista actual = cabeza;
        int i = 0;
        while (actual != null) {
            arreglo[i++] = actual.getReclamo();
            actual = actual.getSiguiente();
        }
        return arreglo;
    }
    
    public int getTamaño() { 
        return tamaño; 
    }
    
    public void mergeSortPrioridad(Reclamo[] arreglo, int izq, int der) {
        if (izq < der) {
            int medio = (izq + der) / 2;
            mergeSortPrioridad(arreglo, izq, medio);
            mergeSortPrioridad(arreglo, medio + 1, der);
            merge(arreglo, izq, medio, der);
        }
    }

    private void merge(Reclamo[] arreglo, int izq, int medio, int der) {
        int n1 = medio - izq + 1;
        int n2 = der - medio;

        Reclamo[] L = new Reclamo[n1];
        Reclamo[] R = new Reclamo[n2];

        for (int i = 0; i < n1; ++i) L[i] = arreglo[izq + i];
        for (int j = 0; j < n2; ++j) R[j] = arreglo[medio + 1 + j];

        int i = 0, j = 0, k = izq;
        while (i < n1 && j < n2) {
            if (L[i].getPrioridad() <= R[j].getPrioridad()) {
                arreglo[k] = L[i];
                i++;
            } else {
                arreglo[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) arreglo[k++] = L[i++];
        while (j < n2) arreglo[k++] = R[j++];
    }

    public void bubbleSortCodigo(Reclamo[] arreglo) {
        int n = arreglo.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arreglo[j].getCodigoUnico() > arreglo[j + 1].getCodigoUnico()) {
                    Reclamo temp = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = temp;
                }
            }
        }
    }

    public Reclamo busquedaBinaria(Reclamo[] arreglo, int codigo) {
        int inicio = 0;
        int fin = arreglo.length - 1;

        while (inicio <= fin) {
            int medio = inicio + (fin - inicio) / 2;

            if (arreglo[medio].getCodigoUnico() == codigo) {
                return arreglo[medio];
            }
            if (arreglo[medio].getCodigoUnico() < codigo) {
                inicio = medio + 1;
            } else {
                fin = medio - 1;
            }
        }
        return null;
    }
}