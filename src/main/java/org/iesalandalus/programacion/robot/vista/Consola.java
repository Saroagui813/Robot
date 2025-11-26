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
        System.out.println("6. Salir");
    }

    public static int elegirOpcion() {
        Consola.mostrarMenuPrincipal();
        System.out.println("Elige una opción.");
        int opcionMenu;
        do {
            opcionMenu = Entrada.entero();
        } while (opcionMenu < 1 || opcionMenu > 6);
        return opcionMenu;
    }

    public static Zona elegirZona() {
        int x;
        int y;
        do {
        System.out.print("Dime el valor de la x: ");
        x = Entrada.entero();
        System.out.print("Dime el valor de la y: ");
        y = Entrada.entero();
        try {
            new Zona(x, y);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("La zona no es válida.");
        }
        return new Zona(x, y);
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
        Consola.mostrarMenuOrientacion();
        System.out.println("Elige una opción.");
        int opcionOrientacion;
        do {
            opcionOrientacion = Entrada.entero();
        } while (opcionOrientacion < 1 || opcionOrientacion > 6);
        return opcionOrientacion;
    }

    public static Coordenada elegirCoordenada() {

    }

    public static char elegirComando() {

    }

    public static void mostrarRobot(ControladorRobot controladorRobot) {
        Objects.requireNonNull(controladorRobot, "El controlador no puede ser nulo.");
        System.out.println(controladorRobot);
    }

    public static void despedirse() {
        System.out.println("¡Hasta luego!");
    }
}
