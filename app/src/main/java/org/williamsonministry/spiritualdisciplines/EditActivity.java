package org.williamsonministry.spiritualdisciplines;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class EditActivity extends AppCompatActivity implements PlanRecAdapter.RemovePlan {
    @Override
    public void onRemovePlanResult(Plan plan) {
        if (Utils.removePlan(plan)) {
            Toast.makeText(this, "Training removed from your plan", Toast.LENGTH_SHORT).show();
            planRecAdapter.setPlans(getDayPlans(plan.getDay()));
        }
    }

    public static final String TAG = "EditActivity";

    private TextView txtDay;
    private RecyclerView recyclerView;
    private Button btnAddPlan;

    private PlanRecAdapter planRecAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        initViews();

        planRecAdapter = new PlanRecAdapter(this);
        planRecAdapter.setType("edit");
        recyclerView.setAdapter(planRecAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        Intent intent = getIntent();
        if (null != intent) {
            String day = intent.getStringExtra("day");
            if (null != day)    {
                txtDay.setText(day);
                ArrayList<Plan> plans = getDayPlans(day);
                planRecAdapter.setPlans(plans);
            }
        }

        btnAddPlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (EditActivity.this, AllTrainingsActivity.class);
                startActivity(intent);
            }
        });
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
        Log.d(TAG, "initViews: called");
        txtDay = findViewById(R.id.txtDay);
        recyclerView = findViewById(R.id.recyclerView);
        btnAddPlan = findViewById(R.id.btnAddPlan);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(EditActivity.this, PlanActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}