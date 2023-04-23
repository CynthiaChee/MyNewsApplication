package com.example.mynewsapplication;

public class MyVerticalModel {
    String verticalTitle, verticalDescription;
    int image;

    public MyVerticalModel(String verticalTitle, String verticalDescription, int image) {
        this.verticalTitle = verticalTitle;
        this.verticalDescription = verticalDescription;
        this.image = image;
    }

    public String getVerticalTitle() {
        return verticalTitle;
    }

    public String getVerticalDescription() {
        return verticalDescription;
    }

    public int getImage() {
        return image;
    }
}
