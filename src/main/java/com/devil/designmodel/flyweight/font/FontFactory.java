package com.devil.designmodel.flyweight.font;

import java.util.HashMap;
import java.util.Map;

public class FontFactory {
    private static Map<Integer, Font> numFont = new HashMap<Integer, Font>();
    private static Map<String, Font> charFont = new HashMap<String, Font>();

    public static NumberFont getNumFont(Integer num, String size, String color) {
        Font f = numFont.get(num);
        if (f == null || !f.getSize().equals(size) || !f.getColor().equals(color)) {
            f = new NumberFont(num, size, color);
            numFont.put(num, f);
        }
        return (NumberFont) f;
    }

    public static CharFont getCharFont(String tchar, String size, String color) {
        Font f = charFont.get(tchar);
        if (f == null || !f.getSize().equals(size) || !f.getColor().equals(color)) {
            f = new CharFont(tchar, size, color);
            charFont.put(tchar, f);
        }
        return (CharFont) f;
    }
}
