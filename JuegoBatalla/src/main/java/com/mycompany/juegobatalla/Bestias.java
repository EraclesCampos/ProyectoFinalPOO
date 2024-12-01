package com.mycompany.juegobatalla;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ADMIN
 */
import java.util.ArrayList;

public class Bestias extends Ejercito {

    int dado;

    public Bestias(String nombre, int puntosVida, int nivelResistencia) {
        super(nombre, puntosVida, nivelResistencia);

    }

    public int getNivelResistencia(){
        return nivelResistencia;
    }

    public int tirarDadosBestias(){
        return dado =(int) (Math.random()*(90+1));
    }

    public int atacar(Heroes heroe) {
    int at = tirarDadosBestias();  // Genera el valor del dado para el ataque
    
    // Si el ataque supera la resistencia, restar la vida
    if (at > heroe.getNivelResistencia()) {
        return at;  // Retorna el valor del ataque
    }
    
    // Si no supera la resistencia, el héroe no recibe daño
    return 0;  // No hay daño si la resistencia del héroe es mayor que el ataque
}



    public boolean getVida(){
        boolean vidas = getPuntosVida()<=0;
        if(vidas==true);
        System.out.println(getNombre()+" ha sido eliminado");
        return vidas;
    }

    public String toString(){
        return " y "+getNombre()+" (Vida="+getPuntosVida()+" Armadura="+getNivelResistencia()+")";
    } 
    
    
}