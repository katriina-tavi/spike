package org.song.spike.sso.service;

import com.xxl.sso.core.entity.ReturnT;
import com.xxl.sso.core.user.XxlSsoUser;
import org.song.spike.sso.entity.UserInfo;

import javax.servlet.http.HttpServletRequest;

public interface UserService {

    ReturnT<UserInfo> findUser(UserInfo userInfo);

    ReturnT<XxlSsoUser> getUserInfo(HttpServletRequest request);


}
