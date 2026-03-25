package Week_18;
import java.util.*;


/**
 * Write a description of class Student here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Student
{
    private int studentID;
    private String name;
    private String gender;
    private String skill;
    private String course;
    private static ArrayList<Student> studentList=new ArrayList<>();
    public Student(int studentID,String name, String gender, String skill,String course, ArrayList<Student> studentList)
    {
        this.studentID=studentID;
        this.name=name;
        this.gender=gender;
        this.skill=skill;
        this.course=course;
        this.studentList=studentList;
    }
    
    
    public int getStudentID()
    {
        return this.studentID;
    }
    
    public String getName()
    {
        return this.name;
    }
    
    public String getGender()
    {
        return this.gender;
    }
    
    public String getSkill()
    {
        return this.skill;
    }
    
    public String getCourse()
    {
        return this.course;
    }
    
    public static ArrayList<Student> getStudentList() {
        return studentList;
    }

    public boolean addStudent(Student student) {
        for (Student val : studentList) {
            if (val.getStudentID() == student.getStudentID()) {
                return false; 
            }
        }
        studentList.add(student);
        return true;
    }
    
    public static void viewStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No student records found.");
        } else {
            System.out.println("\n--- Student Records ---");
            for (Student s : studentList) {
                System.out.println("ID: " + s.getStudentID() +" | Name: " + s.getName() +" | Gender: "
                + s.getGender() +" | Skill: " + s.getSkill() + " | Course: " + s.getCourse());
            }
        }
    }
    
     public static boolean deleteStudent(int id) {
        for (Student val : studentList) {
            if (val.getStudentID() == id) {
                studentList.remove(val);
                return true;
            }
        }
        return false;
    }
}

