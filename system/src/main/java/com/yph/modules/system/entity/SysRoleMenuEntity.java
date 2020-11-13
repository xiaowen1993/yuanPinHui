package com.yph.modules.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * <p>
 * 角色菜单表
 * </p>
 *
 * @author LC
 * @since 2020-11-12
 */
@TableName("sys_role_menu")
public class SysRoleMenuEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    /**
     * 角色ID
     */
    private Integer roleId;

    /**
     * 菜单ID
     */
    private Integer menuId;

    public Integer getId() {
        return id;
    }

    public SysRoleMenuEntity setId(Integer id) {
        this.id = id;
        return this;
    }
    public Integer getRoleId() {
        return roleId;
    }

    public SysRoleMenuEntity setRoleId(Integer roleId) {
        this.roleId = roleId;
        return this;
    }
    public Integer getMenuId() {
        return menuId;
    }

    public SysRoleMenuEntity setMenuId(Integer menuId) {
        this.menuId = menuId;
        return this;
    }

    @Override
    public String toString() {
        return "SysRoleMenuEntity{" +
            "id=" + id +
            ", roleId=" + roleId +
            ", menuId=" + menuId +
        "}";
    }
}
