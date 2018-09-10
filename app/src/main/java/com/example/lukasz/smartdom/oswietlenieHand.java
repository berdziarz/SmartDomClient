package com.example.lukasz.smartdom;

/**
 * Created by Lukasz on 2017-03-22.
 */

public class oswietlenieHand {
   private static boolean b1,b2,b3,b4,b5,b6;

    public static synchronized boolean getB1()
    {
        return b1;
    }
    public static synchronized void setB1(boolean b)
    {
        oswietlenieHand.b1=b;
    }
    public static synchronized boolean getB2()
    {
        return b2;
    }
    public static synchronized void setB2(boolean b)
    {
        oswietlenieHand.b2=b;
    }
    public static synchronized boolean getB3()
    {
        return b3;
    }
    public static synchronized void setB3(boolean b)
    {
        oswietlenieHand.b3=b;
    }
    public static synchronized boolean getB4()
    {
        return b4;
    }
    public static synchronized void setB4(boolean b)
    {
        oswietlenieHand.b4=b;
    }
    public static synchronized boolean getB5()
    {
        return b5;
    }
    public static synchronized void setB5(boolean b)
    {
        oswietlenieHand.b5=b;
    }
    public static synchronized boolean getB6()
    {
        return b6;
    }
    public static synchronized void setB6(boolean b)
    {
        oswietlenieHand.b6=b;
    }
}
