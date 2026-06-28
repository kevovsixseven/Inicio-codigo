/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistema_de_reclamos;

/**
 *
 * @author User
 */
import java.util.LinkedList;
import java.util.Queue;

public class ColaPendientes {
    private Queue<Reclamo> cola;

    public ColaPendientes() {
        cola = new LinkedList<>();
    }

    public void agregarACola(Reclamo reclamo) {
        cola.add(reclamo);
    }

    public void atenderSiguiente() {
        if (cola.isEmpty()) {
            System.out.println("\n*** No hay reclamos pendientes en la cola ***");
        } else {
            Reclamo atendido = cola.poll();
            atendido.setEstado("En Proceso");
            System.out.println("\n*** Atendiendo Reclamo ***");
            System.out.println(atendido);
        }
    }

    public void mostrarCola() {
        if (cola.isEmpty()) {
            System.out.println("\n*** La cola está vacía ***");
            return;
        }
        for (Reclamo r : cola) {
            System.out.println("  " + r);
        }
    }
}