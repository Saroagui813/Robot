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
        setZona(zona);
        this.coordenada = zona.getCentro();
        this.orientacion = Orientacion.NORTE;
    }

    public Robot(Zona zona, Orientacion orientacion) {
        setZona(zona);
        this.coordenada = zona.getCentro();
        setOrientacion(orientacion);
    }

    public Robot(Zona zona, Orientacion orientacion, Coordenada coordenada) {
        setZona(zona);
        setCoordenada(coordenada);
        setOrientacion(orientacion);
    }

    public Robot(Robot robot) {
        Objects.requireNonNull(robot, "El robot no puede ser nulo.");
        zona = robot.zona;
        coordenada = robot.coordenada;
        orientacion = robot.orientacion;
    }

    public Zona getZona() {
        return zona;
    }

    private void setZona(Zona zona) {
        Objects.requireNonNull(zona, "La zona no puede ser nula.");
        this.zona = zona;
    }

    public Orientacion getOrientacion() {
        return orientacion;
    }

    public void setOrientacion(Orientacion orientacion) {
        Objects.requireNonNull(orientacion, "La orientación no puede ser nula.");
        this.orientacion = orientacion;
    }

    public Coordenada getCoordenada() {
        return coordenada;
    }

    public void setCoordenada(Coordenada coordenada) {
        Objects.requireNonNull(coordenada, "La coordenada no puede ser nula.");
        if (!zona.pertenece(coordenada)) {
            throw new IllegalArgumentException("La coordenada no pertenece a la zona.");
        }
        this.coordenada = coordenada;
    }

    public void avanzar() throws RobotExcepcion {
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
            throw new RobotExcepcion("No se puede avanzar, ya que se sale de la zona.");
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
