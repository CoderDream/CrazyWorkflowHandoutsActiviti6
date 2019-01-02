package com.coderdream.first_act;

import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.identity.Group;

/**
 *
 */
public class SingleResult {
	public static void main(String[] args) {
		// 新建流程引擎
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();

		IdentityService identityService = engine.getIdentityService();
		//
		Group group = identityService.createGroupQuery().groupName("Group_5")
				.singleResult();

		System.out.println(group.getId() + "---" + group.getName() + "---"
				+ group.getType());

		// 关闭流程引擎
		engine.close();
	}
}
// 7---Group_5---TYPE_0
