

<p align="center">
	<img alt="logo" src="https://gitee.com/xnqysabout/RuoYi-fast-cms/raw/main/public/demoImg/%E5%88%9B%E6%84%8F.png">
</p>


<h1 align="center" style="margin: 30px 0 30px; font-weight: bold;">RuoYi-fast-cms </h1>
<h4 align="center">基于RuoYi-fast v4.7.9开发的轻量级Java网站内容管理系统</h4>
<p align="center">
	<a href="https://gitee.com/y_project/RuoYi"><img src="https://img.shields.io/badge/RuoYi-v4.7.9-brightgreen.svg"></a>
	<a href="https://gitee.com/y_project/RuoYi/blob/master/LICENSE"><img src="https://img.shields.io/github/license/mashape/apistatus.svg"></a>
</p>


## 系统介绍
> 一直想做一款Java CMS 网站管理系统，曾用各种内容管理系统脚手架开发单位门户网站，发现开发高端大气官网总不能随心所欲，为拥有一套javaweb管理系统旨在满足政务服务平台及站群系统定制需求，结合多年网站设计开发经验由云而生。
本项目基于RuoYi-fast二次开发，网站后台用SpringBoot + MyBatis，前端网站模版用thymeleaf+bootstrap开发，多套模板，可自由飞翔。

  
## 环境要求

* JDK >= 1.8
* MySQL >= 5.7
* Maven >= 3.0

## 升级日志
* 2024-10-12：新增访问统计
* 2024-10-05：v1.0.0 初始化项目，发布到Gitee。


## 本项目扩展功能
- [x] 文章管理：文章内容推荐、置顶、幻灯、审核、发布、跳转链接。
- [x] 分类管理：无限级分类，支持自定义分类模板。
- [x] 单页管理：单页面增加、修改、删除。
- [x] 专栏管理：专题专栏，支持自定义分类模板。
- [x] 导航管理：支持自定义导航模板，自定义跳转链接、高亮显示。
- [x] 在线投稿：投稿功能，支持在线投稿，投稿管理，投稿审核。
- [x] 幻灯管理：根据设置的类型任意调用。
- [x] 友情链接：多级友情链接，可根据类型任意调用。
- [x] 文章统计：各部门的文章统计，可直观查看文章排名。
- [x] 站群管理：多级用户集约化管理，支持用户分配角色、分配数据权限、文章审批。
- [x] 站内搜索：支持文章检索、栏目检索等。
- [x] 信箱管理：支持在线写信、回复、加密查看等。
- [x] 回收站：支持文章软删除、硬删除。
- [x] 访问统计：网站首页底部显示访问总量、今天、昨天ip、pv 访问量。


## 内置功能

- [x] 用户管理：用户是系统操作者，该功能主要完成系统用户配置。
- [x] 部门管理：配置系统组织机构（公司、部门、小组），树结构展现支持数据权限。
- [x] 岗位管理：配置系统用户所属担任职务。
- [x] 菜单管理：配置系统菜单，操作权限，按钮权限标识等。
- [x] 角色管理：角色菜单权限分配、设置角色按机构进行数据范围权限划分。
- [x] 字典管理：对系统中经常使用的一些较为固定的数据进行维护。
- [x] 参数管理：对系统动态配置常用参数。
- [x] 通知公告：系统通知公告信息发布维护。
- [x] 操作日志：系统正常操作日志记录和查询；系统异常信息日志记录和查询。
- [x] 登录日志：系统登录日志记录查询包含登录异常。
- [x] 在线用户：当前系统中活跃用户状态监控。
- [x] 定时任务：在线（添加、修改、删除)任务调度包含执行结果日志。
- [x] 代码生成：前后端代码的生成（java、html、xml、sql）支持CRUD下载 。
- [x] 系统接口：根据业务代码自动生成相关的api接口文档。
- [x] 服务监控：监视当前系统CPU、内存、磁盘、堆栈等相关信息。
- [x] 缓存监控：对系统的缓存查询，删除、清空等操作。
- [x] 在线构建器：拖动表单元素生成相应的HTML代码。
- [x] 连接池监视：监视当前系统数据库连接池状态，可进行分析SQL找出系统性能瓶颈。



