package org.song.spike.sso.dto;

import lombok.Data;

@Data
public class SysUserDTO extends BaseDTO {
    private String userAccount;
    private String username;
    private String phone;
    private String email;
    private String password;
    private String salt;
}
