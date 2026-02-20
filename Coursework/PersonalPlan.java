package Coursework;


/**
 * Write a description of class PersonalPlan here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PersonalPlan extends AIModel
{
    private int remainingPrompts;
    public PersonalPlan(String modelName,double price,int parameterCount,String contextWindow,int remainingPrompts)
    {
        super(modelName, price,parameterCount,contextWindow);
        this.remainingPrompts=remainingPrompts;
    }
    
    //Accessor for remainingPrompts
    public int getRemainingPrompts()
    {
       return this.remainingPrompts; 
    }
    
    //Method for additional prompts
    public String purchasePrompts(int additionalPrompts)
    {
        if(additionalPrompts<0)
        {
            return "You need to upgrade to Pro Plan";
        }
        else
        {
            remainingPrompts+=additionalPrompts;
            return "Successfully added"+additionalPrompts+"prompts"+"Now your total prompts remaining are:"+remainingPrompts;
        }
    }
    
    //Method
    public String userPrompts(String promptText,int expectedLength)
    {
    if(remainingPrompts>0)
    {
        remainingPrompts-=1;
        return "Prompt text:"+promptText+"\nExpected output length:"+expectedLength+"\nPrompts Remaining"+remainingPrompts;
    }
    else
    {
        return"Your monthly quota has been reached";
    }
}

    //Overriding the to string method
    @Override
    public String toString()
    {
        return super.toString()+"Remaning Prompts:"+getRemainingPrompts();
    }
}