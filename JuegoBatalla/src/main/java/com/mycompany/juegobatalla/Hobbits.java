package com.mycompany.juegobatalla;

public class Hobbits extends Heroes {
    
    public Hobbits(String nombre, int puntosVida, int nivelResistencia) {
        super(nombre, puntosVida, nivelResistencia);
    }
    @Override
    public int atacar(Bestias bestia) {
        int ataque = mayorResultado() + 10;
        return ataque;
    }
}