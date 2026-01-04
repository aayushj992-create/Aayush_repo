package Week_8;


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
        //Invocation-object banaunu parcha//how do we call instance varirable.
        Calculator calc= new Calculator();
        calc.displayInfo();//void + no parameters
        calc.add(10,20);//actual parameters
        calc.add(30,40);
        calc.add(50,60);
        System.out.println(calc.getFixedNumber());
        int fixNum=calc.getFixedNumber();
        System.out.println("The fix number is:" +fixNum);
        int multi=calc.multiply(10,20);
        System.out.println("The multi number is:" +multi);
        
        System.out.println(Calculator.square(10));
        Car c1=new Car();
        Car c2=new Car("green");
        
        Car c3=new Car(104);
        Car c4=new Car("yellow",105);
        
    }
}