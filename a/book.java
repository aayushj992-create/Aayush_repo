package a;


/**
 * Write a description of class book_info here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class book
{
    String Title;
    double price;
    static final String publisherName="JK Rowling";
    public void displayInfo()
    {
        System.out.println(Title+price+publisherName);
    }
}