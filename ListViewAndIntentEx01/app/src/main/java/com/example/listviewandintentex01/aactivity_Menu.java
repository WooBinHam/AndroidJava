package com.example.listviewandintentex01;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AlertDialog.Builder;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.view.MotionEvent;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class aactivity_Menu extends AppCompatActivity {
    // 이전 페이지로
    Button btnReturn;
    Button btnSelect;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amenu);
        setTitle("STARBUCKS 메뉴");
        ListView listView = findViewById(R.id.listview);

        List<String> list = new ArrayList<>();
        list.add("아이스 카페 아메리카노 4500");
        list.add("아이스 카페 라떼 5000");
        list.add("아이스 자몽 허니 블랙 티 5700");
        list.add("아이스 스타벅스 돌체 라떼 5900");
        list.add("콜드 브루 4900");

        ArrayAdapter arrayAdapter = new ArrayAdapter(getApplicationContext(),android.R.layout.simple_list_item_1,list);
        listView.setAdapter(arrayAdapter);

        btnReturn =(Button)findViewById(R.id.BtnReturn);//이전 화면으로 가는 버튼
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });

        Button btnSelect = (Button)findViewById(R.id.btnSelect); //메뉴 선택이 모두 끝나 다음 화면으로 넘어가게 하는 버튼
        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent
                Intent intent = new Intent(aactivity_Menu.this,aactivity_Pay.class);
                startActivity(intent);//다음 액티비티 화면에 출력
            }
        });

    }
    public void DialogClick(View view) {//왜자꾸 여기서 오류가 뜰까...
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("다이얼로그").setMessage("다이얼로그가 보인다면 성공입니다. 축하합니다!");
        builder.setPositiveButton("성공", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "Yeah!!", Toast.LENGTH_LONG).show();
            }
        });
        builder.setNegativeButton("실패", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),"Try again!", Toast.LENGTH_LONG).show();
            }
        });

        builder.setNeutralButton("Nuetral", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),"neutral click", Toast.LENGTH_LONG).show();
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}