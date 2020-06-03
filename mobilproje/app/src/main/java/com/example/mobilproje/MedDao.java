package com.example.mobilproje;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
interface MedDao {

    @Insert
    List<Long> insertAll(Medicine...meds);
    @Insert
    List<Long> insertNotes(NotActivity...notes);
    @Insert
    List<Long> insertEczanes(EczaneActivity...eczanes);

    @Query("SELECT * FROM Medicine")
    public List<Medicine> getAllMedicines();


    @Query("SELECT * FROM NotActivity")
    public List<NotActivity>getAllNotes();

    @Query("SELECT * FROM EczaneActivity")
   public List<EczaneActivity> getAllEczanes();


}