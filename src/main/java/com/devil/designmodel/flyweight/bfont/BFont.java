package com.devil.designmodel.flyweight.bfont;

public class BFont implements Font {
    private String tchar;

    public BFont(String tchar) {
        this.tchar = tchar;
    }

    @Override
    public String createFont() {
        return "this is a SizeFont";
    }

    public String getTchar() {
        return tchar;
    }

    public void setTchar(String tchar) {
        this.tchar = tchar;
    }

}
