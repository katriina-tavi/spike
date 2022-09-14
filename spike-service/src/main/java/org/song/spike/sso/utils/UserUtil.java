package org.song.spike.sso.utils;

import com.xxl.sso.core.login.SsoTokenLoginHelper;
import com.xxl.sso.core.user.XxlSsoUser;
import com.xxl.sso.core.util.JedisUtil;
import org.song.spike.sso.dto.SysUserDTO;

import javax.servlet.http.HttpServletRequest;

public class UserUtil {


    public static SysUserDTO getUserInfo() {

        HttpServletRequest request = RequestContextHolderUtil.getRequest();
        XxlSsoUser xxlSsoUser = SsoTokenLoginHelper.loginCheck(request);

        SysUserDTO sysUserDTO = new SysUserDTO();
        sysUserDTO.setUserAccount(xxlSsoUser.getUsername());
        sysUserDTO.setUserName("");
        sysUserDTO.setEmail("");
        sysUserDTO.setId(0L);


        String concat = "xxl_sso_sessionid".concat("#2");

        Object objectValue = JedisUtil.getObjectValue(concat);




        return sysUserDTO;
    }
}
