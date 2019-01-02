package com.coderdream.first_act;

import org.activiti.bpmn.model.BpmnModel;
import org.activiti.bpmn.model.EndEvent;
import org.activiti.bpmn.model.Process;
import org.activiti.bpmn.model.SequenceFlow;
import org.activiti.bpmn.model.StartEvent;
import org.activiti.bpmn.model.UserTask;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.DeploymentBuilder;

/**
 * 添加BPMN模型
 *
 */
public class AddBpmnModelTest {
	public static void main(String[] args) throws Exception {
		// 新建流程引擎
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
		// 存储服务
		RepositoryService repositoryService = engine.getRepositoryService();
		// 新建部署构造器
		DeploymentBuilder deploymentBuilder = repositoryService.createDeployment();
		String resourceName = "My Process";
		BpmnModel bpmnModel = createProcessModel();
		// 发布部署构造器
		deploymentBuilder.addBpmnModel(resourceName, bpmnModel);
		// 发布部署构造器
		deploymentBuilder.deploy();
		// 关闭流程引擎
		engine.close();
	}
	
	private static BpmnModel createProcessModel() {
		// 创建BPMN模型
		BpmnModel model = new BpmnModel();
		// 创建一个流程定义
		Process process = new Process();
		model.addProcess(process);
		process.setId("myProcess");
		process.setName("My Process");
		// 开始事件
		StartEvent startEvent = new StartEvent();
		startEvent.setId("startEvent");
		process.addFlowElement(startEvent);
		// 用户任务
		UserTask userTask = new UserTask();
		userTask.setName("User Task");
		userTask.setId("userTask");
		process.addFlowElement(userTask);
		// 结束事件
		EndEvent endEvent = new EndEvent();
		endEvent.setId("endEvent");
		process.addFlowElement(endEvent);		
		// 添加流程顺序
		process.addFlowElement(new SequenceFlow("startEvent", "userTask"));
		process.addFlowElement(new SequenceFlow("userTask", "endEvent"));
		return model;
	}
}

//<?xml version="1.0" encoding="UTF-8"?>
//<definitions xmlns="http://www.omg.org/spec/BPMN/20100524/MODEL" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:activiti="http://activiti.org/bpmn" xmlns:bpmndi="http://www.omg.org/spec/BPMN/20100524/DI" xmlns:omgdc="http://www.omg.org/spec/DD/20100524/DC" xmlns:omgdi="http://www.omg.org/spec/DD/20100524/DI" typeLanguage="http://www.w3.org/2001/XMLSchema" expressionLanguage="http://www.w3.org/1999/XPath" targetNamespace="http://www.activiti.org/test">
//  <process id="myProcess" name="My Process" isExecutable="true">
//    <startEvent id="startEvent"></startEvent>
//    <userTask id="userTask" name="User Task"></userTask>
//    <endEvent id="endEvent"></endEvent>
//    <sequenceFlow sourceRef="startEvent" targetRef="userTask"></sequenceFlow>
//    <sequenceFlow sourceRef="userTask" targetRef="endEvent"></sequenceFlow>
//  </process>
//  <bpmndi:BPMNDiagram id="BPMNDiagram_myProcess">
//    <bpmndi:BPMNPlane bpmnElement="myProcess" id="BPMNPlane_myProcess"></bpmndi:BPMNPlane>
//  </bpmndi:BPMNDiagram>
//</definitions>
