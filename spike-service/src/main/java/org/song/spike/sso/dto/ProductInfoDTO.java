package org.song.spike.sso.dto;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.song.spike.sso.entity.BaseEntity;

@Data
public class ProductInfoDTO extends BaseDTO {
    private String productCode;
    private String productName;
}
