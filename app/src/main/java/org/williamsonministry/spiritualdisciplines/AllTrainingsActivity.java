package org.williamsonministry.spiritualdisciplines;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class AllTrainingsActivity extends AppCompatActivity {
    private static final String TAG = "AllTrainingsActivity";

    private RecyclerView recyclerView;
    private TrainingAdapter trainingAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_trainings);

        recyclerView = findViewById(R.id.recyclerView);
        trainingAdapter = new TrainingAdapter(this);
        recyclerView.setAdapter(trainingAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        ArrayList<Training> allTrainings = Utils.getTrainings();
        if (null != allTrainings) {
            trainingAdapter.setTrainings(allTrainings);
        }
    }
}