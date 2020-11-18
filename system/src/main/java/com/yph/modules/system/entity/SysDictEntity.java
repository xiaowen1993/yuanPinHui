package com.yph.modules.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import java.io.Serializable;

/**
 * <p>
 * 基础字典
 * </p>
 *
 * @author LC
 * @since 2020-11-12
 */
@TableName("sys_dict")
public class SysDictEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 字典id
     */
    @TableId(value = "dict_id", type = IdType.AUTO)
    private Integer dictId;

    /**
     * 所属字典类型的id
     */
    private Integer dictTypeId;

    /**
     * 字典编码
     */
    private String code;

    /**
     * 字典名称
     */
    private String name;


    /**
     * 状态（字典）
     */
    private Integer status;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 字典的描述
     */
    private String description;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 创建人
     */
    private Integer createUser;

    /**
     * 修改人
     */
    private Integer updateUser;

    public Integer getDictId() {
        return dictId;
    }

    public SysDictEntity setDictId(Integer dictId) {
        this.dictId = dictId;
        return this;
    }
    public Integer getDictTypeId() {
        return dictTypeId;
    }

    public SysDictEntity setDictTypeId(Integer dictTypeId) {
        this.dictTypeId = dictTypeId;
        return this;
    }
    public String getCode() {
        return code;
    }

    public SysDictEntity setCode(String code) {
        this.code = code;
        return this;
    }
    public String getName() {
        return name;
    }

    public SysDictEntity setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getSort() {
        return sort;
    }

    public SysDictEntity setSort(Integer sort) {
        this.sort = sort;
        return this;
    }
    public String getDescription() {
        return description;
    }

    public SysDictEntity setDescription(String description) {
        this.description = description;
        return this;
    }
    public Date getCreateTime() {
        return createTime;
    }

    public SysDictEntity setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }
    public Date getUpdateTime() {
        return updateTime;
    }

    public SysDictEntity setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
        return this;
    }
    public Integer getCreateUser() {
        return createUser;
    }

    public SysDictEntity setCreateUser(Integer createUser) {
        this.createUser = createUser;
        return this;
    }
    public Integer getUpdateUser() {
        return updateUser;
    }

    public SysDictEntity setUpdateUser(Integer updateUser) {
        this.updateUser = updateUser;
        return this;
    }

    @Override
    public String toString() {
        return "SysDictEntity{" +
            "dictId=" + dictId +
            ", dictTypeId=" + dictTypeId +
            ", code=" + code +
            ", name=" + name +
            ", status=" + status +
            ", sort=" + sort +
            ", description=" + description +
            ", createTime=" + createTime +
            ", updateTime=" + updateTime +
            ", createUser=" + createUser +
            ", updateUser=" + updateUser +
        "}";
    }
}
