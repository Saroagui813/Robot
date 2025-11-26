package org.iesalandalus.programacion.robot.modelo;

public class ControladorRobot {

    private Robot robot;

    public ControladorRobot() {
        this.robot = new Robot(robot);
    }

    public Robot getRobot() {
        return new Robot(robot);
    }

    public void ejecutar(char comando) {
        switch (comando) {
            case 'A', 'a' -> robot.avanzar();
            case 'I', 'i' -> robot.girarALaIzquierda();
            case 'D', 'd' -> robot.girarALaDerecha();
            default -> throw new IllegalArgumentException("Comando incorrecto");
        }
    }
}
