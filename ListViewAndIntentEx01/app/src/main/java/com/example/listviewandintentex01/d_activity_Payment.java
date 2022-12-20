package com.example.listviewandintentex01;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AlertDialog;

public class d_activity_Payment extends AppCompatActivity {
    int i;
    TextView tvName1, tvCount, tvPrice;
    EditText dlgEdtName1,dlgEdtPrice,dlgEdttvCount;
    View dialogView;
    Button btnInfo;

    Button btnReturnToTable;
    public static Context tableContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dpayment);
        setTitle("레스토랑 자리 예약");

        btnReturnToTable = (Button) findViewById(R.id.BtnReturnToTable);
        btnReturnToTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        tvName1 = (TextView)findViewById(R.id.tvName1);
        tvPrice = (TextView)findViewById(R.id.tvPrice);
        tvCount = (TextView)findViewById(R.id.tvCount);
        btnInfo = (Button)findViewById(R.id.BtnInfo);

        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //dialog1.xml 파일 인플레이트
                dialogView = (View) View.inflate(d_activity_Payment.this,R.layout.activity_dpayment,null);

                //alertDialog.Builder 생성
                AlertDialog.Builder dlg = new AlertDialog.Builder(d_activity_Payment.this);
                dlg.setTitle("예약자 정보 입력");
                dlg.setIcon(R.drawable.ic_launcher_background);
                dlg.setView(dialogView); //인플레이트한 것을 대화상자로 사용

                //setPositiveButton
                dlg.setPositiveButton("확인",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dlgEdtName1 = (EditText)dialogView.findViewById(R.id.dlgEdt1);
//                                dlgEdtPrice = (EditText)dialogView.findViewById(R.id.dlgEdt2);

                                tvName1.setText(dlgEdtName1.getText().toString());
                                tvPrice.setText(dlgEdtPrice.getText().toString());
                                tvCount.setText(dlgEdttvCount.getText().toString());

                                Toast.makeText(getApplicationContext(),"예약자 정보 확인했습니다.",
                                        Toast.LENGTH_SHORT).show();
                            }
                        });

                //
                dlg.setNegativeButton("취소",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getApplicationContext(),"취소했습니다.",
                                        Toast.LENGTH_SHORT).show();
                            }
                        });
                dlg.show(); //가장 중요! dialog창 보이기
            }
        });
    }
}

