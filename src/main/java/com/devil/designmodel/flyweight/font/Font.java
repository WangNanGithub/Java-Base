package com.devil.designmodel.flyweight.font;

public abstract class Font {
    String size;
    String color;

    abstract String createFont();

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

}
