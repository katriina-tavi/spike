package org.song.spike.sso.service.impl;

import com.alibaba.fastjson.TypeReference;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxl.sso.core.entity.ReturnT;
import org.song.spike.sso.dto.PageDTO;
import org.song.spike.sso.dto.ProductInfoDTO;
import org.song.spike.sso.entity.ProductInfo;
import org.song.spike.sso.mapper.ProductInfoMapper;
import org.song.spike.sso.service.ProductInfoService;
import org.song.spike.sso.utils.WrappedBeanCopier;
import org.springframework.stereotype.Service;

@Service
public class ProductInfoServiceImpl extends ServiceImpl<ProductInfoMapper, ProductInfo> implements ProductInfoService {

    /**
     * 分页查询产品信息
     *
     * @param page
     * @return
     */
    public ReturnT<IPage<ProductInfoDTO>> pageData(PageDTO<ProductInfoDTO> page) {
        LambdaQueryWrapper<ProductInfo> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.eq(ProductInfo::getDelFlag, false);
        Page<ProductInfo> pageData = this.page(Page.of(page.getPageNo(), page.getPageSize()), queryWrapper);
        return new ReturnT<>(WrappedBeanCopier.copyProperties(pageData, new TypeReference<Page<ProductInfoDTO>>() {
        }));
    }
}
