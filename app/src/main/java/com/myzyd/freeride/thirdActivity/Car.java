package com.myzyd.freeride.thirdActivity;

/**
 * Created by xiehehe on 15/8/20.
 */
public class Car {

    private int id;//ID
    private String name;//菜名
    private int imgId;//图片
    private String danjia;//单价
    private double price;//价格
    private String unit;//单位
    private String all;//合计
    private double allPrice;//总价

    //ID
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //菜名
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //图片
    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    //单价
    public String getDanjia() {
        return danjia;
    }

    public void setDanjia(String danjia) {
        this.danjia = danjia;
    }

    //价格
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    //单位
    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit= unit;
    }

    //合计
    public String getAll() {
        return all;
    }

    public void setAll(String all) {
        this.all= all;
    }

    //总价
    public double getAllPrice() {
        return allPrice;
    }

    public void setAllPrice(double allPrice) {
        this.allPrice = allPrice;
    }
}
