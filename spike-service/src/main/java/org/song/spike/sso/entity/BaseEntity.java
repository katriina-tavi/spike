package org.song.spike.sso.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BaseEntity {
    private Long id;

    @ApiModelProperty("逻辑删除标记(0--正常 1--删除)")
    private String delFlag;

    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("创建人")
    private String createBy;

    @ApiModelProperty("更新时间")
    private LocalDateTime updateTime;

    @ApiModelProperty("修改人")
    private String updateBy;

    @ApiModelProperty("备注")
    private String remark;
}
