package org.song.spike.sso.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author xuxueli 2018-03-22 23:51:51
 */
@Data
@TableName("user_info")
public class UserInfo extends BaseEntity{

    private String username;
    private String password;

}
