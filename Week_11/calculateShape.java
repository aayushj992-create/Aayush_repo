package Week_11;


/**
 * Write a description of class calculateShape here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class calculateShape
{
    public static void main(String[] args){
        shape r1=new rectangle(20,50);
        shape c1=new circle(2);
        System.out.println(r1.calculateArea());
        r1.draw();
        c1.draw();
    }
}