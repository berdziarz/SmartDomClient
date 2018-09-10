package com.example.lukasz.smartdom;

import java.net.Socket;

/**
 * Created by Lukasz on 2017-03-21.
 */

public class SocketHand {
    private static Socket socket;

    public static synchronized Socket getSocket(){
        return socket;
    }

    public static synchronized void setSocket(Socket socket){
        SocketHand.socket = socket;
    }
}
