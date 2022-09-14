package org.song.spike.sso.dto;

import lombok.Data;

import java.util.List;

@Data
public class SysMenuDTO extends BaseDTO {
    private String menuName;
    private String menuCode;
    private String menuType;
    private String path;
    private Long parentId;
    private String icon;
    private String component;
    private Integer sort;

    private List<SysMenuDTO> children;


    //是否勾选标识
    private Boolean selectFlag;

    //角色编码
    private String roleCode;
}
