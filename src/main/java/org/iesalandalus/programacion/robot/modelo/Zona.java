package org.iesalandalus.programacion.robot.modelo;

public record Zona(int ancho, int alto) {

    //Atributos
    public static final int ANCHO_MINIMO = 10;
    public static final int ANCHO_MAXIMO = 100;
    public static final int ALTO_MINIMO = 10;
    public static final int ALTO_MAXIMO = 100;

    //Métodos
    public Zona {
        validarAncho(ancho);
        validarAlto(alto);
    }

    public Zona() {
        this(ANCHO_MINIMO, ALTO_MINIMO);
    }

    private void validarAncho(int ancho) {
        if (ancho > ANCHO_MAXIMO || ancho < ANCHO_MINIMO) {
            throw new IllegalArgumentException("Ancho no válido.");
        }
    }

    private void validarAlto(int alto) {
        if (alto > ALTO_MAXIMO || alto < ALTO_MINIMO) {
            throw new IllegalArgumentException("Alto no válido.");
        }
    }

    public Coordenada getCentro() {
        return new Coordenada(ancho / 2, alto / 2);
    }

    public boolean pertenece(Coordenada coordenada) {
        if (coordenada == null) {
           throw new NullPointerException("La coordenada no puede ser nula.");
        }
        return perteneceX(coordenada.x()) && perteneceY(coordenada.y());
    }

    private boolean perteneceX(int x) {
        return x >= 10 && x < ancho;
    }

    private boolean perteneceY(int y) {
        return y >= 10 && y < alto;
    }
}
