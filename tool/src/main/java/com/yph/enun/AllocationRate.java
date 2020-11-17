package com.yph.enun;

import com.yph.util.BigDecimalUtil;

import java.math.BigDecimal;

/**
 * @author Agu
 */
public enum AllocationRate {


    CASE1(1, new BigDecimal("0.08"), new BigDecimal("0.01")),
    CASE2(2, new BigDecimal("0.13"), new BigDecimal("0.01")),
    CASE3(3, new BigDecimal("0.17"), new BigDecimal("0.01")),
    CASE4(4, new BigDecimal("0.21"), new BigDecimal("0.01")),
    CASE5(5, new BigDecimal("0.24"), new BigDecimal("0.01")),
    CASE6(6, new BigDecimal("0.27"), new BigDecimal("0.01"));

    //当前级别
    private Integer level;
    //当前比率
    private BigDecimal rate;
    //平级奖励
    private BigDecimal peers;

    AllocationRate(Integer level, BigDecimal rate, BigDecimal peers) {
        this.level = level;
        this.rate = rate;
        this.peers = peers;
    }


    public static AllocationRate getCase(Integer i) {
        for (AllocationRate value : values()) {
            if (value.level == i) {
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

    public BigDecimal getPeers(Long l) {
        return getPeers(new BigDecimal(l.toString()));
    }


    public BigDecimal getPeers(BigDecimal bigDecimal) {

        return BigDecimalUtil.multiply(bigDecimal, this.peers);
    }

    //peers

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public BigDecimal getPeers() {
        return peers;
    }

    public void setPeers(BigDecimal peers) {
        this.peers = peers;
    }
}
