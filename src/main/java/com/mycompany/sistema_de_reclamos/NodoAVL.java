/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistema_de_reclamos;

/**
 *
 * @author Sebastian Yevenes G
 */
public class NodoAVL {
    
    private Reclamo reclamo;
    private NodoAVL izquierdo;
    private NodoAVL derecho; 
    private int altura;

    public NodoAVL(Reclamo reclamo) {
        this.reclamo = reclamo;
        this.izquierdo = null;
        this.derecho = null;
        this.altura = 1;
    }
    
    public Reclamo getReclamo(){
        return reclamo;
    }
    
    public NodoAVL getIzquierdo(){
        return izquierdo;
    }
    public void setIzquierdo(NodoAVL izquierdo){
        this.izquierdo = izquierdo;
    }
    
    public NodoAVL getDerecho(){
        return derecho;
    }
    public void setDerecho(NodoAVL derecho){
        this.derecho = derecho;
    }
    
    public int getAltura(){
        return altura;
    }
    public void setAltura(int altura){
        this.altura = altura;
    } 
    
}
