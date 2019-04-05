package com.cmartin.learn;

public class MyJavaImplementation implements MyJavaInterface {
    @Override
    public Integer convertStringToInteger(String s) throws NumberFormatException {
        return Integer.parseInt(s);
    }
}
