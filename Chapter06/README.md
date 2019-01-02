# 第6章 用户组与用户
## 6.1 用户组管理
### 6.1.1 Group对象
### 6.1.2 创建用户组

- 代码清单：SaveGroup.java
```java
// 新建流程引擎
ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();

IdentityService identityService = engine.getIdentityService();

Random ran = new Random(10);
for (int i = 0; i < 10; i++) {
	Group group = identityService.newGroup(String.valueOf(i));
	group.setName("Group_" + ran.nextInt(10));
	group.setType("TYPE_" + ran.nextInt(10));
	identityService.saveGroup(group);
}

// 关闭流程引擎
engine.close();
```
- 执行结果
```
0	1	Group_3	TYPE_0
1	1	Group_3	TYPE_0
2	1	Group_6	TYPE_6
3	1	Group_7	TYPE_8
4	1	Group_1	TYPE_4
5	1	Group_3	TYPE_9
6	1	Group_1	TYPE_8
7	1	Group_5	TYPE_0
8	1	Group_6	TYPE_3
9	1	Group_3	TYPE_8
```
### 6.1.3 修改用户组
### 6.1.4 删除用户组
## 6.2 Activiti数据查询
### 6.2.1 查询对象

- 代码清单：FieldQuery.java
```java
List<Group> groups = identityService.createGroupQuery()
		.groupName("Group_3").groupType("TYPE_0").list();

for (Group group : groups) {
	System.out.println(group.getId() + "---" + group.getName() + "---"
			+ group.getType());
}
```
- 查询结果
```
0---Group_3---TYPE_0
1---Group_3---TYPE_0
```
### 6.2.2 list方法

- 代码清单：ListGroup.java
```java
List<Group> groups = identityService.createGroupQuery().list();

for (Group group : groups) {
	System.out.println(group.getId() + "---" + group.getName() + "---" + group.getType());
}
```
- 查询结果
```
0---Group_3---TYPE_0
1---Group_3---TYPE_0
2---Group_6---TYPE_6
3---Group_7---TYPE_8
4---Group_1---TYPE_4
5---Group_3---TYPE_9
6---Group_1---TYPE_8
7---Group_5---TYPE_0
8---Group_6---TYPE_3
9---Group_3---TYPE_8
```

### 6.2.3 listPage方法

- 代码清单：ListPageGroup.java
```java
List<Group> groups = identityService.createGroupQuery().listPage(1, 5);

for (Group group : groups) {
	System.out.println(group.getId() + "---" + group.getName() + "---"
			+ group.getType());
}
```
- 查询结果
```
1---Group_3---TYPE_0
2---Group_6---TYPE_6
3---Group_7---TYPE_8
4---Group_1---TYPE_4
5---Group_3---TYPE_9
```
### 6.2.4 count方法

- 代码清单：CountGroup.java
```java
Long count = identityService.createGroupQuery().count();

System.out.println(count);	
```
- 查询结果
```
10
```
### 6.2.5 排序方法

- 代码清单：SortGroup.java
```java
List<Group> groups = identityService.createGroupQuery()
		.orderByGroupName().desc().list();

for (Group group : groups) {
	System.out.println(group.getId() + "---" + group.getName() + "---"
			+ group.getType());
}
```
- 查询结果
```
3---Group_7---TYPE_8
2---Group_6---TYPE_6
8---Group_6---TYPE_3
7---Group_5---TYPE_0
0---Group_3---TYPE_0
1---Group_3---TYPE_0
5---Group_3---TYPE_9
9---Group_3---TYPE_8
4---Group_1---TYPE_4
6---Group_1---TYPE_8
```
### 6.2.6 ID排序问题
### 6.2.7 多字段排序

- 代码清单：SortMultiGroup.java
```java
// 先按名称降序，再按类型降序
List<Group> groups = identityService.createGroupQuery()
		.orderByGroupName().desc().orderByGroupType().desc().list();

for (Group group : groups) {
	System.out.println(group.getId() + "---" + group.getName() + "---"
			+ group.getType());
}
```
- 查询结果
```
3---Group_7---TYPE_8
2---Group_6---TYPE_6
8---Group_6---TYPE_3
7---Group_5---TYPE_0
5---Group_3---TYPE_9
9---Group_3---TYPE_8
0---Group_3---TYPE_0
1---Group_3---TYPE_0
6---Group_1---TYPE_8
4---Group_1---TYPE_4
```
### 6.2.8 singleResult方法

- 代码清单：SingleResult.java
```java
Group group = identityService.createGroupQuery().groupName("Group_5")
		.singleResult();

System.out.println(group.getId() + "---" + group.getName() + "---"
		+ group.getType());
```
- 查询结果
```
7---Group_5---TYPE_0
```
### 6.2.9 用户组数据查询
### 6.2.10 原生SQL查询

- 代码清单：NativeQuery.java
```java
List<Group> groups = identityService.createNativeGroupQuery()
		.sql("SELECT * FROM ACT_ID_GROUP WHERE NAME_ = #{name}")
		.parameter("name", "Group_3").list();

for (Group group : groups) {
	System.out.println(group.getId() + "---" + group.getName() + "---"
			+ group.getType());
}
```
- 查询结果
```
0---Group_3---TYPE_0
1---Group_3---TYPE_0
5---Group_3---TYPE_9
9---Group_3---TYPE_8
```
## 6.3 用户管理
### 6.3.1 User对象
### 6.3.2 添加用户
### 6.3.3 修改用户
### 6.3.4 删除用户
### 6.3.5 验证用户密码
### 6.3.6 用户数据查询
### 6.3.7 设置认证用户
## 6.4 用户信息管理
### 6.4.1 添加和删除用户信息
### 6.4.2 查询用户信息
### 6.4.3 设置用户图片
## 6.5 用户组与用户的关系
### 6.5.1 绑定关系
### 6.5.2 解除绑定
### 6.5.3 查询用户组下的用户
### 6.5.4 查询用户所属的用户组
## 6.6 本章小结
