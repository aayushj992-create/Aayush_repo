package home;
import java.util.*;

public class Student {
    private int studentID;
    private String name;
    private String gender;
    private String skill;
    private String course;
    
    private static ArrayList<Student> studentList = new ArrayList<>();

    public Student(int studentID, String name, String gender, String skill, String course) {
        this.studentID = studentID;
        this.name = name;
        this.gender = gender;
        this.skill = skill;
        this.course = course;
    }

    // Getters
    public int getStudentID() { return studentID; }
    public String getName() { return name; }
    public String getGender() { return gender; }
    public String getSkill() { return skill; }
    public String getCourse() { return course; }

    // Requirement: addStudent logic with unique ID check
    public static boolean addStudent(Student student) {
        for (Student val : studentList) {
            if (val.getStudentID() == student.getStudentID()) {
                return false; 
            }
        }
        studentList.add(student);
        return true;
    }

    public static boolean deleteStudent(int id) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getStudentID() == id) {
                studentList.remove(i);
                return true;
            }
        }
        return false;
    }
    
    public static ArrayList<Student> getStudentList() {
        return studentList;
    }
}
