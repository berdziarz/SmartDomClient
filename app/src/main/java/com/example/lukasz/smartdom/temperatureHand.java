package com.example.lukasz.smartdom;

/**
 * Created by Lukasz on 2017-03-21.
 */

public class temperatureHand {
    private static String temperatura="0.0";
    private static int min=0,max=0;
    private static boolean kontrola=false;

    public static synchronized String getTemperatura()
    {
        return temperatura;
    }
    public static synchronized void setTemperatura(String string)
    {
        String[] c;
        char c2;
        c=string.split("[.]");
        c2=c[1].charAt(0);
        string=c[0]+"."+c2+"\u2103";
        temperatureHand.temperatura=string;
;   }
    public static synchronized int getMin()
    {
        return min;
    }
    public static synchronized void setMin(int i)
    {
        temperatureHand.min=i;
    }
    public static synchronized int getMax()
    {
        return max;
    }
    public static synchronized void setMax(int i)
    {
        temperatureHand.max=i;
    }
    public static synchronized boolean getKontrola()
    {
        return kontrola;
    }
    public static synchronized void setKontrola(boolean b)
    {
        temperatureHand.kontrola=b;
    }
}
