package testCourse;


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
    
    public void setModelName(String modelName)
    {
        this.modelName=modelName;
    }
    
    //Accessor for price
    public double getPrice()
    {
       return this.price; 
    }
    public void setPrice(double price)
    {
        this.price=price;
    }
    
    //Accessor for paramenterCount
    public int getParameterCount()
    {
       return this.parameterCount; 
    }
    public void setParameterCount(int parameterCount)
    {
        this.parameterCount=parameterCount;
    }
    
    //Accessor for contextWindow
    public int getContextWindow()
    {
       return this.contextWindow; 
    }
    public void setContextWindow(int contextWindow)
    {
        this.contextWindow=contextWindow;
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
