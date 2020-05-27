package com.example.mobilproje;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
interface MedDao {

    @Insert
    List<Long> insertAll(medicine...meds);
    @Insert
    List<Long> insertNotes(note...notes);

    @Query("SELECT * FROM medicine")
    public List<medicine> getAllMedicines();


    @Query("SELECT * FROM note")
    public List<note> getAllNotes();


}