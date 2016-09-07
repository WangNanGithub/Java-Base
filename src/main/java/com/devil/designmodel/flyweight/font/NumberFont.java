package com.devil.designmodel.flyweight.font;

public class NumberFont extends Font {
    private Integer num;

    public NumberFont(Integer num, String size, String color) {
        this.num = num;
        this.size = size;
        this.color = color;
    }

    @Override
    String createFont() {
        return "this is NumberFont";
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

}
