package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Change extends AppCompatActivity {

    EditText et_id, et_pass;
    Button btn_change, btn_cancel;
    String str1, str2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change);

        et_id=(EditText)findViewById(R.id.et_id3);
        et_pass=(EditText)findViewById(R.id.et_pass3);
        btn_change = (Button)findViewById(R.id.btn_change2);
        btn_cancel = (Button)findViewById(R.id.btn_cancel3);

        btn_change.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                str1=et_id.getText().toString();
                str2=et_pass.getText().toString();
                Intent intent =new Intent(Change.this, MainActivity.class);
                intent.putExtra("id", str1);
                intent.putExtra("password", str2);
                startActivity(intent);
                Toast.makeText(Change.this,"회원 변경 완료", Toast.LENGTH_LONG).show();
            }

        });

        btn_cancel.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent cancel = new Intent(Change.this, MainActivity.class);
                startActivity(cancel);
            }
        });
    }
}







