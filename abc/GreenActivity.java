package abc;

public class GreenActivity {
    private int    activityID;
    private String activityType;
    private String date;
    private int    points;

    public GreenActivity(int id, String type, String date) {
        this.activityID   = id;
        this.activityType = type;
        this.date         = date;
        this.points       = calculatePoints(type);
    }

    public static int calculatePoints(String type) {
        if 
        (type.equals("Cycling"))     
        return 10;
        if (type.equals("Electricity")) 
        return 15;
        if (type.equals("Recycling"))   
        return 12;
        return 5;
    }

    public int    getActivityID()   
    { 
        return activityID; 
    }
    public String getActivityType() 
    { 
        return activityType;
    }
    public String getDate()         
    { 
        return date; 
    }
    public int    getPoints()       
    { 
        return points; 
    }

    public void setActivityType(String activityType) 
    { 
        this.activityType = activityType; 
    }
    public void setDate(String date)                 
    { 
        this.date = date; 
    }
    public void setPoints(int points)                
    { 
        this.points = points; 
    }
}