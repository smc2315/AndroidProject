package com.example.androidproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BoughtAdapter extends RecyclerView.Adapter<BoughtAdapter.MyViewHolder> {
    // 레이아웃의 뷰 객체들과 연결고리 역할을 하는 inner 클래
    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView boughtName;
        TextView boughtPrice;
        MyViewHolder(View view){
            super(view);
            boughtName = view.findViewById(R.id.boughtName);
            boughtPrice = view.findViewById(R.id.boughtPrice);
        }
    }
    // School 객체들을 담을 수 있는 리스트
    private ArrayList<Picture> myPictureList2;
    BoughtAdapter(ArrayList<Picture> schools){
        this.myPictureList2 = schools;
    }

    @Override
    public BoughtAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.bought_items, parent, false);
        return new MyViewHolder(v);
    }
    // 리싸이클러에 보여지는 이미지와 문장들을 설정함.
    @Override
    public void onBindViewHolder(BoughtAdapter.MyViewHolder holder, final int position) {
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        myViewHolder.boughtName.setText(myPictureList2.get(position).getName());
        myViewHolder.boughtPrice.setText(String.valueOf(myPictureList2.get(position).getPrice()));
    }
    @Override
    public int getItemCount() {
        return myPictureList2.size();
    }
}
