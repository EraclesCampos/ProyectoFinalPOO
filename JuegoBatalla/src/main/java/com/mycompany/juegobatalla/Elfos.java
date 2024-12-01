package com.mycompany.juegobatalla;

public class Elfos extends Heroes {

    public Elfos(String nombre, int puntosVida, int nivelResistencia) {
        super(nombre, puntosVida, nivelResistencia);
    }

    @Override
    public int atacar(Bestias bestia) {
        int ataque = mayorResultado() + 10;
        if (ataque > bestia.getNivelResistencia()) {
             return ataque;
        }
        else return 0;
    }
}
