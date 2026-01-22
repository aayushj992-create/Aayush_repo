package Week_11;


/**
 * Write a description of class CropManagement here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CropManagement
{
    public static void main(String[] args)
    {
        Crop m1=new maize("maize","hill-friendly",3000,"low");
        Crop w1=new wheat("wheat","winter",200,"moderate");
        Crop r1=new rice("rice","monsoon",1000,"high");
        System.out.println(m1);
        System.out.println(w1);
        System.out.println(r1);
        r1.calculateTransportCost();
    }
}