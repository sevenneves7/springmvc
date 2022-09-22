第一个SpringMVC项目
需求：用户在页面发起一个请求，请求给SpringMVC的控制器对象，并显示请求的处理结果

实现步骤：
1.新建web maven工程
2.加入依赖
    spring-webmvc依赖，间接把spring的依赖都加入到项目中
    jsp，servlet依赖
3.重点：在web.xml中注册SpringMVC框架的核心对象DisPatcherServlet
    1）DisPatcherServlet叫做中央调度器，是一个servlet，继承HttpServlet
    2）DisPatcherServlet也叫前端控制器
    3）DisPatcherServlet负责接收用户提交的请求，调用其他控制器对象，并把请求的处理结果显示给用户
4.创建一个发起请求的页面 index.jsp
5.创建控制器（处理器）类
    1）在类的上面加入@Controller注解，创建对象，并放入到SpringMVC容器中
    2）在类中的方法上面加入@RequestMapping注解
6.创建一个作为结果的jsp，显示请求的处理结果
7.创建SpringMVC的配置文件（Spring的配置文件一样）
    1）声明组件扫描器，指定@Controller注解所在的包名
    2）声明视图解析器，帮助处理视图