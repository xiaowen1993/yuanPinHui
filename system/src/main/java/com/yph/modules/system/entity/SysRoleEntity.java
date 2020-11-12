package com.yph.modules.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 系统角色表
 * </p>
 *
 * @author 
 * @since 2020-11-12
 */
@TableName("sys_role")
public class SysRoleEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 角色编码
     */
    private String roleCode;

    /**
     * 角色描述
     */
    private String roleDesc;

    /**
     * 数据权限类型
     */
    private String dsType;

    /**
     * 创建用户
     */
    private Long createUser;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改用户
     */
    private Long updateUser;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 删除标识（0-正常,1-删除）
     */
    private String delFlag;

    /**
     * 序号
     */
    private Integer sort;

    public Integer getId() {
        return id;
    }

    public SysRoleEntity setId(Integer id) {
        this.id = id;
        return this;
    }
    public String getRoleName() {
        return roleName;
    }

    public SysRoleEntity setRoleName(String roleName) {
        this.roleName = roleName;
        return this;
    }
    public String getRoleCode() {
        return roleCode;
    }

    public SysRoleEntity setRoleCode(String roleCode) {
        this.roleCode = roleCode;
        return this;
    }
    public String getRoleDesc() {
        return roleDesc;
    }

    public SysRoleEntity setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
        return this;
    }
    public String getDsType() {
        return dsType;
    }

    public SysRoleEntity setDsType(String dsType) {
        this.dsType = dsType;
        return this;
    }
    public Long getCreateUser() {
        return createUser;
    }

    public SysRoleEntity setCreateUser(Long createUser) {
        this.createUser = createUser;
        return this;
    }
    public Date getCreateTime() {
        return createTime;
    }

    public SysRoleEntity setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }
    public Long getUpdateUser() {
        return updateUser;
    }

    public SysRoleEntity setUpdateUser(Long updateUser) {
        this.updateUser = updateUser;
        return this;
    }
    public Date getUpdateTime() {
        return updateTime;
    }

    public SysRoleEntity setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
        return this;
    }
    public String getDelFlag() {
        return delFlag;
    }

    public SysRoleEntity setDelFlag(String delFlag) {
        this.delFlag = delFlag;
        return this;
    }
    public Integer getSort() {
        return sort;
    }

    public SysRoleEntity setSort(Integer sort) {
        this.sort = sort;
        return this;
    }

    @Override
    public String toString() {
        return "SysRoleEntity{" +
            "id=" + id +
            ", roleName=" + roleName +
            ", roleCode=" + roleCode +
            ", roleDesc=" + roleDesc +
            ", dsType=" + dsType +
            ", createUser=" + createUser +
            ", createTime=" + createTime +
            ", updateUser=" + updateUser +
            ", updateTime=" + updateTime +
            ", delFlag=" + delFlag +
            ", sort=" + sort +
        "}";
    }
}
