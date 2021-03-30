package com.example.registerloginexample;

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

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {
    final Context context = this;
    private EditText et_id, et_pass;
    private Button btn_login, btn_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Log.i("gilbut", "onCreate");


        et_id =findViewById(R.id.et_id);
        et_pass =findViewById(R.id.et_pass);
        btn_login =findViewById(R.id.btn_login);
        btn_register =findViewById(R.id.btn_register);

        btn_register.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });


        btn_login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String userID = et_id.getText().toString();
                String userPass = et_pass.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");
                            if(success){//로그인 성공
                                String ueserID = jsonObject.getString("userID");
                                String ueserPass = jsonObject.getString("userPassword");
                                Toast.makeText(getApplicationContext(), "로그인 성공!",Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                intent.putExtra("userID",userID);
                                intent.putExtra("userPass",userPass);
                                startActivity(intent);
                            }
                            else{//로그인 실패
                                Toast.makeText(getApplicationContext(), "로그인 실패ㅠㅠ",Toast.LENGTH_SHORT).show();
                                return;
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                LoginRequest loginRequest = new LoginRequest(userID, userPass, responseListener);
                RequestQueue queue = Volley.newRequestQueue(LoginActivity.this);
                queue.add(loginRequest);
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
                        LoginActivity.this.finish();
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