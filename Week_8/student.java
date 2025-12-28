package Week_8;


/**
 * Write a description of class student here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class student
{
    //Attributes
  private String name;
  private int id;
  //Constructor-object lai initialize garne
  public student(String name,int id)
  {
      this.name=name;
      this.id=id;
  }
  //getters and setters methods
  //setters ma return type hunna so void
  public void setName(String name)
  {
      this.name=name;
  }
  public String getName()
  {
   return this.name;   
  }
  public void setId(int id)
  {
      this.id=id;
  }
  public int getId()
  {
      return this.id;
  }//sequence=constructor,getter setters ani methods
  //<ethods to display info
void displayInfo()
{
    String namee=this.getName();
    int ID=this.getId();
    System.out.println("Name of the new student is:"+namee);
    System.out.println("id of the student is:"+ID);
}
}