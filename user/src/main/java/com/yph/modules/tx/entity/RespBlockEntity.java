package com.yph.modules.tx.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author 
 * @since 2020-11-24
 */
@TableName("resp_block")
public class RespBlockEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 区块号
     */
    private Long height;

    /**
     * 上一个区块的哈希值
     */
    private String prevblockHash;

    /**
     * 根
     */
    private String root;

    /**
     * 版本号
     */
    private String version;

    /**
     * 该区块的时间戳
     */
    private Date timestamp;

    /**
     * 该区块的hash
     */
    private String hash;

    /**
     * 旷工地址
     */
    private String miner;

    public Long getId() {
        return id;
    }

    public RespBlockEntity setId(Long id) {
        this.id = id;
        return this;
    }
    public Long getHeight() {
        return height;
    }

    public RespBlockEntity setHeight(Long height) {
        this.height = height;
        return this;
    }
    public String getPrevblockHash() {
        return prevblockHash;
    }

    public RespBlockEntity setPrevblockHash(String prevblockHash) {
        this.prevblockHash = prevblockHash;
        return this;
    }
    public String getRoot() {
        return root;
    }

    public RespBlockEntity setRoot(String root) {
        this.root = root;
        return this;
    }
    public String getVersion() {
        return version;
    }

    public RespBlockEntity setVersion(String version) {
        this.version = version;
        return this;
    }
    public Date getTimestamp() {
        return timestamp;
    }

    public RespBlockEntity setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
        return this;
    }
    public String getHash() {
        return hash;
    }

    public RespBlockEntity setHash(String hash) {
        this.hash = hash;
        return this;
    }
    public String getMiner() {
        return miner;
    }

    public RespBlockEntity setMiner(String miner) {
        this.miner = miner;
        return this;
    }

    @Override
    public String toString() {
        return "RespBlockEntity{" +
            "id=" + id +
            ", height=" + height +
            ", prevblockHash=" + prevblockHash +
            ", root=" + root +
            ", version=" + version +
            ", timestamp=" + timestamp +
            ", hash=" + hash +
            ", miner=" + miner +
        "}";
    }
}
