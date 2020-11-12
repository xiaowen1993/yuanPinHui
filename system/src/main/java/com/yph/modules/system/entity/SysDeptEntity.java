package com.yph.modules.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import java.io.Serializable;

/**
 * <p>
 * 部门表
 * </p>
 *
 * @author 
 * @since 2020-11-12
 */
@TableName("sys_dept")
public class SysDeptEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private Integer deptId;

    /**
     * 父部门id
     */
    private Long pid;

    /**
     * 简称
     */
    private String simpleName;

    /**
     * 全称
     */
    private String fullName;

    /**
     * 描述
     */
    private String description;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 创建人
     */
    private Long createUser;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改人
     */
    private Long updateUser;

    /**
     * 修改时间
     */
    private Date updateTime;

    public Integer getDeptId() {
        return deptId;
    }

    public SysDeptEntity setDeptId(Integer deptId) {
        this.deptId = deptId;
        return this;
    }
    public Long getPid() {
        return pid;
    }

    public SysDeptEntity setPid(Long pid) {
        this.pid = pid;
        return this;
    }
    public String getSimpleName() {
        return simpleName;
    }

    public SysDeptEntity setSimpleName(String simpleName) {
        this.simpleName = simpleName;
        return this;
    }
    public String getFullName() {
        return fullName;
    }

    public SysDeptEntity setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }
    public String getDescription() {
        return description;
    }

    public SysDeptEntity setDescription(String description) {
        this.description = description;
        return this;
    }
    public Integer getSort() {
        return sort;
    }

    public SysDeptEntity setSort(Integer sort) {
        this.sort = sort;
        return this;
    }
    public Long getCreateUser() {
        return createUser;
    }

    public SysDeptEntity setCreateUser(Long createUser) {
        this.createUser = createUser;
        return this;
    }
    public Date getCreateTime() {
        return createTime;
    }

    public SysDeptEntity setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }
    public Long getUpdateUser() {
        return updateUser;
    }

    public SysDeptEntity setUpdateUser(Long updateUser) {
        this.updateUser = updateUser;
        return this;
    }
    public Date getUpdateTime() {
        return updateTime;
    }

    public SysDeptEntity setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    @Override
    public String toString() {
        return "SysDeptEntity{" +
            "deptId=" + deptId +
            ", pid=" + pid +
            ", simpleName=" + simpleName +
            ", fullName=" + fullName +
            ", description=" + description +
            ", sort=" + sort +
            ", createUser=" + createUser +
            ", createTime=" + createTime +
            ", updateUser=" + updateUser +
            ", updateTime=" + updateTime +
        "}";
    }
}
