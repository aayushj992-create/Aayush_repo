package Week_11;


/**
 * Write a description of class maize here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class maize extends Crop
{
    private String waterRequirement;
    public maize(String cropName,String season,double landArea,String  waterRequirement)
    {
        super(cropName,season,landArea);
        this.waterRequirement=waterRequirement;
    }
    public String getwaterRequirement()
    {
        return this.waterRequirement;
    }
    public void setwaterRequirement(String waterRequirement)
    {
        this.waterRequirement=waterRequirement;
    }
    @Override
    public void calculateWaterRequirement()
    {
        System.out.println(getwaterRequirement());
    }
    @Override
    public void calculateYield()
    {
        System.out.println(getlandArea()*2);
    }
    @Override
    public String toString()
    {
        return super.toString()+"water requirement"+getwaterRequirement();
    }
    @Override
    public void calculateTransportCost(){
        System.out.println(1000);
    }
    @Override
    public void getTransportMethod(){
        System.out.println("Truck");
    }
}