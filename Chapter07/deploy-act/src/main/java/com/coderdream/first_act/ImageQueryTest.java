package com.coderdream.first_act;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;

public class ImageQueryTest {

	public static void main(String[] args) throws Exception {
		// 创建流程引擎
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
		// 得到流程存储服务对象
		RepositoryService repositoryService = engine.getRepositoryService();
		// 部署一份流程文件与相应的流程图文件
		Deployment dep = repositoryService.createDeployment()
				.addClasspathResource("MyFirstProcess.bpmn").deploy();
		// 查询流程定义
		ProcessDefinition def = repositoryService
				.createProcessDefinitionQuery().deploymentId(dep.getId())
				.singleResult();
		// 查询资源文件
		InputStream is = repositoryService.getProcessDiagram(def.getId());
		// 将输入流转换为图片对象
		BufferedImage image = ImageIO.read(is);
		// 保存为图片文件
		File file = new File("resources/result.png");
		if (!file.exists()) {
			file.createNewFile();
		}
		FileOutputStream fos = new FileOutputStream(file);
		ImageIO.write(image, "png", fos);
		fos.close();
		is.close();
		// 关闭流程引擎
		engine.close();
	}
}
