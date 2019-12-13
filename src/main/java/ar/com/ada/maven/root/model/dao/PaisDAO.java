package ar.com.ada.maven.root.model.dao;

import ar.com.ada.maven.root.model.DBConection;
import ar.com.ada.maven.root.model.dto.Continent;
import ar.com.ada.maven.root.model.dto.Pais;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PaisDAO implements Dao<Pais> {
        private ContinentDAO continentDAO = new ContinentDAO(false);

        @Override
        public ArrayList<Pais> findAll() {
                String sql = "SELECT * FROM Pais";
                ArrayList<Pais> paises = new ArrayList<>();
                try {
                        Connection connection = DBConection.getConnection();
                        Statement statement = connection.createStatement();
                        ResultSet rs = statement.executeQuery(sql);
                        while (rs.next()) {
                                // con el campo Continent_id busco el continente con el dao de Continent
                                Continent continent = continentDAO.findById(rs.getInt("Continent_id"));
                                Pais pais = new Pais(rs.getInt("id"), rs.getString("name"), continent);
                                paises.add(pais);
                        }
                        connection.close();
                } catch (SQLException | ClassNotFoundException | IllegalAccessException | InstantiationException e) {
                        System.out.println("CONNECTION ERROR: " + e.getMessage());
                }
                return paises;
        }

        @Override
        public Pais findById(Integer id) {
                return null;
        }

        @Override
        public Boolean save(Pais pais) {
                return null;
        }

        @Override
        public Boolean update(Pais pais, Integer id) {
                return null;
        }

        @Override
        public Boolean delete(Integer id) {
                return null;
        }
}