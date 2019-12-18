package ar.com.ada.maven.root.model.dao;

import ar.com.ada.maven.root.model.DBConection;
import ar.com.ada.maven.root.model.dto.Continent;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class ContinentDAO implements Dao<Continent> {
    private Boolean willCloseConnection = true;

    public ContinentDAO() {
    }

    public ContinentDAO(Boolean willCloseConnection) {
        this.willCloseConnection = willCloseConnection;
    }

    @Override
    public Collection<Continent> findAll() {
        String sql = "SELECT * FROM Continent";
        Collection<Continent> continents = new ArrayList<>();

        try {
            Connection connection = DBConection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Continent continent = new Continent(rs.getInt("id"), rs.getString("name"));
                continents.add(continent);
            }
            connection.close();
        } catch (SQLException | ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            System.out.println("CONNECTION ERROR: " + e.getMessage());
        }

        return continents;
    }

    @Override
    public Continent findById(Integer id) {
        String sql = "SELECT * FROM Continent WHERE id = ?";
        Continent continent = null;
        try {
            Connection connection = DBConection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next())
                continent = new Continent(rs.getInt("id"), rs.getString("nombre"));

            if (willCloseConnection)
                connection.close();
        } catch (Exception e) {
            System.out.println("CONNECTION ERROR: " + e.getMessage());
        }

        return continent;
    }

    @Override
    public boolean save(Continent continent) {
        String sql = "INSERT INTO Continent (nombre) VALUES (?)";
        int hasInsert = 0;
        try {
            Connection connection = DBConection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, continent.getNombre());
            hasInsert = preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException | ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            System.out.println("CONNECTION ERROR: " + e.getMessage());
        }
        return hasInsert == 1;
    }

    @Override
    public boolean update(Continent continent, Integer id) {
        String sql = "UPDATE Continent SET nombre = ? WHERE id = ?";
        int hasUpdate = 0;

        // validacion de actualizacion
        Continent continentDB = findById(id);

        try {
            Connection connection = DBConection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, continent.getNombre());
            preparedStatement.setInt(2, id);

            if (!continent.getNombre().equals(continentDB.getNombre()))
                hasUpdate = preparedStatement.executeUpdate();

            connection.close();
        } catch (SQLException | ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            System.out.println("CONNECTION ERROR: " + e.getMessage());
        }

        return hasUpdate == 1;
    }

    @Override
    public Boolean delete(Integer id) {
        String sql = "DELETE FROM Continent WHERE id = ?";
        int hasDelete = 0;
        try {
            Connection connection = DBConection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            hasDelete = preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            System.out.println("CONNECTION ERROR: " + e.getMessage());
        }
        return hasDelete == 1;
    }
}
