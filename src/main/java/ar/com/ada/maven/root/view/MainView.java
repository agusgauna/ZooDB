package ar.com.ada.maven.root.view;

import ar.com.ada.maven.root.utils.ScannerSingletone;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainView {

    public int selectOption() {
        System.out.println("Bienvenido a la aplicación de Zoologicos");
        System.out.println("Ingrese la opcion correspondiente: 1. Continente 2. Salir");
        Scanner scanner = ScannerSingletone.getInstance();
        while (true) {
            try {
                int choice = scanner.nextInt();
                return choice;
            } catch (InputMismatchException E) {
                System.out.println(" La selección no es valida, por favor, ingrese una opción valida.");
                scanner.next();
            }
        }
    }
}

