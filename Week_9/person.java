package Week_9;


/**
 * Write a description of class person here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class person
{
   int id;
   String name;
   double basicSalary;
   static String collegeName="Hello University";
   public person(int id,String name,double basicSalary){
       this.id=id;
       this.name=name;
       this.basicSalary=basicSalary;
   }
   double calculateAnnualSalary(){
       return this.basicSalary*12;
   }
   public void displayInfo(){
       System.out.println("Id:"+id);
       System.out.println("Name:"+name);
       System.out.println("Salary:"+basicSalary);
       System.out.println("CollegeName:"+collegeName);
       
       
   }
}