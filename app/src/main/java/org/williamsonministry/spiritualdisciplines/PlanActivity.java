package org.williamsonministry.spiritualdisciplines;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class PlanActivity extends AppCompatActivity {
    public static final String TAG = "PlanActivity";

    private TextView mondayEdit, tuesdayEdit, wednesdayEdit, thursdayEdit, fridayEdit, saturdayEdit, sundayEdit;
    private RecyclerView mondayRecView, tuesdayRecView, wednesdayRecView, thursdayRecView,
            fridayRecView, saturdayRecView, sundayRecView;
    private RelativeLayout noPlanRelLayout;
    private NestedScrollView nestedScrollView;
    private Button btnAddPlan;
    private PlanRecAdapter mondayAdapter, tuesdayAdapter, wedAdapter, thurAdapter, friAdapter, satAdapter, sunAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan);
        initViews();
        ArrayList<Plan> plans = Utils.getPlans();
        if (null != plans) {
            if (plans.size() > 0) {
                noPlanRelLayout.setVisibility(View.GONE);
                nestedScrollView.setVisibility(View.VISIBLE);

                initRecViews();
            } else {
                noPlanRelLayout.setVisibility(View.VISIBLE);
                nestedScrollView.setVisibility(View.GONE);
                btnAddPlan.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(PlanActivity.this, AllTrainingsActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                    }
                });
            }
        } else {
            noPlanRelLayout.setVisibility(View.VISIBLE);
            nestedScrollView.setVisibility(View.GONE);
            btnAddPlan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(PlanActivity.this, AllTrainingsActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }
            });
        }
    }

    private void initRecViews() {
        Log.d(TAG, "initRecViews: started");

        mondayAdapter = new PlanRecAdapter(this);
        mondayRecView.setAdapter(mondayAdapter);
        mondayRecView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        mondayAdapter.setPlans(getDayPlans("Monday"));

        tuesdayAdapter = new PlanRecAdapter(this);
        tuesdayRecView.setAdapter(tuesdayAdapter);
        tuesdayRecView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        tuesdayAdapter.setPlans(getDayPlans("Tuesday"));

        wedAdapter = new PlanRecAdapter(this);
        wednesdayRecView.setAdapter(wedAdapter);
        wednesdayRecView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        wedAdapter.setPlans(getDayPlans("Wednesday"));

        thurAdapter = new PlanRecAdapter(this);
        thursdayRecView.setAdapter(thurAdapter);
        thursdayRecView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        thurAdapter.setPlans(getDayPlans("Thursday"));

        friAdapter = new PlanRecAdapter(this);
        fridayRecView.setAdapter(friAdapter);
        fridayRecView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        friAdapter.setPlans(getDayPlans("Friday"));

        satAdapter = new PlanRecAdapter(this);
        saturdayRecView.setAdapter(satAdapter);
        saturdayRecView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        satAdapter.setPlans(getDayPlans("Saturday"));

        sunAdapter = new PlanRecAdapter(this);
        sundayRecView.setAdapter(sunAdapter);
        sundayRecView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        sunAdapter.setPlans(getDayPlans("Sunday"));
    }

    private ArrayList<Plan> getDayPlans(String day) {
        ArrayList<Plan> plans = Utils.getPlans();
        if (plans != null && plans.size()>0) {
            ArrayList<Plan> dayPlans = new ArrayList<>();
            for (Plan p: plans)  {
                if (p.getDay().equalsIgnoreCase(day)) {
                    dayPlans.add(p);
                }
            }
            return dayPlans;
        }   else {
            return new ArrayList<Plan>();
        }
    }

    private void initViews() {
        Log.d(TAG, "initViews: started");
        mondayEdit = findViewById(R.id.mondayEdit);
        tuesdayEdit = findViewById(R.id.tuesdayEdit);
        wednesdayEdit = findViewById(R.id.wednesdayEdit);
        thursdayEdit = findViewById(R.id.thursdayEdit);
        fridayEdit = findViewById(R.id.fridayEdit);
        saturdayEdit = findViewById(R.id.saturdayEdit);
        sundayEdit = findViewById(R.id.sundayEdit);
        mondayRecView = findViewById(R.id.mondayRecView);
        tuesdayRecView = findViewById(R.id.tuesdayRecView);
        wednesdayRecView = findViewById(R.id.wednesdayRecView);
        thursdayRecView = findViewById(R.id.thursdayRecView);
        fridayRecView = findViewById(R.id.fridayRecView);
        saturdayRecView = findViewById(R.id.saturdayRecView);
        sundayRecView = findViewById(R.id.sundayRecView);
        noPlanRelLayout = findViewById(R.id.noPlanRelLayout);
        nestedScrollView = findViewById(R.id.nestedScrollView);
        btnAddPlan = findViewById(R.id.btnAddPlan);
    }
}