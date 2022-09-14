package org.song.spike.sso.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xxl.sso.core.entity.ReturnT;
import org.song.spike.sso.dto.PageDTO;
import org.song.spike.sso.dto.ProductInfoDTO;
import org.song.spike.sso.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/productInfo")
public class ProductInfoController {

    @Autowired
    private ProductInfoService sysMenuService;

    @PostMapping("/pageData")
    ReturnT<IPage<ProductInfoDTO>> pageData(@RequestBody PageDTO<ProductInfoDTO> page) {
        return sysMenuService.pageData(page);
    }
}
