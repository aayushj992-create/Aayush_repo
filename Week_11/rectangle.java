package Week_11;


/**
 * Write a description of class rectangle here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class rectangle extends shape
{
    private double length;
    private double breadth;
    public rectangle(double length,double breadth)
    {
        this.length=length;
        this.breadth=breadth;
    }
    public double getlength(){
        return this.length;
    }
    public double getbreadth(){
        return this.breadth;
    }
    @Override 
    public double calculateArea(){
        double Area=getlength()*getbreadth();
        return Area;
    }
    @Override
    public double calculatePerimeter(){
        double Perimeter=2*getlength()+getbreadth();
        return Perimeter;
    }
    @Override
    public void draw(){
        System.out.println("Drawng rectangle");
    }
}