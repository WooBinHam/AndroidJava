package com.example.listviewandintentex01;


import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

public class aactivity_Pay extends Activity {



    TextView tvName2;
    TextView seat2;
    TextView people;
    Button btnConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apay);
        setTitle("카페 자리 예약 확정");


        //메인 액티비티로 이동해 정보 수정 가능 back기능
        Button btnReturn = (Button)findViewById(R.id.BtnReturnToTable);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //두번째 액티비티의 화면 동작 설계
        //이전 화면 정보 뿌리기
        tvName2 = (TextView)findViewById(R.id.tvName2);
        seat2 = (TextView)findViewById(R.id.Seat2);
        people=(TextView)findViewById(R.id.people);
        //앞의 MainActivity 의 정보 받아오기
        //context로 액티비티 전체를 받아와 이전에 저장된 텍스트 변수의 텍스트를 가져옴

        seat2.setText(((a_activity)a_activity.PersonContext).seat.getText());
        people.setText(((a_activity)a_activity.PersonContext).dlgEdtName.getText());

        Button btnFinish = (Button)findViewById(R.id.BtnFinish);
        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent
                Intent intent = new Intent(aactivity_Pay.this,aactivity_End.class);
                startActivity(intent);//다음 액티비티 화면에 출력
            }
        });

    }

}
