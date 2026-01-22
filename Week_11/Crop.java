package Week_11;


/**
 * Write a description of class Crop here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class Crop implements transportable
{
    private String cropName;
    private String season;
    private double landArea;
    public Crop(String cropName,String season,double landArea)
    {
        this.cropName=cropName;
        this.season=season;
        this.landArea=landArea;
    }
    public String getcropName()
    {
        return this.cropName;
    }
    public void setcropName(String cropName)
    {
        this.cropName=cropName;
    }
    public String getseason()
    {
        return this.season;
    }
    public void setseason(String season)
    {
        this.season=season;
    }
    public double getlandArea()
    {
        return this.landArea;
    }
    public void setlandArea(double landArea)
    {
        this.landArea=landArea;
    }
    public abstract void calculateYield();
    public abstract void calculateWaterRequirement();
    @Override
    public String toString(){
        return "Name="+getcropName()+"Season="+getseason()+"Land area="+getlandArea();
    } 
}