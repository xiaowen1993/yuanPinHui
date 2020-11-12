package com.yph.modules.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import java.io.Serializable;

/**
 * <p>
 * 字典类型表
 * </p>
 *
 * @author 
 * @since 2020-11-12
 */
@TableName("sys_dict_type")
public class SysDictTypeEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 字典类型id
     */
    private Integer dictTypeId;

    /**
     * 字典类型编码
     */
    private String code;

    /**
     * 字典类型名称
     */
    private String name;

    /**
     * 字典描述
     */
    private String description;

    /**
     * 是否是系统字典，1-是，0-否
     */
    private Long systemFlag;

    /**
     * 状态(字典)
     */
    private String status;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 添加时间
     */
    private Date createTime;

    /**
     * 创建人
     */
    private Long createUser;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 修改人
     */
    private Long updateUser;

    public Integer getDictTypeId() {
        return dictTypeId;
    }

    public SysDictTypeEntity setDictTypeId(Integer dictTypeId) {
        this.dictTypeId = dictTypeId;
        return this;
    }
    public String getCode() {
        return code;
    }

    public SysDictTypeEntity setCode(String code) {
        this.code = code;
        return this;
    }
    public String getName() {
        return name;
    }

    public SysDictTypeEntity setName(String name) {
        this.name = name;
        return this;
    }
    public String getDescription() {
        return description;
    }

    public SysDictTypeEntity setDescription(String description) {
        this.description = description;
        return this;
    }
    public Long getSystemFlag() {
        return systemFlag;
    }

    public SysDictTypeEntity setSystemFlag(Long systemFlag) {
        this.systemFlag = systemFlag;
        return this;
    }
    public String getStatus() {
        return status;
    }

    public SysDictTypeEntity setStatus(String status) {
        this.status = status;
        return this;
    }
    public Integer getSort() {
        return sort;
    }

    public SysDictTypeEntity setSort(Integer sort) {
        this.sort = sort;
        return this;
    }
    public Date getCreateTime() {
        return createTime;
    }

    public SysDictTypeEntity setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }
    public Long getCreateUser() {
        return createUser;
    }

    public SysDictTypeEntity setCreateUser(Long createUser) {
        this.createUser = createUser;
        return this;
    }
    public Date getUpdateTime() {
        return updateTime;
    }

    public SysDictTypeEntity setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
        return this;
    }
    public Long getUpdateUser() {
        return updateUser;
    }

    public SysDictTypeEntity setUpdateUser(Long updateUser) {
        this.updateUser = updateUser;
        return this;
    }

    @Override
    public String toString() {
        return "SysDictTypeEntity{" +
            "dictTypeId=" + dictTypeId +
            ", code=" + code +
            ", name=" + name +
            ", description=" + description +
            ", systemFlag=" + systemFlag +
            ", status=" + status +
            ", sort=" + sort +
            ", createTime=" + createTime +
            ", createUser=" + createUser +
            ", updateTime=" + updateTime +
            ", updateUser=" + updateUser +
        "}";
    }
}
