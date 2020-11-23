package com.yph.modules.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 部门表
 * </p>
 *
 * @author LC
 * @since 2020-11-12
 */
@TableName("sys_dept")
public class SysDeptEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "dept_id", type = IdType.AUTO)
    private Integer deptId;

    /**
     * 父部门id
     */
    private Integer pid;

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

    @TableField(exist = false)
    private List<SysDeptEntity> children;

    /**
     * 创建人
     */
    private String createUser;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改人
     */
    private String updateUser;

    /**
     * 修改时间
     */
    private Date updateTime;

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getSimpleName() {
        return simpleName;
    }

    public void setSimpleName(String simpleName) {
        this.simpleName = simpleName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public List<SysDeptEntity> getChildren() {
        return children;
    }

    public void setChildren(List<SysDeptEntity> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "SysDeptEntity{" +
                "deptId=" + deptId +
                ", pid=" + pid +
                ", simpleName='" + simpleName + '\'' +
                ", fullName='" + fullName + '\'' +
                ", description='" + description + '\'' +
                ", sort=" + sort +
                ", children=" + children +
                ", createUser='" + createUser + '\'' +
                ", createTime=" + createTime +
                ", updateUser='" + updateUser + '\'' +
                ", updateTime=" + updateTime +
                '}';
    }
}
