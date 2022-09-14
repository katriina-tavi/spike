package org.song.spike.sso.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class MenuTreeDTO extends TreeNodeDTO implements Serializable {

    private String icon;

    private String code;

    private String name;

    private String path;

    private String component;

    private String label;

    private Integer sort;

    private Boolean hasChildren;

    private String menuType;

    //是否勾选标识
    private Boolean selectFlag;

    public MenuTreeDTO() {
    }



    public MenuTreeDTO(SysMenuDTO menu) {
        this.id = menu.getId();
        this.parentId = menu.getParentId();
        this.icon = menu.getIcon();
        this.name = menu.getMenuName();
        this.code = menu.getMenuCode();
        this.path = menu.getPath();
        this.component = menu.getComponent();
        this.label = menu.getMenuName();
        this.sort = menu.getSort();
        this.menuType = menu.getMenuType();
        this.selectFlag = menu.getSelectFlag();
    }

}
