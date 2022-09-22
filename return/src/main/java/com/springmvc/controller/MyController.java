package com.springmvc.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springmvc.vo.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * @RequestMapping :
 *  value：所有请求地址的公共部分，叫做模块名称.下面代码中即"/test"
 *  位置：放在类的上面
 */

@Controller
public class MyController {

    /**
     * 处理器方法返回String--表示逻辑视图名称，需要配置视图解析器
     * @param name
     * @param age
     * @return
     */
    @RequestMapping(value = "/returnString-view.do")
    public String doReturnView(HttpServletRequest request,String name,Integer age){// doGet()----service请求处理

        request.setAttribute("myname",name);
        request.setAttribute("myage",age);
//        show：逻辑视图名称，项目中配置了视图解析器
        return "show";

    }

    //处理器方法返回String，表示完整试图路径，此时不能配置视图解析器
    @RequestMapping(value = "/returnString-view2.do")
    public String doReturnView2(HttpServletRequest request,String name,Integer age){// doGet()----service请求处理

        request.setAttribute("myname",name);
        request.setAttribute("myage",age);
//        完整视图路径，项目中不能配置视图解析器
        return "/WEB-INF/view/show.jsp";

    }
    //处理器方法返回void，相应Ajax请求
    @RequestMapping(value = "/returnVoid-ajax.do")
    public void doReturnVoidAjax(HttpServletResponse response,String name,Integer age) throws IOException {// doGet()----service请求处理
//        处理Ajax，使用json做数据的格式
//        service调用完成了，使用Student表示处理结果
        Student student=new Student();
        student.setName(name);
        student.setAge(age);

        String json="";
//        把结果转为json格式对象
        if(student!=null){
            ObjectMapper om=new ObjectMapper();
            json =om.writeValueAsString(student);
            System.out.println("student转换的json===="+json);
        }

//        输出数据，响应Ajax的请求
        response.setContentType("application/json;charset=utf-8");
        PrintWriter pw=response.getWriter();
        pw.println(json);
        pw.flush();
        pw.close();

    }

    /**
     * 处理器方法返回一个Student，通过框架转为json，响应Ajax请求
     * @ResponseBody:
     *  作用：把处理器方法返回对象转为json后，通过HttpServletResponse输出给浏览器
     *  位置：方法的定义上面
     * 返回对象框架的处理流程：
     *  1.框架会把返回Student类型，调用框架中的ArrayList<HttpMessageConverter>中每个类的canWrite()方法
     *      检查哪个HttpMessageConverter接口的实现类能处理Student类型的数据
     *  2.框架会调用实现类的write(),MappingJackson2HttpMessageConverter的write()方法
     *      把Student对象转为json，调用Jackson的ObjectMapper实现转为json
     *  3.框架会调用@ResponseBody把结果数据输出到浏览器，Ajax请求处理完成
     */
    @RequestMapping("/returnStudentJson.do")
    @ResponseBody
    public Student doStudentJsonObject(String name,Integer age){
//        调用service，获取请求数据结果，Student对象表示结果数据
        Student student=new Student();
        student.setName("欢砸");
        student.setAge(16);
        return student;
    }

    /**
     * 处理器方法返回List<Student>
     */
    @RequestMapping("/returnStudentJsonArray.do")
    @ResponseBody
    public List<Student> doStudentJsonObjectArray(String name, Integer age){
        List<Student> list=new ArrayList<>();
        Student student=new Student();
        student.setName("药");
        student.setAge(25);
        list.add(student);

        student=new Student();
        student.setName("coin");
        student.setAge(26);
        list.add(student);

        return list;
    }
    /**
     * 处理器方法返回的是String，String表示数据的，不是视图
     * 区分返回值String是数据还是视图，看有没有@ResponseBody注解，如果有返回的就是数据，反之是视图
     *
     * 默认使用text/plain;charset=ISO-8859-1作为contentType导致中文乱码
     * 解决方案：给RequestMapping增加一个属性produces，指定新的contentType
     */

    @RequestMapping(value = "/returnStringData.do",produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String doStringData(String name,Integer age){
        return "Hello大萨达";
    }
}
