package ar.com.ada.maven.root.model.dao;

import ar.com.ada.maven.root.model.DBConection;
import ar.com.ada.maven.root.model.dto.Continent;
import ar.com.ada.maven.root.model.dto.Pais;

import java.sql.*;
import java.util.ArrayList;

public class PaisDAO implements Dao<Pais> {
        private ContinentDAO continentDAO = new ContinentDAO(false);
        private Boolean willCloseConnection = true;

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
                String sql = "SELECT * FROM Pais WHERE id = ?";
                Pais pais = null;
                try {
                        Connection connection = DBConection.getConnection();
                        PreparedStatement preparedStatement = connection.prepareStatement(sql);
                        preparedStatement.setInt(1, id);
                        ResultSet rs = preparedStatement.executeQuery();
                        Continent continent = continentDAO.findById(rs.getInt("id_continent"));
                        if (rs.next())
                                pais = new Pais(rs.getInt("id"), rs.getString("Nombre"), continent;
                        if (willCloseConnection)
                                connection.close();
                } catch (Exception e) {
                        System.out.println("CONNECTION ERROR: " + e.getMessage());
                }
                return pais;
        }

        @Override
        public boolean save(Pais pais) {
                String sql = "INSERT INTO Pais (nombre) VALUES ?";
                int hasInsert = 0;
                try {
                        Connection connection = DBConection.getConnection();
                        PreparedStatement preparedStatement = connection.prepareStatement(sql);
                        preparedStatement.setString(1, pais.getNombre());
                        hasInsert = preparedStatement.executeUpdate();
                        connection.close();
                } catch (Exception e) {
                        System.out.println("CONNECTION ERROR: " + e.getMessage());
                }
                return hasInsert == 1;
        }

        @Override
        public boolean update(Pais pais, Integer id) {
                String sql = "UPDATE Pais SET nombre = ? WHERE id = ?";
                int hasUpdate = 0;
                Pais paisDB = findById(id);
                try {
                        Connection connection = DBConection.getConnection();
                        PreparedStatement preparedStatement = connection.prepareStatement(sql);
                        preparedStatement.setString(1,pais.getNombre());
                        preparedStatement.setInt(1, id);
                        if (!pais.getNombre().equals(paisDB.getNombre()))
                                hasUpdate = preparedStatement.executeUpdate();

                        connection.close();
                } catch (Exception e) {
                        System.out.println("CONNECTION ERROR: " + e.getMessage());
                }
                return hasUpdate == 1;
        }

        @Override
        public Boolean delete(Integer id) {
                String sql = "DELETE FROM Pais WHERE id = ?";
                int hasDelete = 0;
                try {
                        Connection connection = DBConection.getConnection();
                        PreparedStatement preparedStatement = connection.prepareStatement(sql);
                        preparedStatement.setInt(1, id);
                        hasDelete = preparedStatement.executeUpdate();
                } catch (Exception e) {
                        System.out.println("CONNECTION ERROR: " + e.getMessage());
                }
                return hasDelete == 1;
        }
}