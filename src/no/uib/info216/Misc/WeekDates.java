package no.uib.info216.Misc;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

/**
 * Created by fox on 5/19/16.
 */
public class WeekDates {

    public String getName(int day) {
        switch (day) {
            case Calendar.MONDAY:
                return "Monday";
            case Calendar.TUESDAY:
                return "Tuesday";
            case Calendar.WEDNESDAY:
                return "Wednesday";
            case Calendar.THURSDAY:
                return "Thursday";
            case Calendar.FRIDAY:
                return "Friday";
            case Calendar.SATURDAY:
                return "Saturday";
            case Calendar.SUNDAY:
                return "Sunday";
        }
        return null;
    }

    /**
     * Get the days and names of the days N number of days ahead
     * @param numberOfDays int Number of days lookahead
     * @return Hashmap String,String. Name of day -> Date
     */
    public HashMap<String, String> getWeekDates(int numberOfDays){
        HashMap<String,String> returnDates = new HashMap<String,String>();

        Calendar cal = Calendar.getInstance();
        int day = cal.get(Calendar.DAY_OF_WEEK);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");

        //Get 7 days
        for(int i = numberOfDays; i!=0; i--){
            if(day > numberOfDays){
                day = 1;
            }
            returnDates.put(this.getName(day), formatter.format(cal.getTime()));

            //Increments
            cal.add(Calendar.DATE, 1);
            day += 1;
        }

        return returnDates;
    }
}
