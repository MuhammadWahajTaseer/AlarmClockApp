package com.wahaj.alarmclock;

/**
 * This is the Alarm class that stores all information about the alarm
 * It has getters and setters to access private fields
 */

public class Alarm {

    private int id;
    private int hour;
    private int minute;
    private int ampm;
    private int origHour;
    private int origMinute;
    private int origAmpm;
    public boolean dismissed;
    private boolean repeating;
    private String descript;

    //variables for snooze
    private boolean snooze = false;
    private int rang = 0;

    // Arrray for which days to ring, STARTS ON SUNDAY
    // SUN MON TUES WED THURS FRI SAT
    private boolean[] days = { false, false, false, false, false, false, false };

    // path for the ringer sound file
    private String ringerPath = null;


    /**
     *
     * @param hour          Hour
     * @param minute        Minute
     * @param ampm          AM = 0; PM = 1
     * @param repeating     Weekly repeating or not
     * @param words         Label
     * @param days          If repeating -> days of the week starting sunday
     *
     *  Constructor that initializes everything
     */
    public Alarm(int hour, int minute, int ampm, boolean repeating, String words, boolean []days)
    {
        this.hour = hour;
        this.minute = minute;
        this.ampm = ampm;
        this.origHour = hour;
        this.origMinute = minute;
        this.origAmpm = ampm;
        this.descript = words;
        this.days = days;

    }


    /**
     * Getter methods of attributes from Alarm class
     *
     */
    public int getOrigHour()
    {
        return this.origHour;
    }
    public int getOrigMinute()
    {
        return this.origMinute;
    }
    public int getorigAmpm()
    {
        return this.origAmpm;
    }
    public int getRang()
    {
        return this.rang;
    }
    public boolean getSnooze()
    {
        return this.snooze;
    }
    public int getID()
    {
        return id;
    }

    public int getHour()
    {
        return hour;
    }

    public String getName()
    {
        return descript;
    }

    public int getMin()
    {
        return minute;
    }

    public int getAMPM()
    {
        return ampm;
    }

    public boolean getRepeating()
    {
        return repeating;
    }

    public boolean[] getDays()
    {
        return days;
    }

    public String getDescription()
    {
        return this.descript;
    }
    public String getRingerPath()
    {
        return this.ringerPath;
    }


    /**
     *
     * @return Converts alarm object to a string for displaying
     */
    public String toString()
    {

        String tempMin = Integer.toString(minute);
        if (minute < 10)
        {
            tempMin = "0" + tempMin;
        }

        String temp = this.getHour() + ":" + tempMin;

        if (this.getAMPM() == 0)
        {
            temp += " AM";
        }
        else
        {
            temp += " PM";
        }
        return temp;
    }




    /**
     * Setter methods of attributes from Alarm class
     *
     */

    public void setOrigHour(int hour)
    {
        this.origHour = hour;
    }

    public void setDays(boolean[] day)
    {
        this.days = day;
    }
    public void setOrigMinute(int mint)
    {
        this.origMinute = mint;
    }
    public void setorigAmpm(int ampm)
    {
        this.origAmpm  = ampm;
    }
    public void setSnooze(boolean snooze)
    {
        this.snooze = snooze;
    }


    public void setID(int id)
    {
        this.id = id;
    }

    public void setHour(int hour)
    {
        this.hour = hour;
    }

    public void setMin(int mins)
    {
        this.minute = mins;
    }
    public void setAMPM(int amopm)
    {
        this.ampm = amopm;
    }

    public void setRingerPath(String path)
    {
        this.ringerPath = path;
    }

    public void setName(String words)
    {
        this.descript = words;
    }



}
