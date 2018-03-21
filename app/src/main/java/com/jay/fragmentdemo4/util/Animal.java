package com.jay.fragmentdemo4.util;

/**
 * Created by zhangguangpeng on 2018/3/14.
 */

public class Animal {

    private String aName;
    private String aSpeak;
    private int aIcon;

    public Animal() {

    }

    public Animal(String aName, String aSpeak, int aIcon) {
        this.aName = aName;
        this.aSpeak = aSpeak;
        this.aIcon = aIcon;
    }

    public void setaName(String aName) {
        this.aName = aName;
    }

    public String getaName() {
        return aName;
    }

    public void setaIcon(int aIcon) {
        this.aIcon = aIcon;
    }

    public int getaIcon() {
        return aIcon;
    }

    public void setaSpeak(String aSpeak) {
        this.aSpeak = aSpeak;
    }

    public String getaSpeak() {
        return aSpeak;
    }
}
