package com.yph.modules.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * <p>
 * 用户角色表
 * </p>
 *
 * @author 
 * @since 2020-11-12
 */
@TableName("sys_user_role")
public class SysUserRoleEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 角色ID
     */
    private Integer roleId;

    public Integer getId() {
        return id;
    }

    public SysUserRoleEntity setId(Integer id) {
        this.id = id;
        return this;
    }
    public Integer getUserId() {
        return userId;
    }

    public SysUserRoleEntity setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }
    public Integer getRoleId() {
        return roleId;
    }

    public SysUserRoleEntity setRoleId(Integer roleId) {
        this.roleId = roleId;
        return this;
    }

    @Override
    public String toString() {
        return "SysUserRoleEntity{" +
            "id=" + id +
            ", userId=" + userId +
            ", roleId=" + roleId +
        "}";
    }
}
