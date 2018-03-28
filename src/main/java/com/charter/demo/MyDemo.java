package com.charter.demo;

public class MyDemo {
    public static void main(String[] args) {
        UrlReader urlReader = new UrlReader();

        try {
            urlReader.readPage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
