package com.springmvc.controller;

import com.springmvc.vo.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @RequestMapping :
 *  value：所有请求地址的公共部分，叫做模块名称.下面代码中即"/test"
 *  位置：放在类的上面
 */

@Controller
public class MyController {

    /**
     * 逐个接收请求参数
     *  要求：处理器方法的形参名和请求中的参数必须一致
     *      同名的请求参数赋给同名的形参
     * 框架接收请求参数
     *      1.使用request对象接收请求参数
     *          String strName=request.getParameter("name");
     *          String strAge=request.getParameter("age");
     *      2.springmvc框架通过DisPatcherServlet调用MyController的doSome()方法
     *          调用方法时，按名称对应，把接收的参数赋值给形参
     *          doSome(strName,Integer.valueOf(strAge))
     *          框架会提供类型转换的功能，把String转为int,long,float,double等类型
     */
    @RequestMapping(value = "/receiveProperty.do")
    public ModelAndView doSome(String name,Integer age){// doGet()----service请求处理
        //处理some.do请求。
        ModelAndView mv=new ModelAndView();
//        添加数据,框架在请求的最后把数据放入到request作用域
        mv.addObject("myname",name);
        mv.addObject("myage",Integer.valueOf(age));

        mv.setViewName("show");

//        返回mv
        return mv;

    }

    /**
     * 请求中参数名和处理器方法的形参名不一样
     * @RequestParam ：逐个接收请求参数中，解决请求中参数名与形参名不一样的问题
     *  属性：1.value 请求中的参数名
     *       2.required是一个boolean，默认是true，表示请求中必须包含此参数
     *  位置：在处理器方法的形参定义前面
     */
    @RequestMapping(value = "/receiveparam.do")
    public ModelAndView receiveParam(@RequestParam(value = "rname",required = false) String name,
                                     @RequestParam(value = "rage",required = false) Integer age){// doGet()----service请求处理
        //处理some.do请求。
        ModelAndView mv=new ModelAndView();
//        添加数据,框架在请求的最后把数据放入到request作用域
        mv.addObject("myname",name);
        mv.addObject("myage",age);

        mv.setViewName("show");

//        返回mv
        return mv;

    }

    /**
     * 处理器方法形参是Java对象，这个对象的属性名和请求中的参数名是一样的
     * 框架会创建形参的Java对象，给属性赋值。请求中的参数是name，框架会调用setName()
     * @return
     */
    @RequestMapping(value = "/receiveobject.do")
    public ModelAndView receiveParam(Student student){// doGet()----service请求处理
        //处理some.do请求。
        System.out.println("receiveParam,name="+student.getName()+"  age="+student.getAge());
        ModelAndView mv=new ModelAndView();
//        添加数据,框架在请求的最后把数据放入到request作用域
        mv.addObject("myname",student.getName());
        mv.addObject("myage",student.getAge());
        mv.addObject("student",student);

        mv.setViewName("show");

//        返回mv
        return mv;

    }
}
