package com.exemple.learnspace;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.exemple.learnspace.AddCourseActivity;
import com.exemple.learnspace.Course;
import com.exemple.learnspace.CourseAdapter;
import com.exemple.learnspace.DBHelper;
import com.exemple.learnspace.R;

import java.util.ArrayList;

public class DashboardActivity extends AppCompatActivity {

    private ListView courseListView;
    private DBHelper dbHelper;
    private ArrayList<Course> courseList;
    private CourseAdapter courseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        courseListView = findViewById(R.id.courseListView);
        dbHelper = new DBHelper(this);
        courseList = new ArrayList<>();

        // Fetch all courses from the database
        Cursor cursor = dbHelper.getAllCourses();
        if (cursor != null) {
            while (cursor.moveToNext()) {
                int courseId = cursor.getInt(cursor.getColumnIndex("course_id"));
                String courseName = cursor.getString(cursor.getColumnIndex("course_name"));
                String courseDesc = cursor.getString(cursor.getColumnIndex("course_desc"));
                Course course = new Course(courseId, courseName, courseDesc);
                courseList.add(course);
            }
            cursor.close();
        }

        // Set the adapter for the ListView
        courseAdapter = new CourseAdapter(this, courseList);
        courseListView.setAdapter(courseAdapter);

        // On item click listener for course list
        courseListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Course selectedCourse = courseList.get(position);
                Toast.makeText(DashboardActivity.this, "Selected: " + selectedCourse.getCourseName(), Toast.LENGTH_SHORT).show();
            }
        });

        // Add new course button
        findViewById(R.id.btnAddCourse).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this, AddCourseActivity.class);
                startActivity(intent);
            }
        });
    }
}
