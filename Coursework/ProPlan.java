package Coursework;
import java.util.ArrayList;


/**
 * Write a description of class ProPlan here.
 *
 * @author (Aayush Joshi)
 * @version (a version number or a date)
 */
public class ProPlan extends AIModel
{
    private  int slotsAvailable;
    private ArrayList<String> member;
    public ProPlan(String modelName,double price,int parameterCount,int contextWindow,int slotsAvailable)
    {
        super(modelName, price,parameterCount,contextWindow);
        this.slotsAvailable=slotsAvailable;
        this.member=new ArrayList<>();
    }
    
    //Accessor for slots
    public int getSlots()
    {
       return this.slotsAvailable; 
    }
    
    public void setSlots(int slotsAvailable)
    {
       this.slotsAvailable=slotsAvailable; 
    }
    
    //Method for Adding team meamber
    public String addTeamMember(String memberName)
    {
        if(slotsAvailable>0)
        {
           slotsAvailable--;
           member.add(memberName);
           return "Team member:"+memberName+" added successfully."+"\nAvailable Slots Remaining:" + slotsAvailable;  
        }
        else
        {
            return "No available team slots. Please upgrade your Pro Plan.";
        }
    }
    
    //Method to remove team member
    public String removeTeamMember(String memberName)
    {
        slotsAvailable++;   
        member.remove(memberName);
        return "Team member:"+memberName+" removed successfully."+"\nAvailable Slots Remaining:" + slotsAvailable; 
    }
    
   public String usePrompt(String userText, int outputTokens)
    {
    int tokensUsed;

    try {
        tokensUsed = super.calculateTokenUsage(userText, outputTokens);
    }
    catch (IllegalArgumentException e)
    {
        return e.getMessage();
    }
    catch (Exception e)
    {
        return "Error: Context limit exceeded.";
    }

    return "Success. Tokens used: " + tokensUsed;
    }
    
    //Overriding the to string method
    @Override
    public String display()
    {
        return "Model Name:"+getModelName()+"\nPrice:"+getPrice()+"\nParameter Count:"+getParameterCount()
        +"\nContext Window:"+getContextWindow()+"\nAvailable Team Slots: " + getSlots();
    }
}