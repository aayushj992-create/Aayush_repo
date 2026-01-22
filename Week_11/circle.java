package Week_11;


/**
 * Write a description of class circle here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class circle extends shape
{
    private double radius;
    public circle(double radius)
    {
        this.radius=radius;
    }
    public double getradius(){
        return this.radius;
    }
    @Override 
    public double calculateArea(){
        double Area=3.14*getradius()*getradius();
        return Area;
    }
    @Override
    public double calculatePerimeter(){
        double Perimeter=2*3.14*getradius();
        return Perimeter;
    }
    @Override
    public void draw(){
        System.out.println("Drawng circle");
    }
}