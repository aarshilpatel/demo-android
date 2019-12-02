package com.example.demo;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyBaseAdapter extends BaseAdapter {
    ArrayList<DataModel> dataModelArrayList;
    String grid;
    Context context;

    public MyBaseAdapter(Context context, ArrayList<DataModel> dataModelArrayList) {
    this.context = context;
    this.dataModelArrayList = dataModelArrayList;


    }
    public MyBaseAdapter(Context context , ArrayList<DataModel> dataModelArrayList, String grid) {

   this.context = context;
   this.dataModelArrayList = dataModelArrayList;
   this.grid = grid;
    }

    @Override
    public int getCount() {
        return dataModelArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return dataModelArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (grid.equals("Grid")){


            view = layoutInflater.inflate(R.layout.raw_grid,null);
            ImageView imdata = (ImageView)view.findViewById(R.id.img_card);
            TextView tvdata = (TextView)view.findViewById(R.id.tv_card);

            DataModel dataModel = (DataModel)getItem(i);
            tvdata.setText(dataModel.getStrLang());
            imdata.setImageResource(dataModel.getImgData());

        }else {

            view = layoutInflater.inflate(R.layout.raw_custom_list,null);
            ImageView imdata = (ImageView)view.findViewById(R.id.img_data);
            TextView tvdata = (TextView)view.findViewById(R.id.tv_data);

            DataModel dataModel = (DataModel)getItem(i);
            tvdata.setText(dataModel.getStrLang());
            imdata.setImageResource(dataModel.getImgData());


        }

        return view;
    }
}

