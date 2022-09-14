package org.song.spike.sso.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("product_info")
public class ProductInfo extends BaseEntity{
    private String productCode;
    private String productName;
}
