package com.exemple.learnspace;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddCourseActivity extends AppCompatActivity {

    private EditText courseNameEditText, courseDescEditText;
    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_course);

        courseNameEditText = findViewById(R.id.inputCourseName);
        courseDescEditText = findViewById(R.id.inputCourseDesc);
        dbHelper = new DBHelper(this);

        findViewById(R.id.btnSave).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String courseName = courseNameEditText.getText().toString().trim();
                String courseDesc = courseDescEditText.getText().toString().trim();

                if (!courseName.isEmpty() && !courseDesc.isEmpty()) {
                    boolean success = dbHelper.insertCourse(courseName, courseDesc);
                    if (success) {
                        Toast.makeText(AddCourseActivity.this, "Course added successfully", Toast.LENGTH_SHORT).show();
                        finish(); // Close the AddCourseActivity
                    } else {
                        Toast.makeText(AddCourseActivity.this, "Failed to add course", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(AddCourseActivity.this, "Please enter course name and description", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
