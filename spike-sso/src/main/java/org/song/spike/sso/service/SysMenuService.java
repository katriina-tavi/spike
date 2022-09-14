package org.song.spike.sso.service;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.TypeReference;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxl.sso.core.entity.ReturnT;
import org.song.spike.sso.dto.MenuTreeDTO;
import org.song.spike.sso.dto.PageDTO;
import org.song.spike.sso.dto.SysMenuDTO;
import org.song.spike.sso.entity.SysMenu;
import org.song.spike.sso.entity.SysRoleMenu;
import org.song.spike.sso.mapper.SysMenuMapper;
import org.song.spike.sso.utils.TreeUtil;
import org.song.spike.sso.utils.WrappedBeanCopier;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SysMenuService extends ServiceImpl<SysMenuMapper, SysMenu> {

    @Resource
    private SysRoleMenuService sysRoleMenuService;

    /**
     * 分页查询国家信息
     *
     * @param page
     * @return
     */
    public ReturnT<IPage<SysMenuDTO>> pageData(PageDTO<SysMenuDTO> page) {
        LambdaQueryWrapper<SysMenu> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.eq(StringUtils.isNotBlank(page.getEntity().getMenuCode()), SysMenu::getMenuCode, page.getEntity().getMenuCode());
        queryWrapper.eq(StringUtils.isNotBlank(page.getEntity().getMenuName()), SysMenu::getMenuName, page.getEntity().getMenuName());
        queryWrapper.eq(SysMenu::getDelFlag, false);
        Page<SysMenu> pageData = this.page(Page.of(page.getPageNo(), page.getPageSize()), queryWrapper);
        return new ReturnT<>(WrappedBeanCopier.copyProperties(pageData, new TypeReference<Page<SysMenuDTO>>() {
        }));
    }


    /**
     * 获取树形菜单
     *
     * @param roleCode
     * @return
     */
    public List<MenuTreeDTO> getSysMenuTree(String roleCode) {
        //查询所有菜单
        LambdaQueryWrapper<SysMenu> lambdaQuery = Wrappers.lambdaQuery();
        lambdaQuery.eq(SysMenu::getDelFlag, Boolean.FALSE);
        lambdaQuery.orderByAsc(SysMenu::getSort);
        List<SysMenu> menuList = this.list(lambdaQuery);
        List<SysMenuDTO> sysMenuDTOS = WrappedBeanCopier.copyPropertiesOfList(menuList, SysMenuDTO.class);

        if (StrUtil.isNotEmpty(roleCode)) {
            //查询这个角色配置的菜单
            LambdaQueryWrapper<SysRoleMenu> lambdaQuery1 = Wrappers.lambdaQuery();
            lambdaQuery1.eq(SysRoleMenu::getRoleCode, roleCode);
            List<SysRoleMenu> roleMenuList = sysRoleMenuService.list(lambdaQuery1);
            if (CollectionUtil.isNotEmpty(roleMenuList)) {
                Set<String> menuCodes = roleMenuList.stream().map(SysRoleMenu::getMenuCode).collect(Collectors.toSet());
                sysMenuDTOS.forEach(v -> v.setSelectFlag(menuCodes.contains(v.getMenuCode()) ? Boolean.TRUE : Boolean.FALSE));
            }
        }
        List<MenuTreeDTO> menuTreeList = sysMenuDTOS.stream().map(MenuTreeDTO::new).collect(Collectors.toList());
        List<MenuTreeDTO> build = TreeUtil.build(menuTreeList, -1L);
        return build;
    }

    public String saveOrUpdateMenu(SysMenuDTO param) {
        Assert.isTrue(StrUtil.isNotEmpty(param.getMenuName()), "菜单名称不能为空");
        Assert.isTrue(StrUtil.isNotEmpty(param.getMenuCode()), "菜单编码不能为空");
        Assert.isTrue(param.getMenuType() != null, "菜单类型不能为空");
        Assert.isTrue(param.getParentId() != null, "父级不能为空");
        Assert.isTrue(StrUtil.isNotEmpty(param.getMenuCode()), "菜单编码不能为空");

        SysMenu sysMenu = WrappedBeanCopier.copyProperties(param, SysMenu.class);

        //根据编码查询菜单
        LambdaQueryWrapper<SysMenu> lambdaQuery = Wrappers.lambdaQuery();
        lambdaQuery.eq(SysMenu::getMenuCode, param.getMenuCode());
        lambdaQuery.eq(SysMenu::getDelFlag, Boolean.FALSE);
        SysMenu sysMenu1 = this.getOne(lambdaQuery);
        //更新
        if (param.getId() != null) {
            //更新时,防止更新成重复数据,需要进行更新校验
            if (sysMenu1 != null && !sysMenu1.getId().equals(param.getId())) {
                Assert.isTrue(Boolean.FALSE, "菜单编码不能重复");
            }
            boolean update = this.updateById(sysMenu);
            Assert.isTrue(update, "操作失败");
        } else {
            Assert.isTrue(sysMenu1 == null, "菜单编码不能重复");
            //数据落库
            sysMenu.setCreateBy("");
            sysMenu.setCreateTime(new Date());
            boolean save = this.save(sysMenu);
            Assert.isTrue(save, "操作失败");
        }


        return "操作成功";
    }


}
