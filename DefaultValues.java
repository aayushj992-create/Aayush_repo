
/**
 * Write a description of class DefaultValues here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DefaultValues
{
    byte a;
    short b;
    int c;
    long d;
    float e;
    double f;
    char g;
    boolean h;
    public static void main(String[] args){
        DefaultValues t1=new DefaultValues();
        System.out.println(t1.a);
        System.out.println(t1.b);
        System.out.println(t1.c);
        System.out.println(t1.d);
        System.out.println(t1.e);
        System.out.println(t1.f);
        System.out.println(t1.g);
        System.out.println(t1.h);
        //this wouldn't work in a local variable because literals of the local variable should be introduced.
    }
}