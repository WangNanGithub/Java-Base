package com.devil.effective.clone.deep;
public class Address implements Cloneable{  
      
    private String state;  
    private String province;  
    private String city;  
      
    public String getState() {  
        return state;  
    }  
    public void setState(String state) {  
        this.state = state;  
    }  
    public String getProvince() {  
        return province;  
    }  
    public void setProvince(String province) {  
        this.province = province;  
    }  
    public String getCity() {  
        return city;  
    }  
    public void setCity(String city) {  
        this.city = city;  
    }  
    @Override  
    public String toString() {  
        StringBuilder sb = new StringBuilder();  
        sb.append("国家：" + state + ", ");  
        sb.append("省：" + province + ", ");  
        sb.append("市：" + city);  
        return sb.toString();  
    }  
    public Address(String state, String province, String city) {  
        super();  
        this.state = state;  
        this.province = province;  
        this.city = city;  
    }  
    
    /**
	 * 浅度克隆，1.实现Cloneable接口 2.重载Object的clone方法
	 * 对于要克隆的对象，对于其基本数据类型的属性，复制一份给新产生的对象，对于非基本数据类型的属性，仅仅复制一份引用给新产生的对象，
	 * 即新产生的对象和原始对象中的非基本数据类型的属性都指向的是同一个对象
	 */
    @Override  
    public Address clone() {  
        Address address = null;  
        try {  
            address = (Address) super.clone();  
        } catch (CloneNotSupportedException e) {  
            e.printStackTrace();  
        }  
        return address;  
    }  
}