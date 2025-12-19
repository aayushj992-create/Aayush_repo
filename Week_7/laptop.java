package Week_7;


/**
 * Write a description of class laptop here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class laptop
{
    String brand;
    int ram;
    int price;
    public laptop(String brand,int ram,int price){
        this.brand=brand;
        this.ram=ram;
        this.price=price;  
    }
    void display(){
        if(ram>8)
        {
        System.out.println(brand);
        System.out.println(ram);
        System.out.println(price);}
    }
}