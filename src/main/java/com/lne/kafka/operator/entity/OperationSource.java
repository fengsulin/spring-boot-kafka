package com.lne.kafka.operator.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 资源池
 * </p>
 *
 * @author fengsulin
 * @since 2022-07-08
 */
@TableName("operation_source")
public class OperationSource implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 资源池id
     */
    @TableId
    private Long id;

    /**
     * 资源池名字
     */
    private String sourceName;

    /**
     * 是否删除（1 是，0 否）
     */
    private Integer isDelete;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }
    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
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
        return "OperationSource{" +
            "id=" + id +
            ", sourceName=" + sourceName +
            ", isDelete=" + isDelete +
            ", createTime=" + createTime +
            ", updateTime=" + updateTime +
        "}";
    }
}
