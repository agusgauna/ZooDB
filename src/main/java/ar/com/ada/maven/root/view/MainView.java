package ar.com.ada.maven.root.view;

import ar.com.ada.maven.root.utils.Ansi;
import ar.com.ada.maven.root.utils.ScannerSingletone;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainView {

    public int mainMenuSelectOption() {
        System.out.println("\n\n+--------------------------------------------------+");
        System.out.println("\t\t   Bienvenidos a Zoo World App");
        System.out.println("+--------------------------------------------------+\n");


        System.out.println("Para empezar a operar, seleccione un modulo del menu: \n");
        System.out.println("| 1 | Continentes");
        System.out.println("| 2 | Paises");
        System.out.println("| 3 | Ciudades");
        System.out.println("| 4 | Cerrar el programa");
        System.out.println("-------------------------\n");

        Scanner keyboard = ScannerSingletone.getInstance();

        while (true) {
            try {
                System.out.print("? ");
                int choice = keyboard.nextInt();
                return choice;
            } catch (InputMismatchException e) {
                System.out.println("Mensaje de error que indique que deber ser valida la seleccion");
                keyboard.next();
            }
        }
    }

    public static void chooseValidOption() {
        System.out.println(Ansi.RED);
        System.out.println("Error, debe ingresar una opcion valida");
        System.out.println(Ansi.RESET);
    }

    public static void invalidData() {
        System.out.println(Ansi.RED);
        System.out.println("Error, por favor ingrese datos validos.");
        System.out.println(Ansi.RESET);
    }
}
