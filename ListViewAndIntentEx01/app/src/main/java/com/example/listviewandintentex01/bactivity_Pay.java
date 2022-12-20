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
import android.widget.TextView;
import android.widget.Toast;

public class bactivity_Pay extends AppCompatActivity {

    TextView tvName, tvNum, tvSeat, tvTotalPrice;
    EditText dlgEdtName; //dialg박스에 입력 받는 부분
    View dialogView; //dialog1.xml 인플레이트할 변수

    Button btnIn;

    // 이전 페이지로
    Button btnReturn;
    Button btnNext; //다음 액티비티로 넘어가는 버튼

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bpay);
        setTitle("EDIYA COFFEE 결제하기");

        Intent intent = getIntent();
        String personN = intent.getStringExtra("personN");
        String seatN = intent.getStringExtra("seatN");
        int price = intent.getExtras().getInt("price");
        String totalPrice = String.valueOf(price);

        btnReturn =(Button)findViewById(R.id.BtnReturn);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });

        tvName=(TextView)findViewById(R.id.tvName);
        tvNum=(TextView)findViewById(R.id.tvNum);
        tvSeat=(TextView)findViewById(R.id.tvSeat);
        tvTotalPrice=(TextView)findViewById(R.id.tvTotalPrice);

        btnIn=(Button)findViewById(R.id.btnIn);
        //다이얼로그 창 띄우는 버튼
        btnIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //dialog1.xml 파일 인플레이트
                dialogView = (View) View.inflate(bactivity_Pay.this,R.layout.activity_bdialog3,null);

                //alertDialog.Builder 생성
                AlertDialog.Builder dlg = new AlertDialog.Builder(bactivity_Pay.this);
                dlg.setTitle("예약자 성함");
                dlg.setIcon(R.drawable.ic_launcher_background);
                dlg.setView(dialogView); //인플레이트한 것을 대화상자로 사용

                dlg.setPositiveButton("확인",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dlgEdtName = (EditText)dialogView.findViewById(R.id.dlgEdt1);

                                tvName.setText(dlgEdtName.getText().toString());

                                Toast.makeText(getApplicationContext(),"예약자 정보 확인했습니다.",
                                        Toast.LENGTH_SHORT).show();
                            }
                        });

                dlg.setNegativeButton("취소",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getApplicationContext(),"취소했습니다.",
                                        Toast.LENGTH_SHORT).show();
                            }
                        });
                dlg.show();
            }
        });

        tvNum.setText(personN);
        tvSeat.setText(seatN);
        tvTotalPrice.setText(totalPrice);

        btnNext = (Button)findViewById(R.id.BtnNext);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent
                Intent intent = new Intent(bactivity_Pay.this,bactivity_Finish.class);
                startActivity(intent);//다음 액티비티 화면에 출력
            }
        });
    }
}