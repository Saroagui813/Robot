package org.iesalandalus.programacion.robot.vista;

import org.iesalandalus.programacion.robot.modelo.*;
import org.iesalandalus.programacion.utilidades.Entrada;

import java.util.Objects;

public class Consola {

    private Consola() {

    }

    public static void mostrarMenuPrincipal() {
        System.out.println("1. Controlar un robot por defecto.");
        System.out.println("2. Controlar robot indicando su zona.");
        System.out.println("3. Controlar robot indicando su zona y orientación.");
        System.out.println("4. Controlar robot indicando su zona, orientación y coordenada inicial.");
        System.out.println("5. Ejecutar comando.");
        System.out.println();
        System.out.println("6. Salir");
        System.out.println();
    }

    public static int elegirOpcion() {
        int opcionMenu;
        do {
            System.out.println("Elige una opción.");
            opcionMenu = Entrada.entero();
        } while (opcionMenu < 1 || opcionMenu > 5);
        return opcionMenu;
    }

    public static Zona elegirZona() {
        Zona zona = null;
        do {
            System.out.print("Dime el valor de la x: ");
            int ancho = Entrada.entero();
            System.out.print("Dime el valor de la y: ");
            int alto = Entrada.entero();
            try {
                zona = new Zona(ancho, alto);
            } catch (IllegalArgumentException iae) {
                System.out.println("ERROR: " + iae.getMessage());
            }
        } while (zona == null);
        return zona;
    }

    public static void mostrarMenuOrientacion() {
        System.out.println("1. Norte.");
        System.out.println("2. Noreste.");
        System.out.println("3. Este.");
        System.out.println("4. Sureste.");
        System.out.println("5. Sur.");
        System.out.println("6. Suroeste.");
        System.out.println("7. Oeste.");
        System.out.println("8. Noroeste.");
    }

    public static Orientacion elegirOrientacion() {
        int opcionOrientacion;
        do {
            System.out.print("Elige la orientación del 1 al 8: ");
            opcionOrientacion = Entrada.entero();
        } while (opcionOrientacion < 1 || opcionOrientacion > 8);
        return switch (opcionOrientacion) {
            case 1 -> Orientacion.NORTE;
            case 2 -> Orientacion.NORESTE;
            case 3 -> Orientacion.ESTE;
            case 4 -> Orientacion.SURESTE;
            case 5 -> Orientacion.SUR;
            case 6 -> Orientacion.SUROESTE;
            case 7 -> Orientacion.OESTE;
            case 8 -> Orientacion.NOROESTE;
            default -> null;
        };
    }

    public static Coordenada elegirCoordenada() {
        System.out.println("Indica la coordenada de la X.");
        int x = Entrada.entero();
        System.out.println("Indica la coordenada de la Y.");
        int y = Entrada.entero();
        return new Coordenada(x,y);
    }

    public static char elegirComando() {
        System.out.print("Indica el comando a ejecutar: ");
        return Entrada.caracter();
    }

    public static void mostrarRobot(ControladorRobot controladorRobot) {
        System.out.println();
        Objects.requireNonNull(controladorRobot, "El controlador no puede ser nulo.");
        System.out.println(controladorRobot);
        System.out.println();
    }

    public static void despedirse() {
        System.out.println("¡Hasta luego!");
    }
}
