package com.yph.modules.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 商品表
 * </p>
 *
 * @author 
 * @since 2020-11-23
 */
@TableName("goods")
public class GoodsEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 店铺id
     */
    private Integer shopId;

    /**
     * 商品标题
     */
    private String title;

    /**
     * 商品封面
     */
    private String cover;

    /**
     * 商品图片
     */
    private String images;

    /**
     * 商品分类
     */
    private String category;

    /**
     * 品牌名称
     */
    private String brandName;

    /**
     * 状态;1-已上架；2-已下架
     */
    private String status;

    /**
     * 审核状态
     */
    private String approvalStatus;

    /**
     * 商品售价
     */
    private String sellingPrice;

    /**
     * 成本价
     */
    private String costPrice;

    /**
     * 原价
     */
    private String originalPrice;

    /**
     * 库存
     */
    private String stock;

    /**
     * 库存预警值;库存-1
     */
    private String stockWarning;

    /**
     * 销量
     */
    private String sales;

    /**
     * 是否热卖
     */
    private Integer bestSeller;

    /**
     * 是否推荐
     */
    private Integer recommend;

    /**
     * 是否新品
     */
    private Integer newProduct;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 赠送成长值
     */
    private String growthValue;

    /**
     * 赠送积分
     */
    private String integral;

    /**
     * 计量单位
     */
    private String unit;

    /**
     * 重量
     */
    private Float weight;

    /**
     * 是否包邮
     */
    private String freeShipping;

    /**
     * 浏览量
     */
    private String pageviews;

    /**
     * 添加时间
     */
    private Date addTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public GoodsEntity setId(Integer id) {
        this.id = id;
        return this;
    }
    public Integer getShopId() {
        return shopId;
    }

    public GoodsEntity setShopId(Integer shopId) {
        this.shopId = shopId;
        return this;
    }
    public String getTitle() {
        return title;
    }

    public GoodsEntity setTitle(String title) {
        this.title = title;
        return this;
    }
    public String getCover() {
        return cover;
    }

    public GoodsEntity setCover(String cover) {
        this.cover = cover;
        return this;
    }
    public String getImages() {
        return images;
    }

    public GoodsEntity setImages(String images) {
        this.images = images;
        return this;
    }
    public String getCategory() {
        return category;
    }

    public GoodsEntity setCategory(String category) {
        this.category = category;
        return this;
    }
    public String getBrandName() {
        return brandName;
    }

    public GoodsEntity setBrandName(String brandName) {
        this.brandName = brandName;
        return this;
    }
    public String getStatus() {
        return status;
    }

    public GoodsEntity setStatus(String status) {
        this.status = status;
        return this;
    }
    public String getApprovalStatus() {
        return approvalStatus;
    }

    public GoodsEntity setApprovalStatus(String approvalStatus) {
        this.approvalStatus = approvalStatus;
        return this;
    }
    public String getSellingPrice() {
        return sellingPrice;
    }

    public GoodsEntity setSellingPrice(String sellingPrice) {
        this.sellingPrice = sellingPrice;
        return this;
    }
    public String getCostPrice() {
        return costPrice;
    }

    public GoodsEntity setCostPrice(String costPrice) {
        this.costPrice = costPrice;
        return this;
    }
    public String getOriginalPrice() {
        return originalPrice;
    }

    public GoodsEntity setOriginalPrice(String originalPrice) {
        this.originalPrice = originalPrice;
        return this;
    }
    public String getStock() {
        return stock;
    }

    public GoodsEntity setStock(String stock) {
        this.stock = stock;
        return this;
    }
    public String getStockWarning() {
        return stockWarning;
    }

    public GoodsEntity setStockWarning(String stockWarning) {
        this.stockWarning = stockWarning;
        return this;
    }
    public String getSales() {
        return sales;
    }

    public GoodsEntity setSales(String sales) {
        this.sales = sales;
        return this;
    }
    public Integer getBestSeller() {
        return bestSeller;
    }

    public GoodsEntity setBestSeller(Integer bestSeller) {
        this.bestSeller = bestSeller;
        return this;
    }
    public Integer getRecommend() {
        return recommend;
    }

    public GoodsEntity setRecommend(Integer recommend) {
        this.recommend = recommend;
        return this;
    }
    public Integer getNewProduct() {
        return newProduct;
    }

    public GoodsEntity setNewProduct(Integer newProduct) {
        this.newProduct = newProduct;
        return this;
    }
    public Integer getSort() {
        return sort;
    }

    public GoodsEntity setSort(Integer sort) {
        this.sort = sort;
        return this;
    }
    public String getGrowthValue() {
        return growthValue;
    }

    public GoodsEntity setGrowthValue(String growthValue) {
        this.growthValue = growthValue;
        return this;
    }
    public String getIntegral() {
        return integral;
    }

    public GoodsEntity setIntegral(String integral) {
        this.integral = integral;
        return this;
    }
    public String getUnit() {
        return unit;
    }

    public GoodsEntity setUnit(String unit) {
        this.unit = unit;
        return this;
    }
    public Float getWeight() {
        return weight;
    }

    public GoodsEntity setWeight(Float weight) {
        this.weight = weight;
        return this;
    }
    public String getFreeShipping() {
        return freeShipping;
    }

    public GoodsEntity setFreeShipping(String freeShipping) {
        this.freeShipping = freeShipping;
        return this;
    }
    public String getPageviews() {
        return pageviews;
    }

    public GoodsEntity setPageviews(String pageviews) {
        this.pageviews = pageviews;
        return this;
    }
    public Date getAddTime() {
        return addTime;
    }

    public GoodsEntity setAddTime(Date addTime) {
        this.addTime = addTime;
        return this;
    }
    public Date getUpdateTime() {
        return updateTime;
    }

    public GoodsEntity setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    @Override
    public String toString() {
        return "GoodsEntity{" +
            "id=" + id +
            ", shopId=" + shopId +
            ", title=" + title +
            ", cover=" + cover +
            ", images=" + images +
            ", category=" + category +
            ", brandName=" + brandName +
            ", status=" + status +
            ", approvalStatus=" + approvalStatus +
            ", sellingPrice=" + sellingPrice +
            ", costPrice=" + costPrice +
            ", originalPrice=" + originalPrice +
            ", stock=" + stock +
            ", stockWarning=" + stockWarning +
            ", sales=" + sales +
            ", bestSeller=" + bestSeller +
            ", recommend=" + recommend +
            ", newProduct=" + newProduct +
            ", sort=" + sort +
            ", growthValue=" + growthValue +
            ", integral=" + integral +
            ", unit=" + unit +
            ", weight=" + weight +
            ", freeShipping=" + freeShipping +
            ", pageviews=" + pageviews +
            ", addTime=" + addTime +
            ", updateTime=" + updateTime +
        "}";
    }
}
