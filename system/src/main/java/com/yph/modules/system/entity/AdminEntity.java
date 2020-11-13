package com.yph.modules.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author 
 * @since 2020-11-12
 */
@TableName("admin")
public class AdminEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "admin_id", type = IdType.AUTO)
    private Integer adminId;

    /**
     * 管理员名称
     */
    private String adminNikename;

    /**
     * 管理员登录账号
     */
    private String adminName;

    /**
     * 管理员密码
     */
    private String adminPassword;

    /**
     * 管理员级别
     */
    private String adminLevel;

    /**
     * 如果是代理身份,地区ID就是他所管理的地区 40000
     */
    private Integer regionId;

    /**
     * 表示上下级关系
     */
    private Integer adminBoss;

    /**
     * 地区名称
     */
    private String regionName;

    /**
     * 省
     */
    private Integer province;

    /**
     * 创建时间
     */
    private Date addTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    public Integer getAdminId() {
        return adminId;
    }

    public AdminEntity setAdminId(Integer adminId) {
        this.adminId = adminId;
        return this;
    }
    public String getAdminNikename() {
        return adminNikename;
    }

    public AdminEntity setAdminNikename(String adminNikename) {
        this.adminNikename = adminNikename;
        return this;
    }
    public String getAdminName() {
        return adminName;
    }

    public AdminEntity setAdminName(String adminName) {
        this.adminName = adminName;
        return this;
    }
    public String getAdminPassword() {
        return adminPassword;
    }

    public AdminEntity setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
        return this;
    }
    public String getAdminLevel() {
        return adminLevel;
    }

    public AdminEntity setAdminLevel(String adminLevel) {
        this.adminLevel = adminLevel;
        return this;
    }
    public Integer getRegionId() {
        return regionId;
    }

    public AdminEntity setRegionId(Integer regionId) {
        this.regionId = regionId;
        return this;
    }
    public Integer getAdminBoss() {
        return adminBoss;
    }

    public AdminEntity setAdminBoss(Integer adminBoss) {
        this.adminBoss = adminBoss;
        return this;
    }
    public String getRegionName() {
        return regionName;
    }

    public AdminEntity setRegionName(String regionName) {
        this.regionName = regionName;
        return this;
    }
    public Integer getProvince() {
        return province;
    }

    public AdminEntity setProvince(Integer province) {
        this.province = province;
        return this;
    }
    public Date getAddTime() {
        return addTime;
    }

    public AdminEntity setAddTime(Date addTime) {
        this.addTime = addTime;
        return this;
    }
    public Date getUpdateTime() {
        return updateTime;
    }

    public AdminEntity setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    @Override
    public String toString() {
        return "AdminEntity{" +
            "adminId=" + adminId +
            ", adminNikename=" + adminNikename +
            ", adminName=" + adminName +
            ", adminPassword=" + adminPassword +
            ", adminLevel=" + adminLevel +
            ", regionId=" + regionId +
            ", adminBoss=" + adminBoss +
            ", regionName=" + regionName +
            ", province=" + province +
            ", addTime=" + addTime +
            ", updateTime=" + updateTime +
        "}";
    }
}
