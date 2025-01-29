package devandroid.macedo.justeatburguer_v2.model;

import android.os.Parcel;
import android.os.Parcelable;

public class MenuItem {
    private String name;
    private double price;

    public MenuItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}