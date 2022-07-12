package com.lne.kafka.operator.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * <p>
 * 监控属性类别表
 * </p>
 *
 * @author fengsulin
 * @since 2022-07-08
 */
@TableName("operation_category")
public class OperationCategory implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId
    private Long id;

    /**
     * 健康指标类别名
     */
    private String categoryName;

    /**
     * 是否禁用（1 是，0否）
     */
    private Integer isDelete;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public String toString() {
        return "OperationCategory{" +
            "id=" + id +
            ", categoryName=" + categoryName +
            ", isDelete=" + isDelete +
        "}";
    }
}
