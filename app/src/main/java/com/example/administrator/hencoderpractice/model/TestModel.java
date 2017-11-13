package com.example.administrator.hencoderpractice.model;

/**
 * Created by Administrator on 2017/11/7.
 */

public class TestModel {
    private String name, title, img_url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public TestModel() {
    }

    public TestModel(String name, String title, String img_url) {
        this.name = name;
        this.title = title;
        this.img_url = img_url;
    }
}
