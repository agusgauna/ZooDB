package ar.com.ada.maven.root.model.dao;

import ar.com.ada.maven.root.model.DBConection;
import ar.com.ada.maven.root.model.dto.AnimalXZoo;
import ar.com.ada.maven.root.model.dto.Zoo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

//public class AnimalXZooDAO implements Dao<AnimalXZoo> {
 //   private ZooDAO zooDAO = new ZooDAO(false);
//   private Boolean willCloseConnection = true;

//  public AnimalXZooDAO() { }

//  public AnimalXZooDAO(Boolean willCloseConnection) {
//      this.willCloseConnection = willCloseConnection;
//  }

//  @Override
//  public Collection<AnimalXZoo> findAll() {
//      String sql = "SELECT * FROM Animal_X_Zoo";
//      ArrayList<AnimalXZoo> animalXZoos = new ArrayList<>();
//      try {
//          Connection connection = DBConection.getConnection();
//          Statement statement = connection.createStatement();
//          ResultSet rs = statement.executeQuery(sql);
//          while (rs.next()) {
//              Zoo zoo = zooDAO.findById(rs.getInt("Zoo_id"));
//              AnimalXZoo animalXZoo = new AnimalXZoo(rs.getInt())
//          }
////      }
//    return null;
//  }

//  @Override
//  public AnimalXZoo findById(Integer id) {
//      return null;
//  }

//  @Override
//  public boolean save(AnimalXZoo animalXZoo) {
//      return false;
//  }

//  @Override
//  public boolean update(AnimalXZoo animalXZoo, Integer id) {
//      return false;
//  }

//  @Override
//  public Boolean delete(Integer id) {
//      return null;
//  }
//}
