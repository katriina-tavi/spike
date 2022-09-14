package org.song.spike.sso.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="SysRoleMenuDTO", description="角色菜单表")
public class SysRoleMenuDTO extends BaseDTO {
    @ApiModelProperty(value = "角色编码")
    private String roleCode;
    @ApiModelProperty(value = "菜单编码")
    private String menuCode;

}
