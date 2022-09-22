package com.ssm.service.impl;

import com.ssm.dao.StudentDao;
import com.ssm.domain.Student;
import com.ssm.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
//    引用类型自动注入@Autowired，@Resource
    @Resource
    private StudentDao studentDao;
    @Override
    public int addStudent(Student student) {
        return studentDao.insertStudent(student);
    }

    @Override
    public List<Student> findStudents() {

        return studentDao.selectStudents();
    }
}
