package org.song.spike.sso.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 用户角色表
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_user_role")
public class SysUserRole extends BaseEntity {
    /**
    * 用户工号
    */
    private String userAccount;
    /**
    * 角色编码
    */
    private String roleCode;

}
