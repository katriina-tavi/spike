package org.song.spike.sso.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 系统角色表
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_role")
public class SysRole extends BaseEntity {
    /**
    * 角色名称
    */
    private String roleName;
    /**
    * 角色编码
    */
    private String roleCode;
    /**
    * 角色描述
    */
    private String roleDesc;

}
