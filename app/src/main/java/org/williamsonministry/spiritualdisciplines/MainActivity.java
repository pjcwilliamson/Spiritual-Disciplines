package org.williamsonministry.spiritualdisciplines;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private Button btnSeeYourPlans, btnAllActivities, btnAbout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        // TODO: 10/21/2021 Create onClickListeners


    }

    private void initView() {
        Log.d(TAG, "initViews: started");

        btnSeeYourPlans = findViewById(R.id.btnSeeYourPlans);
        btnAllActivities = findViewById(R.id.btnAllActivities);
        btnAbout = findViewById(R.id.btnAbout);
    }
}