package com.zjw.collection.list;

import com.zjw.domain.Student;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zjw
 * @date 2023/08/17 16:04
 */
public class ListTest2 {

    @Test
    public void testListToObject(){
        List<Student> studentList = new ArrayList<>();
        studentList.add(Student.builder().name("zjw").build());
        studentList.add(Student.builder().name("zjw").build());
        Object[] objects = new Object[2];
        objects[0] = studentList;
        List<Student> studentList2 = (List<Student>)objects[0];
        System.out.println(studentList2);
    }
}
