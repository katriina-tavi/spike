/*
 *
 * 此类来自 https://gitee.com/geek_qi/cloud-platform/blob/master/ace-common/src/main/java/com/github/wxiaoqi/security/common/vo/TreeNode.java
 * @ Apache-2.0
 */

package org.song.spike.sso.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ace
 * @author lengleng
 * @date 2017年11月9日23:33:45
 */
@Data
public class TreeNodeDTO {

	protected Long id;

	protected Long parentId;

	protected List<TreeNodeDTO> children = new ArrayList<>();

	public void add(TreeNodeDTO node) {
		children.add(node);
	}

}
