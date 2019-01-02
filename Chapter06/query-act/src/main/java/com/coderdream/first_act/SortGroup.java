package com.coderdream.first_act;

import java.util.List;

import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.identity.Group;

/**
 * Hello world!
 *
 */
public class SortGroup {
	public static void main(String[] args) {
		// 新建流程引擎
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();

		IdentityService identityService = engine.getIdentityService();

		List<Group> groups = identityService.createGroupQuery()
				.orderByGroupName().desc().list();

		for (Group group : groups) {
			System.out.println(group.getId() + "---" + group.getName() + "---"
					+ group.getType());
		}

		// 关闭流程引擎
		engine.close();
	}
}
// 1---Group_1---TYPE_1
// 2---Group_2---TYPE_2
// 3---Group_3---TYPE_3
// 4---Group_4---TYPE_4
// 5---Group_5---TYPE_5
