package com.coderdream.first_act;

import java.util.Random;

import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.identity.Group;

/**
 * SaveGroup
 *
 */
public class SaveGroup {
	public static void main(String[] args) {
		// 新建流程引擎
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
		
		IdentityService identityService = engine.getIdentityService();
		
		Random ran = new Random(10);
		for (int i = 0; i < 10; i++) {
			Group group = identityService.newGroup(String.valueOf(i));
			group.setName("Group_" + ran.nextInt(10));
			group.setType("TYPE_" + ran.nextInt(10));
			identityService.saveGroup(group);
		}

		// 关闭流程引擎
		engine.close();
	}
}
