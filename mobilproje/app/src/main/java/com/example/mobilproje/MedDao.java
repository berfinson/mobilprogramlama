package com.example.mobilproje;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
interface MedDao {

    @Insert
    List<Long> insertAll(medicine...meds);

    @Query("SELECT * FROM medicine")
    public List<medicine> getAllMedicines();
}