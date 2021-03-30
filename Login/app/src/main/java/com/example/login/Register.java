package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    EditText et_id, et_pass;
    Button btn_signin;
    String str1, str2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        et_id=(EditText)findViewById(R.id.et_id);
        et_pass=(EditText)findViewById(R.id.et_pass);
        btn_signin = (Button)findViewById(R.id.btn_signin);

        btn_signin.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                str1=et_id.getText().toString();
                str2=et_id.getText().toString();
                Intent intent =new Intent(Register.this, MainActivity.class);
                intent.putExtra("id", str1);
                intent.putExtra("password", str2);
                startActivity(intent);
                Toast.makeText(Register.this,"회원 등록 완료", Toast.LENGTH_LONG).show();
            }

        });

    }
}



