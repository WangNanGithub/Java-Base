package com.devil.effective.annotation.inherited;

public class MyChildObjOld implements MyParentObj {
    public boolean isInherited() {
        return false;
    }

    public String doSomething() {
        return "";
    }

    public boolean equals(Object obj) {
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        return "";
    }

    public Class annotationType() {
        return null;
    }
}