# 第2章　安装与运行Activiti 
## 2.1　下载与运行Activiti
###  2.1.1 下载和安装JDK
###  2.1.2 下载和安装MySQL
###  2.1.3 下载和安装Activiti
- 在浏览器输入 https://github.com/Activiti/Activiti/releases?after=7-201711-EA 进入 Activiti的GitHub网页；
- 下载zip包并解压；
- 将war文件夹的activiti-admin.war、activiti-app.war和activiti-rest.war拷贝到D:\Java\apache-tomcat-8.5.12\webapps目录下；
- 执行D:\Java\apache-tomcat-8.5.12\bin\startup.bat；
- 启动成功需要一分钟左右。
![](<images/01_Deploy.png>)
## 2.2 运行官方的Activiti示例
### 2.2.1 请假流程概述
### 2.2.2 新建用户
	
- 在浏览器输入 http://localhost:8080/activiti-app 进入app项目登陆界面，输入用户名和密码（amdin/test）进入系统：
![](<images/02_Login.png>) 
- 点击【Identity Management】图标，进入用户管理界面
![](<images/03_MainIdentityManagement.png>)
- 选择【Users】面板，点击【Create User】按钮，新建用户
![](<images/04_Users.png>)
- 输入用户信息                                                                                                                                                 
![](<images/05_CreateUser.png>)
- 创建两个用户worker和leader，列表如下
![](<images/06_UserList.png>)

### 2.2.3 定义流程

- 点击页面左上角的图标，进入主界面
![](<images/07_MainPage.png>)
- 点击【Kickstart App】图标，进入流程界面
![](<images/08_CreateProcess.png>)
- 点击【Create Process】按钮：设置流程名称
![](<images/17_ProcessInfo.png>)
- 在开始节点点击头像图标，创建第一个节点
![](<images/09_Process1.png>)
- 设置第一个节点
![](<images/10_Process2.png>)
- 继续创建第二个节点和流程结束节点：
![](<images/11_Process3.png>)
- 设置节点的【Assignments】                                                                                                                               
![](<images/42_Assignments.png>)
- 选择分配给单个用户                                                                                                                               
![](<images/12_Process4.png>)
- 第一个节点的设置结果
![](<images/14_Process5.png>)
- 第二个节点的设置结果
![](<images/15_Process6.png>)
- 点击左上角的按钮，保存流程
![](<images/16_Process7.png>)

### 2.2.4 发布流程
- 创建应用                                                                                                                                                 
![](<images/18_CreateApp.png>)
- 设置应用信息                                                                                                                                                 
![](<images/19_AppInfo.png>)
- 准备将流程添加到应用，点击【Edit included models】进入添加页面
![](<images/20_AddModelsToApp.png>)
- 点击流程，将流程添加到应用，右上角的图标变成实心的即表示添加成功
![](<images/21_AddModel.png>)
- 流程添加完成                                                                                                                                                 
![](<images/22_ModelAdded.png>)
- 准备应用发布，点击右上角的【Publish】按钮                                                                                                                                                 
![](<images/23_AppPublish.png>)
- 确认发布                                                                                                                                                 
![](<images/24_PublishConfirm.png>)
- 应用发布完成                                                                                                                                                 
![](<images/25_AppAdded.png>)

### 2.2.5 启动与完成流程

