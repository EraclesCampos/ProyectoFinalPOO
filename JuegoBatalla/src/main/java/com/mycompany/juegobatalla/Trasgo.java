package com.mycompany.juegobatalla;

public class Trasgo extends Bestias {
    public Trasgo(String nombre, int puntosVida, int nivelResistencia) {
        super(nombre, puntosVida, nivelResistencia);

    }
    @Override
    public int atacar(Heroes heroe) {
        int ataque = tirarDadosBestias() + 5; // Incremento especial del ataque de los orcos
        return ataque;
    }
}
