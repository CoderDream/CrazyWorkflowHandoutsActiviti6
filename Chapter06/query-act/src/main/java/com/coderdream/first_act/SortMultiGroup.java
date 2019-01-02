package com.coderdream.first_act;

import java.util.List;

import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.identity.Group;

/**
 * 多字段排序 [JAVA中的Random()函数](https://www.cnblogs.com/ningvsban/p/3590722.html)
 */
public class SortMultiGroup {
	public static void main(String[] args) {
		// 新建流程引擎
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();

		IdentityService identityService = engine.getIdentityService();

		// 先按名称降序，再按类型降序
		List<Group> groups = identityService.createGroupQuery()
				.orderByGroupName().desc().orderByGroupType().desc().list();

		for (Group group : groups) {
			System.out.println(group.getId() + "---" + group.getName() + "---"
					+ group.getType());
		}

		// 关闭流程引擎
		engine.close();
	}
}
// 3---Group_7---TYPE_8
// 2---Group_6---TYPE_6
// 8---Group_6---TYPE_3
// 7---Group_5---TYPE_0
// 5---Group_3---TYPE_9
// 9---Group_3---TYPE_8
// 0---Group_3---TYPE_0
// 1---Group_3---TYPE_0
// 6---Group_1---TYPE_8
// 4---Group_1---TYPE_4

