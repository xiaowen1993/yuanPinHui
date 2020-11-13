package com.yph.modules.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 角色菜单表
 * </p>
 *
 * @author 
 * @since 2020-11-13
 */
@TableName("sys_admin_role")
public class SysAdminRoleEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * admin ID
     */
    private Integer adminId;

    /**
     * 角色ID
     */
    private Integer roleId;

    public Integer getId() {
        return id;
    }

    public SysAdminRoleEntity setId(Integer id) {
        this.id = id;
        return this;
    }
    public Integer getAdminId() {
        return adminId;
    }

    public SysAdminRoleEntity setAdminId(Integer adminId) {
        this.adminId = adminId;
        return this;
    }
    public Integer getRoleId() {
        return roleId;
    }

    public SysAdminRoleEntity setRoleId(Integer roleId) {
        this.roleId = roleId;
        return this;
    }

    @Override
    public String toString() {
        return "SysAdminRoleEntity{" +
            "id=" + id +
            ", adminId=" + adminId +
            ", roleId=" + roleId +
        "}";
    }
}
