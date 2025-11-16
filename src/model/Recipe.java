package model;

public class Recipe {
    private int id;
    private String title;
    private String ingredients;
    private String instructions;
    private String category;
    private String imagePath;
    private boolean favorite;

    public Recipe(int id, String title, String ingredients, String instructions,
                  String category, String imagePath, boolean favorite) {
        this.id = id; this.title = title; this.ingredients = ingredients;
        this.instructions = instructions; this.category = category;
        this.imagePath = imagePath; this.favorite = favorite;
    }

    // getters & setters
    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getIngredients() { return ingredients; }
    public String getInstructions() { return instructions; }
    public String getCategory() { return category; }
    public String getImagePath() { return imagePath; }
    public boolean isFavorite() { return favorite; }

    public void setId(int id) { this.id = id; }
    public void setTitle(String t) { this.title = t; }
    public void setIngredients(String s) { this.ingredients = s; }
    public void setInstructions(String s) { this.instructions = s; }
    public void setCategory(String c) { this.category = c; }
    public void setImagePath(String p) { this.imagePath = p; }
    public void setFavorite(boolean f) { this.favorite = f; }
}
