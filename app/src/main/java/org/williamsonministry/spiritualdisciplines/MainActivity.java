package org.williamsonministry.spiritualdisciplines;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private Button btnSeeYourPlans, btnAllTrainings, btnAbout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        Utils.initTrainings();

        // TODO: 10/21/2021 Create onClickListeners
        
        btnAllTrainings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AllTrainingsActivity.class);
                startActivity(intent);
            }
        });

    }

    private void initView() {
        Log.d(TAG, "initViews: started");

        btnSeeYourPlans = findViewById(R.id.btnSeeYourPlans);
        btnAllTrainings = findViewById(R.id.btnAllActivities);
        btnAbout = findViewById(R.id.btnAbout);
    }
}