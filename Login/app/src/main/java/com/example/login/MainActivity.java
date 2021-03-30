package com.example.login;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    final Context context = this;
    EditText et_id, et_pass;
    Button btn_login, btn_change, btn_exit, btn_signup;
    String[] id={};
    String[] pass={};
    public static final int SIZE = 100;
    int i=0, j=0, k=0, a=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("gilbut", "onCreate");

        et_id=(EditText)findViewById(R.id.et_id);
        et_pass=(EditText)findViewById(R.id.et_pass);
        btn_login=(Button)findViewById(R.id.btn_login);
        btn_signup=(Button)findViewById(R.id.btn_signup);
        btn_change=(Button)findViewById(R.id.btn_change);
        btn_exit=(Button)findViewById(R.id.btn_exit);


        btn_login.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent=getIntent();
                id[i++]=intent.getStringExtra("id");
                pass[j++]=intent.getStringExtra("password");
                startActivity(intent);
                for(k=0; k<SIZE; k++) {
                    if (et_id.equals(id[k])&&et_pass.equals(pass[k])) {
                        a=1;
                        Intent intent2 = new Intent(MainActivity.this, messenger.class);
                        startActivity(intent2);
                        break;
                    }
                    else
                        a=0;
                        continue;

                }
                if(a==1)
                    Toast.makeText(MainActivity.this, "로그인 성공", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(MainActivity.this, "로그인 실패", Toast.LENGTH_LONG).show();
            }
        });

        btn_signup.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent = new Intent(MainActivity.this, Register.class);
                startActivity(intent);
            }
        });

    }

    private void dialog() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
        alertDialogBuilder.setTitle("프로그램 종료");
        alertDialogBuilder
                .setMessage("프로그램을 종료하겠습니까?")
                .setCancelable(false)
                .setPositiveButton("종료", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int id){
                        MainActivity.this.finish();
                    }
                })
                .setNegativeButton("취소", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int id){
                        dialog.cancel();
                    }
                });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.i("gilbut", "onResume");
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.i("gilbut", "onDestroy");
    }

    public void go(View view){
        dialog();
    }
}