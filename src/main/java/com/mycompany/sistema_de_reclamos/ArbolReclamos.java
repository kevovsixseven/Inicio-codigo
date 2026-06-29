/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistema_de_reclamos;

/**
 *
 * @author User
 */
public class ArbolReclamos {
    private NodoArbol raiz;

    public ArbolReclamos() {
        this.raiz = null;
    }

    public void insertar(Reclamo reclamo) {
        raiz = insertarRecursivo(raiz, reclamo);
    }

    private NodoArbol insertarRecursivo(NodoArbol actual, Reclamo reclamo) {
        if (actual == null) {
            return new NodoArbol(reclamo);
        }
        if (reclamo.getCodigoUnico() < actual.getReclamo().getCodigoUnico()) {
            actual.setIzquierdo(insertarRecursivo(actual.getIzquierdo(), reclamo));
        } else if (reclamo.getCodigoUnico() > actual.getReclamo().getCodigoUnico()) {
            actual.setDerecho(insertarRecursivo(actual.getDerecho(), reclamo));
        }
        return actual;
    }

    public Reclamo buscarPorCodigo(int codigo) {
        return buscarRecursivo(raiz, codigo);
    }

    private Reclamo buscarRecursivo(NodoArbol actual, int codigo) {
        if (actual == null) return null;
        
        if (codigo == actual.getReclamo().getCodigoUnico()) {
            return actual.getReclamo();
        }
        if (codigo < actual.getReclamo().getCodigoUnico()) {
            return buscarRecursivo(actual.getIzquierdo(), codigo);
        } else {
            return buscarRecursivo(actual.getDerecho(), codigo);
        }
    }
    
    public void eliminar(int codigo) {
    raiz = eliminarRecursivo(raiz, codigo);
}
    private NodoArbol eliminarRecursivo(NodoArbol actual, int codigo) {
    if (actual == null) {
        return null;
    }
    if (codigo < actual.getReclamo().getCodigoUnico()) {
        actual.setIzquierdo(eliminarRecursivo(actual.getIzquierdo(), codigo));
    }else if (codigo > actual.getReclamo().getCodigoUnico()) {
        actual.setDerecho(eliminarRecursivo(actual.getDerecho(), codigo));
    }else{
         if (actual.getIzquierdo() == null) {
        return actual.getDerecho();
         }
    if (actual.getDerecho() == null) {
        return actual.getIzquierdo();
         }
    NodoArbol sucesor = obtenerMenor(actual.getDerecho());
    actual.setReclamo(sucesor.getReclamo());
    actual.setDerecho(eliminarRecursivo(
        actual.getDerecho(),
        sucesor.getReclamo().getCodigoUnico()));
    }
    return actual;
}
    
    private NodoArbol obtenerMenor(NodoArbol nodo) {
    while (nodo.getIzquierdo() != null) {
        nodo = nodo.getIzquierdo();
    }
    return nodo;
}
    

    public void mostrarInOrden() {
        if (raiz == null) {
            System.out.println("\n*** El árbol está vacío ***");
        } else {
            mostrarInOrdenRecursivo(raiz);
        }
    }
    private void mostrarInOrdenRecursivo(NodoArbol actual) {
        if (actual != null) {
            mostrarInOrdenRecursivo(actual.getIzquierdo());
            System.out.println("  " + actual.getReclamo());
            mostrarInOrdenRecursivo(actual.getDerecho());
        }
    }
    
    public void mostrarPreOrden(){
        if(raiz==null){
            System.out.println("\n*** El árbol está vacio ***");
        }else{
            mostrarPreOrdenRecursivo(raiz);
        }
    }
    private void mostrarPreOrdenRecursivo(NodoArbol actual) {
    if (actual != null) {
        System.out.println("  " + actual.getReclamo());
        mostrarPreOrdenRecursivo(actual.getIzquierdo());
        mostrarPreOrdenRecursivo(actual.getDerecho());
    }
}
    
   public void mostrarPostOrden() {
        if (raiz == null) {
        System.out.println("\n*** El árbol está vacío ***");
        }else{
        mostrarPostOrdenRecursivo(raiz);
        }
    }
   private void mostrarPostOrdenRecursivo(NodoArbol actual) {
    if (actual != null) {
        mostrarPostOrdenRecursivo(actual.getIzquierdo());
        mostrarPostOrdenRecursivo(actual.getDerecho());
        System.out.println("  " + actual.getReclamo());
    }
} 
   
}
