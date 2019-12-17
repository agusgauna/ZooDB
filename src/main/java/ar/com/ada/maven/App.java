package ar.com.ada.maven;

import ar.com.ada.maven.root.model.dao.ContinentDAO;
import ar.com.ada.maven.root.model.dao.Dao;
import ar.com.ada.maven.root.model.dao.PaisDAO;
import ar.com.ada.maven.root.model.dto.Continent;
import ar.com.ada.maven.root.model.dto.Pais;

import java.io.IOException;
import java.util.ArrayList;

public class App
{
    public static void main(String[] args) throws IOException {


        ContinentDAO dao = new ContinentDAO();
        PaisDAO paisDAO = new PaisDAO();
//        List<Continent> continentList = dao.findAll();
//
//        // Lambda
//        continentList.forEach(continent -> System.out.println(continent.toString()));

        // get by ID
//        Continent continent = dao.findById(2);
//       if (continent != null)
//           System.out.println(continent.toString());

        // update
//        Continent continentUpdate = new Continent("América");
//        Integer idUpdate = 2;
//        Boolean hasUpdate = dao.update(continentUpdate, idUpdate);
//        if (hasUpdate)
//            System.out.println("Se actualizo el registro " + idUpdate);
//        else
//            System.out.println("NO se pudo realizar la actualizacion");

//        ArrayList<Pais> paises = paisDAO.findAll();

  //      paises.forEach(pais -> {
    //        String paisNombre = pais.getNombre();
        //      String continentNombre = pais.getContinent().getNombre();
        //    System.out.println("Continete: " + continentNombre + " Pais: " + paisNombre);
        // });

//        paises.forEach(pais -> System.out.println(pais.toString()));

        Pais pais = paisDAO.findById(2);
        if (pais != null) {
            System.out.println(pais.toString());
        }
    }
}
