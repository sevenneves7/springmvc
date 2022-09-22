ssm:SSM整合开发
SpringMVC：视图层，负责接收请求，显示处理结果
spring：业务层，管理service，dao，工具类对象
mybatis：持久层，访问数据库的
用户发起请求---SpringMVC接收---spring中的service对象---mybatis处理数据

SpringMVC容器是spring容器的子容器，类似Java中的继承
在子容器中的Controller可以访问父容器中的Service对象，就可以实现controller使用service对象

实现步骤：
1.新建maven web项目
2.加入依赖
    SpringMVC spring mybatis三个框架的依赖，Jackson依赖，mysql驱动，druid连接池，jsp，servlet依赖
3，写web.xml
    1）注册DisPatcherServlet，目的：1.创建SpringMVC容器对象，才能创建Controller类对象
                                 2.创建的是Servlet，才能接收用户请求
    2）注册spring的监听器：ContextLoaderListener，目的：创建spring容器对象，才能创建service，dao等对象
    3）注册字符集过滤器，解决post请求乱码的问题
4.创建包，Controller，service，dao，实体类包
5.写SpringMVC，spring，mybatis的配置文件
    1）SpringMVC配置文件
    2）spring配置文件
    3）mybatis配置文案
    4）数据库的属性配置文件
6.写代码，dao接口和mapper文件，service和实现类，controller，实体类
7.写jsp页面