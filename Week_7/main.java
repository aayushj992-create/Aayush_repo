package Week_7;


/**
 * Write a description of class main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class main
{
    public static void main(String[] args)
    {
        //<className> variable_name=new class name 
        //object creation
        student s1= new student("np01cp44s20035",22,"Computing"); //student()-default constructor/non parameter wise constructor
        System.out.println(s1.collegeId);//attributes are made to pass data,we get data from attributes
        System.out.println(s1.age);
        System.out.println(s1.course);
        s1.study();
        student s2=new student();
        s2.collegeId="np01cp45s20035";
        s2.age=19;
        s2.course="Computing";
        System.out.println(s2.collegeId);//attributes are made to pass data,we get data from attributes
        System.out.println(s2.age);
        System.out.println(s2.course);  
        s2.laugh();
        
        car c1=new car();
        c1.Brand="Pagani";
        c1.price=99999.99f;
        c1.Model="X0-ZRX";
        System.out.println(c1.Brand);
        System.out.println(c1.price);
        System.out.println(c1.Model);
        c1.drive();
        
        car c2=new car();
        c2.Brand="Tesla";
        c2.price=199999.99f;
        c2.Model="X72-ZRX";
        System.out.println(c2.Brand);
        System.out.println(c2.price);
        System.out.println(c2.Model);
        c2.brake();
    }
}