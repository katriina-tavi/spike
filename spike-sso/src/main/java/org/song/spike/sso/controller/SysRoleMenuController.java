package org.song.spike.sso.controller;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.song.spike.sso.service.SysRoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@Api(value = "sysRoleMenu", tags = "角色菜单表")
@RequestMapping(value = "/sysRoleMenu")
public class SysRoleMenuController  {

    @Autowired
    private SysRoleMenuService sysRoleMenuService;


}
