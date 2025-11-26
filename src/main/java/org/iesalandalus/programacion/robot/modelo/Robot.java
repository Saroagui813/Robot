package org.iesalandalus.programacion.robot.modelo;

import java.util.Objects;

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
        try {
            setCoordenada(coordenada);
        } catch (IllegalArgumentException e) {
            throw new RobotException("Esa coordenada no es válida.");
        }
        this.zona = zona;
        this.coordenada = coordenada;
        this.orientacion = orientacion;
    }

    public Robot(Robot robot) {
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

    public void setCoordenada(Coordenada nuevaCoordenada) {
        this.coordenada = nuevaCoordenada;
    }

    public void avanzar () {
        Coordenada nuevaCoordenada = null;
        switch (orientacion) {
            case NORTE -> nuevaCoordenada = new Coordenada(coordenada.x(), coordenada.y() + 1);
            case NORESTE -> nuevaCoordenada = new Coordenada(coordenada.x() + 1, coordenada.y() + 1);
            case NOROESTE -> nuevaCoordenada = new Coordenada(coordenada.x() - 1, coordenada.y() + 1);
            case OESTE -> nuevaCoordenada = new Coordenada(coordenada.x() - 1, coordenada.y());
            case ESTE -> nuevaCoordenada = new Coordenada(coordenada.x() + 1, coordenada.y());
            case SUR -> nuevaCoordenada = new Coordenada(coordenada.x(), coordenada.y() - 1);
            case SURESTE -> nuevaCoordenada = new Coordenada(coordenada.x() + 1, coordenada.y() - 1);
            case SUROESTE -> nuevaCoordenada = new Coordenada(coordenada.x() - 1, coordenada.y() - 1);
        }
        try {
            setCoordenada(nuevaCoordenada);
        } catch (IllegalArgumentException e) {
            throw new RobotException("Esta coordenada no es válida");
        }
    }

    public void girarALaDerecha() {
        orientacion = switch (orientacion) {
            case SUR -> Orientacion.SUROESTE;
            case SUROESTE -> Orientacion.OESTE;
            case OESTE -> Orientacion.NOROESTE;
            case NOROESTE -> Orientacion.NORTE;
            case NORTE -> Orientacion.NORESTE;
            case NORESTE -> Orientacion.ESTE;
            case ESTE -> Orientacion.SURESTE;
            case SURESTE -> Orientacion.SUR;
        };
    }

    public void girarALaIzquierda() {
        orientacion = switch (orientacion) {
            case SUR -> Orientacion.SURESTE;
            case SURESTE -> Orientacion.ESTE;
            case ESTE -> Orientacion.NORESTE;
            case NORESTE -> Orientacion.NORTE;
            case NORTE -> Orientacion.NOROESTE;
            case NOROESTE -> Orientacion.OESTE;
            case OESTE -> Orientacion.SUROESTE;
            case SUROESTE -> Orientacion.SUR;
        };
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Robot robot)) return false;
        return Objects.equals(coordenada, robot.coordenada) && orientacion == robot.orientacion && Objects.equals(zona, robot.zona);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordenada, orientacion, zona);
    }

    @Override
    public String toString() {
        return "Robot [Coordenada = " + coordenada + ", Orientación=" + orientacion + ", Zona=" + zona + ']';
    }
}
