package com.example.recycle;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CarAdapterGrid extends RecyclerView.Adapter<CarAdapterGrid.CarViewHolder> {

    private ArrayList<Car> dataList;

    public CarAdapterGrid(ArrayList<Car> data) {
        this.dataList = data;
    }

    @Override
    public CarViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        View view = layoutInflater.inflate(R.layout.layout_item_card, parent, false);
        return new CarViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return (dataList != null) ? dataList.size() : 0;
    }


    @Override
    public void onBindViewHolder(CarViewHolder holder, int position) {
        holder.tv_title.setText(dataList.get(position).getName());
        holder.iv_imageCard.setImageResource(dataList.get(position).getImage());

        holder.iv_imageCard.setTag(dataList.get(position).getImage());
        holder.tv_details.setTag(dataList.get(position).getDetail());

    }

    public class CarViewHolder extends RecyclerView.ViewHolder{
        TextView tv_title;
        TextView tv_details;
        ImageView iv_imageCard;

        public CarViewHolder(View itemView) {
            super(itemView);
            tv_title = itemView.findViewById(R.id.tv_title);
            tv_details = itemView.findViewById(R.id.tv_details);
            iv_imageCard = itemView.findViewById(R.id.iv_imageCard);



            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent a = new Intent(v.getContext(), SecondActivity.class);
                    a.putExtra("name", tv_title.getText());
                    a.putExtra("details",(String) tv_details.getTag());
                    a.putExtra("photos", (int) iv_imageCard.getTag());
                    v.getContext().startActivity(a);
                }
            });
        }
    }
}
