package com.yaytech.webelement;

public class ForTest {
    public static void main(String[] args) {
        a:
        for (int i = 0 ; i<10 ; i++){
            b:
            for (int j = 0; j<10; j++){
                System.out.println("hi"+j);
                if(j==5)
                    break a;
            }
        }
    }
}
