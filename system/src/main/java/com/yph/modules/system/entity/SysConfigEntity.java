package com.yph.modules.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import java.io.Serializable;

/**
 * <p>
 * 参数配置
 * </p>
 *
 * @author 
 * @since 2020-11-12
 */
@TableName("sys_config")
public class SysConfigEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Integer id;

    /**
     * 名称
     */
    private String name;

    /**
     * 属性编码标识
     */
    private String code;

    /**
     * 是否是字典中的值
     */
    private String dictFlag;

    /**
     * 字典类型的编码
     */
    private Long dictTypeId;

    /**
     * 属性值，如果是字典中的类型，则为dict的code
     */
    private String value;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建人
     */
    private Long createUser;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 更新人
     */
    private Long updateUser;

    public Integer getId() {
        return id;
    }

    public SysConfigEntity setId(Integer id) {
        this.id = id;
        return this;
    }
    public String getName() {
        return name;
    }

    public SysConfigEntity setName(String name) {
        this.name = name;
        return this;
    }
    public String getCode() {
        return code;
    }

    public SysConfigEntity setCode(String code) {
        this.code = code;
        return this;
    }
    public String getDictFlag() {
        return dictFlag;
    }

    public SysConfigEntity setDictFlag(String dictFlag) {
        this.dictFlag = dictFlag;
        return this;
    }
    public Long getDictTypeId() {
        return dictTypeId;
    }

    public SysConfigEntity setDictTypeId(Long dictTypeId) {
        this.dictTypeId = dictTypeId;
        return this;
    }
    public String getValue() {
        return value;
    }

    public SysConfigEntity setValue(String value) {
        this.value = value;
        return this;
    }
    public String getRemark() {
        return remark;
    }

    public SysConfigEntity setRemark(String remark) {
        this.remark = remark;
        return this;
    }
    public Date getCreateTime() {
        return createTime;
    }

    public SysConfigEntity setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }
    public Long getCreateUser() {
        return createUser;
    }

    public SysConfigEntity setCreateUser(Long createUser) {
        this.createUser = createUser;
        return this;
    }
    public Date getUpdateTime() {
        return updateTime;
    }

    public SysConfigEntity setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
        return this;
    }
    public Long getUpdateUser() {
        return updateUser;
    }

    public SysConfigEntity setUpdateUser(Long updateUser) {
        this.updateUser = updateUser;
        return this;
    }

    @Override
    public String toString() {
        return "SysConfigEntity{" +
            "id=" + id +
            ", name=" + name +
            ", code=" + code +
            ", dictFlag=" + dictFlag +
            ", dictTypeId=" + dictTypeId +
            ", value=" + value +
            ", remark=" + remark +
            ", createTime=" + createTime +
            ", createUser=" + createUser +
            ", updateTime=" + updateTime +
            ", updateUser=" + updateUser +
        "}";
    }
}
