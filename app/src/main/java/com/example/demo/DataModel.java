package com.example.demo;

public class DataModel {
    String strLang;
    int imgData;

    public DataModel(String strLang, int imgData) {

        this.strLang=strLang;
        this.imgData=imgData;
    }

    public String getStrLang() {
        return strLang;
    }

    public void setStrLang(String strLang) {
        this.strLang = strLang;
    }

    public int getImgData() {
        return imgData;
    }

    public void setImgData(int imgData) {
        this.imgData = imgData;
    }
}
