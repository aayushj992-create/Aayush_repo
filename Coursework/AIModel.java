package Coursework;


/**
 * Write a description of class AIModel here.
 *
 * @author (Aayush Joshi)
 * @version (a version number or a date)
 */
public abstract class AIModel
{
    private String modelName;
    private double price;
    private int parameterCount;
    private int contextWindow;
    
    //Constructor of AIModel
    public AIModel(String modelName,double price,int parameterCount,int contextWindow)
    {
        this.modelName=modelName;
        this.price=price;
        this.parameterCount=parameterCount;
        this.contextWindow=contextWindow;
    }
    
    //Accessor for modelName
    public String getModelName()
    {
       return this.modelName; 
    }
    
    //Accessor for price
    public double getPrice()
    {
       return this.price; 
    }
    
    //Accessor for paramenterCount
    public int getParameterCount()
    {
       return this.parameterCount; 
    }
    
    //Accessor for contextWindow
    public int getContextWindow()
    {
       return this.contextWindow; 
    }
    
    public boolean calculateTokenUsage(String userText,int outputTokens)
    {
        int inputTokens=userText.length()/4;
        final int systemTokens=100;     
        int totalTokens=inputTokens+outputTokens+systemTokens;
        return totalTokens<=getContextWindow();
    }
    //Abstract display method
    public abstract String display();
}