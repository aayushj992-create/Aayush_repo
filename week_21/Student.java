package week_21;


/**
 * Write a description of class Student here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Student { 
    String name, age, gender, skills, course;
    public Student(String name, String age, String gender, String skills, String course)
    { 
        this.name = name; 
        this.age = age;
        this.gender = gender;
        this.skills = skills;
        this.course = course;
    }
    public String[] getStudentData()
    { return new String[] 
        {"Name: "+name, "Age: "+age, "Gender: "+gender, "Skills: "+skills, "Course: "+course};
        } 
    }