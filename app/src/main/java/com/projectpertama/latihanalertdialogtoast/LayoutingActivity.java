package com.projectpertama.latihanalertdialogtoast;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class LayoutingActivity extends AppCompatActivity implements View.OnClickListener {

    //membuat variabel
    Button btnLogin;
    EditText tbUsername, tbPassword;
    TextView tvRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layouting);

        //inisialisasi variabel
        btnLogin = findViewById(R.id.btnlogin);
        tbUsername = findViewById(R.id.tbusername);
        tbPassword = findViewById(R.id.tbpassword);
        tvRegister = findViewById(R.id.tvregister);

        btnLogin.setOnClickListener(this);
        tvRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnlogin:
                //handling login

                String username = tbUsername.getText().toString();
                String password = tbPassword.getText().toString();

                //membuat kondisi error

                if (username.length() < 6 ) {
                    tbUsername.setError("Username harus lebih dari 6 Charackter");
                } else if (password.length() < 6) {
                    tbPassword.setError("Password harus lebih dari 6 Charackter");
                } else {
                    Intent intenHome = new Intent(LayoutingActivity.this, HomeActivity.class);
                    intenHome.putExtra("USERNAME", username);
                    startActivityForResult(intenHome, 2);
                }
                break;
            case R.id.tvregister:
                //handling register
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 2) {
            if (resultCode == RESULT_OK) {
                String result = data.getStringExtra("key_logout");
                Toast.makeText(this, result, Toast.LENGTH_SHORT).show();

                //MEMBUAT PASSWORD
                tbPassword.setText("");
                tbUsername.setText("");
            }
        }
    }
}