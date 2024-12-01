package com.mycompany.juegobatalla;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ADMIN
 */
import java.util.List;

public class Heroes extends Ejercito {
    int dado1;
    int dado2;

    public Heroes(String nombre, int puntosVida, int nivelResistencia) {
        super(nombre, puntosVida, nivelResistencia);
    }

    public int mayorResultado(){
        dado1=(int) (Math.random()*(100+1));
        dado2=(int) (Math.random()*(100+1));
        System.out.println("primer dado:"+dado1);
        System.out.println("segundo dado:"+dado2);

        if(dado1 <dado2){
            return dado2;
        }else
            return dado1;
    }
    // Obtén el ataque del héroe

    // Constructor de Héroe
    public int atacar(Bestias bestias) {
        int ataque = mayorResultado();

        if (ataque > bestias.getNivelResistencia()) {
            if (ataque < 0) {
                ataque = 0;
            }
            
            return ataque;
        } else {
            return 0;
        }
    }




    public boolean vida( List<Heroes> heroes){
        boolean vidas = getPuntosVida()<=0;
        if(vidas==false);
        System.out.println(getNombre()+" ha sido eliminado");
        return vidas;
    }

    public String toString(){
        return "Lucha entre "+getNombre()+" (Vida="+getPuntosVida()+" Armadura="+getNivelResistencia()+")";
    }

}


