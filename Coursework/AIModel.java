package Coursework;


/**
 * Write a description of class AIModel here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class AIModel
{
    private String modelName;
    private double price;
    private int parameterCount;
    private String contextWindow;
    
    //Constructor of AIModel
    public AIModel(String modelName,double price,int parameterCount,String contextWindow)
    {
        this.modelName=modelName;
        this.price=price;
        this.parameterCount=parameterCount;
        this.contextWindow=contextWindow;
    }
    
    //Getter Setter for modelName
    public void setModelName(String modelName)
    {
        this.modelName=modelName;
    }
    public String getModelName()
    {
       return this.modelName; 
    }
    
    //Getter Setter for price
    public void setPrice(double price)
    {
        this.price=price;
    }
    public double getPrice()
    {
       return this.price; 
    }
    
    //Getter Setter for paramenterCount
    public void setParameterCount(int parameterCount)
    {
        this.parameterCount=parameterCount;
    }
    public int getParameterCount()
    {
       return this.parameterCount; 
    }
    
    //Getter Setter for contextWindow
    public void setContextWindow(String contextWindow)
    {
        this.contextWindow=contextWindow;
    }
    public String getContextWindow()
    {
       return this.contextWindow; 
    }
    
    //To string Method
    @Override
    public String toString()
    {
        return "Name of AI model:"+getModelName()+"\nPricing:"+getPrice()+"\nParameters count:"+getParameterCount()+
        "\nContext Window Size:"+getContextWindow();
    }
    
}