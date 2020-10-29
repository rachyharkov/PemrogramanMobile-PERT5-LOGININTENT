package com.projectpertama.latihanalertdialogtoast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.annotation.Nullable;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnToast, btnAlert, btnLayouting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setContentView(R.layout.activity_main);
        btnToast = (Button) findViewById(R.id.btntoast);
        btnAlert = (Button) findViewById(R.id.btnalert);
        btnLayouting = (Button) findViewById(R.id.btnlayouting);

        btnToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Ini Toast", Toast.LENGTH_LONG).show();
            }
        });
        btnAlert.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btntoast) {

        } else if (v.getId() == R.id.btnalert) {
            Intent intenalert = new Intent(this, AlertActivity.class);
            startActivity(intenalert);

        }
    }

    public void menujulogin(View vi) {
        startActivity( new Intent(this, LayoutingActivity.class));
    }
}