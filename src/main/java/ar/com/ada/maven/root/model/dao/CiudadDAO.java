package ar.com.ada.maven.root.model.dao;

import ar.com.ada.maven.root.model.DBConection;
import ar.com.ada.maven.root.model.dto.Ciudad;
import ar.com.ada.maven.root.model.dto.Pais;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

public class CiudadDAO implements Dao<Ciudad> {
    private PaisDAO paisDAO = new PaisDAO(false);
    private Boolean willCloseConnection = true;

    public CiudadDAO() { }

    public CiudadDAO(Boolean willCloseConnection) {
        this.willCloseConnection = willCloseConnection;
    }

    @Override
    public Collection<Ciudad> findAll() {
        String sql = "SELECT * FROM Ciudad";
        ArrayList<Ciudad> ciudads = new ArrayList<>();
        try {
            Connection connection = DBConection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Pais pais = paisDAO.findById(rs.getInt("Pais_id"));
                Ciudad ciudad = new Ciudad(rs.getInt("id"), rs.getString("nombre"), pais);
                ciudads.add(ciudad);
            }
            connection.close();
        } catch (Exception e) {
            System.out.println("CONNECTION ERROR: " + e.getMessage());
        }
        return ciudads;
    }

    @Override
    public Ciudad findById(Integer id) {
        String sql = "SELECT * FROM Ciudad WHERE id = ?";
        Ciudad ciudad = null;
        try {
            Connection connection = DBConection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                Pais pais = paisDAO.findById(rs.getInt("pais_id"));
                ciudad = new Ciudad(rs.getInt("id"), rs.getString("nombre"), pais);
            }
            if (willCloseConnection)
                connection.close();
        } catch (Exception e) {
            System.out.println("CONNECTION ERROR: " +e.getMessage());
        }
        return ciudad;
    }

    @Override
    public boolean save(Ciudad ciudad) {
        String sql = "INSERT INTO Ciudad (nombre) VALUES ? ";
        int hasInsert = 0;
        try {
            Connection connection = DBConection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, ciudad.getNombre());
            hasInsert = preparedStatement.executeUpdate();
            connection.close();
        } catch (Exception e) {
            System.out.println("CONNECTION ERROR: " + e.getMessage());
        }
        return hasInsert == 1;
    }

    @Override
    public boolean update(Ciudad ciudad, Integer id) {
        String sql = "UPDATE Ciudad SET nombre = ? WHERE id = ?";
        int hasUpdate = 0;
        Ciudad ciudadDB = findById(id);
        try {
            Connection connection = DBConection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, ciudad.getNombre());
            preparedStatement.setInt(1, id);
            if (!ciudad.getNombre().equals(ciudadDB.getNombre()))
                hasUpdate = preparedStatement.executeUpdate();
            connection.close();
        } catch (Exception e) {
            System.out.println("CONNECTION ERROR: " + e.getMessage());
        }
        return hasUpdate == 1;
    }

    @Override
    public Boolean delete(Integer id) {
        String sql = "DELETE FROM Ciudad WHERE id = ? ";
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
