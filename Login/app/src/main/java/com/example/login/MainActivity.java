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
import android.widget.Toast;
class Person{
    String id;
    String pass;
}
public class MainActivity extends AppCompatActivity {
    final Context context = this;
    EditText et_id, et_pass;
    Button btn_login, btn_change, btn_exit, btn_signup;
    String id, pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("gilbut", "onCreate");

        Person person = new Person();
        et_id=(EditText)findViewById(R.id.et_id2);
        et_pass=(EditText)findViewById(R.id.et_pass2);
        btn_login=(Button)findViewById(R.id.btn_login);
        btn_signup=(Button)findViewById(R.id.btn_signup);
        btn_change=(Button)findViewById(R.id.btn_change);
        btn_exit=(Button)findViewById(R.id.btn_exit);


        btn_login.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent=getIntent();//이 다음 Toast
                person.id=intent.getStringExtra("id");
                person.pass=intent.getStringExtra("password");
                startActivity(intent);
                id=et_id.getText().toString();
                pass=et_pass.getText().toString();
                if (id.equals(person.id)&&pass.equals(person.pass)) {

                    Intent login = new Intent(MainActivity.this, messenger.class);
                    startActivity(login);
                    Toast.makeText(MainActivity.this, "로그인 성공", Toast.LENGTH_LONG).show();
                    }
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

        btn_change.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent change = new Intent(MainActivity.this, Change.class);
                startActivity(change);
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