package com.coderdream.first_act;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.DeploymentBuilder;

public class BpmnErrorTest {

    public static void main(String[] args) {       
		// 新建流程引擎
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
		// 存储服务
		RepositoryService repositoryService = engine.getRepositoryService();
		// 新建部署构造器
		DeploymentBuilder deploymentBuilder = repositoryService.createDeployment();
		// 增加错误的schema文件（包括无效的标签）<test>test</test>
		// 报错信息：[Validation set: 'activiti-executable-process' | 
		//Problem: 'activiti-start-event-multiple-found'] : 
		//Multiple none start events are not supported - 
		//[Extra info : processDefinitionId = myProcess | 
		// processDefinitionName = My process |  | id = startevent1 |  
		//| activityName = Start | ] ( line: 4, column: 47)
		deploymentBuilder.addClasspathResource("error/bpmn_error.bpmn");
		// 禁用Bpmn验证
		deploymentBuilder.disableBpmnValidation();
		// 发布部署构造器
		deploymentBuilder.deploy();
		// 关闭流程引擎
		engine.close();
    }

}
