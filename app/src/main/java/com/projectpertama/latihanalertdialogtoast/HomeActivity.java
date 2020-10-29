package com.projectpertama.latihanalertdialogtoast;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    //membuat variabel

    Button btnLogout;
    TextView tvUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnLogout = findViewById(R.id.btnlogout);
        tvUsername = findViewById(R.id.tv_homeusername);
        String usernameText = getIntent().getStringExtra("USERNAME");
        tvUsername.setText(usernameText);

        //Mengirim data ke LayoutActivity dengan menggunakan ActivityForResult

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(HomeActivity.this);

                //set Dialog
                dialog.setTitle("Logout");

                //set pesan dialog
                dialog.setMessage("Klik Yes untuk Keluar")
                        .setIcon(R.drawable.ic_baseline_arrow_downward_24)
                        .setCancelable(true) //klik diluar alert maka ke cancel
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        })
                        //Menampilkan toast yang akan ditampilkan di layoutActivity
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int i) {
                                Intent data = new Intent();
                                data.putExtra("key_logout", "Anda telah logout, silahkan login lagi");
                                setResult(Activity.RESULT_OK,data);
                                finish();
                            }
                        });
                dialog.show();
            }
        });
    }
}