## 安装步骤
1、git 拉取源码；
```agsl
git clone https://gitee.com/y_project/RuoYi-fast-cms.git
```
2、导入 idea , 配置 maven 自动下载依赖；

3、/src/main/resources/application-druid.yml 修改为自己的数据库、用户名、密码、端口；
```agsl
 master:
   url: jdbc:mysql://localhost:3306/ruoyi-fast-cms?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=true&serverTimezone=GMT%2B8
   username: root
   password: root
```
4、创建数据库；

5、导入数据 /public/sql/ruoyi-fast-cms.sql；

6、配置文件上传路径  profile: /public/uploadPath

7、配置日志存放路径 /RuoYi-fast-cms/src/main/resources/logback.xml
```agsl
<!-- 日志存放路径 -->
<property name="log.path" value="/wwwroot/ruoyi-fast-cms/public/logs" />
```
8、启动项目；

9、访问 http://localhost:8080/login 登录。





## 模版预览图
<table>
    <tr>
        <td><img src="https://gitee.com/xnqysabout/RuoYi-fast-cms/raw/main/public/demoImg/demo1.jpg"/></td>
        <td><img src="https://gitee.com/xnqysabout/RuoYi-fast-cms/raw/main/public/demoImg/demo2.jpg"/></td>
    </tr>
<tr>
        <td><img src="https://gitee.com/xnqysabout/RuoYi-fast-cms/raw/main/public/demoImg/demo3.jpg"/></td>
        <td>陆续发布，敬请期待...</td>
    </tr>
</table>

## 在线体验

* 模板 01：http://web-demo.system-code.vip/red/home
* 模板 02：http://web-demo.system-code.vip/green/home
* 模板 03：http://web-demo.system-code.vip/blue/home
* 模板陆续发布...
* 后台地址：http://web-demo.system-code.vip/login
* 后台账号：ry/admin123

## 网站模板支出
> 声明：PC网站模版没有开源，请购买授权，仅需 ¥499元，购买地址：<a href="https://www.xnqys.com/article/22.html" target="_blank">PC网站模版</a>； 购买后，可永久免费使用；
> 
> 服务：提供远程部署及技术咨询服务；
> 
> 支出：陆续发布精致的网站模版，欢迎大家选购。


## 后台预览图

<table>
    <tr>
        <td><img src="https://gitee.com/xnqysabout/RuoYi-fast-cms/raw/main/public/demoImg/001.png"/></td>
        <td><img src="https://gitee.com/xnqysabout/RuoYi-fast-cms/raw/main/public/demoImg/002.png"/></td>
    </tr>
<tr>
        <td><img src="https://gitee.com/xnqysabout/RuoYi-fast-cms/raw/main/public/demoImg/002.png"/></td>
        <td><img src="https://gitee.com/xnqysabout/RuoYi-fast-cms/raw/main/public/demoImg/003.png"/></td>
    </tr>
<tr>
        <td><img src="https://gitee.com/xnqysabout/RuoYi-fast-cms/raw/main/public/demoImg/005.png"/></td>
        <td><img src="https://gitee.com/xnqysabout/RuoYi-fast-cms/raw/main/public/demoImg/006.png"/></td>
    </tr>
<tr>
        <td><img src="https://gitee.com/xnqysabout/RuoYi-fast-cms/raw/main/public/demoImg/007.png"/></td>
        <td><img src="https://gitee.com/xnqysabout/RuoYi-fast-cms/raw/main/public/demoImg/008.png"/></td>
    </tr>
</table>

## 特别鸣谢
* RuoYi
* RuoYi-fast
* bootstrap

## QQ群交流
QQ群：749272719