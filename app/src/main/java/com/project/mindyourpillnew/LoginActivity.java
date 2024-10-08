package com.project.mindyourpillnew;

import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.project.mindyourpillnew.databinding.ActivityLoginBinding;
import com.project.mindyourpillnew.entity.User;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {

    ActivityLoginBinding binding;
    private EditText email, password;
    private TextView signup;
    private Button loginButton;
    private UserRepository userRepository = new UserRepository();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        email = binding.txtEmail;
        password = binding.txtPassword;
        signup = binding.signupRedirect;
        loginButton = binding.btnLogin;

        loginButton.setOnClickListener(v -> {
            if(validateInput()) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                intent.putExtra("username", userRepository.getUser(email.getText().toString(), password.getText().toString()).getUsername());
                startActivity(intent);
                finish();
            }
        });

        signup.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
            startActivity(intent);
            finish();
        });
    }

    private boolean validateInput() {
        if (email.getText().toString().isEmpty() || password.getText().toString().isEmpty()) {
            email.setError("All fields must be filled");
            password.setError("All fields must be filled");
            return false;
        }

        if(!userRepository.checkUser(email.getText().toString(), password.getText().toString())){
            email.setError("Email not found or password is incorrect");
            return false;
        }
        return true;
    }
}