package org.song.spike.sso.dto;

import lombok.Data;

@Data
public class SysUserDTO extends BaseDTO {
    private String userAccount;
    private String userName;
    private String phone;
    private String email;
}
