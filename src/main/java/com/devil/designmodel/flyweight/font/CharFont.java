package com.devil.designmodel.flyweight.font;

public class CharFont extends Font {
    private String tchar;

    public CharFont(String tchar, String size, String color) {
        this.tchar = tchar;
        this.size = size;
        this.color = color;
    }

    @Override
    String createFont() {
        return "this is CharFont";
    }

    public String getTchar() {
        return tchar;
    }

    public void setTchar(String tchar) {
        this.tchar = tchar;
    }

}
