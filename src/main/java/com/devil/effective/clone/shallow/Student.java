package com.devil.effective.clone.shallow;

/**
 * 
 *
 * @author yuansheng
 * @version 1.0.0
 */
public class Student implements Cloneable {
    private String[] classNames;
    private int id;
    private String name;
    private StringBuffer sport;
    private static final int CARD_ID = 120080;

    /**
     * 
     * {@inheritDoc}
     * 
     * @author yuansheng
     * @version 1.0.0
     */
    @Override
    public Student clone() {
        Student student = null;
        try {
            student = (Student) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return student;
    }

    /**
     * 
     * {@inheritDoc}
     * 
     * @author yuansheng
     * @version 1.0.0
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("姓名：" + name + ",");
        sb.append("ID：" + id + ", ");
        sb.append("CARD_ID：" + CARD_ID + ",");
        sb.append("运动：" + sport + ",");
        sb.append("课程：");
        for (String string : classNames) {
            sb.append(string);
        }
        return sb.toString();
    }

    public StringBuffer getSport() {
        return sport;
    }

    public void setSport(StringBuffer sport) {
        this.sport = sport;
    }

    public String[] getClassNames() {
        return classNames;
    }

    public void setClassNames(String[] classNames) {
        this.classNames = classNames;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static int getCardId() {
        return CARD_ID;
    }

}
