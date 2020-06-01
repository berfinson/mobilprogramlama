package com.example.mobilproje;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Medicine.class, NotActivity.class, EczaneActivity.class}, version = 1)
public abstract class MedDatabase extends RoomDatabase {

    private  static  MedDatabase instance;


    public static MedDatabase getInstance(Context context)
    {
        if(instance==null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), MedDatabase.class, "MedicineDb").build();
        }

        return  instance;

    }

    public  abstract  MedDao medDao();


}
