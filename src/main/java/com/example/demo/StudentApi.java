package com.example.demo;

import org.springframework.web.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")

public class StudentApi {

    private List<Student> studentList;

    public StudentApi()
    {
        this.studentList = new ArrayList<>();
    }
    @PostMapping("/AddStudent")
    public boolean addStudent(@RequestBody Student student)
    {

        return studentList.add(student);
    }
    @GetMapping("/StudentList")
    public List<Student> getStudentList()
    {
        return studentList;
    }

    @GetMapping ("/{id}")
    public Student getStudent(@PathVariable int id)
    {
        return studentList.stream().filter(student -> student.getId() == id).findFirst().get();
    }
   @GetMapping ("/{id}/name")
    public String getStudentName(@PathVariable int id)
    {
        return studentList.stream().filter(student -> student.getId()==id).findFirst().get().getName();
    }
    @GetMapping("/delete/{id}")
    public boolean deleteStudentById(@PathVariable int id)
    {
        Student user = studentList.stream().filter(student -> student.getId() == id).findFirst().get();
                return studentList.remove(user);
    }

}
