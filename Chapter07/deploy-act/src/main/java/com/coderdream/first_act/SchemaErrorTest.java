package com.coderdream.first_act;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.DeploymentBuilder;

public class SchemaErrorTest {

    public static void main(String[] args) {           
		// 新建流程引擎
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
		// 存储服务
		RepositoryService repositoryService = engine.getRepositoryService();
		// 新建部署构造器
		DeploymentBuilder deploymentBuilder = repositoryService.createDeployment();
		// 增加错误的schema文件（包括无效的标签）<test>test</test> 
		// 校验报错：发现了以元素 'test' 开头的无效内容。
		deploymentBuilder.addClasspathResource("error/schema_error.bpmn");
		// 禁用Schema验证
		deploymentBuilder.disableSchemaValidation();
		// 发布部署构造器
		deploymentBuilder.deploy();
		// 关闭流程引擎
		engine.close();
    }

}
