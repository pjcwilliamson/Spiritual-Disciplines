package org.williamsonministry.spiritualdisciplines;

import static org.williamsonministry.spiritualdisciplines.TrainingActivity.TRAINING_KEY;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;

public class PlanRecAdapter extends RecyclerView.Adapter<PlanRecAdapter.ViewHolder> {

    private ArrayList<Plan> plans = new ArrayList<>();
    private Context mContext;

    public PlanRecAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.plan_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtName.setText(plans.get(position).getTraining().getName());
        holder.txtDescription.setText(plans.get(position).getTraining().getShortDesc());
        holder.txtTime.setText(String.valueOf(plans.get(position).getMinutes()));
        Glide.with(mContext)
                .asBitmap()
                .load(plans.get(position).getTraining().getImageURL())
                .into(holder.image);
        if (plans.get(position).isAccomplished())   {
            holder.emptyCircle.setVisibility(View.GONE);
            holder.checkedCircle.setVisibility(View.VISIBLE);
        }   else    {
            holder.checkedCircle.setVisibility(View.GONE);
            holder.emptyCircle.setVisibility(View.VISIBLE);
        }

        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, TrainingActivity.class);
                //intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra(TRAINING_KEY, plans.get(position).getTraining());
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return plans.size();
    }

    public void setPlans(ArrayList<Plan> plans) {
        this.plans = plans;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txtTime, txtName, txtDescription;
        private MaterialCardView parent;
        private ImageView image, emptyCircle, checkedCircle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtName);
            txtTime = itemView.findViewById(R.id.txtTime);
            txtDescription = itemView.findViewById(R.id.txtDescription);
            parent = itemView.findViewById(R.id.parent);
            image = itemView.findViewById(R.id.trainingImage);
            emptyCircle = itemView.findViewById(R.id.emptyCircle);
            checkedCircle = itemView.findViewById(R.id.checkedCircle);
        }
    }
}
