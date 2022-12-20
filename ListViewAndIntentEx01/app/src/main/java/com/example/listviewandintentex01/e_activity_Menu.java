package com.example.listviewandintentex01;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class e_activity_Menu extends AppCompatActivity {
    // 이전 페이지로
    Button btnReturn;
    Button btnNext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dmenu);
        setTitle("TwosomePlace 자리 예약");

        btnNext = (Button)findViewById(R.id.BtnNext);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent
                Intent intent = new Intent(e_activity_Menu.this,d_activity_Payment.class);
                startActivity(intent);//다음 액티비티 화면에 출력
            }
        });
    }

}