//package org.example.service;
//
//
//import org.example.dto.Good;
//
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.UUID;
//
//public class GoodService {
//
//    public Good save(Good good) {
//
//        try {
//            good.setId(UUID.randomUUID());
//
//            Connection connection = getConnection();
//            PreparedStatement preparedStatement = connection.prepareStatement("insert into goods (id,title,description,price) values (?,?,?,?)");
//
//            preparedStatement.setObject(1, good.getId());
//            preparedStatement.setString(2, good.getTitle());
//            preparedStatement.setString(3, good.getDescription());
//            preparedStatement.setLong(4, good.getPrice());
//
//            preparedStatement.execute();
//        }catch (Exception e){
//            System.out.println("Error");
//        }
//
//        return good;
//
//    }
//
//    public void delete(UUID id){
//        try {
//            Connection connection = getConnection();
//            PreparedStatement preparedStatement = connection.prepareStatement("delete from goods where id = ?");
//
//            preparedStatement.setObject(1, id);
//
//            preparedStatement.execute();
//        }catch (Exception e){
//            System.out.println("Error");
//        }
//
//    }
//
//    public Good getById(UUID id){
//
//        try {
//            Connection connection = getConnection();
//            var statement = connection.prepareStatement("select * from goods where id = ?");
//            statement.setObject(1,id);
//
//            var resultSet = statement.executeQuery();
//
//            while (resultSet.next()) {
//
//                var title = resultSet.getString("title");
//                var description = resultSet.getString("description");
//                var price = resultSet.getLong("price");
//
//                return new Good(id, title, description, price);
//
//            }
//
//        } catch (Exception e){
//            System.out.println("Error");
//        }
//
//        return new Good();
//    }
//
//
//    public List<Good> getAll(){
//
//        List<Good> goods = new ArrayList<>();
//
//        try {
//            Connection connection = getConnection();
//            Statement statement = connection.createStatement();
//
//            var resultSet = statement.executeQuery("select * from goods");
//
//            while (resultSet.next()){
//                var id = resultSet.getObject("id", UUID.class);
//                var title = resultSet.getString("title");
//                var description = resultSet.getString("description");
//                var price = resultSet.getLong("price");
//
//                var good = new Good(id,title,description,price);
//
//                goods.add(good);
//
//            }
//
//        }catch (Exception e){
//            System.out.println("Error");
//        }
//
//        return goods;
//    }
//
//    public void update(UUID id,Good good) {
//
//        try {
//
//            Connection connection = getConnection();
//            PreparedStatement preparedStatement = connection.prepareStatement("update goods set title = ?, description = ?, price = ? where id = ?");
//
//            preparedStatement.setString(1, good.getTitle());
//            preparedStatement.setString(2, good.getDescription());
//            preparedStatement.setLong(3, good.getPrice());
//            preparedStatement.setObject(4,id);
//            preparedStatement.execute();
//        } catch (Exception e) {
//            System.out.println("Error");
//        }
//    }
//
//
//
//    private Connection getConnection(){
//        try {
//            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres");
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//    }
//}
