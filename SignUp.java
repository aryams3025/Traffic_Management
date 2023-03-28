package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.vishnusivadas.advanced_httpurlconnection.PutData;

public class SignUp extends AppCompatActivity {

    EditText fullNameEditText, emailEditText, usernameEditText, passwordEditText;
    Button signUpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        fullNameEditText = findViewById(R.id.fullname);
        emailEditText = findViewById(R.id.email);
        usernameEditText = findViewById(R.id.username);
        passwordEditText = findViewById(R.id.password);

        signUpButton = findViewById(R.id.button22);
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fullName = fullNameEditText.getText().toString().trim();
                String email = emailEditText.getText().toString().trim();
                String username = usernameEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();

                if (fullName.isEmpty()) {
                    Toast.makeText(SignUp.this, "Please enter your full name", Toast.LENGTH_SHORT).show();
                } else if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    Toast.makeText(SignUp.this, "Please enter a valid email address", Toast.LENGTH_SHORT).show();
                } else if (username.isEmpty()) {
                    Toast.makeText(SignUp.this, "Please enter a username", Toast.LENGTH_SHORT).show();
                } else if (password.isEmpty() || password.length() < 6) {
                    Toast.makeText(SignUp.this, "Password should be at least 6 characters long", Toast.LENGTH_SHORT).show();
                } else {
                    //Starting Write and Read data with URL
                    //Creating array for parameters
                    String[] field = new String[4];
                    field[0] = "fullname";
                    field[1] = "username";
                    field[2] = "email";
                    field[3] = "password";
                    //Creating array for data
                    String[] data = new String[4];
                    data[0] = fullName;
                    data[1] = username;
                    data[2] = email;
                    data[3] = password;

                    //Start ProgressBar first (Set visibility VISIBLE)
                    Handler handler = new Handler(Looper.getMainLooper());
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            PutData putData = new PutData("https://projects.vishnusivadas.com/AdvancedHttpURLConnection/putDataTest.php", "POST", field, data);
                            if (putData.startPut()) {
                                if (putData.onComplete()) {
                                    String result = putData.getResult();
                                    //End ProgressBar (Set visibility to GONE)
                                    Log.i("PutData", result);
                                }
                            }
                        }
                    });

                    // TODO: Perform sign up action
                    Intent intent = new Intent(SignUp.this, Login.class);
                    startActivity(intent);
                }
            }
        });
    }
}
