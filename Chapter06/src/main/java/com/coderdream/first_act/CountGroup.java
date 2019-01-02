package com.coderdream.first_act;

import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;

/**
 * Hello world!
 *
 */
public class CountGroup {
	public static void main(String[] args) {
		// 新建流程引擎
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
		
		IdentityService identityService = engine.getIdentityService();		
		// 
		Long count = identityService.createGroupQuery().count();
		
		System.out.println(count);		

		// 关闭流程引擎
		engine.close();
	}
}
// 10
