package com.coderdream.first_act;

import java.util.List;

import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.identity.Group;

/**
 *
 */
public class FieldQuery {
	public static void main(String[] args) {
		// 新建流程引擎
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();

		IdentityService identityService = engine.getIdentityService();

		List<Group> groups = identityService.createGroupQuery()
				.groupName("Group_3").groupType("TYPE_0").list();

		for (Group group : groups) {
			System.out.println(group.getId() + "---" + group.getName() + "---"
					+ group.getType());
		}

		// 关闭流程引擎
		engine.close();
	}
}
// 0---Group_3---TYPE_0
// 1---Group_3---TYPE_0

