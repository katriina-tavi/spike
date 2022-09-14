package org.song.spike.sso.controller;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.song.spike.sso.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@Api(value = "sysRole", tags = "系统角色表")
@RequestMapping(value = "/sysRole")
public class SysRoleController {

    @Autowired
    private SysRoleService sysRoleService;


}
