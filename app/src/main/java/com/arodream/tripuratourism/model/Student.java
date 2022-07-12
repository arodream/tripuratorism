package com.arodream.tripuratourism.model;

public class Student {
    int img;
    String name;
    String work;
    String detail;


    public Student(int img, String name, String work ,String detail) {
        this.img = img;
        this.name = name;
        this.work = work;
        this.detail = detail;

    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

}
