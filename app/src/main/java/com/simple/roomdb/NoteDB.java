package com.simple.roomdb;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = Note.class, version = 1)
public abstract class NoteDB extends RoomDatabase {
    private static NoteDB noteDB;

    static synchronized NoteDB getInstance(Context context) {
        if (noteDB == null) {
            noteDB = Room.databaseBuilder(context, NoteDB.class, "note_db")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }
        return noteDB;
    }

    public abstract NoteDao noteDao();
}
