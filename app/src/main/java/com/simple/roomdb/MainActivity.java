package com.simple.roomdb;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final NoteRepository repository = new NoteRepository(getApplication());

        final EditText editText = findViewById(R.id.edit_text);
        final TextView textView = findViewById(R.id.text_view);
        Button addBtn = findViewById(R.id.add_btn);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editText.getText().toString();
                Note note = new Note(text);
                repository.add(note);
            }
        });
        Button updateBtn = findViewById(R.id.update_btn);
        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Note> notes = repository.getNotes();
                StringBuilder builder = new StringBuilder();
                for (Note note : notes) {
                    builder.append(note.getText());
                    builder.append(", ");
                }
                String text = builder.toString();
                textView.setText(text);
            }
        });
    }
}
