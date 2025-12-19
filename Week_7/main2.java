package Week_7;
/**
 * Write a description of class main2 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class main2
{
    public static void main(String[] args){
        book b1=new book();
        b1.Title="Harry Potter";
        b1.Author="Jk Rowling";
        b1.Price=999;
        System.out.println(b1.Title);
        System.out.println(b1.Author);
        System.out.println("Rs"+b1.Price);
        book b2=new book();
        b2.Title="Gernimo Stilton";
        b2.Author="Lucy";
        b2.Price=550;
        System.out.println(b2.Title);
        System.out.println(b2.Author);
        System.out.println("Rs"+b2.Price);
        System.out.println();
        Rectangle r1=new Rectangle();
        r1.length=5;
        r1.breadth=6;
        r1.area();
        Rectangle r2=new Rectangle();
        r2.length=4;
        r2.breadth=1;
        r2.area();
        Employee e1=new Employee();
        e1.id=101;
        e1.name="John";
        e1.salary=92020.54f;
        Employee e2=new Employee();
        e2.id=102;
        e2.name="Jerry";
        e2.salary=91120.25f;
        Employee e3=new Employee();
        e3.id=103;
        e3.name="James";
        e3.salary=93000.14f;
        if(e1.salary>e2.salary && e1.salary>e3.salary)
        {
            e1.details();
        }
        else if(e2.salary>e1.salary && e2   .salary>e3.salary)
        {
           e2.details();
        }
        else
        {
           e3.details();        
        }
        System.out.println();
        laptop l1=new laptop("Lenovo",16,99999);
        laptop l2=new laptop("Hp",4,59999);
        laptop l3=new laptop("Acer",8,79999);
        l1.display();
        l2.display();
        l3.display();
        System.out.println();
        mobile m1=new mobile("Iphone",99999);
        mobile m2=new mobile("Samsung",100000);
        mobile m3=new mobile("Nokia",19000);
        m1.isAffordable();
        m2.isAffordable();
        m3.isAffordable();
        System.out.println();
        Result re1=new Result(98,82,63);
        Result re2=new Result(68,52,93);
        Result re3=new Result(58,92,43);
        re1.percentage();
        re2.percentage();
        re3.percentage();
        System.out.println();
        bankAccount account1=new bankAccount(0016200,"Ram",99999.99);
        bankAccount account2=new bankAccount(0016300,"Shyam",21363.21);
        account1.deposit();
        account2.withdraw();
}
}