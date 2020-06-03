package com.example.mobilproje;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "eczane")
public class Eczane {
    @PrimaryKey(autoGenerate = true)
    public  int Id;
    public String name;
    public String adres;
    public String telefon;

    public Eczane(String name, String adres, String telefon) {
        this.name = name;
        this.adres = adres;
        this.telefon = telefon;
    }


}
