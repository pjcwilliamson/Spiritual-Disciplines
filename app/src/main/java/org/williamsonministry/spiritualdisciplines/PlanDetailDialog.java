package org.williamsonministry.spiritualdisciplines;

import static org.williamsonministry.spiritualdisciplines.TrainingActivity.TRAINING_KEY;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class PlanDetailDialog extends DialogFragment {

    public interface PassPlanInterface  {
        void getPlan(Plan plan);
    }

    private PassPlanInterface passPlanInterface;

    private Button btnAdd, btnDismiss;
    private Spinner spDays;
    private TextView txtName;
    private EditText etTxtMinutes;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        View view = getActivity().getLayoutInflater().inflate(R.layout.dialog_plan_details, null);
        initViews(view);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity())
                .setView(view)
                .setTitle("Enter Details");

        Bundle bundle = getArguments();

        if (null != bundle) {
            Training training = bundle.getParcelable(TRAINING_KEY);
            if (training != null)   {
                txtName.setText(training.getName());
                btnDismiss.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dismiss();
                    }
                });
                btnAdd.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String day = spDays.getSelectedItem().toString();
                        int minutes = Integer.valueOf(etTxtMinutes.getText().toString());
                        Plan plan = new Plan(training, minutes, day,false);

                        try {
                            passPlanInterface = (PassPlanInterface) getActivity();
                            passPlanInterface.getPlan(plan);
                            dismiss();
                        }catch (ClassCastException e)   {
                            e.printStackTrace();
                            dismiss();
                        }
                    }
                });
            }
        }

        return builder.create();
    }

    private void initViews(View view) {
        btnAdd = view.findViewById(R.id.btnAdd);
        btnDismiss = view.findViewById(R.id.btnDismiss);
        spDays = view.findViewById(R.id.spinnerDays);
        txtName = view.findViewById(R.id.txtName);
        etTxtMinutes = view.findViewById(R.id.edtTxtMinutes);
    }
}
