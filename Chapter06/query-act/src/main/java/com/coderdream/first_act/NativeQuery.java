package com.coderdream.first_act;

import java.util.List;

import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.identity.Group;

/**
 *
 */
public class NativeQuery {
	public static void main(String[] args) {
		// 新建流程引擎
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();

		IdentityService identityService = engine.getIdentityService();

		List<Group> groups = identityService.createNativeGroupQuery()
				.sql("SELECT * FROM ACT_ID_GROUP WHERE NAME_ = #{name}")
				.parameter("name", "Group_3").list();

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
// 5---Group_3---TYPE_9
// 9---Group_3---TYPE_8

