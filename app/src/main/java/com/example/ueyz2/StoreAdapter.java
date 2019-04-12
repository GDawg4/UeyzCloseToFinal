package com.example.ueyz2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class StoreAdapter extends RecyclerView.Adapter<StoreAdapter.StoreViewHolder> {

    public Context mCtx;
    private List<StoreModel> storeModelList;

    public StoreAdapter(Context mCtx, List<StoreModel> storeModelList) {
        this.mCtx = mCtx;
        this.storeModelList = storeModelList;
    }

    @NonNull
    @Override
    public StoreViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.store_layout,null);
        StoreViewHolder holder = new StoreViewHolder(view);
        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull StoreViewHolder storeViewHolder, int i){
        StoreModel store = storeModelList.get(i);

        storeViewHolder.StoreTitle.setText(store.type);
        storeViewHolder.textViewDescription.setText(store.description);
        storeViewHolder.textViewType.setText(store.name);
        storeViewHolder.imageView.setImageDrawable(mCtx.getResources().getDrawable(store.imageId));

    }

    @Override
    public int getItemCount() {
        return storeModelList.size();
    }

    static class StoreViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imageView;
        TextView StoreTitle, Direction, textViewDescription, textViewType;
        public StoreViewHolder(@NonNull final View itemView) {
            super(itemView);
            imageView= itemView.findViewById(R.id.imageView);
            StoreTitle= itemView.findViewById(R.id.StoreTitle);
            textViewDescription = itemView.findViewById(R.id.textViewDescription);
            textViewType = itemView.findViewById(R.id.textViewType);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        }

        @Override
        public void onClick(View v) {
            Log.d("YAY", "You clicked here boy?");

        }
    }
}
