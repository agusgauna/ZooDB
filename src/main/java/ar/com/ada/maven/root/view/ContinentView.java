package ar.com.ada.maven.root.view;

import ar.com.ada.maven.root.model.dao.ContinentDAO;
import ar.com.ada.maven.root.model.dto.Continent;
import ar.com.ada.maven.root.utils.ScannerSingletone;
import jdk.internal.jline.internal.Ansi;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ContinentView {

    public int continentMenuSelectOption() {
        System.out.println("Ud a ingresado al modulo Continente.");
        System.out.println("Las opciones disponibles son: 1.Listar 2. Agregar 3. Editar 4. Eliminar 5. Salir");
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

    public void printAllContinents(List<Continent> continents) {
        System.out.println("El listado de los Continentes es:");
        continents.forEach(continent -> {
            String nombre = continent.getNombre();
            Integer id = continent.getId();
            System.out.println("Id: " + id + ". Nombre: " + nombre);
        });
        ScannerSingletone.pressEnterKeyToContinue();
    }

    public String getNameNewContinent() {
        System.out.println("Ud ha ingresado al formulario para agregar un continente");
        System.out.println("Ingrese el nombre del continente, si deja el texto vacio, se cancela el proceso de guardado");
        Scanner scanner = ScannerSingletone.getInstance();
        scanner.nextLine();
        while (true) {
            try {
                String name = scanner.nextLine().trim();
                while (!name.matches("^[A-Za-záéíóúüÁÉÍÓÚÜ\\s]+$") && !name.isEmpty()) {
                    System.out.println("Debe ingresar un dato válido");
                    name = scanner.nextLine();
                }
                return name;
            } catch (InputMismatchException e) {
                System.out.println("Debe ingresar un dato válido");
                scanner.next();
            }
        }
    }

    public void showNewContinent(String name) {
        System.out.println("El continente agregado es: " + name);
        ScannerSingletone.pressEnterKeyToContinue();
    }

    public void newContinentCanceled() {
        System.out.println("El continente no se ha podido agregar");
        ScannerSingletone.pressEnterKeyToContinue();
    }

    public void continentAlreadyExists(String name) {
        System.out.println("El continente ya existe en la base de datos");
        ScannerSingletone.pressEnterKeyToContinue();
    }

    public String printContinentsPerPage(List<Continent> continents, List<String> paginator) {
        System.out.println("\n+----------------------------------------------------------------+");
        System.out.println("\t  Zoo World App :: Modulo Continente  :: Lista Continente");
        System.out.println("+----------------------------------------------------------------+\n");

        Scanner keyboard = ScannerSingletone.getInstance();

        while (true) {
            try {
                System.out.println("? ");
                String nombre = keyboard.nextLine().trim();
                while (!nombre.matches("^[0-9IiAaSsUuEe]+$") && !nombre.isEmpty()) {
                    System.out.println("Error, debe ingresar una opcion valida");
                    nombre = keyboard.nextLine();
                }
                return nombre;
            } catch (InputMismatchException e) {
                System.out.println("Error, debe ingresar un dato valido");
                keyboard.next();
            }
        }
    }

    public int continentIdSelected(String action) {
        System.out.println("Ingrese el numero de ID del continente para" + action + "o 0 para cancelar: \n");

        Scanner keyboard = ScannerSingletone.getInstance();

        while (true) {
            try {
                System.out.println("? ");
                int choice = keyboard.nextInt();
                return choice;
            } catch (InputMismatchException e) {
                System.out.println("Error, debe ingresar un id valido");
                keyboard.next();
            }
        }
    }
    public static String getNameToUpdate(Continent continent) {
        System.out.println("Se actualizara el nombre del siguiente continente: ");
        System.out.println(Ansi.);
    }
}
