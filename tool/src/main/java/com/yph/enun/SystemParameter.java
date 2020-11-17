package com.yph.enun;

import java.math.BigDecimal;

/**
 * @author Agu
 */
public class SystemParameter {


    //生命源转换能量源的比率
    public   static BigDecimal LifeSourceToEEnergyRate = new BigDecimal("0.01");

    //直推
    public  static  BigDecimal directPush = new BigDecimal("0.3");
   //  间推
    public  static  BigDecimal indirectPush = new BigDecimal("0.1");

}
