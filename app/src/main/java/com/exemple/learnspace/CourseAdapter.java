package com.exemple.learnspace;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class CourseAdapter extends ArrayAdapter<Course> {

    private Context context;
    private List<Course> courseList;

    public CourseAdapter(Context context, List<Course> courseList) {
        super(context, 0, courseList);
        this.context = context;
        this.courseList = courseList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.course_item, parent, false);
        }

        Course currentCourse = courseList.get(position);

        TextView courseName = convertView.findViewById(R.id.courseName);
        TextView courseDesc = convertView.findViewById(R.id.courseDesc);

        courseName.setText(currentCourse.getCourseName());
        courseDesc.setText(currentCourse.getCourseDesc());

        return convertView;
    }
}
