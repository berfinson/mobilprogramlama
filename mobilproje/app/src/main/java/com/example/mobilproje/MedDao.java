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
    List<Long> insertNotes(Note...notes);
    @Insert
    List<Long> insertEczanes(Eczane...eczanes);

    @Query("SELECT * FROM medicine")
    public List<Medicine> getAllMedicines();

    @Query("SELECT * FROM note")
    public List<Note>getAllNotes();

    @Query("SELECT * FROM eczane")
   public List<Eczane> getAllEczanes();


}