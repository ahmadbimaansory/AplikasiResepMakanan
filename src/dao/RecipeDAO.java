package dao;

import database.DatabaseConnection;
import model.Recipe;
import java.sql.*;
import java.util.*;

public class RecipeDAO {

    public List<Recipe> getAll() throws SQLException {
        List<Recipe> list = new ArrayList<>();
        String q = "SELECT * FROM recipes ORDER BY title";
        try (Connection c = DatabaseConnection.getConnection();
             Statement s = c.createStatement();
             ResultSet rs = s.executeQuery(q)) {
            while (rs.next()) {
                list.add(new Recipe(
                    rs.getInt("id"),
                    rs.getString("title"),
                    rs.getString("ingredients"),
                    rs.getString("instructions"),
                    rs.getString("category"),
                    rs.getString("imagePath"),
                    rs.getInt("favorite") == 1
                ));
            }
        }
        return list;
    }

    public void insert(Recipe r) throws SQLException {
        String sql = "INSERT INTO recipes(title,ingredients,instructions,category,imagePath,favorite) VALUES(?,?,?,?,?,?)";
        try (Connection c = DatabaseConnection.getConnection();
             PreparedStatement p = c.prepareStatement(sql)) {
            p.setString(1, r.getTitle());
            p.setString(2, r.getIngredients());
            p.setString(3, r.getInstructions());
            p.setString(4, r.getCategory());
            p.setString(5, r.getImagePath());
            p.setInt(6, r.isFavorite() ? 1 : 0);
            p.executeUpdate();
        }
    }

    public void update(Recipe r) throws SQLException {
        String sql = "UPDATE recipes SET title=?,ingredients=?,instructions=?,category=?,imagePath=?,favorite=? WHERE id=?";
        try (Connection c = DatabaseConnection.getConnection();
             PreparedStatement p = c.prepareStatement(sql)) {
            p.setString(1, r.getTitle());
            p.setString(2, r.getIngredients());
            p.setString(3, r.getInstructions());
            p.setString(4, r.getCategory());
            p.setString(5, r.getImagePath());
            p.setInt(6, r.isFavorite() ? 1 : 0);
            p.setInt(7, r.getId());
            p.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM recipes WHERE id=?";
        try (Connection c = DatabaseConnection.getConnection();
             PreparedStatement p = c.prepareStatement(sql)) {
            p.setInt(1, id);
            p.executeUpdate();
        }
    }

    public List<Recipe> search(String keyword) throws SQLException {
        List<Recipe> list = new ArrayList<>();
        String q = "SELECT * FROM recipes WHERE title LIKE ? OR ingredients LIKE ? ORDER BY title";
        try (Connection c = DatabaseConnection.getConnection();
             PreparedStatement p = c.prepareStatement(q)) {
            String k = "%" + keyword + "%";
            p.setString(1, k);
            p.setString(2, k);
            try (ResultSet rs = p.executeQuery()) {
                while (rs.next()) {
                    list.add(new Recipe(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("ingredients"),
                        rs.getString("instructions"),
                        rs.getString("category"),
                        rs.getString("imagePath"),
                        rs.getInt("favorite") == 1
                    ));
                }
            }
        }
        return list;
    }
}
