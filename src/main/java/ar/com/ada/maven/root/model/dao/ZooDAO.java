package ar.com.ada.maven.root.model.dao;

import ar.com.ada.maven.root.model.DBConection;
import ar.com.ada.maven.root.model.dto.Ciudad;
import ar.com.ada.maven.root.model.dto.Zoo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

public class ZooDAO implements Dao<Zoo> {
    private CiudadDAO ciudadDAO = new CiudadDAO(false);
    private Boolean willCloseConnection = true;

    public ZooDAO() {}

    public ZooDAO(Boolean willCloseConnection) {
        this.willCloseConnection = willCloseConnection;
    }

    @Override
    public Collection<Zoo> findAll() {
        String sql = "SELECT * FROM Zoo";
        ArrayList<Zoo> zoos = new  ArrayList<>();
        try {
            Connection connection = DBConection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Ciudad ciudad = ciudadDAO.findById(rs.getInt("Ciudad_id"));
                Zoo zoo = new Zoo(rs.getInt("id"), rs.getString("nombre"),
                        rs.getString("tamaño"), rs.getInt("presupuesto"), ciudad);
                zoos.add(zoo);
            }
            connection.close();
        } catch (Exception e) {
            System.out.println("CONNECTION ERROR: " + e.getMessage());
        }
        return zoos;
    }

    @Override
    public Zoo findById(Integer id) {
        String sql = "SELECT * FROM Zoo WHERE id = ? ";
        Zoo zoo = null;
        try {
            Connection connection = DBConection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                Ciudad ciudad = ciudadDAO.findById(rs.getInt("ciudad_id"));
                zoo = new Zoo(rs.getInt("id"), rs.getString("nombre"),
                        rs.getString("tamaño"), rs.getInt("presupuesto"), ciudad);
            }
            if (willCloseConnection)
                connection.close();
        } catch (Exception e) {
            System.out.println("CONNECTION ERROR: " + e.getMessage());
        }
        return zoo;
    }

    @Override
    public boolean save(Zoo zoo) {
        String sql = "INSERT INTO Zoo (nombre, tamaño, presupuesto) VALUES (?,?,?) ";
        int hasInsert = 0;
        try {
            Connection connection = DBConection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, zoo.getNombre());
            preparedStatement.setString(1, zoo.getTamaño());
            preparedStatement.setInt(1, zoo.getPresupuesto());
            hasInsert = preparedStatement.executeUpdate();
            connection.close();
        } catch (Exception e) {
            System.out.println("CONNECTION ERROR: " + e.getMessage());
        }
        return hasInsert == 1;
    }

    @Override
    public boolean update(Zoo zoo, Integer id) {
        String sql = "UPDATE Zoo SET nombre = ? WHERE id = ? ";
        int hasUpdate = 0;
        Zoo zooDB = findById(id);
        try {
            Connection connection = DBConection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, zoo.getNombre());
            preparedStatement.setInt(1, id);
            if (!zoo.getNombre().equals(zooDB.getNombre()))
                hasUpdate = preparedStatement.executeUpdate();
            connection.close();
        } catch (Exception e) {
            System.out.println("CONNECTION ERROR: " + e.getMessage());
        }
        return hasUpdate == 1;
    }

    @Override
    public Boolean delete(Integer id) {
        String sql = "DELETE FROM Zoo WHERE id = ? ";
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
