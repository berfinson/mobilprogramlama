package com.example.mobilproje;

public class medicine {

    private String name;
    private String date;

    public String getName() {
        return name;
    }

    public void setName(String name) {

        this.name = name;
    }
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String image;

    public medicine(String name, String date, String image) {
        this.name = name;
        this.date = date;
        this.image = image;
    }

    public medicine() {
    }
}
