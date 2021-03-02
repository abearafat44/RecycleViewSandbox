package com.example.recycleviewsandbox;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    private List<ItemTemplate> itemList;
    private RecyclerViewClickListener listener;

    public CustomAdapter(List<ItemTemplate> itemList, RecyclerViewClickListener listener) {
        this.itemList = itemList;
        this.listener=listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String title = itemList.get(position).getTitle();
        holder.setData(title);
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public interface RecyclerViewClickListener{
        void onClick(View v, int position);
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView title;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            title = itemView.findViewById(R.id.textTitle);
            itemView.setOnClickListener(this);
        }

        private void setData(String titleText){
            title.setText(titleText);
        }

        @Override
        public void onClick(View view) {
            listener.onClick(view, getAdapterPosition());
        }
    }
}
