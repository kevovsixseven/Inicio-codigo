/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistema_de_reclamos;

/**
 *
 * @author User
 */
public class NodoLista {
    private Reclamo reclamo;
    private NodoLista siguiente;

    public NodoLista(Reclamo reclamo) {
        this.reclamo = reclamo;
        this.siguiente = null;
    }

    public Reclamo getReclamo() { return reclamo; }
    public NodoLista getSiguiente() { return siguiente; }
    public void setSiguiente(NodoLista siguiente) { this.siguiente = siguiente; }
}