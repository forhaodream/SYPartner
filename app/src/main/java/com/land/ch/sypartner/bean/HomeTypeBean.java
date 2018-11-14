package com.land.ch.sypartner.bean;

/**
 * Created by CH
 * on 2018/10/16 16:23
 */
public class HomeTypeBean {


    private String title;
    private int img;

    public HomeTypeBean(String title, int img) {
        this.title = title;
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

}
