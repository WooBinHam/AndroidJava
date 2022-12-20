package com.example.listviewandintentex01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class d_activity_Menu extends AppCompatActivity {
    // 이전 페이지로
    Button btnReturn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dmenu);
        setTitle("TwosomePlace 자리 예약");

        btnReturn =(Button)findViewById(R.id.BtnReturn);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });

    }
}