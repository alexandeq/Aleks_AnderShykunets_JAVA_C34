//package org.example;
//
//import java.sql.*;
//
//public class MainApp {
//    public static void main(String[] args) {
//
//
//        String url = "jdbc:postgresql://localhost:5432/postgres";
//        String user = "postgres";
//        String password = "postgres";
//
//        try (Connection conn = DriverManager.getConnection(url, user, password)) {
//            System.out.println("✅ Подключение к PostgreSQL успешно!");
//        } catch (SQLException e) {
//            System.err.println("❌ Ошибка подключения: " + e.getMessage());
//        }
//
//        String insertSQL = "INSERT INTO persons (login, password) VALUES (?, ?)";
//
//        try (Connection conn = DriverManager.getConnection(url, user, password);
//             PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
//
//            // Установите параметры
//            pstmt.setString(1, "test_login");
//            pstmt.setString(2, "test_password"); // Лучше использовать хеш
//
//            int rowsInserted = pstmt.executeUpdate();
//            System.out.println("Добавлено строк: " + rowsInserted);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//
//
//        }
//    }
//
//}
//

