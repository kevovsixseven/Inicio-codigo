/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistema_de_reclamos;

/**
 *
 * @author Sebastian Yevenes G
 */
public class ArbolAVL {
    
    private NodoAVL raiz;

    public ArbolAVL() {
        this.raiz = null;
    }
    
    public NodoAVL getRaiz(){
        return raiz;
    }
    
    private int altura (NodoAVL nodo){
        if (nodo==null){
            return 0;
        }
        return nodo.getAltura();
    }
    
    private int obtenerBalance(NodoAVL nodo){
         if (nodo==null){
            return 0;
        }
         return altura(nodo.getIzquierdo())- altura(nodo.getDerecho());
    }
    
    private int maximo(int a, int b) {
         if (a > b) {
            return a;
    }
    return b;
}
    
    public void insertar(Reclamo reclamo) {
    raiz = insertarRecursivo(raiz, reclamo);
}
    private NodoAVL insertarRecursivo(NodoAVL actual, Reclamo reclamo) {

    if (actual == null) {
        return new NodoAVL(reclamo);
    }

    if (reclamo.getCodigoUnico() < actual.getReclamo().getCodigoUnico()) {
        actual.setIzquierdo(insertarRecursivo(actual.getIzquierdo(), reclamo));
    } else if (reclamo.getCodigoUnico() > actual.getReclamo().getCodigoUnico()) {
        actual.setDerecho(insertarRecursivo(actual.getDerecho(), reclamo));
    }
    actual.setAltura(1 + maximo(altura(actual.getIzquierdo()), altura(actual.getDerecho())));
    int balance = obtenerBalance(actual);
    if (balance>1 && reclamo.getCodigoUnico()<actual.getIzquierdo().getReclamo().getCodigoUnico()){
      return rotacionDerecha(actual);      
    }
    if (balance<-1 && reclamo.getCodigoUnico()>actual.getDerecho().getReclamo().getCodigoUnico()){
      return rotacionIzquierda(actual);
}
    if (balance>1 && reclamo.getCodigoUnico()>actual.getIzquierdo().getReclamo().getCodigoUnico()){
    actual.setIzquierdo(rotacionIzquierda(actual.getIzquierdo()));
      return rotacionDerecha(actual);
}
    if (balance<-1 && reclamo.getCodigoUnico()<actual.getDerecho().getReclamo().getCodigoUnico()){
    actual.setDerecho(rotacionDerecha(actual.getDerecho()));
      return rotacionIzquierda(actual);
}
      return actual;
} 
    
    private NodoAVL rotacionDerecha(NodoAVL y) {

    NodoAVL x = y.getIzquierdo();
    NodoAVL t2 = x.getDerecho();

    x.setDerecho(y);
    y.setIzquierdo(t2);

    y.setAltura(1 + maximo(altura(y.getIzquierdo()), altura(y.getDerecho())));
    x.setAltura(1 + maximo(altura(x.getIzquierdo()), altura(x.getDerecho())));

    return x;
}
    
    private NodoAVL rotacionIzquierda(NodoAVL x) {

    NodoAVL y = x.getDerecho();
    NodoAVL t2 = y.getIzquierdo();

    y.setIzquierdo(x);
    x.setDerecho(t2);

    x.setAltura(1 + maximo(altura(x.getIzquierdo()), altura(x.getDerecho())));
    y.setAltura(1 + maximo(altura(y.getIzquierdo()), altura(y.getDerecho())));

    return y;
}
    
public void inOrden() {
    inOrdenRecursivo(raiz);
}
private void inOrdenRecursivo(NodoAVL actual) {
    if (actual != null) {
        inOrdenRecursivo(actual.getIzquierdo());
        System.out.println(actual.getReclamo().getCodigoUnico());
        inOrdenRecursivo(actual.getDerecho());
    }
  } 
}
