/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.breaklinestudio.intro.main;

import java.util.Scanner;
import menu.menu;

/**
 *
 * @author camper
 */
public class Main {
 public static void main(String[] args) {
        // Limpia la consola imprimiendo 25 líneas en blanco
        for (int i = 0; i < 15; i++) {
            System.out.println();
        }
    
        LigaBetPlay liga = new LigaBetPlay();
        try (Scanner sc = new Scanner(System.in)) {
            String opcion;
            
            do {
                menu m = new menu();
                m.menu();
                opcion = sc.next();
                
                switch (opcion) {
                    case "1" -> {
                        System.out.print("Ingrese el nombre del equipo: ");
                        String nombreEquipo = sc.next();
                        liga.registrarEquipo(nombreEquipo);

                    }
                    case "2" -> {
                       System.out.print("Ingrese el nombre del equipo local: ");
                        String local = sc.next();
                        System.out.print("Ingrese el nombre del equipo visitante: ");
                        String visitante = sc.next();
                        System.out.print("Ingrese los goles del equipo local: ");
                        int golesLocal = sc.nextInt();
                        System.out.print("Ingrese los goles del equipo visitante: ");
                        int golesVisitante = sc.nextInt();

                        if (liga.validarNombreEquipo(local) && liga.validarNombreEquipo(visitante)) {
                            liga.registrarFecha(local, visitante, golesLocal, golesVisitante);
                            System.out.println("El partido ha sido registrado.");
                        } else {
                            if (!liga.validarNombreEquipo(local)) {
                                System.out.println("El equipo local no se encuentra en la lista.");
                            }
                            if (!liga.validarNombreEquipo(visitante)) {
                                System.out.println("El equipo visitante no se encuentra en la lista.");
                            }
                        }
                    }
                    case "3" -> liga.mostrarReportes();
                    case "4" -> System.out.println("Adiosssss!!...");
                    default -> System.out.println("Opción no válida");
                }
            } while (!opcion.equals("4"));
        }
    }
}

