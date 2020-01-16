package ar.com.ada.maven.root.controller;

import ar.com.ada.maven.root.model.dao.ContinentDAO;
import ar.com.ada.maven.root.model.dto.Continent;
import ar.com.ada.maven.root.view.ContinentView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ContinentController {
    private static ContinentView view = new ContinentView();
    private static ContinentDAO continentDAO = new ContinentDAO();

    private static void continentList() {
        List<Continent> continents = continentDAO.findAll();
        view.printAllContinents(continents);
    }

    public static void init() {
        boolean a = false;
        while (!a) {
            int option = view.continentMenuSelectOption();
            switch (option) {
                case 1:
                    continentList();
                    break;
                case 2:
                    createNewContinent();
                    break;
                case 3:
                    edithContinent();
                    break;
                case 5:
                    a = true;
                    break;
                default:
                    System.out.println("Debe seleccionar una opción valida");
            }
        }
    }

    public static void createNewContinent() {
        String nombreContinent = view.getNameNewContinent();
        if (!nombreContinent.isEmpty()) {
            Continent newContinent = new Continent(nombreContinent);
            Continent byName = continentDAO.findByName(nombreContinent);

            if (nombreContinent != null && newContinent.getNombre().equals(byName.getNombre())) {
                view.continentAlreadyExists(newContinent.getNombre());
            } else {
                Boolean resultado = continentDAO.save(newContinent);
                if (resultado)
                    view.showNewContinent(newContinent.getNombre());
            }
        } else {
            view.newContinentCanceled();
        }
    }

    private static List<String> buildPaginator(int currentPage, int totalPages) {
        List<String> pages = new ArrayList<>();
        pages.add("[Inicio]");
        pages.add("[Anterior]");

        for (int i = 1; i <= totalPages; i++) {
            if (i == currentPage + 1)
                pages.add("[>" + i + "<]");
            else
                pages.add("[" + i + "]");
        }

        pages.add("[Siguiente]");
        pages.add("[Ultimo]");

        return pages;
    }

    private static Integer continentListPerPage() {
        int limit = 3, currentPage = 0;
        List<Continent> continents;
        int numberContinents;
        int totalPages;
        List<String> paginator;
        Boolean shouldGetOut = false;
        while (!shouldGetOut) {
            continents = continentDAO.findAll(limit, currentPage * limit);
            numberContinents = continentDAO.getTotalContinents();
            totalPages = (int) Math.ceil((double) numberContinents / limit);
            paginator = buildPaginator(currentPage, totalPages);
            String choice = view.printContinentsPerPage(continents, paginator);
            switch (choice) {
                case "i": case "I":
                    currentPage = 0;
                    break;
                case "a": case "A":
                    if (currentPage > 0) currentPage--;
                    break;
                case "s": case "S":
                    if (currentPage + 1 < totalPages) currentPage++;
                    break;
                case "u": case "U":
                    currentPage = totalPages - 1;
                    break;
                case "e": case "E":
                    return view.continentIdSelected("Editar");
                case "q": case "Q":
                    shouldGetOut = true;
                    break;
                default:
                    if (choice.matches("^-?\\d+$")) {
                        int page = Integer.parseInt(choice);
                        if (page > 0 && page <= totalPages) currentPage = page - 1;
                    } else
                        System.out.println("Error, debe ingresar una opcion valida del paginador");
            }
        }
        return 0;
    }

    public static void editSelectedContinent(int id) {
        Continent continent = continentDAO.findById(id);
        if (continent != null) {
            String nameToUpdate = view.getNameToUpdate(continent);
            if (!nameToUpdate.isEmpty()) {
                Continent continent2 = continentDAO.findByName(nameToUpdate);

                if (continent2 != null && continent2.getId() != id) {
                    view.continentAlreadyExists(nameToUpdate);
                }
                continent.setNombre(nameToUpdate);

                Boolean isSaved = continentDAO.update(continent, id);

                if (isSaved)
                    view.showUpdateContinent(continent.getNombre());
            } else
                view.updateContinentCanceled();
        } else {
            view.continentNotExist(id);
            int continentIdSelected = view.continentIdSelected("Editar");
            if (continentIdSelected !=0)
                editSelectedContinent(continentIdSelected);
            else
                view.updateContinentCanceled();
        }
    }
    private static void edithContinent() {
        int continentIdToEdith = continentListPerPage();
        if (continentIdToEdith != 0)
            editSelectedContinent(continentIdToEdith);
        else
            view.updateContinentCanceled();
        continentListPerPage();
    }
}
