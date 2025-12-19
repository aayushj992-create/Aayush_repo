package Week_7;


/**
 * Write a description of class Result here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Result
{
    int subject1;
    int subject2;
    int subject3;
    public Result(int marks1,int marks2,int marks3){
        this.subject1=marks1;
        this.subject2=marks2;
        this.subject3=marks3;
    }
    void percentage(){
        int total=subject1+subject2+subject3;
        float percentage=(total/300f)*100f;
        System.out.println("Your total Percentage is"+percentage);
          
    }
    
}