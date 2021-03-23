package com.example.third;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void change(View view){
        TextView Id=(TextView)findViewById(R.id.textView);
        TextView Password = (TextView) findViewById(R.id.textView2);
        Id.setText("An Sung Won");
        Password.setText("123456789");
    }

    public void reset(View view){
        TextView Id=(TextView)findViewById(R.id.textView);
        TextView Password = (TextView)findViewById(R.id.textView2);
        Id.setText("ID");
        Password.setText("PASSWORD");
    }

}