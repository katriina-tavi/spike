package org.song.spike.sso.dto;

import com.xxl.sso.core.user.XxlSsoUser;
import lombok.Data;

@Data
public class XxlSsoUserDTO extends XxlSsoUser {

    private String userAccount;
}
