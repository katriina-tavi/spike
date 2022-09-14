package org.song.spike.sso.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xxl.sso.core.entity.ReturnT;
import com.xxl.sso.core.user.XxlSsoUser;
import org.song.spike.sso.dto.PageDTO;
import org.song.spike.sso.dto.SysUserDTO;
import org.song.spike.sso.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * sso server (for app)
 *
 * @author xuxueli 2018-04-08 21:02:54
 */
@RestController
@RequestMapping("/user")
public class SysUserController {

    @Autowired
    private SysUserService userService;


    /**
     * Login
     *
     * @param request
     * @return
     */
    @RequestMapping("/index")
    public ReturnT<XxlSsoUser> login(HttpServletRequest request) {
        return userService.getSysUser(request);
    }
    @PostMapping("/pageData")
    ReturnT<IPage<SysUserDTO>> pageData(@RequestBody PageDTO<SysUserDTO> page) {
        return userService.pageData(page);
    }
}
