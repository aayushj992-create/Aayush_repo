package week_12;


/**
 * Write a description of class Student here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Student
{
    private String name;
    private long phone;
    private String group;
    public Student(String name,long phone,String group)
    {
        this.name=name;
        this.phone=phone;
        this.group=group;
    }
    
    public String getName()
    {
        return this.name;
    }
    public void setName(String name)
    {
        this.name=name;
    }
    
    public long getPhone()
    {
        return this.phone;
    }
    public void setPhone(long phone)
    {
        this.phone=phone;
    }
    
    public String getGroup()
    {
        return this.group;
    }
    public void setGroup(String group)
    {
        this.group=group;
    }
    
    public String toString()
    {
        return "Name----->"+getName()+"Phone-------->"+getPhone()+"Group-------->"+getGroup();
    }
    
}