package com.org.java_concurrentcy_in_practice.service;

public class Widget {
    public synchronized void dosomething(){
        System.out.println("widget do something!");
    }
}
