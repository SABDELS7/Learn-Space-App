package com.exemple.learnspace;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.exemple.learnspace.R;

public class CourseDetailsActivity extends AppCompatActivity {

    private TextView courseNameTextView, courseDescTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_details);

        courseNameTextView = findViewById(R.id.courseNameTextView);
        courseDescTextView = findViewById(R.id.courseDescTextView);

        // Retrieve the course info passed through the Intent
        String courseName = getIntent().getStringExtra("course_name");
        String courseDesc = getIntent().getStringExtra("course_desc");

        courseNameTextView.setText(courseName);
        courseDescTextView.setText(courseDesc);
    }
}
