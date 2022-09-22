package com.ssm.controller;

import com.ssm.domain.Student;
import com.ssm.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Resource
    private StudentService service;

//    注册学生
    @RequestMapping("/addStudent.do")
    public ModelAndView addStudent(Student student){
        ModelAndView mv=new ModelAndView();
        String tips="注册失败";
//        调用service处理student
        int nums = service.addStudent(student);
        if(nums>0){
//            注册成功
            tips="学生==="+student.getName()+"，注册成功";
        }
//        添加数据
        mv.addObject("tips",tips);
//        指定结果页面
        /**
         * forward和redirect的使用
         *  语法：setViewName("forward:视图完整路径")，setViewName("redirect:视图完整路径")
         *  特点：二者都不和视图解析器一同使用，就当项目中没有视图解析器
         *  例如： mv.setViewName("forward:/index.jsp")
         *
         *  使用重定向redirect存在两个域，要取到传递的数据需要使用${param},例如${param.myname} ${param.myage}
         *      相当于request.getParameter("myname)
         *  ?重定向不能访问/WEB-INF资源
         */
        mv.setViewName("result");
        return mv;
    }

//    处理查询，响应Ajax
    @RequestMapping("/queryStudent.do")
    @ResponseBody
    public List<Student> queryStudent(){
//        参数检查，简单的数据处理
        List<Student> students = service.findStudents();
        return students;
    }
}
