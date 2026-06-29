/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistema_de_reclamos;

/**
 *
 * @author User
 */
import java.time.LocalDate;
import java.util.Stack;

public class Reclamo {
    private int codigoUnico;
    private String nombreCiudadano;
    private String rutCiudadano;
    private String tipoReclamo;
    private String descripcion;
    private LocalDate fechaIngreso;
    private String estado;
    private int prioridad;
    private LocalDate fechaLimite;
    private Stack<String> historial;

    public Reclamo(int codigoUnico, String nombreCiudadano, String rutCiudadano, 
                   String tipoReclamo, String descripcion, int prioridad, LocalDate fechaLimite) {
        this.codigoUnico = codigoUnico;
        this.nombreCiudadano = nombreCiudadano;
        this.rutCiudadano = rutCiudadano;
        this.tipoReclamo = tipoReclamo;
        this.descripcion = descripcion;
        this.prioridad = prioridad;
        this.fechaLimite = fechaLimite;
        this.fechaIngreso = LocalDate.now();
        this.estado = "Pendiente";
        
        this.historial = new Stack<>();
        registrarCambio("Ingreso inicial. Estado: Pendiente, Prioridad: " + prioridad);
    }

    public void registrarCambio(String cambio) {
        historial.push(LocalDate.now() + " - " + cambio);
    }

    public void mostrarHistorial() {
        System.out.println("\n--- Historial de Cambios ---");
        if (historial.isEmpty()) {
            System.out.println("No hay historial.");
        } else {
            for (int i = historial.size() - 1; i >= 0; i--) {
                System.out.println("-> " + historial.get(i));
            }
        }
    }

    public int getCodigoUnico() { 
        return codigoUnico; 
    }
    public String getTipoReclamo() { 
        return tipoReclamo; 
    }
    public int getPrioridad() 
    { return prioridad; 
    }
    public String getEstado() { 
        return estado; 
    }
    public LocalDate getFechaLimite() { 
        return fechaLimite; 
    }

    public void setEstado(String estado) {
        this.estado = estado;
        registrarCambio("Estado cambiado a: " + estado);
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
        registrarCambio("Prioridad cambiada a: " + prioridad);
    }

    @Override
    public String toString() {
        return "ID: " + codigoUnico + " | Cliente: " + nombreCiudadano + " | Tipo: " + tipoReclamo + 
               " | Prioridad: " + prioridad + " | Estado: " + estado + " | Vence: " + fechaLimite;
    }
}