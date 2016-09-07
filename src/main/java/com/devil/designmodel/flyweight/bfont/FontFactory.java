package com.devil.designmodel.flyweight.bfont;

import java.util.HashMap;
import java.util.Map;

public class FontFactory {
    private static Map<String, Font> fonts = new HashMap<String, Font>();

    public static Font getFont(String tchar) {
        Font font = fonts.get(tchar);
        if (font == null) {
            font = new BFont(tchar);
            fonts.put(tchar, font);
        }
        return font;
    }

}
