package com.example.recyclerviewlab;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(
                findViewById(R.id.main), (v, insets) -> {
                    Insets systemBars = insets.getInsets(
                            WindowInsetsCompat.Type.systemBars());

                    v.setPadding(
                            systemBars.left,
                            systemBars.top,
                            systemBars.right,
                            systemBars.bottom);

                    return insets;
                });

        // Préparer les données de la liste.
        String[] data = new String[50];

        for (int i = 0; i < data.length; i++) {
            data[i] = "Élément " + (i + 1);
        }

        // Récupérer la liste définie dans le fichier XML.
        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        // Disposer les éléments verticalement.
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Relier les données à la liste.
        recyclerView.setAdapter(new CustomAdapter(data));
    }
}