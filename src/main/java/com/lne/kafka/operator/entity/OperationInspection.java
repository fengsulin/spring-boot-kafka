package com.lne.kafka.operator.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 巡检表
 * </p>
 *
 * @author fengsulin
 * @since 2022-07-08
 */
@TableName("operation_inspection")
public class OperationInspection implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId
    private Long id;

    /**
     * 巡检名称
     */
    private String inspectionName;

    /**
     * 巡检类别id
     */
    private Long categoryId;

    /**
     * 巡检应用服务id
     */
    private Long serviceId;

    /**
     * 巡检时间
     */
    @TableField(value = "inspection_time")
    private LocalDateTime inspectionTime;

    /**
     * 巡检结果
     */
    private String inspectionValue;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getInspectionName() {
        return inspectionName;
    }

    public void setInspectionName(String inspectionName) {
        this.inspectionName = inspectionName;
    }
    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }
    public LocalDateTime getInspectionTime() {
        return inspectionTime;
    }

    public void setInspectionTime(LocalDateTime inspectionTime) {
        this.inspectionTime = inspectionTime;
    }
    public String getInspectionValue() {
        return inspectionValue;
    }

    public void setInspectionValue(String inspectionValue) {
        this.inspectionValue = inspectionValue;
    }

    @Override
    public String toString() {
        return "OperationInspection{" +
            "id=" + id +
            ", inspectionName=" + inspectionName +
            ", categoryId=" + categoryId +
            ", serviceId=" + serviceId +
            ", time=" + inspectionTime +
            ", inspectionValue=" + inspectionValue +
        "}";
    }
}
