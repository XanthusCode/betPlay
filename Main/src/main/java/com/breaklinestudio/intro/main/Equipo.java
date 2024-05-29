/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.breaklinestudio.intro.main;

/**
 *
 * @author camper
 */
public class Equipo {
     String nombre;
    int PJ, PG, PP, PE, GF, GC, TP;

    public Equipo(String nombre) {
        this.nombre = nombre;
        this.PJ = 0;
        this.PG = 0;
        this.PP = 0;
        this.PE = 0;
        this.GF = 0;
        this.GC = 0;
        this.TP = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPJ() {
        return PJ;
    }

    public void setPJ(int PJ) {
        this.PJ = PJ;
    }

    public int getPG() {
        return PG;
    }

    public void setPG(int PG) {
        this.PG = PG;
    }

    public int getPP() {
        return PP;
    }

    public void setPP(int PP) {
        this.PP = PP;
    }

    public int getPE() {
        return PE;
    }

    public void setPE(int PE) {
        this.PE = PE;
    }

    public int getGF() {
        return GF;
    }

    public void setGF(int GF) {
        this.GF = GF;
    }

    public int getGC() {
        return GC;
    }

    public void setGC(int GC) {
        this.GC = GC;
    }

    public int getTP() {
        return TP;
    }

    public void setTP(int TP) {
        this.TP = TP;
    }
}

