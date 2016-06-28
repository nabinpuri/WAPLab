/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foreachdemo.bean;

/**
 *
 * @author 984984
 */
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class Student
{
    private String name;
    private int age;
    public Student()
    {
    }
    public Student(String name, int age)
    {
        this.name = name;
        this.age = age;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public String getName()
    {
        return name;
    }

    public void setAge(int age)
    {
        this.age = age;
    }
    public int getAge()
    {
        return age;
    }
}

