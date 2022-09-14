package org.song.spike.sso.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxl.sso.core.entity.ReturnT;
import com.xxl.sso.core.login.SsoTokenLoginHelper;
import com.xxl.sso.core.user.XxlSsoUser;
import org.song.spike.sso.entity.UserInfo;
import org.song.spike.sso.mapper.UserInfoMapper;
import org.song.spike.sso.service.UserService;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class UserServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserService {

    @Override
    public ReturnT<UserInfo> findUser(UserInfo userInfo) {

        if (userInfo==null || userInfo.getUsername().trim().length()==0) {
            return new ReturnT<>(ReturnT.FAIL_CODE, "Please input username.");
        }
        if (userInfo==null || userInfo.getPassword().trim().length()==0) {
            return new ReturnT<>(ReturnT.FAIL_CODE, "Please input password.");
        }
        LambdaQueryWrapper<UserInfo> lambdaQuery = Wrappers.lambdaQuery();
        lambdaQuery.eq(UserInfo::getUsername, userInfo.getUsername());
        lambdaQuery.eq(UserInfo::getPassword, userInfo.getPassword());
        UserInfo user = getOne(lambdaQuery);
        if (user != null) {
            return new ReturnT<>(user);
        }
        return new ReturnT<>(ReturnT.FAIL_CODE, "username or password is invalid.");
    }
    public ReturnT<XxlSsoUser> getUserInfo(HttpServletRequest request) {
        return new ReturnT<>(SsoTokenLoginHelper.loginCheck(request));
    }
}
