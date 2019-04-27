package com.test.afinal;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

public class MoreFragment extends Fragment{

    String name[]={"Our Team","Help and Support","Refer and Earn","Share the app","Rate us","About us","Careers with us"};

        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

            View v=inflater.inflate(R.layout.fragment_more,null);
            ListAdapter moreAdapter=new moreCustomAdapter(v.getContext(),name);
            ListView moreListVew =(ListView) v.findViewById(R.id.moreItemListView);
            moreListVew.setAdapter(moreAdapter);
            moreListVew.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Intent intent;
                    switch(i){
                        case 0:
                             intent=new Intent(view.getContext(),TeamActivity.class);
                            startActivity(intent);
                            break;
                        case 1:
                             intent=new Intent(view.getContext(),HelpSupport.class);
                            startActivity(intent);
                            break;
                        case 2:
                             intent=new Intent(view.getContext(),ReferEarnActivity.class);
                            startActivity(intent);
                            break;
                        case 3:
                             intent=new Intent(view.getContext(),ReferEarnActivity.class);
                            startActivity(intent);
                            break;
                        case 4:
                             intent=new Intent(view.getContext(),RateUsActivity.class);
                            startActivity(intent);
                            break;
                        case 5:
                            intent=new Intent(view.getContext(),AboutUsActivity.class);
                            startActivity(intent);
                            break;
                        case 6:
                            intent=new Intent(view.getContext(),CareerActivity.class);
                            startActivity(intent);
                            break;

                    }
                }
            });
            return v;
        }
    }


