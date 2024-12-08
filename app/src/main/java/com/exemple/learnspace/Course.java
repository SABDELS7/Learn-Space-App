package com.exemple.learnspace;

public class Course {
    private int courseId;
    private String courseName;
    private String courseDesc;

    // Constructor
    public Course(int courseId, String courseName, String courseDesc) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseDesc = courseDesc;
    }

    // Getters and Setters
    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseDesc() {
        return courseDesc;
    }

    public void setCourseDesc(String courseDesc) {
        this.courseDesc = courseDesc;
    }
}
