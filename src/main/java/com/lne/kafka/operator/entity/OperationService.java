package com.lne.kafka.operator.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * <p>
 * web服务表
 * </p>
 *
 * @author fengsulin
 * @since 2022-07-08
 */
@TableName("operation_service")
public class OperationService implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * web服务id
     */
    @TableId
    private Long id;

    /**
     * web服务名称
     */
    private String serviceName;

    /**
     * 服务所属系统id
     */
    private Long systemId;

    /**
     * 服务路径
     */
    private String serviceUrl;

    /**
     * 服务是否删除（1 删除，0 否）
     */
    private Integer isDelete;

    /**
     * 服务端口
     */
    private String servicePort;

    /**
     * 是否纳管（1 是，0 否）
     */
    private Integer isNanotubes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }
    public Long getSystemId() {
        return systemId;
    }

    public void setSystemId(Long systemId) {
        this.systemId = systemId;
    }
    public String getServiceUrl() {
        return serviceUrl;
    }

    public void setServiceUrl(String serviceUrl) {
        this.serviceUrl = serviceUrl;
    }
    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
    public String getServicePort() {
        return servicePort;
    }

    public void setServicePort(String servicePort) {
        this.servicePort = servicePort;
    }
    public Integer getIsNanotubes() {
        return isNanotubes;
    }

    public void setIsNanotubes(Integer isNanotubes) {
        this.isNanotubes = isNanotubes;
    }

    @Override
    public String toString() {
        return "OperationService{" +
            "id=" + id +
            ", serviceName=" + serviceName +
            ", systemId=" + systemId +
            ", serviceUrl=" + serviceUrl +
            ", isDelete=" + isDelete +
            ", servicePort=" + servicePort +
            ", isNanotubes=" + isNanotubes +
        "}";
    }
}
