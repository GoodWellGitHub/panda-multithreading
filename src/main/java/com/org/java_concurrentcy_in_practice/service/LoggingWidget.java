package com.org.java_concurrentcy_in_practice.service;

public class LoggingWidget extends Widget {
    public synchronized void dosomething() {
        System.out.println("LogingWight do something ");
        super.dosomething();
    }
}