- 使用worker账号登陆系统，准备发起流程
![](<images/26_StartProcess1.png>)
- 点击【Start process】，发起流程，可以点击Comments旁边的+号填入备注信息                                                                                                                                                                                                                                                                                                  
![](<images/27_StartProcess2.png>)
- 流程流转图，现阶段节点在worker这里
![](<images/28_StartProcess3.png>)
- 点击【Complete】按钮，发起流程
![](<images/29_StartProcess4.png>)
- 流程流转图，现阶段节点已转到leader这里
![](<images/30_StartProcess5.png>)
- 使用 leader 账号登陆系统，leader登陆后的界面，有一个任务需要审核，点击右上角的【Complete】可以进行审核
![](<images/31_ProcessAudit1.png>)
- 直接点击【Process】面板，可以查看流程详情
![](<images/32_ProcessAudit2.png>)
- 点击【Task】面板右上角的【Complete】完成审核
![](<images/33_ProcessAudit3.png>)
- 在浏览器输入 http://localhost:8080/activiti-admin 进入admin项目登陆界面，输入用户名和密码（amdin/admin）进入系统：                                                                                                                      
![](<images/34_AdminLogin.png>)
- admin项目首页                                                                                                                                                                               
![](<images/35_AdminMain.png>)
- 修改端口信息，记得修改密码信息为test，因为app项目的admin账号对应的密码是test：                                                                                
![](<images/36_Config.png>)
- 校验信息                                                                                                                               
![](<images/37_ConfigCheck.png>)
- 已发布的信息列表                                                                                                                               
![](<images/38_Info1.png>)
- 流程定义列表                                                                                                                               
![](<images/39_Info2.png>)
- 单个流程信息详情                                                                                                                               
![](<images/43_Info5.png>)
- 实例信息列表                                                                                                                               
![](<images/40_Info3.png>)
- 任务信息列表                                                                                                                               
![](<images/41_Info4.png>)
- 任务详细信息                                                                                                                               
![](<images/44_Info6.png>)                                                                                                                       
### 2.2.6 流程引擎管理
## 2.3 安装开发环境
### 2.3.1 下载Eclipse
### 2.3.2 安装Activiti插件
## 2.4 编写第一个Activiti程序
### 2.4.1 如何运行本书示例
### 2.4.2 建立工程环境
- 创建一个Java的Maven工程
![](<images/45_Project.png>)      
- Maven 依赖
```xml
<dependencies>
	<dependency>
		<groupId>junit</groupId>
		<artifactId>junit</artifactId>
		<version>4.11</version>
		<scope>test</scope>
	</dependency>
	<dependency>
		<groupId>org.activiti</groupId>
		<artifactId>activiti-engine</artifactId>
		<version>6.0.0</version>
	</dependency>
	<dependency>
		<groupId>org.slf4j</groupId>
		<artifactId>slf4j-api</artifactId>
		<version>1.7.21</version>
	</dependency>
	<dependency>
		<groupId>org.slf4j</groupId>
		<artifactId>slf4j-log4j12</artifactId>
		<version>1.7.21</version>
	</dependency>
	<dependency>
		<groupId>mysql</groupId>
		<artifactId>mysql-connector-java</artifactId>
		<version>5.1.47</version>
	</dependency>
</dependencies>
```

### 2.4.3 创建配置文件
- activiti.cfg.xml配置文件
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans 
       http://www.springframework.org/schema/beans/spring-beans.xsd">
	<!-- 流程引擎配置的bean -->
	<bean id="processEngineConfiguration"
		class="org.activiti.engine.impl.cfg.StandaloneProcessEngineConfiguration">
		<property name="jdbcUrl" value="jdbc:mysql://localhost:3306/act?
            useUnicode=true&amp;characterEncoding=utf8&amp;serverTimezone=UTC&amp;useSSL=false" />
		<property name="jdbcDriver" value="com.mysql.jdbc.Driver" />
		<property name="jdbcUsername" value="root" />
		<property name="jdbcPassword" value="1234" />
		<property name="databaseSchemaUpdate" value="true" />
	</bean>
</beans>
```
### 2.4.4 创建流程文件
- 流程文件MyFirstProcess.bpmn（两个节点）
![](<images/46_ProcessFile.png>)

- xml内容
```xml
<?xml version="1.0" encoding="UTF-8"?>
<definitions ...">
  <process id="myProcess" name="My process" isExecutable="true">
    <startEvent id="startevent1" name="Start"></startEvent>
    <endEvent id="endevent1" name="End"></endEvent>
    <userTask id="usertask1" name="Write Vacation"></userTask>
    <userTask id="usertask2" name="Audit"></userTask>
    <sequenceFlow id="flow1" sourceRef="startevent1" targetRef="usertask1"></sequenceFlow>
    <sequenceFlow id="flow2" sourceRef="usertask1" targetRef="usertask2"></sequenceFlow>
    <sequenceFlow id="flow3" sourceRef="usertask2" targetRef="endevent1"></sequenceFlow>
  </process>
  <bpmndi:BPMNDiagram id="BPMNDiagram_myProcess">
    <bpmndi:BPMNPlane bpmnElement="myProcess" id="BPMNPlane_myProcess">
      <bpmndi:BPMNShape bpmnElement="startevent1" id="BPMNShape_startevent1">
        <omgdc:Bounds height="35.0" width="35.0" x="220.0" y="250.0"></omgdc:Bounds>
      </bpmndi:BPMNShape>
      <bpmndi:BPMNShape bpmnElement="endevent1" id="BPMNShape_endevent1">
        <omgdc:Bounds height="35.0" width="35.0" x="701.0" y="250.0"></omgdc:Bounds>
      </bpmndi:BPMNShape>
      <bpmndi:BPMNShape bpmnElement="usertask1" id="BPMNShape_usertask1">
        <omgdc:Bounds height="55.0" width="105.0" x="320.0" y="240.0"></omgdc:Bounds>
      </bpmndi:BPMNShape>
      <bpmndi:BPMNShape bpmnElement="usertask2" id="BPMNShape_usertask2">
        <omgdc:Bounds height="55.0" width="105.0" x="521.0" y="240.0"></omgdc:Bounds>
      </bpmndi:BPMNShape>
      <bpmndi:BPMNEdge bpmnElement="flow1" id="BPMNEdge_flow1">
        <omgdi:waypoint x="255.0" y="267.0"></omgdi:waypoint>
        <omgdi:waypoint x="320.0" y="267.0"></omgdi:waypoint>
      </bpmndi:BPMNEdge>
      <bpmndi:BPMNEdge bpmnElement="flow2" id="BPMNEdge_flow2">
        <omgdi:waypoint x="425.0" y="267.0"></omgdi:waypoint>
        <omgdi:waypoint x="521.0" y="267.0"></omgdi:waypoint>
      </bpmndi:BPMNEdge>
      <bpmndi:BPMNEdge bpmnElement="flow3" id="BPMNEdge_flow3">
        <omgdi:waypoint x="626.0" y="267.0"></omgdi:waypoint>
        <omgdi:waypoint x="701.0" y="267.0"></omgdi:waypoint>
      </bpmndi:BPMNEdge>
    </bpmndi:BPMNPlane>
  </bpmndi:BPMNDiagram>
