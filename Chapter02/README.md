


### 第2章　安装与运行Activiti 7 
- 2.1　下载与运行Activiti 8 
	- 2.1.1　下载和安装JDK 8 
	- 2.1.2　下载和安装MySQL 9 
	- 2.1.3 下载和安装Activiti 10 

1. 将activiti-admin.war、activiti-app.war和activiti-rest.war拷贝到D:\Java\apache-tomcat-8.5.12\webapps目录下；
2. 执行D:\Java\apache-tomcat-8.5.12\bin\startup.bat；
3. 启动成功需要一分钟左右。
![width=40% bordered](<images/01_Deploy.png>)
- 2.2 运行官方的Activiti示例 11 
	- 2.2.1 请假流程概述 11 
	- 2.2.2 新建用户 11 
	
1. 通过访问 http://localhost:8080/activiti-app 进入系统
 ![width=40% bordered](<images/02_Login.png>)
2. 用户名和密码分别为：amdin/test		
3. 点击【Identity Management】图标，选择【Users】面板
 ![width=40% bordered](<images/03_MainIdentityManagement.png>)
4. 新建用户
 ![width=40% bordered](<images/04_Users.png>)
 ![width=40% bordered](<images/05_CreateUser.png>)
5. 用户列表
 ![width=40% bordered](<images/06_UserList.png>)

	- 2.2.3 定义流程 12 
1. 点击页面左上角的图标，进入主界面
 ![width=40% bordered](<images/07_MainPage.png>)
2. 点击【Kickstart App】图标，进入流程界面
 ![width=40% bordered](<images/08_CreateProcess.png>)
3. 点击【Create Process】按钮：
	- 2.2.4 发布流程 14 
	- 2.2.5 启动与完成流程 15 
	- 2.2.6 流程引擎管理 16 
- 2.3 安装开发环境 17 
	- 2.3.1 下载Eclipse 17 
	- 2.3.2 安装Activiti插件 18 
- 2.4 编写第一个Activiti程序 19 
	- 2.4.1 如何运行本书示例 19 
	- 2.4.2 建立工程环境 19 
	- 2.4.3 创建配置文件 20 
	- 2.4.4 创建流程文件 20 
	- 2.4.5 加载流程文件与启动流程 21 
- 2.5 本章小结 22 


1leader

http://localhost:8080/activiti-app

用户名、密码：amdin/test


点击【】图标，选择【Users】面板