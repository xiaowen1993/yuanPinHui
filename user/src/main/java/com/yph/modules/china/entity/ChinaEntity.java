package com.yph.modules.china.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author 
 * @since 2020-11-17
 */
@TableName("china")
public class ChinaEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("Id")
    private Integer Id;

    @TableField("Name")
    private String Name;

    @TableField("Pid")
    private Integer Pid;

    public Integer getId() {
        return Id;
    }

    public ChinaEntity setId(Integer Id) {
        this.Id = Id;
        return this;
    }
    public String getName() {
        return Name;
    }

    public ChinaEntity setName(String Name) {
        this.Name = Name;
        return this;
    }
    public Integer getPid() {
        return Pid;
    }

    public ChinaEntity setPid(Integer Pid) {
        this.Pid = Pid;
        return this;
    }

    @Override
    public String toString() {
        return "ChinaEntity{" +
            "Id=" + Id +
            ", Name=" + Name +
            ", Pid=" + Pid +
        "}";
    }
}
