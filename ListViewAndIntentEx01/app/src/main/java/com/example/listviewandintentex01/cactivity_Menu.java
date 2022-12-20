package com.example.listviewandintentex01;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class cactivity_Menu extends AppCompatActivity {

    //dialog 변수
    TextView tvMenu, tvPrice, tvCnt, tvTotal; //보여지는 텍스트
    EditText dlgEdtName; //dialg박스에 입력 받는 부분
    View dialogView; //dialog1.xml 인플레이트할 변수

    Button btnInfo;// 메뉴 수량 입력
    Button btnNext; //다음 액티비티로 넘어가는 버튼

    Button[] numButtons = new Button[12];
    Integer[] numBtnIDs = { R.id.BtnNum0,R.id.BtnNum1,R.id.BtnNum2,R.id.BtnNum3,R.id.BtnNum4,
            R.id.BtnNum5,R.id.BtnNum6,R.id.BtnNum7,
            R.id.BtnNum8,R.id.BtnNum9, R.id.BtnNum10,R.id.BtnNum11,};
    Integer[] menuPrice = {2000,2500,3000,3500,4000,4500,4000,3500,3000,2500,2000,1500};
    // 이전 페이지로
    Button btnReturn;

    int i,j, Total = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cmenu);
        setTitle("백다방 메뉴 선택");

        Intent intent = getIntent();
        int seatNum = intent.getExtras().getInt("seatN");
        String seatN = String.valueOf(seatNum);
//        int seatN = intent.getIntExtra("seatN", 1);
        String personN = intent.getStringExtra("personN");

        btnReturn =(Button)findViewById(R.id.BtnReturn);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });

        //인원 수 dialog를 위한 변수 연결
//        tvNum = (TextView) findViewById(R.id.tvNum);
        tvTotal = (TextView)findViewById(R.id.tvTotal);
        tvMenu = (TextView) findViewById(R.id.tvMenu);
        tvPrice = (TextView) findViewById(R.id.tvPrice);
        tvCnt=(TextView) findViewById(R.id.tvCnt);
        btnInfo = (Button)findViewById(R.id.BtnInfo);

        for(i=0;i<numButtons.length;i++){
            numButtons[i] = (Button)findViewById(numBtnIDs[i]);
        }

        for(i=0;i<numButtons.length;i++) {
            final int index;
            index = i;
            int price = menuPrice[i];
            numButtons[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String str = numButtons[index].getText().toString();
                    //dialog1.xml 파일 인플레이트
                    dialogView = (View) View.inflate(cactivity_Menu.this, R.layout.activity_cdialog2, null);

                    //alertDialog.Builder 생성
                    AlertDialog.Builder dlg = new AlertDialog.Builder(cactivity_Menu.this);
                    dlg.setTitle("수량 입력");
                    dlg.setIcon(R.drawable.ic_launcher_background);
                    dlg.setView(dialogView); //인플레이트한 것을 대화상자로 사용

                    dlg.setPositiveButton("확인",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dlgEdtName = (EditText) dialogView.findViewById(R.id.dlgEdt1);
                                    Editable cnt = dlgEdtName.getText();

                                    tvMenu.append("\n"+str);
                                    tvCnt.append("\n"+cnt.toString());
                                    tvPrice.append("\n"+Integer.parseInt(cnt.toString())*price);
                                    Total+=Integer.parseInt(cnt.toString())*price;
                                    tvTotal.setText("￦"+Total);
                                    tvTotal.setTextColor(Color.BLUE);

                                    Toast.makeText(getApplicationContext(), "수량 확인했습니다.",
                                            Toast.LENGTH_SHORT).show();
                                }
                            });

                    dlg.setNegativeButton("취소",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Toast.makeText(getApplicationContext(), "취소했습니다.",
                                            Toast.LENGTH_SHORT).show();
                                }
                            });
                    dlg.show();
                }
            });
        }

        btnNext = (Button)findViewById(R.id.BtnNext);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent
                Intent intent = new Intent(cactivity_Menu.this,cactivity_Pay.class);
                intent.putExtra("seatN",seatN);
                intent.putExtra("personN",personN);
                intent.putExtra("price",Total);
                startActivity(intent);//다음 액티비티 화면에 출력
            }
        });
    }
}