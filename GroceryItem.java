package com.example.experiment4;
public class GroceryItem {
    private String name;
    private String images;

    public GroceryItem(String name, String images) {
        this.name = name;
        this.images = images;
    }

    public String getName() {
        return name;
    }

    public String getImages() {
        return images;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImages(String images) {
        this.images = images;
    }
}
