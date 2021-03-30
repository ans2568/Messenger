package com.example.android;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.android.ui.login.LoginActivity;

public class MainActivity extends AppCompatActivity {
    final Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("gilbut", "onCreate");
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

    public void sendMessage(View view){
        TextView tv =(TextView)findViewById(R.id.textView);
        tv.setText("Hi!");
    }

    public void go_Sign_up(View view){
        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(intent);
    }


    public void sendMessage3(View view){
        getSupportFragmentManager().beginTransaction().add(R.id.item_container, new BlankFragment()).commit();
    }

    public void go(View view){
        dialog();
    }
}