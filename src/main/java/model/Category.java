package model;

public class Category {
    int id;
    String name;

    public Category(){};

    public Category(int catId, String catName) {
        this.id = catId;
        this.name = catName;
    }

    public int getCatId() {
        return id;
    }

    public void setCatId(int catId) {
        this.id = catId;
    }

    public String getCatName() {
        return name;
    }

    public void setCatName(String catName) {
        this.name = catName;
    }
}
