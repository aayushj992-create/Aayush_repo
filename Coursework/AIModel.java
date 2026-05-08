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
    
    public int calculateTokenUsage(String inputText, int expectedOutputToken) 
    {
    if (inputText == null) {
        throw new IllegalArgumentException("inputToken must not be null");
    }

    String[] text = inputText.split(" ");
    int inputTokens = (text.length + 3) / 4;  
    final int SYSTEM_TOKENS = 10;

    int totalTokens = inputTokens + SYSTEM_TOKENS + expectedOutputToken;

    if (totalTokens > getContextWindow()) {
        throw new IllegalArgumentException(
            "Error: total tokens (" + totalTokens + ") exceeds context window (" + getContextWindow() + ")"
        );
    }

    return totalTokens;   
    }
    //Abstract display method
    public abstract String display();
}