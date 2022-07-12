package com.lne.kafka.operator.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 告警表
 * </p>
 *
 * @author fengsulin
 * @since 2022-07-08
 */
@TableName("operation_alert")
public class OperationAlert implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 告警id
     */
    @TableId(value = "ID")
    private Integer id;

    /**
     * 所属告警组id
     */
    private Integer groupId;

    /**
     * 告警名称
     */
    private String alertname;

    /**
     * 告警标识
     */
    private String alertLabel;

    /**
     * 告警状态（1 已解决，0 未解决）
     */
    private Integer status;

    /**
     * 告警产生时间
     */
    private LocalDateTime startTime;

    /**
     * 告警解决时间
     */
    private LocalDateTime endTime;

    /**
     * 告警详细描述
     */
    private String description;

    /**
     * 告警结论
     */
    private String summary;

    /**
     * 告警访问路径
     */
    private String instance;

    /**
     * 告警等级
     */
    private String alertLevel;

    /**
     * 出现告警的系统
     */
    private String systemName;

    /**
     * 是否派单（0 否，1是）
     */
    private Integer sendOrders;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }
    public String getAlertname() {
        return alertname;
    }

    public void setAlertname(String alertname) {
        this.alertname = alertname;
    }
    public String getAlertLabel() {
        return alertLabel;
    }

    public void setAlertLabel(String alertLabel) {
        this.alertLabel = alertLabel;
    }
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }
    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
    public String getInstance() {
        return instance;
    }

    public void setInstance(String instance) {
        this.instance = instance;
    }
    public String getAlertLevel() {
        return alertLevel;
    }

    public void setAlertLevel(String alertLevel) {
        this.alertLevel = alertLevel;
    }
    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }
    public Integer getSendOrders() {
        return sendOrders;
    }

    public void setSendOrders(Integer sendOrders) {
        this.sendOrders = sendOrders;
    }

    @Override
    public String toString() {
        return "OperationAlert{" +
            "id=" + id +
            ", groupId=" + groupId +
            ", alertname=" + alertname +
            ", alertLabel=" + alertLabel +
            ", status=" + status +
            ", startTime=" + startTime +
            ", endTime=" + endTime +
            ", description=" + description +
            ", summary=" + summary +
            ", instance=" + instance +
            ", alertLevel=" + alertLevel +
            ", systemName=" + systemName +
            ", sendOrders=" + sendOrders +
        "}";
    }
}
