package org.iesalandalus.programacion.robot.modelo;

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
        this.coordenada = coordenada;

    }

    public Robot(Robot robot) {

    }

    public Zona getZona() {
        return zona;
    }

    private void setZona(Zona zona) {
        this.zona = zona;
    }
}
