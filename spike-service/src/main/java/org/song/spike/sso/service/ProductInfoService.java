package org.song.spike.sso.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xxl.sso.core.entity.ReturnT;
import org.song.spike.sso.dto.PageDTO;
import org.song.spike.sso.dto.ProductInfoDTO;

public interface ProductInfoService {

    ReturnT<IPage<ProductInfoDTO>> pageData(PageDTO<ProductInfoDTO> page);


}
