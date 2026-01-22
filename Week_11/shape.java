package Week_11;


/**
 * Write a description of class shape here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class shape implements drawable
{
    public abstract double calculateArea();
    public abstract double calculatePerimeter();
    public void displayShapeInfo(){
        System.out.println("Area:");
        System.out.println("Perimeter");
    }
    
}