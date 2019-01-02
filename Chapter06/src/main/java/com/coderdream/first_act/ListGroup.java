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
public class ListGroup {
	public static void main(String[] args) {
		// 新建流程引擎
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
		
		IdentityService identityService = engine.getIdentityService();
		
		List<Group> groups = identityService.createGroupQuery().list();
		
		for (Group group : groups) {
			System.out.println(group.getId() + "---" + group.getName() + "---" + group.getType());
		}		

		// 关闭流程引擎
		engine.close();
	}
}
