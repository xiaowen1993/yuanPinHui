package com.yph.util;

import java.math.BigDecimal;

/**
 * @author Agu
 */
public class BigDecimalUtil {




    public  static BigDecimal multiply(BigDecimal b1,BigDecimal b2){
        if (b1 ==null || b2 == null){
            return new BigDecimal("0");
        }
        BigDecimal bigDecimal = null;
        try {
            bigDecimal = b1.multiply(b2).setScale(2);
         }catch (ArithmeticException e){
        //小于0
            bigDecimal = new BigDecimal("0");
    }
        return bigDecimal;
    }


    public static BigDecimal divide100(Integer size){
        BigDecimal bigDecimal=new BigDecimal("100");
        BigDecimal bigDecimal1 = new BigDecimal(size + "");
        BigDecimal divide1 = bigDecimal1.divide(bigDecimal);
        return divide1;
    }


    public static BigDecimal multiply100(Integer size){
        BigDecimal bigDecimal=new BigDecimal("100");
        BigDecimal multiply = bigDecimal.multiply(new BigDecimal(size + ""));
        return multiply;
    }

    public static BigDecimal divide100(String size){
        BigDecimal bigDecimal=new BigDecimal("100");
        BigDecimal bigDecimal1 = new BigDecimal(size);
        BigDecimal divide1 = bigDecimal1.divide(bigDecimal);
        return divide1;
    }


    public static BigDecimal multiply100(String size){
        BigDecimal bigDecimal=new BigDecimal("100");
        BigDecimal multiply = bigDecimal.multiply(new BigDecimal(size));
        return multiply;
    }

}
