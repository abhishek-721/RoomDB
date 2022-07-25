package com.simple.roomdb;

import android.app.Application;

import java.util.List;

public class NoteRepository {
    private NoteDao noteDao;

    public NoteRepository(Application application) {
        NoteDB db = NoteDB.getInstance(application);
        noteDao = db.noteDao();
    }

    public void add(Note note) {
        noteDao.add(note);
    }

    public void remove(Note note) {
        noteDao.remove(note);
    }

    public List<Note> getNotes() {
        return noteDao.getNotes();
    }
}
