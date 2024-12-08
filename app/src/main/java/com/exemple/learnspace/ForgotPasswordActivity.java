package com.exemple.learnspace;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class ForgotPasswordActivity extends AppCompatActivity {
    EditText email, newPassword, confirmPassword;
    Button resetPasswordButton;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        email = findViewById(R.id.editTextEmail);
        newPassword = findViewById(R.id.editTextNewPassword);
        confirmPassword = findViewById(R.id.editTextConfirmPassword);
        resetPasswordButton = findViewById(R.id.buttonResetPassword);
        dbHelper = new DBHelper(this);

        resetPasswordButton.setOnClickListener(v -> {
            String mail = email.getText().toString();
            String newPass = newPassword.getText().toString();
            String confirmPass = confirmPassword.getText().toString();

            if (mail.isEmpty() || newPass.isEmpty() || confirmPass.isEmpty()) {
                Toast.makeText(ForgotPasswordActivity.this, "All fields are required", Toast.LENGTH_SHORT).show();
            } else if (!newPass.equals(confirmPass)) {
                Toast.makeText(ForgotPasswordActivity.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
            } else if (!dbHelper.checkEmail(mail)) {
                Toast.makeText(ForgotPasswordActivity.this, "Email not found", Toast.LENGTH_SHORT).show();
            } else {
                boolean update = dbHelper.updatePassword(mail, newPass);
                if (update) {
                    Toast.makeText(ForgotPasswordActivity.this, "Password Reset Successful", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(ForgotPasswordActivity.this, "Password Reset Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
