package com.exemple.learnspace;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.exemple.learnspace.R;

public class ProfileActivity extends AppCompatActivity {

    private TextView usernameTextView, emailTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        usernameTextView = findViewById(R.id.usernameTextView);
        emailTextView = findViewById(R.id.emailTextView);

        // Retrieve user data (this can be from a database or shared preferences)
        String username = "JohnDoe"; // Example static data
        String email = "john.doe@example.com"; // Example static data

        usernameTextView.setText(username);
        emailTextView.setText(email);
    }
}
