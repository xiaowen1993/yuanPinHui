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
            bigDecimal = b1.multiply(b2).setScale(0);
         }catch (ArithmeticException e){
        //小于0
            bigDecimal = new BigDecimal("0");
    }
        return bigDecimal;
    }


}
