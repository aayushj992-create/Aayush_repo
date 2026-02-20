package Coursework;


/**
 * Write a description of class ProPlan here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ProPlan extends AIModel
{
    private int slots;
    public ProPlan(String modelName,double price,int parameterCount,String contextWindow,int slots)
    {
        super(modelName, price,parameterCount,contextWindow);
        this.slots=slots;
    }
    
    //Getter Setter for slots
    public int getSlots()
    {
       return this.slots; 
    }
    
    //Method for Adding team
    public String addTeam(String memberName)
    {
        if(slots>0)
        {
           slots--;
           return "Team member:"+memberName+"added successfully."+"\nAvailable Slots Remaining:" + slots;  
        }
        else
        {
            return "No available team slots. Please upgrade your Pro Plan.";
        }
    }
    
    //Method
    
    //Overriding the to string method
    @Override
    public String toString()
    {
        return super.toString()+"Remaning Prompts:"+getSlots();
    }
}