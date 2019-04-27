package com.test.afinal;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class moreCustomAdapter extends ArrayAdapter<String>{
    public moreCustomAdapter(@NonNull Context context, String More_Item[]) {
        super(context, R.layout.morelistitem,More_Item);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=LayoutInflater.from(getContext());
        View customView=inflater.inflate(R.layout.morelistitem,parent,false);

        int moreItemImage[]={R.drawable.ic_account_circle_black_24dp,R.drawable.ic_help_black_24dp,R.drawable.ic_group_add_black_24dp,R.drawable.ic_share_black_24dp,R.drawable.ic_grade_black_24dp,R.drawable.ic_dashboard_black_24dp,R.drawable.ic_work_black_24dp};

        String val=getItem(position);
        TextView moreText=(TextView)customView.findViewById(R.id.moreText);
        ImageView moreImage=(ImageView)customView.findViewById(R.id.moreImage);

        moreText.setText(val);
        moreImage.setImageResource(moreItemImage[position]);
        return customView;
    }
}
