package com.simple.roomdb;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface NoteDao {
    @Insert
    void add(Note note);

    @Delete
    void remove(Note note);

    @Query("SELECT * FROM notes")
    List<Note> getNotes();
}
