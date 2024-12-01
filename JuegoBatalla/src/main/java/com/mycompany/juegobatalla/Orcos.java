package com.mycompany.juegobatalla;

public class Orcos extends Bestias {
    public Orcos(String nombre, int puntosVida, int nivelResistencia) {
        super(nombre, puntosVida, nivelResistencia);
    }

    @Override
    public int atacar(Heroes heroe) {
        int ataque = tirarDadosBestias() + 5; // Incremento especial del ataque de los orcos
        return ataque;
    }
}
