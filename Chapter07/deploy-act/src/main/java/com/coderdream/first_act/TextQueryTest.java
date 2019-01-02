package com.coderdream.first_act;

import java.io.InputStream;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.DeploymentBuilder;

public class TextQueryTest {

	public static void main(String[] args) throws Exception {
		// 新建流程引擎
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
		// 存储服务
		RepositoryService repositoryService = engine.getRepositoryService();
		// 新建部署构造器
		DeploymentBuilder deploymentBuilder = repositoryService
				.createDeployment();
		deploymentBuilder.addClasspathResource("my_text.txt");
		Deployment deployment = deploymentBuilder.deploy();
		// 数据查询
		InputStream inputStream = repositoryService.getResourceAsStream(
				deployment.getId(), "my_text.txt");
		int count = inputStream.available();
		byte[] contents = new byte[count];
		inputStream.read(contents);
		String result = new String(contents);
		// 输入结果
		System.out.println(result);
		// 关闭流程引擎
		engine.close();
	}

}
