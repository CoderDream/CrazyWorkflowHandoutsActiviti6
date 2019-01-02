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
public class ListPageGroup {
	public static void main(String[] args) {
		// 新建流程引擎
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
		
		IdentityService identityService = engine.getIdentityService();
		
		List<Group> groups = identityService.createGroupQuery().listPage(1, 5);
		
		for (Group group : groups) {
			System.out.println(group.getId() + "---" + group.getName() + "---" + group.getType());
		}		

		// 关闭流程引擎
		engine.close();
	}
}
//1---Group_3---TYPE_0
//2---Group_6---TYPE_6
//3---Group_7---TYPE_8
//4---Group_1---TYPE_4
//5---Group_3---TYPE_9
