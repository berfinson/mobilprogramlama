package com.example.mobilproje;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "note")
public class note {
    @PrimaryKey(autoGenerate = true)
    public  int Id;
    public String description;
    public String date;

    public note(String description) {
        this.date = String.valueOf(System.currentTimeMillis());
        this.description = description;
    }


}
