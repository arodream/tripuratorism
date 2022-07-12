package com.arodream.tripuratourism.model;

public class Image {
    int img;
    String detail;
    String category;

    public Image(int img, String detail, String category) {
        this.img = img;
        this.detail = detail;
        this.category = category;

    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getCategory(){
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
