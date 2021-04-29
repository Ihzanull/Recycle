package com.example.recycle;

import android.content.res.Resources;

import java.util.ArrayList;

public class CarData {
    static Resources res = MainActivity.getResource();
    private static String name[] = {
            "Mazda",
            "Aston",
            "Bugatti",
            "Ferrari",
            "Honda",
            "Koenigsegg",
            "Lamborgini",
            "Mclaren",
            "Mercedes",
            "Nissan",
    };

    private static String details[] = {
            res.getString(R.string.car_mazda),
            res.getString(R.string.car_aston),
            res.getString(R.string.car_bugatti),
            res.getString(R.string.car_ferrari),
            res.getString(R.string.car_honda),
            res.getString(R.string.car_koenigsegg),
            res.getString(R.string.car_lamborgini),
            res.getString(R.string.car_mclaren),
            res.getString(R.string.car_mercedes),
            res.getString(R.string.car_nissan),
    };

    private static int image[] = {
            R.drawable.mazda,
            R.drawable.aston,
            R.drawable.bugatti,
            R.drawable.ferrari,
            R.drawable.honda,
            R.drawable.koenigsegg,
            R.drawable.lamborghini,
            R.drawable.mclaren,
            R.drawable.mercedes,
            R.drawable.nissan,
    };

    static ArrayList<Car> getListData(){
        ArrayList<Car> list = new ArrayList<>();
        for (int position = 0; position <name.length; position++){
            Car cars = new Car(name[position], details[position], image[position]);
            list.add(cars);
        }
        return list;
    }
}