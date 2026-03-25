package Coursework;


/**
 * Write a description of class PersonalPlan here.
 *
 * @author (Aayush Joshi)
 * @version (a version number or a date)
 */
public class PersonalPlan extends AIModel
{
    private int remainingPrompts;
    public PersonalPlan(String modelName,double price,int parameterCount,int contextWindow,int remainingPrompts)
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
        if(additionalPrompts>0)
        {
            remainingPrompts+=additionalPrompts;
            return "Successfully added "+additionalPrompts+" prompts"+" Now your total prompts remaining are:"+remainingPrompts;
        }
        else
        {
            return "Please enter positive value or you need to upgrade to Pro Plan";
        }
    }
    
    //Method for userPrompts
    public String usePrompt(String promptText, int expectedLength)
    {
    if (remainingPrompts <= 0)                            
    {
        return "Error: Monthly quota exhausted.";
    }
    if (super.calculateTokenUsage(promptText, expectedLength)==false)
    {
        return "Error: Context limit exceeded.";    
    }
    else
    {
    remainingPrompts -= 1;                                
    return "Prompt accepted. Prompts remaining: " + remainingPrompts; 
    }
    }
    
    //Overriding the to string method
    @Override
    public String display()
    {
        return "Model Name:"+getModelName()+"\nPrice:"+getPrice()+"\nParameter Count:"+getParameterCount()
        +"\nContext Window:"+getContextWindow()+"\nRemaning Prompts:"+getRemainingPrompts();
    }
}