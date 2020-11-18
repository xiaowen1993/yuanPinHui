package com.yph.enun;

import com.yph.util.BigDecimalUtil;

import java.math.BigDecimal;

/**
 * @author Agu
 */
public enum ZoneRate {

    shen(1,new BigDecimal("0.03")),shi(2,new BigDecimal("0.02")),qu(3,new BigDecimal("0.01"));

    private  int level;

    private BigDecimal rate;

    ZoneRate(int level, BigDecimal rate) {
        this.level = level;
        this.rate = rate;
    }


    public  static  ZoneRate getZone(int level){
        for (ZoneRate value : values()) {
            if (value.getLevel()==level){
                return value;
            }
        }
        return null;
    }


    public BigDecimal getCurrency(Long l, BigDecimal lo) {
        return getCurrency(new BigDecimal(l.toString()), lo);
    }


    public BigDecimal getCurrency(BigDecimal bigDecimal, BigDecimal lo) {
        return BigDecimalUtil.multiply(bigDecimal, this.rate.subtract(lo));
    }


    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }
}
