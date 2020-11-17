package com.yph.entity;

/**
 * @author Agu
 */
public class AllocationDto {

    //用户ID
    private Integer userId;

    //静态业绩 (本次产生的)
    private Long energySource;

    //用户级别
    private  Integer userLevel;


    public AllocationDto(){

    }

    public AllocationDto(Integer userId, Long energySource, Integer userLevel) {
        this.userId = userId;
        this.energySource = energySource;
        this.userLevel = userLevel;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Long getEnergySource() {
        return energySource;
    }

    public void setEnergySource(Long energySource) {
        this.energySource = energySource;
    }

    public Integer getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(Integer userLevel) {
        this.userLevel = userLevel;
    }
}
