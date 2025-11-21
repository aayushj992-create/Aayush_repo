
/**
 * Write a description of class Data_Type_Inspector here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Data_Type_Inspector
{
    public static void main(String[] args){
        byte a=10;
        short b=23;
        int c=56;
        long d=4567890L;
        float e=89.8921f;
        double f=7613.72139d;
        char g='A';
        boolean h=true;
        System.out.println("Byte has 8-bit:"+a);
        System.out.println("Short has 16-bit:"+b);
        System.out.println("Int has 32-bit:"+c);
        System.out.println("Long has 64-bit:"+d);
        System.out.println("Float has 32-bit:"+e);
        System.out.println("Double has 64-bit:"+f);
        System.out.println("char has 16-bit:"+g);
        System.out.println("Short has 2-bit:"+h);
    }
}