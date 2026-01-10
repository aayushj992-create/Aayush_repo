package week_10;
/**
 * Write a description of class Person here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Person
{
    private int id;
    private String name;
    public Person(int id, String name)
    {
        this.id=id;
        this.name=name;
    }
    public void setId(int id)
    {
        this.id=id;
    }
    public int getId()
    {
        return this.id;
    }
    public void setName(String name)
    {
        this.name=name;
    }
    public String getName()
    {
        return this.name;
    }
    public double calculateSalary()
    {
       return 10000; 
    }
    @Override
    public String toString()
    {
        return "Person details ------>person id:"+getId()+",person Name" + getName();
    }
    public void displayDetails()
    {
        System.out.println("Name:"+getName());
        System.out.println("ID:"+getId());
    }
}