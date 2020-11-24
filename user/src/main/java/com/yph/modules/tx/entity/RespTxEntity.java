package com.yph.modules.tx.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

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
    @TableField("nonce")
    private String Nonce;

    /**
     * 交易的金额
     */
    @TableField("amount")
    private BigDecimal Amount;

    /**
     * 交易发起地址
     */
    @TableField("from")
    private String From;

    /**
     * 交易接受方地址
     */
    @TableField("to")
    private String To;

    /**
     * 交易的hash
     */
    @TableField("hash")
    private String Hash;

    /**
     * 交易的签名
     */
    @TableField("signature")
    private String Signature;

    /**
     * 时间戳
     */
    @TableField("time")
    private Date Time;

    /**
     * 代币脚本
     */
    @TableField("script")
    private String Script;

    /**
     * 关联的resp_block表主键
     */
    private Long respBlockId;

    @Override
    public String toString() {
        return "RespTxEntity{" +
                "id=" + id +
                ", Nonce='" + Nonce + '\'' +
                ", Amount=" + Amount +
                ", From='" + From + '\'' +
                ", To='" + To + '\'' +
                ", Hash='" + Hash + '\'' +
                ", Signature='" + Signature + '\'' +
                ", Time=" + Time +
                ", Script='" + Script + '\'' +
                ", respBlockId=" + respBlockId +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNonce() {
        return Nonce;
    }

    public void setNonce(String nonce) {
        Nonce = nonce;
    }

    public BigDecimal getAmount() {
        return Amount;
    }

    public void setAmount(BigDecimal amount) {
        Amount = amount;
    }

    public String getFrom() {
        return From;
    }

    public void setFrom(String from) {
        From = from;
    }

    public String getTo() {
        return To;
    }

    public void setTo(String to) {
        To = to;
    }

    public String getHash() {
        return Hash;
    }

    public void setHash(String hash) {
        Hash = hash;
    }

    public String getSignature() {
        return Signature;
    }

    public void setSignature(String signature) {
        Signature = signature;
    }

    public Date getTime() {
        return Time;
    }

    public void setTime(Date time) {
        Time = time;
    }

    public String getScript() {
        return Script;
    }

    public void setScript(String script) {
        Script = script;
    }

    public Long getRespBlockId() {
        return respBlockId;
    }

    public void setRespBlockId(Long respBlockId) {
        this.respBlockId = respBlockId;
    }
}
