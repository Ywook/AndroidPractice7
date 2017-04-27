package com.examples.androidpractice7;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    GridView gridView;
    GridViewAdapter adapter;


    ArrayList<Fruit> data = new ArrayList<>();

    CustomWidget cWidget;

    CheckBox checkBox;

    AutoCompleteTextView autoCompleteTextView;

    ArrayAdapter<String> arrayAdapter;

    String search[] = {"abocado", "banana", "cherry", "cranberry", "grape", "kiwi", "orange", "watermelon"};
    Fruit temp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkBox = (CheckBox)findViewById(R.id.checkBox);
        gridView = (GridView)findViewById(R.id.grid);
        autoCompleteTextView = (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView);
        cWidget = (CustomWidget)findViewById(R.id.cswidget);

        adapter = new GridViewAdapter(this,data);

        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line,search);
        autoCompleteTextView.setAdapter(arrayAdapter);

        gridView.setAdapter(adapter);

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                adapter.setPrice(b);
            }
        });

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                temp = data.get(i);
                cWidget.setItem(temp);

            }
        });



        cWidget.setOnAMListener(new CustomWidget.OnAMListener(){
            @Override
            public void onAdd(String name, int imgno, int p) {
                adapter.addItem(new Fruit(name, imgno, p));
            }

            @Override
            public void onModify(String name, int imgno, int p) {
                temp.setName(name);
                temp.setImgno(imgno);
                temp.setsPrice(p);
                adapter.notifyDataSetChanged();
            }
        });

    }
}
