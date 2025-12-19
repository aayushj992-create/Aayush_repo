package Week_7;


/**
 * Write a description of class student here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class student
{
    //Attributes or Properties
    String collegeId;
    int age;
    String course;
    public student(String Id,int age,String course)
    {
        this.collegeId=Id;// this refers to instance variable
        this.age=age;
        this.course=course;
    }
    //behaviour or methods
    public void study()
    {
        System.out.println(collegeId+"is studying");
    }
    public void laugh()//public -access modifier
    {
        System.out.println(collegeId+"is laughing");
    }
}