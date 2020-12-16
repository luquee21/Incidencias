package com.incidences.incidencesapp.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.incidences.incidencesapp.R;
import com.incidences.incidencesapp.models.IncidencesEntity;

import java.util.ArrayList;

public class IncidencesAdapter extends RecyclerView.Adapter<IncidencesAdapter.IncidencesViewHolder> implements View.OnClickListener {

    private static Context context;
    private final ArrayList<IncidencesEntity> items;
    private View.OnClickListener listener;

    public IncidencesAdapter(@NonNull ArrayList<IncidencesEntity> items, Context context) {
        this.items = items;
        IncidencesAdapter.context = context;
    }

    public IncidencesEntity getItem(int position) {
        return items.get(position);
    }

    public boolean removeItem(int position) {
        boolean result = false;
        if (items != null && !items.isEmpty()) {
            items.remove(position);
            notifyItemRemoved(position);
            result = true;
        }
        return result;
    }

    @Override
    public IncidencesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_items, parent, false);
        row.setOnClickListener(this);
        IncidencesViewHolder incidencesViewHolder = new IncidencesViewHolder(row);
        return incidencesViewHolder;
    }

    @Override
    public void onBindViewHolder(IncidencesViewHolder viewHolder, int position) {
        IncidencesEntity item = items.get(position);
        viewHolder.IncidencesBind(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onClick(View view) {
        if (listener != null)
            listener.onClick(view);
    }

    public static class IncidencesViewHolder
            extends RecyclerView.ViewHolder {

        private final TextView nameanddate;
        private final ImageView image;

        public IncidencesViewHolder(View itemView) {
            super(itemView);
            nameanddate = itemView.findViewById(R.id.dateandnameincindences);
            image = itemView.findViewById(R.id.imageincidencerecycler);
        }

        public void IncidencesBind(IncidencesEntity item) {
            if (item.getImage() != null && !item.getImage().isEmpty()) {
                byte[] decodedString = Base64.decode(item.getImage(), Base64.DEFAULT);
                Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
                Bitmap imageScaled = Bitmap.createScaledBitmap(decodedByte, 200, 200, false);
                image.setImageBitmap(imageScaled);
            } else {
                image.setBackground(context.getResources().getDrawable(R.drawable.ic_notas));
            }

            nameanddate.setText(item.getName() + "\n" + item.getDate());
        }

    }
}