</definitions>
```
### 2.4.5 加载流程文件与启动流程

- 自动创建数据库表
```java
public class App {
	public static void main(String[] args) {
		// 新建流程引擎
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();

		// 关闭流程引擎
		engine.close();
	}
}
```

- 运行结果
```
04:04:56,050 [main] INFO  org.activiti.engine.impl.db.DbSqlSession  - 
performing create on engine with resource org/activiti/db/create/activiti.mysql.create.engine.sql
04:04:56,080 [main] INFO  org.activiti.engine.impl.db.DbSqlSession  - 
Found MySQL: majorVersion=5 minorVersion=7
04:05:25,503 [main] INFO  org.activiti.engine.impl.db.DbSqlSession  - 
performing create on history with resource org/activiti/db/create/activiti.mysql.create.history.sql
04:05:25,511 [main] INFO  org.activiti.engine.impl.db.DbSqlSession  - 
Found MySQL: majorVersion=5 minorVersion=7
04:05:29,757 [main] INFO  org.activiti.engine.impl.db.DbSqlSession  - 
performing create on identity with resource org/activiti/db/create/activiti.mysql.create.identity.sql
04:05:29,764 [main] INFO  org.activiti.engine.impl.db.DbSqlSession  - 
Found MySQL: majorVersion=5 minorVersion=7
04:05:31,511 [main] INFO  org.activiti.engine.impl.ProcessEngineImpl  - ProcessEngine default created
04:05:31,790 [main] INFO  org.activiti.engine.ProcessEngines  - initialised process engine default
```

- 创建流程
```java
public class App {
	public static void main(String[] args) {
		// 新建流程引擎
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
		// 存储服务
		RepositoryService repositoryService = engine.getRepositoryService();
		// 运行时服务
		RuntimeService runtimeService = engine.getRuntimeService();
		// 任务服务
		TaskService taskService =engine.getTaskService();
		// 部署服务
		repositoryService.createDeployment().addClasspathResource("MyFirstProcess.bpmn").deploy();
		// process的id属性
		ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("myProcess");
		
		// 普通员工完成请假的任务
		Task task = taskService.createTaskQuery().processInstanceId(processInstance.getId()).singleResult();
		System.out.println("当前流程节点：" + task.getName());
		taskService.complete(task.getId());
		
		// 经理审批任务
		task = taskService.createTaskQuery().processInstanceId(processInstance.getId()).singleResult();
		System.out.println("当前流程节点：" + task.getName());
		taskService.complete(task.getId());
		
		// 流程结束
		task = taskService.createTaskQuery().processInstanceId(processInstance.getId()).singleResult();
		System.out.println("流程结束：" + task);
		// 关闭流程引擎
		engine.close();
	}
}
```

- 运行结果
```
04:34:35,090 [main] INFO  org.activiti.engine.compatibility.DefaultActiviti5CompatibilityHandlerFactory  
- Activiti 5 compatibility handler implementation not found or error during instantiation : 
- org.activiti.compatibility.DefaultActiviti5CompatibilityHandler. Activiti 5 backwards compatibility disabled.
04:34:35,196 [main] INFO  org.activiti.engine.impl.ProcessEngineImpl  - ProcessEngine default created
04:34:35,202 [main] INFO  org.activiti.engine.ProcessEngines  - initialised process engine default
当前流程节点：Write Vacation
当前流程节点：Audit
流程结束：null
```

## 2.5 本章小结
