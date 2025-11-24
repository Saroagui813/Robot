package org.iesalandalus.programacion.robot.modelo;

import java.util.Objects;

public class Robot {

    private Coordenada coordenada;
    private Orientacion orientacion;
    private Zona zona;

    public Robot() {
        zona = new Zona();
        coordenada = zona.getCentro();
        orientacion = Orientacion.NORTE;
    }

    public Robot(Zona zona) {
        this.coordenada = zona.getCentro();
        orientacion = Orientacion.NORTE;
    }

    public Robot(Zona zona, Orientacion orientacion) {
        this.coordenada = zona.getCentro();
        this.orientacion = orientacion;
    }

    public Robot(Zona zona, Orientacion orientacion, Coordenada coordenada) {
        this();
        this.zona = getZona();
        this.orientacion = getOrientacion();
        this.coordenada = ;
    }

    public Robot(Robot robot) {
        System.out.println("Creamos una copia de robot");
        Objects.requireNonNull(robot, "No puedo copiar un objeto nulo.");
        zona = robot.zona;
        coordenada = robot.coordenada;
        orientacion = robot.orientacion;
    }

    public Zona getZona() {
        return zona;
    }

    private void setZona(Zona zona) {
        try {
            this.zona = new Zona();
        } catch ()
    }

    public Orientacion getOrientacion() {
        return orientacion;
    }

    private void setOrientacion(Orientacion orientacion) {
        this.orientacion = orientacion;
    }

    public Coordenada getCoordenada() {
        return coordenada;
    }

    public void setCoordenada(Coordenada coordenada) {
        this.coordenada = coordenada;
    }

}
