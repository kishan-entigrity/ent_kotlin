package com.mycpe.myappkot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView txtRedirect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtRedirect = (TextView) findViewById(R.id.txtRedirect);
        txtRedirect.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.txtRedirect:
//                Intent intent = new Intent(MainActivity.this, InputActivity.class);
                Intent intent = new Intent(MainActivity.this, InputActivityKot.class);
                startActivity(intent);
                break;
        }
    }
}