/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.breaklinestudio.intro.main;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author camper
 */
public class LigaBetPlay {
      private List<Equipo> equipos;

    public LigaBetPlay() {
        this.equipos = new ArrayList<>();
    }

    public void registrarEquipo(String nombreEquipo) {
    if (!validarNombreEquipo(nombreEquipo)) {
        equipos.add(new Equipo(nombreEquipo));
        System.out.println("Equipo " + nombreEquipo + " registrado exitosamente.");
    } else {
        System.out.println("El equipo " + nombreEquipo + " ya está registrado.");
    }
}


   
     public boolean validarNombreEquipo(String nombreEquipo) {
        for (Equipo equipo : equipos) {
            if (equipo.getNombre().equalsIgnoreCase(nombreEquipo)) {
                return true;
            }
        }
        return false;
    }


    public void registrarFecha(String local, String visitante, int golesLocal, int golesVisitante) {
        Equipo equipoLocal = encontrarEquipo(local);
        Equipo equipoVisitante = encontrarEquipo(visitante);

        if (equipoLocal != null && equipoVisitante != null) {
            equipoLocal.PJ++;
            equipoVisitante.PJ++;

            equipoLocal.GF += golesLocal;
            equipoLocal.GC += golesVisitante;

            equipoVisitante.GF += golesVisitante;
            equipoVisitante.GC += golesLocal;

            if (golesLocal > golesVisitante) {
                equipoLocal.PG++;
                equipoVisitante.PP++;
                equipoLocal.TP += 3;
            } else if (golesLocal < golesVisitante) {
                equipoVisitante.PG++;
                equipoLocal.PP++;
                equipoVisitante.TP += 3;
            } else {
                equipoLocal.PE++;
                equipoVisitante.PE++;
                equipoLocal.TP += 1;
                equipoVisitante.TP += 1;
            }
        }
    }

    private Equipo encontrarEquipo(String nombre) {
        for (Equipo equipo : equipos) {
            if (equipo.nombre.equals(nombre)) {
                return equipo;
            }
        }
        return null;
    }

  public void mostrarReportes() {
    Equipo equipoMasGoles = null;
    Equipo equipoMasPuntos = null;
    Equipo equipoMasGanados = null;
    int totalGoles = 0;

    // Verificar si la lista de equipos no está vacía
    if (!equipos.isEmpty()) {
        for (Equipo equipo : equipos) {
            if (equipoMasGoles == null || equipo.getGF() > equipoMasGoles.getGF()) {
                equipoMasGoles = equipo;
            }
            if (equipoMasPuntos == null || equipo.getTP() > equipoMasPuntos.getTP()) {
                equipoMasPuntos = equipo;
            }
            if (equipoMasGanados == null || equipo.getPG() > equipoMasGanados.getPG()) {
                equipoMasGanados = equipo;
            }
            totalGoles += equipo.getGF();
        }

        int totalEquipos = equipos.size(); // Obtener el número total de equipos
        int totalPartidos = totalEquipos * (totalEquipos - 1) / 2;
        double promedioGoles;

        // Calcular el promedio de goles solo si hay partidos jugados
        if (totalPartidos > 0) {
            promedioGoles = (double) totalGoles / totalEquipos;
        } else {
            System.out.println("No se puede calcular el promedio de goles porque no hay partidos jugados.");
            promedioGoles = 0; 
        }

        if (equipoMasGoles != null) {
            System.out.println("Equipo que más goles anotó: " + equipoMasGoles.nombre);
        } else {
            System.out.println("N/A");
        }

        if (equipoMasPuntos != null) {
            System.out.println("Equipo con más puntos: " + equipoMasPuntos.nombre);
        } else {
            System.out.println("N/A");
        }

        if (equipoMasGanados != null) {
            System.out.println("Equipo con más partidos ganados: " + equipoMasGanados.nombre);
        } else {
            System.out.println("N/A");
        }

        
        // Imprimir el total de goles y el promedio de goles
        System.out.println("Total de goles anotados por todos los equipos: " + totalGoles);
        System.out.println("Promedio de goles anotados en el torneo: " + promedioGoles);
    } else {
        System.out.println("La lista de equipos está vacía. No se pueden calcular los reportes.");
    }
    }
}
