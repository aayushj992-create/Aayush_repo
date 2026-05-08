package Coursework;


/**
 * Write a description of class PersonalPlan here.
 *
 * @author (Aayush Joshi)
 * @version (a version number or a date)
 */
public class PersonalPlan extends AIModel
{
    private int availableTokens;
    public PersonalPlan(String modelName,double price,int parameterCount,int contextWindow,int availableTokens)
    {
        super(modelName, price,parameterCount,contextWindow);
        this.availableTokens=availableTokens;
    }   
    
    //Accessor for remainingPrompts
    public int getAvailableTokens()
    {
       return this.availableTokens; 
    }
    
    public void setavailbaleTokens(int availableTokens)
    {
        this.availableTokens=availableTokens;
    }
    
    
    //Method for additional prompts
    public String purchaseTokens(int additionalTokens)
    {
        if(additionalTokens>0)
        {
            availableTokens+=additionalTokens;
            return "Successfully added "+additionalTokens+" prompts"+" Now your total prompts remaining are:"+availableTokens;
        }
        else
        {
            return "Please enter positive value or you need to upgrade to Pro Plan";
        }
    }
    
    //Method for userPrompts
    public String usePrompt(String promptText, int expectedLength)
    {
    if (availableTokens <= 0) {
        return "Error: Monthly quota exhausted.";
    }
    int tokensUsed;
    try {
        tokensUsed = super.calculateTokenUsage(promptText, expectedLength);
    } 
    catch (IllegalArgumentException e) {
        return e.getMessage();
    } 
    catch (Exception e) {
        return "Error: Context limit exceeded.";
    }

    if (tokensUsed > availableTokens) {
        return "Error: Not enough tokens remaining.";
    }

    availableTokens -= tokensUsed;

    return "Prompt accepted. Tokens remaining: " + availableTokens;
    }
    
    
    //Overriding the to string method
    @Override
    public String display()
    {
        return "Model Name:"+getModelName()+"\nPrice:"+getPrice()+"\nParameter Count:"+getParameterCount()
        +"\nContext Window:"+getContextWindow()+"\nRemaning Prompts:"+getAvailableTokens();
    }
}