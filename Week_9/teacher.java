package Week_9;


/**
 * Write a description of class teacher here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class teacher extends person
{
     String subject;
     double bonus;
     public teacher(int id,String name,double basicSalary,String subject,double bonus){
         super(id,name,basicSalary);
         this.subject=subject;
         this.bonus=bonus;
     }
     @Override
     double calculateAnnualSalary(){
        double Bonus=super.calculateAnnualSalary()+ bonus;
        displayInfo();
        System.out.println("Your bonus amount is:"+Bonus);
      return bonus;
      
     }
}