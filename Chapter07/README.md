# 第7章 流程存储
## 7.1 流程文件部署
### 7.1.1 Deployment对象
### 7.1.2 DeploymentBuilder对象
### 7.1.3 添加输入流资源
### 7.1.4 添加classpath资源
### 7.1.5 添加字符串资源
### 7.1.6 添加压缩包资源


- 代码清单：AddZipInputStreamTest.java
```java
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
```
- 执行结果
```
act_re_deployment表中得到ID
根据ID（DEPLOYMENT_ID_）在act_ge_bytearray表中查看数据
```

### 7.1.7 添加BPMN模型资源

- 代码清单：AddBpmnModelTest.java
```java
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
```
- 执行结果
```
通过查询数据库可以看到act_re_deployment表新增了一条数据；
根据最新ID（DEPLOYMENT_ID_）在act_ge_bytearray表中查看数据，
得到两条记录，一条为xml格式、另一条为图片格式
```

### 7.1.8 修改部署信息
### 7.1.9 过滤重复部署
### 7.1.10 取消部署时的验证


- 代码清单：SchemaErrorTest.java
```java
// 新建部署构造器
DeploymentBuilder deploymentBuilder = repositoryService.createDeployment();
// 增加错误的schema文件（包括无效的标签）<test>test</test> 
// 校验报错：发现了以元素 'test' 开头的无效内容。
deploymentBuilder.addClasspathResource("error/schema_error.bpmn");
// 禁用Schema验证
deploymentBuilder.disableSchemaValidation();
// 发布部署构造器
deploymentBuilder.deploy();
```
- 执行结果
```
如果不禁用验证，则校验报错：发现了以元素 'test' 开头的无效内容。
```


- 代码清单：BpmnErrorTest.java
```java
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
```
- 执行结果
```
如果不禁用验证，则报错信息：[Validation set: 'activiti-executable-process' | 
//Problem: 'activiti-start-event-multiple-found'] : 
//Multiple none start events are not supported - 
//[Extra info : processDefinitionId = myProcess | 
// processDefinitionName = My process |  | id = startevent1 |  
//| activityName = Start | ] ( line: 4, column: 47)
```

## 7.2 流程定义的管理
### 7.2.1 ProcessDefinition对象
### 7.2.2 流程部署
### 7.2.3 流程图部署
### 7.2.4 流程图自动生成
### 7.2.5 中止与激活流程定义
### 7.2.6 流程定义缓存配置
### 7.2.7 自定义缓存
## 7.3 流程定义权限
### 7.3.1 设置流程定义的用户权限
### 7.3.2 设置流程定义的用户组权限
### 7.3.3 IdentityLink对象
### 7.3.4 查询权限数据
## 7.4 RepositoryService数据查询与删除
### 7.4.1 查询部署资源

在resources文件夹新建my_text.txt文本文件，内容为：my test content
- 代码清单：SaveGroup.java
```java
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
```
- 执行结果
```
my test content
```
### 7.4.2 查询流程文件


- 代码清单：BpmnQueryTest.java
```java
// 部署一份流程文件
Deployment dep = repositoryService.createDeployment()
        .addClasspathResource("MyFirstProcess.bpmn").deploy();
// 查询流程定义实体
ProcessDefinition def = repositoryService.createProcessDefinitionQuery()
        .deploymentId(dep.getId()).singleResult();
// 查询资源文件
InputStream is = repositoryService.getProcessModel(def.getId());
// 读取输入流
int count = is.available();
byte[] contents = new byte[count];
is.read(contents);
String result = new String(contents);
//输入输出结果
System.out.println(result);
```
- 执行结果
```
<?xml version="1.0" encoding="UTF-8"?>
<definitions xmlns="http://www.omg.org/spec/BPMN/20100524/MODEL" 
xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
xmlns:xsd="http://www.w3.org/2001/XMLSchema" 
xmlns:activiti="http://activiti.org/bpmn" 
xmlns:bpmndi="http://www.omg.org/spec/BPMN/20100524/DI" 
xmlns:omgdc="http://www.omg.org/spec/DD/20100524/DC" 
xmlns:omgdi="http://www.omg.org/spec/DD/20100524/DI" 
typeLanguage="http://www.w3.org/2001/XMLSchema"
 expressionLanguage="http://www.w3.org/1999/XPath" targetNamespace="http://www.activiti.org/test">
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
### 7.4.3 查询流程图
- 代码清单：ImageQueryTest.java
```java
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
```
- 执行结果
```
在resources文件夹下生成图片result.png
```
### 7.4.4 查询部署资源名称

### 7.4.5 删除部署资源

1. 不管是否指定级联，都会删除部署相关的身份数据、流程定义数据、流程资源与部署数据。
2. 如果设置为级联删除，则会将运行的流程实例、流程任务以及流程实例的历史数据删除。
3. 如果不级联删除，但是存在运行时数据，例如还有流程实例，就会删除失败。

```
### 7.4.6 DeploymentQuery对象
### 7.4.7 ProcessDefinitionQuery对象
## 7.5 本章小结



