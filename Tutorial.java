
/**
 * Write a description of class Tutorial here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Tutorial
{
    int agr;
    static int rtr;
    public static void main(String[] args){
        int age=18;
        System.out.println(age);
        Tutorial t1=new Tutorial();
        System.out.println(t1.agr);
        double db=age;
        System.out.println(db);
       double dbr=10.89;
       int itr=(int)dbr;
       System.out.println(itr);
       long abc=100;
       int bcd=(int)abc;
       System.out.println(bcd);
       short st=10;
       short str=11;
    short tyu=(short)(st+str);
    System.out.println(tyu);
    byte a=23;
    byte b=76;
    byte abb=(byte)(a+b);
    System.out.println(abb);
    System.out.println(Byte.MAX_VALUE);
    System.out.println(Byte.MIN_VALUE);
    System.out.println(Byte.SIZE);
    System.out.println(Byte.BYTES);
    
    System.out.println("Hello\nWorld");
    System.out.println("Hello\tWorld");
    System.out.println("Hello\"World\"");
    System.out.println("\u2764");
     }
}