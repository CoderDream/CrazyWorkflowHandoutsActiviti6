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
- 准备应用发布                                                                                                                                                 
![](<images/23_AppPublish.png>)
- 确认发布                                                                                                                                                 
![](<images/24_PublishConfirm.png>)
- 应用发布完成                                                                                                                                                 
![](<images/25_AppAdded.png>)

### 2.2.5 启动与完成流程

- 使用worker账号登陆系统，准备发起流程
![](<images/26_StartProcess1.png>)
- 填入流程信息                                                                                                                                                                                                                                                                                                  
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
### 2.4.3 创建配置文件
### 2.4.4 创建流程文件
### 2.4.5 加载流程文件与启动流程
## 2.5 本章小结
