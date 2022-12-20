package com.example.listviewandintentex01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("내 주변 카페");
        ListView listView = findViewById(R.id.listview);

        List<String> list = new ArrayList<>();
        list.add("STARBUCKS");
        list.add("EDIYA COFFEE");
        list.add("백다방");
        list.add("TwosomePlace");
        list.add("메가커피");

        ArrayAdapter arrayAdapter = new ArrayAdapter(getApplicationContext(),android.R.layout.simple_list_item_1,list);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                if(position == 0){
                    //click a - StarBucks
                    startActivity(new Intent(MainActivity.this,a_activity.class));

                }else if(position == 1){
                    //click b - EDIYA
                    startActivity(new Intent(MainActivity.this,b_activity.class));

                }else if(position == 2){
                    //click c - Paikdabang
                    startActivity(new Intent(MainActivity.this,c_activity.class));

                }else if(position == 3){
                    //click d - TwosomePlace
                    startActivity(new Intent(MainActivity.this,d_activity.class));

                }else if(position == 4){
                    //click e - Mega
                    startActivity(new Intent(MainActivity.this,e_activity.class));
                }
            }
        });
    }
}