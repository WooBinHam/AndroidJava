package com.example.listviewandintentex01;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class a_activity extends AppCompatActivity {

    public static Context PersonContext;
    //dialog 변수
    TextView tvNum; //보여지는 텍스트
    EditText dlgEdtName; //dialg박스에 입력 받는 부분
    View dialogView; //dialog1.xml 인플레이트할 변수

    //변수
    TextView seat;//자리 버튼 선택시 2가지 정보 보여짐
    Button btnInfo;//이용하려는 인원수 입력
    Button btnNext; //다음 액티비티로 넘어가는 버튼

    Button[] numButtons = new Button[20];
    Integer[] numBtnIDs = { R.id.BtnNum0,R.id.BtnNum1,R.id.BtnNum2,R.id.BtnNum3,R.id.BtnNum4,
            R.id.BtnNum5,R.id.BtnNum6,R.id.BtnNum7,R.id.BtnNum8,R.id.BtnNum9,R.id.BtnNum10,
            R.id.BtnNum11,R.id.BtnNum12,R.id.BtnNum13,R.id.BtnNum14,R.id.BtnNum15,
            R.id.BtnNum16,R.id.BtnNum17,R.id.BtnNum18,R.id.BtnNum19};
    // 이전 페이지로
    Button btnReturn;

    int i, j;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aactivity);
        setTitle("STARBUCKS 자리 예약");

        PersonContext=this;

        btnReturn =(Button)findViewById(R.id.BtnReturn);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });
        //좌석 버튼 관련 요소들 연결
        seat = (TextView) findViewById(R.id.Seat);
        btnInfo = (Button)findViewById(R.id.BtnInfo);
        for(i=0;i<numButtons.length;i++){
            numButtons[i] = (Button)findViewById(numBtnIDs[i]);
        }

        //예약자 명,연락처 dialog를 위한 변수 연결
        tvNum = (TextView)findViewById(R.id.tvNum);

        //다이얼로그 창 띄우는 버튼
        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //dialog1.xml 파일 인플레이트
                dialogView = (View) View.inflate(a_activity.this,R.layout.activity_adialog,null);

                //alertDialog.Builder 생성
                AlertDialog.Builder dlg = new AlertDialog.Builder(a_activity.this);
                dlg.setTitle("이용하고자 하는 인원 수 입력");
                dlg.setIcon(R.drawable.ic_launcher_background);
                dlg.setView(dialogView); //인플레이트한 것을 대화상자로 사용

                dlg.setPositiveButton("확인",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dlgEdtName = (EditText)dialogView.findViewById(R.id.dlgEdt1);

                                tvNum.setText(dlgEdtName.getText().toString()+"명");
                                tvNum.setTextColor(Color.BLUE);

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

        for(i=0;i<numButtons.length;i++){
            final int index;
            index = i;
            numButtons[index].setOnClickListener(new View.OnClickListener(){

                public void onClick(View view){
                    //더 구현 : 클릭 시 색 바뀌는거
                    for(j=0;j<numButtons.length;j++){
                        if(j!=index){
                            numButtons[j].setSelected(false);
                        }
                        else{
                            numButtons[j].setSelected(true);
                        }
                    }
                    seat.setText((index+1)+"번 자리"); //버튼 번호를 받아와 띄움
                    seat.setTextColor(Color.BLUE);
                    Toast.makeText(getApplicationContext(),
                            dlgEdtName.getText().toString()+"인 "+(index+1)+"번 좌석을 선택하셨습니다.",Toast.LENGTH_SHORT).show();

                }
            });
        }//for문 끝

        btnNext = (Button)findViewById(R.id.BtnNext);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent
                Intent intent = new Intent(a_activity.this,aactivity_Menu.class);
                startActivity(intent);//다음 액티비티 화면에 출력
            }
        });
    }
}