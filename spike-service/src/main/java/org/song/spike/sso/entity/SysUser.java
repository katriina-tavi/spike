package org.song.spike.sso.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("sys_user")
public class SysUser extends BaseEntity{
    private String userAccount;
    private String userName;
    private String phone;
    private String email;
    private String password;
    private String salt;
}
