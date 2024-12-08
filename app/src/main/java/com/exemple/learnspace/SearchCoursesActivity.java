package com.exemple.learnspace;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SearchCoursesActivity extends AppCompatActivity {

    private EditText searchEditText;
    private ListView searchListView;
    private CourseAdapter courseAdapter;
    private ArrayList<Course> allCourses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_courses);

        searchEditText = findViewById(R.id.searchEditText);
        searchListView = findViewById(R.id.searchListView);

        allCourses = new ArrayList<>();
        // Fetch all courses from the database or static data (use DBHelper in real implementation)
        allCourses.add(new Course(1, "Java Basics", "Learn the basics of Java"));
        allCourses.add(new Course(2, "Advanced Java", "Master Java programming"));

        courseAdapter = new CourseAdapter(this, allCourses);
        searchListView.setAdapter(courseAdapter);

        searchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
                filterCourses(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {}
        });
    }

    private void filterCourses(String query) {
        ArrayList<Course> filteredList = new ArrayList<>();
        for (Course course : allCourses) {
            if (course.getCourseName().toLowerCase().contains(query.toLowerCase()) ||
                    course.getCourseDesc().toLowerCase().contains(query.toLowerCase())) {
                filteredList.add(course);
            }
        }
        courseAdapter.clear();
        courseAdapter.addAll(filteredList);
        courseAdapter.notifyDataSetChanged();
    }
}
