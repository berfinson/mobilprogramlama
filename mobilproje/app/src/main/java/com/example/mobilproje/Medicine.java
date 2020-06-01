package com.example.mobilproje;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "medicine")
public class Medicine {
    @PrimaryKey(autoGenerate = true)
    public  int Id;
    public String name;
    public String date;
    public String image;

    public Medicine(String name, String date, String image) {
        this.name = name;
        this.date = date;
        this.image = image;
    }


}
