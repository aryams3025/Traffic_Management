package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button signupButton;
    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signupButton = findViewById(R.id.button4);
        loginButton = findViewById(R.id.button5);

        // set click listeners for the buttons
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // perform signup action here
                Intent intent = new Intent(MainActivity.this, SignUp.class);
                startActivity(intent);
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // perform login action here
                Intent intent = new Intent(MainActivity.this, Login.class);
                startActivity(intent);
            }
        });
    }

    public void signup(View view){
        Intent intent=new Intent(this,SignUp.class);
        startActivity(intent);
    }

    public void login(View view){
        Intent intent = new Intent(this,Login.class);
        startActivity(intent);
    }
}
