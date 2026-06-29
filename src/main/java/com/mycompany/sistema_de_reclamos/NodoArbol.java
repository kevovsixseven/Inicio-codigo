/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistema_de_reclamos;

/**
 *
 * @author User
 */
public class NodoArbol {
    private Reclamo reclamo;
    private NodoArbol izquierdo;
    private NodoArbol derecho;

    public NodoArbol(Reclamo reclamo) {
        this.reclamo = reclamo;
        this.izquierdo = null;
        this.derecho = null;
    }

    public Reclamo getReclamo() { 
        return reclamo; 
    }
    public void setReclamo(Reclamo reclamo) {
    this.reclamo = reclamo;
}
    
    public NodoArbol getIzquierdo() { 
        return izquierdo; 
    }
    public void setIzquierdo(NodoArbol izquierdo) { 
        this.izquierdo = izquierdo; 
    }
   
    public NodoArbol getDerecho() { 
        return derecho; 
    }
    public void setDerecho(NodoArbol derecho) { 
        this.derecho = derecho; 
    }
}