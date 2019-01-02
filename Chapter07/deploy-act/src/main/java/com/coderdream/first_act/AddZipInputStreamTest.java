package com.coderdream.first_act;

import java.io.File;
import java.io.FileInputStream;
import java.util.zip.ZipInputStream;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.DeploymentBuilder;

/**
 * AddZipInputStreamTest
 *
 */
public class AddZipInputStreamTest {
	public static void main(String[] args) throws Exception {
		// 新建流程引擎
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
		// 存储服务
		RepositoryService repositoryService = engine.getRepositoryService();
		// 新建部署构造器
		DeploymentBuilder deploymentBuilder = repositoryService.createDeployment();
		// 新建文件输入流
		FileInputStream fileInputStream = new FileInputStream(new File("resources/datas.zip"));
		// 新建Zip输入流
		ZipInputStream zipInputStream = new ZipInputStream(fileInputStream);
		// 将Zip输入流添加到部署构造器中
		deploymentBuilder.addZipInputStream(zipInputStream);
		// 发布部署构造器
		deploymentBuilder.deploy();
		// 关闭流程引擎
		engine.close();
	}
}
