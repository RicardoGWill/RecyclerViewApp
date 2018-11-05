package com.ricardogwill.recyclerviewapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    private TextView name, description;
    private Bundle extrasBundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        // This gets information from the MainActivity's Explicit Intent.
        extrasBundle = getIntent().getExtras();

        name = findViewById(R.id.name_TV);
        description = findViewById(R.id.description_TV);

        if (extrasBundle != null) {
            name.setText(extrasBundle.getString("name"));
            description.setText(extrasBundle.getString("description"));
        }

    }
}
