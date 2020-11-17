package com.yph.modules.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 行政区域表
 * </p>
 *
 * @author LC
 * @since 2020-11-12
 */
@TableName("region")
public class RegionEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer areaId;

    /**
     * 行政区域名称
     */
    private String areaName;

    /**
     * 行政区域父ID，例如区县的pid指向市，市的pid指向省，省的pid则是0
     */
    private Integer parentId;

    /**
     * 行政区域类型，如如1则是省， 如果是2则是市，如果是3则是区县
     */
    private Integer level;

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "RegionEntity{" +
                "areaId=" + areaId +
                ", areaName='" + areaName + '\'' +
                ", parentId=" + parentId +
                ", level=" + level +
                '}';
    }
}
