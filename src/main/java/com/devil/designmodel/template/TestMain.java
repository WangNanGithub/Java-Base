package com.devil.designmodel.template;

public class TestMain {
    public static void main(String[] args) {
        System.out.println("泡咖啡");
        Beverage coffee = new Coffee();
        coffee.prepareRecipe();
        System.out.println("泡柠檬绿茶");
        Beverage tea = new Tea();
        tea.prepareRecipe();
    }
}
