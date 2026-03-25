package Week_17;


/**
 * Write a description of class Student here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Student
{
    private int studentId;
    private String studentName;
    private String course;
    public Student(int studentId,String studentName,String course)
    {
        this.studentId=studentId;
        this.studentName=studentName;
        this.course=course;
    }
    public int getStudentId(){
        return this.studentId;
    }
    public String getStudentName(){
        return this.studentName;
    }
    public String getCourse(){
        return this.course;
    }
    
    public String info(){
    return "<HTML>"+"<div style='text-align:center;'>"+"studentId:"+this.studentId+"<br>studentName:"+
    this.studentName+"<br>course:"+this.course+"</div>"+"</HTML>";
    }  
}