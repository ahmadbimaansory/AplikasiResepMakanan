package database;

import java.sql.Connection;
import java.sql.Statement;

public class DatabaseSetup {
    public static void main(String[] args) {
        String sql = "CREATE TABLE IF NOT EXISTS recipes ("
                   + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                   + "title TEXT NOT NULL,"
                   + "ingredients TEXT NOT NULL,"
                   + "instructions TEXT NOT NULL,"
                   + "category TEXT,"
                   + "imagePath TEXT,"
                   + "favorite INTEGER DEFAULT 0"
                   + ");";
        try (Connection c = DatabaseConnection.getConnection();
             Statement s = c.createStatement()) {
            s.execute(sql);
            System.out.println("Tabel recipes siap.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
