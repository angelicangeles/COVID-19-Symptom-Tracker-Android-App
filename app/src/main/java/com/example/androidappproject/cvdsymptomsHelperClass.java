package com.example.androidappproject;

public class cvdsymptomsHelperClass {
    int image;
    String desc, title;

    public cvdsymptomsHelperClass(int image, String desc, String title) {
        this.image = image;
        this.desc = desc;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public int getImage() {
        return image;
    }

    public String getDesc() {
        return desc;
    }
}
