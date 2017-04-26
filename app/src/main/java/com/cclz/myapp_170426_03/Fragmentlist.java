package com.cclz.myapp_170426_03;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragmentlist extends Fragment {
    String str[]={"AAA", "BBB", "CCC"};
    ListView lv;

    public Fragmentlist() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragmentlist, container, false);
        lv = (ListView) v.findViewById(R.id.listView);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ArrayAdapter<String>adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, str);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                FragmentTransaction ft=getFragmentManager().beginTransaction();
                switch(position){
                    case 0:
                    case 1:
                        FragmentB fb=new FragmentB();
                        fb.setArguments(str[position]);
                        ft.replace(R.id.layout_contant, fb);
                        break;
                    case 2:
                        ft.replace(R.id.layout_contant, new FragmentC());
                        break;
                }
                ft.commit();
            }
        });
    }

}
