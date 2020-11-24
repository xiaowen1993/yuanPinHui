package com.yph.modules.tx.entity;

import java.math.BigDecimal;
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
@TableName("resp_tx")
public class RespTxEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 交易的nonce
     */
    private String nonce;

    /**
     * 交易的金额
     */
    private BigDecimal amount;

    /**
     * 交易发起地址
     */
    private String from;

    /**
     * 交易接受方地址
     */
    private String to;

    /**
     * 交易的hash
     */
    private String hash;

    /**
     * 交易的签名
     */
    private String signature;

    /**
     * 时间戳
     */
    private Date time;

    /**
     * 代币脚本
     */
    private String script;

    /**
     * 关联的resp_block表主键
     */
    private Long respBlockId;

    public Long getId() {
        return id;
    }

    public RespTxEntity setId(Long id) {
        this.id = id;
        return this;
    }
    public String getNonce() {
        return nonce;
    }

    public RespTxEntity setNonce(String nonce) {
        this.nonce = nonce;
        return this;
    }
    public BigDecimal getAmount() {
        return amount;
    }

    public RespTxEntity setAmount(BigDecimal amount) {
        this.amount = amount;
        return this;
    }
    public String getFrom() {
        return from;
    }

    public RespTxEntity setFrom(String from) {
        this.from = from;
        return this;
    }
    public String getTo() {
        return to;
    }

    public RespTxEntity setTo(String to) {
        this.to = to;
        return this;
    }
    public String getHash() {
        return hash;
    }

    public RespTxEntity setHash(String hash) {
        this.hash = hash;
        return this;
    }
    public String getSignature() {
        return signature;
    }

    public RespTxEntity setSignature(String signature) {
        this.signature = signature;
        return this;
    }
    public Date getTime() {
        return time;
    }

    public RespTxEntity setTime(Date time) {
        this.time = time;
        return this;
    }
    public String getScript() {
        return script;
    }

    public RespTxEntity setScript(String script) {
        this.script = script;
        return this;
    }
    public Long getRespBlockId() {
        return respBlockId;
    }

    public RespTxEntity setRespBlockId(Long respBlockId) {
        this.respBlockId = respBlockId;
        return this;
    }

    @Override
    public String toString() {
        return "RespTxEntity{" +
            "id=" + id +
            ", nonce=" + nonce +
            ", amount=" + amount +
            ", from=" + from +
            ", to=" + to +
            ", hash=" + hash +
            ", signature=" + signature +
            ", time=" + time +
            ", script=" + script +
            ", respBlockId=" + respBlockId +
        "}";
    }
}
