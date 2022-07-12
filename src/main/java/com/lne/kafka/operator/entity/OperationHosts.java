package com.lne.kafka.operator.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 主机表
 * </p>
 *
 * @author fengsulin
 * @since 2022-07-08
 */
@TableName("operation_hosts")
public class OperationHosts implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主机id
     */
    @TableId
    private Long id;

    /**
     * 主机ip
     */
    private String hostIp;

    /**
     * 主机类型
     */
    private String hostType;

    /**
     * 主机所处位置
     */
    private Long resourceId;

    /**
     * 是否纳管（0是，1 否）
     */
    private Integer isNanotubes;

    /**
     * 主机添加时间
     */
    private LocalDateTime createTime;

    /**
     * 主机更新时间
     */
    private LocalDateTime updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getHostIp() {
        return hostIp;
    }

    public void setHostIp(String hostIp) {
        this.hostIp = hostIp;
    }
    public String getHostType() {
        return hostType;
    }

    public void setHostType(String hostType) {
        this.hostType = hostType;
    }
    public Long getResourceId() {
        return resourceId;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }
    public Integer getIsNanotubes() {
        return isNanotubes;
    }

    public void setIsNanotubes(Integer isNanotubes) {
        this.isNanotubes = isNanotubes;
    }
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "OperationHosts{" +
            "id=" + id +
            ", hostIp=" + hostIp +
            ", hostType=" + hostType +
            ", resourceId=" + resourceId +
            ", isNanotubes=" + isNanotubes +
            ", createTime=" + createTime +
            ", updateTime=" + updateTime +
        "}";
    }
}
