package com.example.cryptobank.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.cryptobank.R;

public class LoginActivity extends AppCompatActivity {
    private EditText userEdt,passEdt;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        initView();
        setVariable();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    private void initView()
    {
        userEdt=findViewById(R.id.editTextText);
        passEdt=findViewById(R.id.editTextTextPassword);
        btnLogin=findViewById(R.id.btnLogin);
    }
    private void setVariable()
    {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(userEdt.getText().toString().isEmpty() || passEdt.getText().toString().isEmpty())
                {
                    Toast.makeText(LoginActivity.this, "Please fill the login form", Toast.LENGTH_SHORT).show();
                }
                else if (userEdt.getText().toString().equals("admin")&& passEdt.getText().toString().equals("admin"))
                {
                    Toast.makeText(LoginActivity.this, "SUCCESSFULLY LOGIN!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LoginActivity.this,MainActivity.class));
                }
                else
                {
                    Toast.makeText(LoginActivity.this, "Incorrect Username and Password!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}