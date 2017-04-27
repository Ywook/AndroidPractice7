package com.examples.androidpractice7;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Mac on 2017. 4. 27..
 */

public class GridItem extends LinearLayout {
    TextView tv;
    TextView tvprice;
    ImageView img;

    public GridItem(Context context) {
        super(context);
        init(context);
    }

    public void init(Context context){
        View view = LayoutInflater.from(context).inflate(R.layout.grid_item, this);

        tv = (TextView)view.findViewById(R.id.tvname);
        img = (ImageView)view.findViewById(R.id.imageView);
        tvprice = (TextView)view.findViewById(R.id.tvprice);
    }

    public void setData(Fruit one){
        tv.setText(one.getName());
        img.setImageResource(one.getImgno());
        tvprice.setText(one.getsPrice());

    }

    public void setVisible(boolean b){
        if(b) tvprice.setVisibility(View.VISIBLE);
        else tvprice.setVisibility(View.GONE);
    }

}
