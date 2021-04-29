package com.example.recycle;

import java.util.ArrayList;

public class Car {
    private String name;
    private String detail;
    private int image;


    public Car(String name, String detail, int image) {
        this.name = name;
        this.detail = detail;
        this.image = image;
    }

    public static void addAll(ArrayList<Car> listData) {
    }


    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}