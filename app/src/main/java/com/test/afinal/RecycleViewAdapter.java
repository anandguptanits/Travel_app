package com.test.afinal;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.Collections;
import java.util.List;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.MyViewHolder>{

    private LayoutInflater inflator;
    List<CategoryImages> data= Collections.emptyList();

    public RecycleViewAdapter(Context context,List<CategoryImages> data){
         inflator = LayoutInflater.from(context);
         this.data=data;
    }
    class MyViewHolder extends RecyclerView.ViewHolder{
             ImageView CategoryImage;

        public MyViewHolder(View itemView) {
            super(itemView);
            CategoryImage= itemView.findViewById(R.id.categories_image);
        }
    }
    @NonNull
    public MyViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
       View v= inflator.inflate(R.layout.categories_image,parent,false);
       MyViewHolder holder=new MyViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        CategoryImages ImageId=data.get(position);
               holder.CategoryImage.setImageResource(ImageId.ImageId);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
