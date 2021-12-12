package com.example.androidproject;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ShopAdapter extends RecyclerView.Adapter<ShopAdapter.MyViewHolder>{
    ArrayList<Picture> myPictureList;

    public class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView myPicture;
        TextView title;
        TextView price;

        public MyViewHolder(View view){
            super(view);
            myPicture = view.findViewById(R.id.imageView4);
            title = view.findViewById(R.id.title);
            price = view.findViewById(R.id.price);
        }
    }


    ShopAdapter(ArrayList<Picture> pictures){
        this.myPictureList = pictures;
    }

    @Override
    public ShopAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder (MyViewHolder holder, final int position){
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        myViewHolder.myPicture.setImageResource(myPictureList.get(position).getImageID());
        myViewHolder.title.setText(myPictureList.get(position).getName());
        myViewHolder.price.setText(myPictureList.get(position).getStrPrice());

        myViewHolder.myPicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context.getApplicationContext(), PictureDetail.class);
                intent.putExtra("image1",myPictureList.get(position).image);
                intent.putExtra("image2",myPictureList.get(position).image2);
                intent.putExtra("title",myPictureList.get(position).name);
                intent.putExtra("price",myPictureList.get(position).strPrice);
                intent.putExtra("detail",myPictureList.get(position).getDescription());
                context.startActivity(intent);
            }
        });
        myViewHolder.title.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                Context context = v.getContext();
                Intent intent = new Intent(context.getApplicationContext(), PictureDetail.class);
                intent.putExtra("image1",myPictureList.get(position).image);
                intent.putExtra("image2",myPictureList.get(position).image2);
                intent.putExtra("title",myPictureList.get(position).name);
                intent.putExtra("price",myPictureList.get(position).strPrice);
                intent.putExtra("detail",myPictureList.get(position).getDescription());
                context.startActivity(intent);
            }
        });
        myViewHolder.price.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                Context context = v.getContext();
                Intent intent = new Intent(context.getApplicationContext(), PictureDetail.class);
                intent.putExtra("image1",myPictureList.get(position).image);
                intent.putExtra("image2",myPictureList.get(position).image2);
                intent.putExtra("title",myPictureList.get(position).name);
                intent.putExtra("price",myPictureList.get(position).strPrice);
                intent.putExtra("detail",myPictureList.get(position).getDescription());
                context.startActivity(intent);
            }
        });
    }
    @Override
    public int getItemCount(){
        return myPictureList.size();
    }
    public void  filterList(ArrayList<Picture> filteredList) {
        myPictureList = filteredList;
        notifyDataSetChanged();
    }
}
