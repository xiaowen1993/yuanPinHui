package com.grpc.enun;

import com.grpc.GrpcParameter;

/**
 * @author Agu
 */
public enum NumberThresholdValue {

    ONE(300,0,100),TOW(100,100,1000),THREE(50,1000,2000),FOUR(20,2000,Long.MAX_VALUE);


    private  long time;

    private long begin;

    private  long end;

    NumberThresholdValue(long time, long begin, long end) {
        this.time = time;
        this.begin = begin;
        this.end = end;
    }

    public  static   long getTimeMs(long number){
        for (NumberThresholdValue value : values()) {
            if (value.begin<=number&&value.end>number){
                return value.time;
            }
        }
        return GrpcParameter.defaultTime;
    }


    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public long getBegin() {
        return begin;
    }

    public void setBegin(long begin) {
        this.begin = begin;
    }

    public long getEnd() {
        return end;
    }

    public void setEnd(long end) {
        this.end = end;
    }
}
