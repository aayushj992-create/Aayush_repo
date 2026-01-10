package week_10;


/**
 * Write a description of class student here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class student
{
    private int rollNo;
    private String name;
    private double marks;
    public student(int no,String name,double marks)
    {
        this.rollNo=no;
        this.name=name;
        this.marks=marks;
    }
    public void setId(int Id)
    {
        this.rollNo=Id;
    }
    public int getId()
    {
        return this.rollNo;
    }
    public void setName(String name)
    {
        this.name=name;
    }
    public String getName()
    {
        return this.name;
    }
    public void setmarks(double marks)
    {
        this.marks=marks;
    }
    public double getmarks()
    {
        return this.marks;
    }
    public String calculateResult(){
        if(marks>=40)
        {
            return "pass";
        }
        else
        {
            return "fail";
        }
    }
    @Override 
    public String toString(){
        return "Id=" + getId()+ ",Name=" +getName()+ ",marks=" +getmarks();
    }
}