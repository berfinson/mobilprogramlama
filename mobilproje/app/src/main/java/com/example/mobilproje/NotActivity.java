package com.example.mobilproje;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "note")
public class NotActivity {
    @PrimaryKey(autoGenerate = true)
    public  int Id;
    public String description;
    public String date;

    public NotActivity(String description) {
        this.date = String.valueOf(System.currentTimeMillis());
        this.description = description;
    }


}
