package com.yaytech.util;

public enum BrowserEnum {
    CHROME("chrome"), IE("ie"), FIREFOX("firefox"),CHROME_HEADLESS("chrome-headless"),
    EDGE("edge"),SAFARI("safari"), OPERA("opera");

    private String name;


    BrowserEnum(String browserName) {
        this.name = browserName;
    }

    public static BrowserEnum getValue(String value){
        for(BrowserEnum browser: values()){
            if(browser.name.equals(value)){
                return browser;
            }
        }
        throw new IllegalArgumentException("invalid browser name: "+ value);
    }



}
