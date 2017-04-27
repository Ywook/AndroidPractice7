package com.examples.androidpractice7;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by Mac on 2017. 4. 27..
 */

public class CustomWidget extends LinearLayout implements View.OnClickListener{
    AutoCompleteTextView autoEt;
    ImageView img;
    Button add_btn;
    Button next_btn;

    int imageno = 0;

    private Boolean M = false;
    public CustomWidget(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context){
        LayoutInflater.from(context).inflate(R.layout.customwidget,this);

        autoEt = (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView);
        img = (ImageView)findViewById(R.id.image1);
        add_btn = (Button)findViewById(R.id.b_add);
        next_btn = (Button)findViewById(R.id.b_next);

        add_btn.setOnClickListener(this);
        next_btn.setOnClickListener(this);

    }

    public void setItem(Fruit temp){
        autoEt.setText(temp.getName());
        img.setImageResource(temp.getImgno());
        add_btn.setText("M");
        M = true;
    }

    interface OnAMListener{
        void onAdd(String name, int imgno, int p);
        void onModify(String name, int imgno, int p);
    }

    public OnAMListener onAddListener;
    public OnAMListener onModifyListener;

    public void setOnAMListener(OnAMListener onAddListener){
        this.onAddListener = onAddListener;
        this.onModifyListener = onAddListener;

    }
    @Override
    public void onClick(View view) {
        if(view == add_btn){
            if(M){
                onModifyListener.onModify(autoEt.getText().toString(), Fruit.image[imageno], imageno);
                add_btn.setText("Add");
                M = false;
                autoEt.setText("");
            }
            else {
                onAddListener.onAdd(autoEt.getText().toString(), Fruit.image[imageno], imageno);
                autoEt.setText("");
            }
        }else{
            if(imageno == Fruit.image.length -1) imageno = -1;
            img.setImageResource(Fruit.image[++imageno]);
        }

    }
}
