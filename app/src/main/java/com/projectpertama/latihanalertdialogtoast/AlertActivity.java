package com.projectpertama.latihanalertdialogtoast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AlertActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnAlert1,btnAlert2,btnAlert3;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert);

        btnAlert1 = findViewById(R.id.btnalert1);
        btnAlert2 = findViewById(R.id.btnalert2);
        btnAlert3 = findViewById(R.id.btnalert3);

        btnAlert1.setOnClickListener(this);
        btnAlert2.setOnClickListener(this);
        btnAlert3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnalert1:
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Maaf Halaman ini Belum Tersedia");
                builder.setMessage("Ini Pesan");
                builder.setNeutralButton("Tutup", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.show();
                break;
            case R.id.btnalert2:
                AlertDialog.Builder builder1 = new AlertDialog.Builder(context);
                builder1.setTitle("Are you sure want to exit?");
                builder1.setMessage("Anda akan keluar");
                builder1.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                builder1.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder1.show();
                break;
            case R.id.btnalert3:
                AlertDialog.Builder builder2 = new AlertDialog.Builder(context);
                builder2.setTitle("Warning");
                builder2.setMessage("Are you sure really want to Exit?");
                builder2.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                builder2.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder2.setNeutralButton("Cabcek", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                        Toast.makeText(AlertActivity.this, "Anda Menekan tombol Cancel", Toast.LENGTH_LONG).show();
                    }
                });
                builder2.show();
                break;
        }
    }
}