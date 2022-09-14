package org.song.spike.sso.service;

import com.alibaba.fastjson.TypeReference;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxl.sso.core.entity.ReturnT;
import com.xxl.sso.core.login.SsoTokenLoginHelper;
import com.xxl.sso.core.user.XxlSsoUser;
import org.song.spike.sso.dto.PageDTO;
import org.song.spike.sso.dto.SysUserDTO;
import org.song.spike.sso.entity.SysUser;
import org.song.spike.sso.mapper.SysUserMapper;
import org.song.spike.sso.utils.WrappedBeanCopier;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class SysUserService extends ServiceImpl<SysUserMapper, SysUser> {

    public ReturnT<SysUser> findUser(SysUser sysUser) {

        if (sysUser == null || sysUser.getUsername().trim().length() == 0) {
            return new ReturnT<>(ReturnT.FAIL_CODE, "Please input username.");
        }
        if (sysUser == null || sysUser.getPassword().trim().length() == 0) {
            return new ReturnT<>(ReturnT.FAIL_CODE, "Please input password.");
        }
        LambdaQueryWrapper<SysUser> lambdaQuery = Wrappers.lambdaQuery();
        lambdaQuery.eq(SysUser::getUsername, sysUser.getUsername());
        lambdaQuery.eq(SysUser::getPassword, sysUser.getPassword());
        SysUser user = getOne(lambdaQuery);
        if (user != null) {
            return new ReturnT<>(user);
        }
        return new ReturnT<>(ReturnT.FAIL_CODE, "username or password is invalid.");
    }


    public ReturnT<XxlSsoUser> getSysUser(HttpServletRequest request) {
        return new ReturnT<>(SsoTokenLoginHelper.loginCheck(request));
    }

    /**
     * 分页查询国家信息
     *
     * @param page
     * @return
     */
    public ReturnT<IPage<SysUserDTO>> pageData(PageDTO<SysUserDTO> page) {
        LambdaQueryWrapper<SysUser> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.eq(StringUtils.isNotBlank(page.getEntity().getUsername()), SysUser::getUsername, page.getEntity().getUsername());
        queryWrapper.eq(SysUser::getDelFlag, false);
        Page<SysUser> pageData = this.page(Page.of(page.getPageNo(), page.getPageSize()), queryWrapper);
        return new ReturnT<>(WrappedBeanCopier.copyProperties(pageData, new TypeReference<Page<SysUserDTO>>() {
        }));
    }
}
