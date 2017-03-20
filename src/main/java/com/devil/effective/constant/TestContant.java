package com.devil.effective.constant;

import java.util.EnumMap;

import org.junit.Test;

public class TestContant {

    @Test
    public void testclass() {
        // 使用内部类来分层，数据访问变得复杂
        String str = new ConstantClass().new Phone().new JsonContent().DEFAULT;
        System.out.println(str);
    }

    @Test
    public void testinterface() {
        // 使用接口，访问看起来比较简单
        String str = ConstantInterface.Phone.JsonContent.DEFAULT;
        System.out.println(str);
    }

    @Test
    public void testenum() {
        // 使用枚举更加方便
        String str = Color.RED.toString();
        System.out.println(str);
        String ss = Color.InColor.BLACK.toString();
        System.out.println(ss);
    }

    @Test
    public void testMap() {
        EnumMap<Color, String> weekMap = new EnumMap<Color, String>(Color.class);
        for (Color color : weekMap.keySet()) {
            System.out.println(color.toString());
        }
    }
}
