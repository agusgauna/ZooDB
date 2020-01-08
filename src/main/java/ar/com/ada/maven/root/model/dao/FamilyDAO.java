package ar.com.ada.maven.root.model.dao;

import ar.com.ada.maven.root.model.DBConection;
import ar.com.ada.maven.root.model.dto.Family;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

//public class FamilyDAO implements Dao<Family> {
//    private Boolean willCloseConnection = true;
//
//    public FamilyDAO() { }

//    public FamilyDAO(Boolean willCloseConnection) { this.willCloseConnection = willCloseConnection; }

//    @Override
 //   public Collection<Family> findAll() {
 //       String sql = "SELECT * FROM Family";
//       Collection <Family> familys = new ArrayList<>();
//      try {
//          Connection connection = DBConection.getConnection();
//          Statement statement = connection.createStatement();
//          ResultSet rs = statement.executeQuery(sql);
//          while (rs.next()) {
//              Family family = new Family(rs.getInt("id"), rs.getString("nombre"));
//              familys.add(family);
//          }
//          connection.close();
//      } catch (SQLException | ClassNotFoundException | IllegalAccessException | InstantiationException e) {
//          System.out.println("CONNECTION ERROR: " + e.getMessage());
//      }
//
//      return familys;
//  }

//  @Override
//  public Family findById(Integer id) {
//      String sql = "SELECT * FROM Family WHER id = ?";
//      Family family = null;
////      try {
//        Connection connection = DBConection.getConnection();
//          PreparedStatement preparedStatement = connection.prepareStatement(sql);
//          preparedStatement.setInt(1, id);
//          ResultSet rs = preparedStatement.executeQuery();
//          if (rs.next())
//              family = new Family(rs.getInt("id"), rs.getString("nombre"));
//          if (willCloseConnection)
//              connection.close();
//      } catch (Exception e) {
//          System.out.println("CONNECTION ERROR: " + e.getMessage());
//      }
//      return family;
//  }

//  @Override
//  public boolean save(Family family) {
//      String sql = "INSERT INTO Family (nombre) VALUES (?) ";
//      int hasInsert = 0;
//      try {
//          Connection connection = DBConection.getConnection();
//          PreparedStatement preparedStatement = connection.prepareStatement(sql);
//          preparedStatement.setString(1, family.getNombre());
//      }
//      return false;
//  }

//  @Override
//  public boolean update(Family family, Integer id) {
//      return false;
//  }

//    @Override
//    public Boolean delete(Integer id) {
//      return null;
//  }
//}
