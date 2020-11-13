package com.yph.modules.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import java.io.Serializable;

/**
 * <p>
 * 后台系统通知表
 * </p>
 *
 * @author 
 * @since 2020-11-12
 */
@TableName("sys_notice")
public class SysNoticeEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Integer noticeId;

    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建人
     */
    private Integer createUser;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 修改人
     */
    private Integer updateUser;

    public Integer getNoticeId() {
        return noticeId;
    }

    public SysNoticeEntity setNoticeId(Integer noticeId) {
        this.noticeId = noticeId;
        return this;
    }
    public String getTitle() {
        return title;
    }

    public SysNoticeEntity setTitle(String title) {
        this.title = title;
        return this;
    }
    public String getContent() {
        return content;
    }

    public SysNoticeEntity setContent(String content) {
        this.content = content;
        return this;
    }
    public Date getCreateTime() {
        return createTime;
    }

    public SysNoticeEntity setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }
    public Integer getCreateUser() {
        return createUser;
    }

    public SysNoticeEntity setCreateUser(Integer createUser) {
        this.createUser = createUser;
        return this;
    }
    public Date getUpdateTime() {
        return updateTime;
    }

    public SysNoticeEntity setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
        return this;
    }
    public Integer getUpdateUser() {
        return updateUser;
    }

    public SysNoticeEntity setUpdateUser(Integer updateUser) {
        this.updateUser = updateUser;
        return this;
    }

    @Override
    public String toString() {
        return "SysNoticeEntity{" +
            "noticeId=" + noticeId +
            ", title=" + title +
            ", content=" + content +
            ", createTime=" + createTime +
            ", createUser=" + createUser +
            ", updateTime=" + updateTime +
            ", updateUser=" + updateUser +
        "}";
    }
}
