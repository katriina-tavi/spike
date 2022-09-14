package org.song.spike.sso.controller;

import com.xxl.sso.core.entity.ReturnT;
import com.xxl.sso.core.login.SsoTokenLoginHelper;
import com.xxl.sso.core.user.XxlSsoUser;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * sso server (for app)
 *
 * @author xuxueli 2018-04-08 21:02:54
 */
@RestController
@RequestMapping("/app")
public class AppController {
    /**
     * logincheck
     *
     * @param sessionId
     * @return
     */
    @RequestMapping("/logincheck")
    public ReturnT<XxlSsoUser> logincheck(String sessionId) {

        // logout
        XxlSsoUser xxlUser = SsoTokenLoginHelper.loginCheck(sessionId);
        if (xxlUser == null) {
            return new ReturnT<XxlSsoUser>(ReturnT.FAIL_CODE, "sso not login.");
        }
        return new ReturnT<XxlSsoUser>(xxlUser);
    }

}
