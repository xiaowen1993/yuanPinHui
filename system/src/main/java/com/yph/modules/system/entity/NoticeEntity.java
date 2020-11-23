package com.yph.modules.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 广告表
 * </p>
 *
 * @author 
 * @since 2020-11-23
 */
@TableName("notice")
public class NoticeEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    /**
     * 标题
     */
    private String title;

    /**
     * 描述
     */
    private String describe;

    /**
     * 状态;1-在用，2-停用
     */
    private Integer state;

    /**
     * 图片
     */
    private String picture;

    /**
     * 格式;1-图片，2-视频，3-推荐
     */
    private Integer format;

    /**
     * 开始时间
     */
    private Date startTime;

    /**
     * 结束时间
     */
    private Date endTime;

    /**
     * 点击率
     */
    private Integer clickRate;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 广告内容
     */
    private String content;

    /**
     * 创建人
     */
    private String createUser;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新人
     */
    private String updateUser;

    /**
     * 更新时间
     */
    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public NoticeEntity setId(Integer id) {
        this.id = id;
        return this;
    }
    public String getTitle() {
        return title;
    }

    public NoticeEntity setTitle(String title) {
        this.title = title;
        return this;
    }
    public String getDescribe() {
        return describe;
    }

    public NoticeEntity setDescribe(String describe) {
        this.describe = describe;
        return this;
    }
    public Integer getState() {
        return state;
    }

    public NoticeEntity setState(Integer state) {
        this.state = state;
        return this;
    }
    public String getPicture() {
        return picture;
    }

    public NoticeEntity setPicture(String picture) {
        this.picture = picture;
        return this;
    }
    public Integer getFormat() {
        return format;
    }

    public NoticeEntity setFormat(Integer format) {
        this.format = format;
        return this;
    }
    public Date getStartTime() {
        return startTime;
    }

    public NoticeEntity setStartTime(Date startTime) {
        this.startTime = startTime;
        return this;
    }
    public Date getEndTime() {
        return endTime;
    }

    public NoticeEntity setEndTime(Date endTime) {
        this.endTime = endTime;
        return this;
    }
    public Integer getClickRate() {
        return clickRate;
    }

    public NoticeEntity setClickRate(Integer clickRate) {
        this.clickRate = clickRate;
        return this;
    }
    public Integer getSort() {
        return sort;
    }

    public NoticeEntity setSort(Integer sort) {
        this.sort = sort;
        return this;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreateUser() {
        return createUser;
    }

    public NoticeEntity setCreateUser(String createUser) {
        this.createUser = createUser;
        return this;
    }
    public Date getCreateTime() {
        return createTime;
    }

    public NoticeEntity setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }
    public String getUpdateUser() {
        return updateUser;
    }

    public NoticeEntity setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
        return this;
    }
    public Date getUpdateTime() {
        return updateTime;
    }

    public NoticeEntity setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    @Override
    public String toString() {
        return "NoticeEntity{" +
            "id=" + id +
            ", title=" + title +
            ", describe=" + describe +
            ", state=" + state +
            ", picture=" + picture +
            ", format=" + format +
            ", startTime=" + startTime +
            ", endTime=" + endTime +
            ", clickRate=" + clickRate +
            ", sort=" + sort +
            ", content=" + content +
            ", createUser=" + createUser +
            ", createTime=" + createTime +
            ", updateUser=" + updateUser +
            ", updateTime=" + updateTime +
        "}";
    }
}
