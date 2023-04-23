package com.example.mynewsapplication;

public class MyNewsModel {
    int image;
    String text;

    public MyNewsModel(int image, String text) {
        this.image = image;
        this.text = text;
    }

    public int getImage() {
        return image;
    }
    public String getText() {
        return text;
    }
}
