package com.example.haitm.sqlitedemo;


public class SinhVien {
    public int id;
    public String fullName="";
    public String studentID="";
    public int gender = 0;
    public int year = 0;

    public SinhVien(String fullName, String studentID, int gender, int year) {
        this.fullName = fullName;
        this.studentID = studentID;
        this.gender = gender;
        this.year = year;
    }
    public SinhVien(int id, String fullName, String studentID, int gender, int year) {
        this.id = id;
        this.fullName = fullName;
        this.studentID = studentID;
        this.gender = gender;
        this.year = year;
    }
}
