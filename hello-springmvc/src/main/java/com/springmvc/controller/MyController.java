package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Controller :创建处理器对象，对象放在SpringMVC容器中
 * 位置：在类的上面
 */
@Controller
public class MyController {
    /*
        处理用户提交的请求，SpringMVC中使用方法来处理
        方法是自定义的，可以有多种返回值，多种参数，方法名称自定义
     */

    /**
     * 使用doSome()方法处理some.do请求
     * @RequestMapping :请求映射，作用是把一个请求地址和一个方法绑定在一起。一个请求指定一个方法处理
     *      属性：1.value 是一个String，表示请求的uri地址的（some.do）
     *          value的值必须是唯一的
     *      位置：1.在方法的上面（常用）
     *           2.在类的上面
     *  说明：使用RequestMapping修饰的方法叫做处理器方法或者控制器方法，该方法可以处理请求的，类似servlet中的doPost、doGet
     *
     *  返回值：ModelAndView  表示本次请求的处理结果
     *      Model：数据，请求处理完后，要显示给用户的数据
     *      View：视图，比如jsp等
     */

//    指定多个地址可以实现不同地址访问同一方法
    @RequestMapping(value = {"/some.do","first.do"})
    public ModelAndView doSome(){// doGet()----service请求处理
        //处理some.do请求。
        ModelAndView mv=new ModelAndView();
//        添加数据,框架在请求的最后把数据放入到request作用域
        mv.addObject("msg","欢迎使用SpringMVC做Web开发");
        mv.addObject("fun","执行的是doSome方法");

//        指定视图，指定视图的完整路径
//        框架对视图执行的forward操作，request.getRequestDispatcher("/show.jsp").forward(...)
//        mv.setViewName("/show.jsp");

//        mv.setViewName("/WEB-INF/view/show.jsp");
//        mv.setViewName("/WEB-INF/view/other.jsp");

//        当配置了视图解析器后，可以使用逻辑名称（文件名），指定视图
//        框架会使用视图解析器的前缀+逻辑名称+后缀组成完整路径，这里就是字符串连接操作
//        WEB-INF/view/+show+.jsp
        mv.setViewName("show");

//        返回mv
        return mv;

    }
    @RequestMapping(value = {"/other.do","/second.do"})
    public ModelAndView doOther(){
        ModelAndView mv=new ModelAndView();
        mv.addObject("msg","欢迎使用SpringMVC做Web开发");
        mv.addObject("fun","执行的是doSome方法");
        mv.setViewName("other");

//        返回mv
        return mv;

    }
}
