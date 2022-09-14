package org.song.spike.sso.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 角色菜单表
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_role_menu")
public class SysRoleMenu extends BaseEntity {
    /**
    * 角色编码
    */
    private String roleCode;
    /**
    * 菜单编码
    */
    private String menuCode;

}
