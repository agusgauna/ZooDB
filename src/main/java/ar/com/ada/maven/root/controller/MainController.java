package ar.com.ada.maven.root.controller;

import ar.com.ada.maven.root.model.dto.Continent;
import ar.com.ada.maven.root.view.MainView;

public class MainController {
    private static MainView view = new MainView();

    public static void run() {
        boolean a = false;

        while (!a) {
            int option = view.selectOption();
            switch (option) {
                case 1:
                    ContinentController.init();
                    break;
                case 2:
                    a = true;
                    break;
                default:
                    System.out.println("Ingrese una opción válida");
                    break;
            }
        }
    }
}
