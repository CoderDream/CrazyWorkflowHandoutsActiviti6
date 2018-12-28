# 第2章　安装与运行Activiti 
## 2.1　下载与运行Activiti
###  2.1.1 下载和安装JDK
###  2.1.2 下载和安装MySQL
###  2.1.3 下载和安装Activiti

- 将activiti-admin.war、activiti-app.war和activiti-rest.war拷贝到D:\Java\apache-tomcat-8.5.12\webapps目录下；
- 执行D:\Java\apache-tomcat-8.5.12\bin\startup.bat；
- 启动成功需要一分钟左右。
![width=40% bordered](<images/01_Deploy.png>)
## 2.2 运行官方的Activiti示例
### 2.2.1 请假流程概述
### 2.2.2 新建用户
	
- 在浏览器输入 http://localhost:8080/activiti-app 进入登陆界面，输入用户名和密码（amdin/test）进入系统：
![width=40% bordered](<images/02_Login.png>) 
- 点击【Identity Management】图标，进入用户管理界面
![width=40% bordered](<images/03_MainIdentityManagement.png>)
- 选择【Users】面板，点击【Create User】按钮，新建用户
![width=40% bordered](<images/04_Users.png>)
- 输入用户信息
![width=40% bordered](<images/05_CreateUser.png>)
- 创建两个用户worker和leader，列表如下
![width=40% bordered](<images/06_UserList.png>)

### 2.2.3 定义流程

- 点击页面左上角的图标，进入主界面
![width=40% bordered](<images/07_MainPage.png>)
- 点击【Kickstart App】图标，进入流程界面
![width=40% bordered](<images/08_CreateProcess.png>)
- 点击【Create Process】按钮：设置流程名称
![width=40% bordered](<images/17_ProcessInfo.png>)
- 在开始节点点击头像图标，创建第一个节点
![width=40% bordered](<images/09_Process1.png>)
- 设置第一个节点
![width=40% bordered](<images/10_Process2.png>)
- 继续创建第二个节点和流程结束节点：
![width=40% bordered](<images/11_Process3.png>)
- 设置节点的【Assignments】，选择分配给单个用户
![width=40% bordered](<images/12_Process4.png>)
- 第一个节点的设置结果
![width=40% bordered](<images/14_Process5.png>)
- 第二个节点的设置结果
![width=40% bordered](<images/15_Process6.png>)
- 点击左上角的按钮，保存流程
![width=40% bordered](<images/16_Process7.png>)

### 2.2.4 发布流程
- 创建应用
![width=40% bordered](<images/18_CreateApp.png>)
- 设置应用信息
![width=40% bordered](<images/19_AppInfo.png>)
- 准备将流程添加到应用
![width=40% bordered](<images/20_AddModelsToApp.png>)
- 点击流程，将流程添加到应用
![width=40% bordered](<images/21_AddModel.png>)
- 流程添加完成
![width=40% bordered](<images/22_ModelAdded.png>)
- 准备应用发布
![width=40% bordered](<images/23_AppPublish.png>)
- 确认发布
![width=40% bordered](<images/24_PublishConfirm.png>)
- 应用发布完成
![width=40% bordered](<images/25_AppAdded.png>)

### 2.2.5 启动与完成流程

- worker准备发起流程
![width=40% bordered](<images/26_StartProcess1.png>)
- 填入流程信息
![width=40% bordered](<images/27_StartProcess2.png>)
- 流程流转图，现阶段节点在worker这里
![width=40% bordered](<images/28_StartProcess3.png>)
- 点击【Complete】按钮，发起流程
![width=40% bordered](<images/29_StartProcess4.png>)
- 流程流转图，现阶段节点已转到leader这里
![width=40% bordered](<images/30_StartProcess5.png>)
- leader登陆后的界面，有一个任务需要审核，点击右上角的【Complete】可以进行审核
![width=40% bordered](<images/31_ProcessAudit1.png>)
- 直接点击【Process】面板，可以查看流程详情
![width=40% bordered](<images/32_ProcessAudit2.png>)
- 点击右上角的【Complete】完成审核
![width=40% bordered](<images/33_ProcessAudit3.png>)
![width=40% bordered](<images/34_AdminLogin.png>)
![width=40% bordered](<images/35_AdminMain.png>)
![width=40% bordered](<images/36_Config.png>)
![width=40% bordered](<images/37_ConfigCheck.png>)
### 2.2.6 流程引擎管理
## 2.3 安装开发环境
### 2.3.1 下载Eclipse
### 2.3.2 安装Activiti插件
## 2.4 编写第一个Activiti程序
### 2.4.1 如何运行本书示例
### 2.4.2 建立工程环境
### 2.4.3 创建配置文件
### 2.4.4 创建流程文件
### 2.4.5 加载流程文件与启动流程
## 2.5 本章小结
