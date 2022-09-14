package org.song.spike.sso.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="SysUserRoleDTO", description="用户角色表")
public class SysUserRoleDTO extends BaseDTO {
    @ApiModelProperty(value = "用户工号")
    private String userAccount;
    @ApiModelProperty(value = "角色编码")
    private String roleCode;

}
