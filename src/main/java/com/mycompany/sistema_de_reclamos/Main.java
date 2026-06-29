/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sistema_de_reclamos;

/**
 *
 * @author User
 */


import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.setOut(new java.io.PrintStream(System.out, true, java.nio.charset.StandardCharsets.UTF_8));
        Scanner teclado = new Scanner(System.in);

        ListaReclamos listaReclamos = new ListaReclamos();
        ArbolReclamos arbolReclamos = new ArbolReclamos();
        ColaPendientes colaPendientes = new ColaPendientes();
        ArbolAVL arbolAVL = new ArbolAVL();

        cargarDatosPrueba (listaReclamos, arbolReclamos, colaPendientes);
        arbolAVL.insertar(new Reclamo(30, "", "", "", "", 1, LocalDate.now()));
        arbolAVL.insertar(new Reclamo(20, "", "", "", "", 1, LocalDate.now()));
        arbolAVL.insertar(new Reclamo(10, "", "", "", "", 1, LocalDate.now()));

        System.out.println("Recorrido InOrden AVL:");
        arbolAVL.inOrden();

        int opcion;

        do {
            mostrarMenu();
            System.out.print("\n- Seleccione una opcion: ");
            opcion = leerEntero(teclado);

            switch (opcion) {
                case 1:
                    registrarReclamo(teclado, listaReclamos, arbolReclamos, colaPendientes);
                    break;
                case 2:
                    modificarReclamo(teclado, arbolReclamos);
                    break;
                case 3:
                    eliminarReclamo(teclado, listaReclamos);
                    break;
                case 4:
                    colaPendientes.atenderSiguiente();
                    break;
                case 5:
                    buscarReclamo(teclado, arbolReclamos);
                    break;
                case 6:
                    System.out.println("\n--- Lista General de Reclamos ---");
                    listaReclamos.mostrarLista();
                    break;
                case 7:
                    mostrarReclamosOrdenadosPrioridad(listaReclamos);
                    break;
                case 8:
                    ejecutarOptimizacion(listaReclamos);
                    break;
                case 9:
                    buscarReclamoSecuencial(teclado, listaReclamos);
                    break;
                case 0:
                    System.out.println("\n*** Programa finalizado correctamente. ***");
                    break;
                default:
                    System.out.println("\n*** Opcion no valida, intente nuevamente. ***");
            }
        } while (opcion != 0);

        teclado.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n==========================================");
        System.out.println("=== SISTEMA MUNICIPAL DE SAN RAFAEL ======");
        System.out.println("==========================================");
        System.out.println("1. Registrar nuevo reclamo");
        System.out.println("2. Modificar reclamo existente");
        System.out.println("3. Eliminar reclamo");
        System.out.println("4. Atender reclamo ");
        System.out.println("5. Buscar reclamo e historial(Arbol BST)");
        System.out.println("6. Mostrar todos los reclamos");
        System.out.println("7. Ordenar por Prioridad");
        System.out.println("8. Ejecutar Optimización");
        System.out.println("9. Buscar reclamo (Búsqueda Secuencial)");
        System.out.println("0. Finalizar");
    }

    private static void cargarDatosPrueba(ListaReclamos lista, ArbolReclamos arbol, ColaPendientes cola) {
        Reclamo r1 = new Reclamo(105, "kevin Guajardo", "11.111.111-1", "Alumbrado", "Poste roto", 3, LocalDate.now().plusDays(2));
        Reclamo r2 = new Reclamo(102, "Maria Soto", "22.222.222-2", "Seguridad", "Robos en plaza", 2, LocalDate.now().plusDays(10));
        
        lista.agregarReclamo(r1); arbol.insertar(r1); cola.agregarACola(r1);
        lista.agregarReclamo(r2); arbol.insertar(r2); cola.agregarACola(r2);
    }

    private static void registrarReclamo(Scanner teclado, ListaReclamos lista, ArbolReclamos arbol, ColaPendientes cola) {
        System.out.print("\nIngrese ID del reclamo: ");
        int id = leerEntero(teclado);
        teclado.nextLine();

        System.out.print("Nombre ciudadano: ");
        String nombre = teclado.nextLine();
        
        System.out.print("RUT: ");
        String rut = teclado.nextLine();

        System.out.print("Tipo reclamo: ");
        String tipo = teclado.nextLine();

        System.out.print("Descripcion: ");
        String desc = teclado.nextLine();

        System.out.print("Prioridad (1-Alta, 2-Media, 3-Baja): ");
        int prio = leerEntero(teclado);

        System.out.print("Dias limite para responder: ");
        int dias = leerEntero(teclado);

        Reclamo nuevo = new Reclamo(id, nombre, rut, tipo, desc, prio, LocalDate.now().plusDays(dias));
        
        lista.agregarReclamo(nuevo);
        arbol.insertar(nuevo);
        cola.agregarACola(nuevo);

        System.out.println("\n*** Reclamo registrado correctamente. ***");
    }

    private static void modificarReclamo(Scanner teclado, ArbolReclamos arbol) {
        System.out.print("\nIngrese ID del reclamo a modificar: ");
        int id = leerEntero(teclado);
        Reclamo r = arbol.buscarPorCodigo(id);

        if (r != null) {
            System.out.println("1. Cambiar Estado (Actual: " + r.getEstado() + ")");
            System.out.println("2. Cambiar Prioridad (Actual: " + r.getPrioridad() + ")");
            System.out.print("¿Qué desea modificar? ");
            int opc = leerEntero(teclado);
            teclado.nextLine(); 

            if (opc == 1) {
                System.out.print("Nuevo estado (Pendiente, En Proceso, Resuelto): ");
                r.setEstado(teclado.nextLine());
                System.out.println("*** Estado actualizado exitosamente. ***");
            } else if (opc == 2) {
                System.out.print("nueva  prioridad (1-Alta, 2-Media, 3-Baja): ");
                r.setPrioridad(leerEntero(teclado));
                System.out.println("*** Prioridad actualizada exitosamente. ***");
            } else {
                System.out.println("*** Opción inválida. ***");
            }
        } else {
            System.out.println("\n*** Reclamo no encontrado en el sistema. ***");
        }
    }

    private static void eliminarReclamo(Scanner teclado, ListaReclamos lista) {
        System.out.print("\nIngrese ID del reclamo a eliminar: ");
        int id = leerEntero(teclado);
        if (lista.eliminarReclamo(id)) {
            System.out.println("\n*** Reclamo eliminado de la lista general exitosamente. ***");
        } else {
            System.out.println("\n*** Reclamo no encontrado. ***");
        }
    }

    private static void buscarReclamo(Scanner teclado, ArbolReclamos arbol) {
        System.out.print("\nIngrese el ID del reclamo: ");
        int id = leerEntero(teclado);

        Reclamo encontrado = arbol.buscarPorCodigo(id);

        if (encontrado != null) {
            System.out.println("\n*** Reclamo Encontrado ***");
            System.out.println(encontrado);
            encontrado.mostrarHistorial();
        } else {
            System.out.println("\n*** Reclamo no encontrado ***");
        }
    }
    
    private static void buscarReclamoSecuencial(Scanner teclado, ListaReclamos lista) {

    System.out.print("\nIngrese el ID del reclamo: ");
    int id = leerEntero(teclado);

        Reclamo encontrado = lista.busquedaSecuencial(id);

    if (encontrado != null) {
        System.out.println("\n*** Reclamo Encontrado ***");
        System.out.println(encontrado);
        encontrado.mostrarHistorial();
    } else {
        System.out.println("\n*** Reclamo no encontrado ***");
    }
}

    private static void mostrarReclamosOrdenadosPrioridad(ListaReclamos lista) {
        Reclamo[] arreglo = lista.toArray();
        if (arreglo.length == 0) {
            System.out.println("\n*** No hay datos para ordenar ***");
            return;
        }

        lista.mergeSortPrioridad(arreglo, 0, arreglo.length - 1);

        System.out.println("\n--- Reclamos Ordenados por Prioridad ---");
        for (Reclamo r : arreglo) {
            System.out.println("  " + r);
        }
    }

    private static void ejecutarOptimizacion(ListaReclamos lista) {
        System.out.println("\n--- Ejecutando optimización automática de prioridades ---");
        Reclamo[] arreglo = lista.toArray();
        LocalDate hoy = LocalDate.now();
        boolean cambios = false;

        for (Reclamo r : arreglo) {
            if (!r.getEstado().equals("Resuelto")) {
                long diasRestantes = ChronoUnit.DAYS.between(hoy, r.getFechaLimite());
                if (diasRestantes <= 3 && r.getPrioridad() > 1) {
                    r.setPrioridad(1);
                    r.registrarCambio("Prioridad subida a 1 por riesgo de vencimiento (" + diasRestantes + " días).");
                    System.out.println("Alerta: Reclamo " + r.getCodigoUnico() + " subió a Prioridad Alta.");
                    cambios = true;
                }
            }
        }
        if (!cambios) System.out.println("No fue necesario optimizar ninguna prioridad.");
    }

    private static int leerEntero(Scanner teclado) {
        while (!teclado.hasNextInt()) {
            System.out.print("Debe ingresar un numero valido: ");
            teclado.next();
        }
        return teclado.nextInt();
    }
}