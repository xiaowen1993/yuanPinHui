package com.yph.modules.system.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 
 * </p>
 *
 * @author LC
 * @since 2020-11-12
 */
@TableName("sys_menu")
public class SysMenuEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    /**
     * 父节点，顶级节点0
     */
    private String pid;

    /**
     * 名称
     */
    private String name;

    /**
     * http://127.0.0.1{{uri}}
     */
    private String uri;

    /**
     * 图标 fa fa-icon
     */
    private String icon;

    /**
     * 1.模块 2.菜单 3.页面 4.按钮 5.默认页面
     */
    private Integer type;

    /**
     * 1.平台 2.代理 3.商户
     */
    private Integer role;

    /**
     * 1.权限 2.所有人
     */
    private Integer power;

    /**
     * 没有权限跳转的页面，默认403
     */
    private String forward;

    /**
     * 排序顺序，小的在上面
     */
    private Integer sort;


    @TableField(exist = false)
    private List<SysMenuEntity> children;

    public List<SysMenuEntity> getChildren() {
        return children;
    }

    public void setChildren(List<SysMenuEntity> children) {
        this.children = children;
    }

    public Integer getId() {
        return id;
    }

    public SysMenuEntity setId(Integer id) {
        this.id = id;
        return this;
    }
    public String getPid() {
        return pid;
    }

    public SysMenuEntity setPid(String pid) {
        this.pid = pid;
        return this;
    }
    public String getName() {
        return name;
    }

    public SysMenuEntity setName(String name) {
        this.name = name;
        return this;
    }
    public String getUri() {
        return uri;
    }

    public SysMenuEntity setUri(String uri) {
        this.uri = uri;
        return this;
    }
    public String getIcon() {
        return icon;
    }

    public SysMenuEntity setIcon(String icon) {
        this.icon = icon;
        return this;
    }
    public Integer getType() {
        return type;
    }

    public SysMenuEntity setType(Integer type) {
        this.type = type;
        return this;
    }
    public Integer getRole() {
        return role;
    }

    public SysMenuEntity setRole(Integer role) {
        this.role = role;
        return this;
    }
    public Integer getPower() {
        return power;
    }

    public SysMenuEntity setPower(Integer power) {
        this.power = power;
        return this;
    }
    public String getForward() {
        return forward;
    }

    public SysMenuEntity setForward(String forward) {
        this.forward = forward;
        return this;
    }
    public Integer getSort() {
        return sort;
    }

    public SysMenuEntity setSort(Integer sort) {
        this.sort = sort;
        return this;
    }

    @Override
    public String toString() {
        return "SysMenuEntity{" +
                "id=" + id +
                ", pid='" + pid + '\'' +
                ", name='" + name + '\'' +
                ", uri='" + uri + '\'' +
                ", icon='" + icon + '\'' +
                ", type=" + type +
                ", role=" + role +
                ", power=" + power +
                ", forward='" + forward + '\'' +
                ", sort=" + sort +
                ", children=" + children +
                '}';
    }
}
