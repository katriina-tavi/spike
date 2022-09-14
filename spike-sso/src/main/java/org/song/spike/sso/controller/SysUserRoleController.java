package org.song.spike.sso.controller;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.song.spike.sso.service.SysUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@Api(value = "sysUserRole", tags = "用户角色表")
@RequestMapping(value = "/sysUserRole")
public class SysUserRoleController {

    @Autowired
    private SysUserRoleService sysUserRoleService;


}
