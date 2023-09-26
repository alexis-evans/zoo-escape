public class Time {
    private int hour;
    private int minute;
    //minLeft was made public only so I could access it from Zoo
    public int minLeft;

    public Time() {
        //each game starts with the same amount of time: 6 hours
        minLeft = 360; 
    }

    public String toString() {
        //used as a converting method. this way I can count the total minutes as integers and manipulate them from the Zoo class, but also print out the time left to the player
        if (minLeft <= 0)
            return ("0 min");
        hour = minLeft / 60;
        minute = minLeft % 60;

        return (hour + " hr " + minute + "min");
    }

    





    
}