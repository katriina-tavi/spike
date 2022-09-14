package org.song.spike.sso.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xxl.sso.core.entity.ReturnT;
import org.song.spike.sso.dto.PageDTO;
import org.song.spike.sso.dto.SysMenuDTO;
import org.song.spike.sso.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * sso server (for app)
 *
 * @author xuxueli 2018-04-08 21:02:54
 */
@RestController
@RequestMapping("/menu")
public class SysMenuController {

    @Autowired
    private SysMenuService sysMenuService;

    @PostMapping("/pageData")
    ReturnT<IPage<SysMenuDTO>> pageData(@RequestBody PageDTO<SysMenuDTO> page) {
        return sysMenuService.pageData(page);
    }
}
