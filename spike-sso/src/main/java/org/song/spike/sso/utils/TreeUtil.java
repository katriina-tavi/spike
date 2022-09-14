package org.song.spike.sso.utils;


import org.song.spike.sso.dto.SysMenuDTO;
import org.song.spike.sso.dto.TreeNodeDTO;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TreeUtil {
    public static List<SysMenuDTO> listWithTree(List<SysMenuDTO> menuDTOList) {
        // 1. 先查出所有分类数据
        // 2. 找出所有一级分类
        //    在映射到每个一级分类 添加它的子分类类
        return menuDTOList.stream()
                .filter(o -> o.getParentId() == -1)
                // 给每个一级分类加子分类
                .peek(o -> o.setChildren(getChildCategoryList(o, menuDTOList)))
                // 排序
                .sorted(Comparator.comparingInt(SysMenuDTO::getSort))
                // 收集
                .collect(Collectors.toList());
    }
    // 根据当前分类 找出子类， 并通过递归找出子类的子类
    private static List<SysMenuDTO> getChildCategoryList(SysMenuDTO currMenu, List<SysMenuDTO> menuDTOS) {
        return menuDTOS.stream().filter(o -> o.getParentId().equals(currMenu.getId()))
                .peek(o -> o.setChildren(getChildCategoryList(o, menuDTOS)))
                .sorted(Comparator.comparingInt(SysMenuDTO::getSort))
                .collect(Collectors.toList());
    }
    /**
     * 两层循环实现建树
     *
     * @param treeNodes 所有的菜单
     * @param root      父节点ID
     * @return 菜单树
     */
    public static  <T extends TreeNodeDTO> List<T> build(List<T> treeNodes, Object root) {
        List<T> trees = new ArrayList<>();

        for (T treeNode : treeNodes) {

            if (root.equals(treeNode.getParentId())) {
                trees.add(treeNode);
            }

            for (T it : treeNodes) {
                if (it.getParentId().equals(treeNode.getId())) {
                    if (treeNode.getChildren() == null) {
                        treeNode.setChildren(new ArrayList<>());
                    }
                    treeNode.add(it);
                }
            }
        }
        return trees;
    }
}
