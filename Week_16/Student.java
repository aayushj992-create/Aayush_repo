package Week_16;


/**
 * Write a description of class Student here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Student
{
    private String name;
    private int age;
    private String school;
    private int grade;
    private String citizenship;
    private String phone;
    public Student(String name,int age,String school,int grade,String citizenship,String phone)
    {
        this.name=name;
        this.age=age;
        this.school=school;
        this.grade=grade;
        this.citizenship=citizenship;
        this.phone=phone;
    }
    
    public String getName()
    {
        return this.name;
    }
    public void setName(String name)
    {
        this.name=name;
    }
    
     public int getAge()
    {
        return this.age;
    }
    public void setAge(int age)
    {
        this.age=age;
    }
    
     public String getSchool()
    {
        return this.school;
    }
    public void setSchool(String school)
    {
        this.school=school;
    }
    
    
    public int getGrade()
    {
        return this.grade;
    }
    public void setGrade(int grade)
    {
        this.grade=grade;
    }
    
     public String getCitizenship()
    {
        return this.citizenship;
    }
    public void setCitizenship(String citizenship)
    {
        this.citizenship=citizenship;
    }
    
     public String getPhone()
    {
        return this.phone;
    }
    public void setPhone(String phone)
    {
        this.phone=phone;
    }
    
    
    public String getNameInitials()
    {
        String[] splittedName=name.trim().split(" ");
        StringBuilder title=new StringBuilder();
        for(String value:splittedName)
        {
            String upper=value.substring(0,1).toUpperCase();
            title=title.append(upper.charAt(0)).append(".");
        }
        String printInitial=title.toString();
        return printInitial;
    }
    
    public String toString()
    {
        return String.format("%s|%d|Grade %d|%s",this.name,this.age,this.grade,this.school);
    }
    
}
