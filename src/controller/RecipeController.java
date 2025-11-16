package controller;

import dao.RecipeDAO;
import model.Recipe;
import java.sql.SQLException;
import java.util.List;

public class RecipeController {
    private RecipeDAO dao = new RecipeDAO();

    public List<Recipe> getAll() throws SQLException { return dao.getAll(); }
    public void add(Recipe r) throws SQLException { dao.insert(r); }
    public void update(Recipe r) throws SQLException { dao.update(r); }
    public void delete(int id) throws SQLException { dao.delete(id); }
    public List<Recipe> search(String kw) throws SQLException { return dao.search(kw); }
}
