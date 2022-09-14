package org.song.spike.sso.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("sys_menu")
public class SysMenu extends BaseEntity{
    private String menuName;
    private String menuCode;
    private String menuType;
    private String path;
    private Long parentId;
    private String icon;
    private String component;
    private Integer sort;
}
