package com.examples.androidpractice7;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

/**
 * Created by Mac on 2017. 4. 27..
 */

public class GridViewAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Fruit> data;
    private Boolean bPrice = false;

    public GridViewAdapter(Context context, ArrayList<Fruit> data) {
        this.context = context;
        this.data = data;
    }

    public void addItem(Fruit fruit){
        data.add(fruit);
        notifyDataSetChanged();
    }

    public void setPrice(Boolean b){
        bPrice = b;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null){
            view = new GridItem(context);
        }
        ((GridItem)view).setVisible(bPrice);
        ((GridItem)view).setData(data.get(i));

        return view;
    }
}
