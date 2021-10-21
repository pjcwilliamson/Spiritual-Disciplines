package org.williamsonministry.spiritualdisciplines;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;

public class TrainingAdapter extends RecyclerView.Adapter<TrainingAdapter.ViewHolder> {

    private static final String TAG = "TrainingAdapter";
    private ArrayList<Training> trainings = new ArrayList<>();
    private Context mContext;

    public TrainingAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.training_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: Called");

        holder.activityName.setText(trainings.get(position).getName());
        holder.activityShortDesc.setText(trainings.get(position).getShortDesc());
        Glide.with(mContext)
                .asBitmap()
                .load(trainings.get(position).getImageURL())
                .into(holder.image);

        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: 10/21/2021 Navigate the User
                Toast.makeText(mContext, "Yet to be completed", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return trainings.size();
    }

    public void setTrainings(ArrayList<Training> trainings) {
        this.trainings = trainings;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private MaterialCardView parent;
        private ImageView image;
        private TextView activityName, activityShortDesc;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            parent = itemView.findViewById(R.id.parent);
            image = itemView.findViewById(R.id.image);
            activityName = itemView.findViewById(R.id.txtName);
            activityShortDesc = itemView.findViewById(R.id.txtDescription);
        }

    }
}
