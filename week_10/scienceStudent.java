package week_10;


/**
 * Write a description of class scienceStudent here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class scienceStudent extends student
{
    public scienceStudent(int no,String name,double marks){
    super(no,name,marks);
}
@Override
public String calculateResult(){
        if(getmarks()>=40)
        {
            return "pass";
        }
        else
        {
            return "fail";
        }
    }
    public String calculateResult(int graceMarks){
        if(getmarks()+graceMarks>=40)
        {
            return "pass";
        }
        else
        {
            return "fail";
        }
    }
    @Override
    public String toString(){
        return super.toString()+"Result"+calculateResult();
    }
}
    
    
    
    