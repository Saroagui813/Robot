package org.iesalandalus.programacion.robot.modelo;

public class Robot {

    private Coordenada coordenada;
    private Orientacion orientacion;
    private Zona zona;

    public Robot() {
        this.zona = new Zona();
        this.coordenada = zona.getCentro();
        this.orientacion = Orientacion.NORTE;
    }

    public Robot(Zona zona) {
        this.zona = zona;
        this.coordenada = zona.getCentro();
        this.orientacion = Orientacion.NORTE;
    }

    public Robot(Zona zona, Orientacion orientacion) {
        this.zona = zona;
        this.coordenada = zona.getCentro();
        this.orientacion = orientacion;
    }

    public Robot(Zona zona, Orientacion orientacion, Coordenada coordenada) {
        this.zona = zona;
        this.coordenada = coordenada;
        this.orientacion = orientacion;
    }

    public Robot(Robot robot) {
        System.out.println("Creamos un robot copia");
        zona = robot.zona;
        coordenada = robot.coordenada;
        orientacion = robot.orientacion;
    }

    public Zona getZona() {
        return zona;
    }

    private void setZona(Zona zona) {
        this.zona = zona;
    }


    public Orientacion getOrientacion() {
        return orientacion;
    }

    public void setOrientacion(Orientacion orientacion) {
        this.orientacion = orientacion;
    }

    public Coordenada getCoordenada() {
        return coordenada;
    }

    public void setCoordenada(Coordenada coordenada) {
        this.coordenada = coordenada;
    }

    public void avanzar (Coordenada coordenada) {

    }
}
