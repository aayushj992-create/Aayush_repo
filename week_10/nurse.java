package week_10;


/**
 * Write a description of class nurse here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class nurse extends Person
{
    private String shift;
    private double extraAllowance;
    public nurse(int id, String name,String shift,double extraAllowance){
        super(id,name);
        this.shift=shift;
        this.extraAllowance=extraAllowance;
    }
     public void setShift(String shift)
    {
        this.shift=shift;
    }
    public String getShift()
    {
        return this.shift;
    }
    public void setextraAllowance(double extraAllowance )
    {
        this.extraAllowance=extraAllowance;
    }
    public double getextraAllowance()
    {
        return this.extraAllowance;
    }
    @Override
    
    public double calculateSalary(){
        double baseFee=super.calculateSalary();
        double salary=baseFee+extraAllowance;
        return salary;
    }
    
    @Override
    public String toString(){
        return super.toString()+",Salary:"+calculateSalary()+"shift: "+ this.shift+ "extra allowance"+ this.extraAllowance;
    }
}
