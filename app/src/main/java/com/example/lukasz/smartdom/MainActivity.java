package com.example.lukasz.smartdom;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class MainActivity extends AppCompatActivity {

    public static final int malinaPORT = 1108;
    public static final String malinaIP= "192.168.1.49";
    BufferedReader br;
    private Socket socket = null;
    private GoogleApiClient client;
    ImageView img;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
        img = (ImageView)findViewById(R.id.imageView2);

        new Thread(new Runnable() {
            @Override
            public void run()
            {
                try {
                    if (SocketHand.getSocket()==null) {
                        socket = new Socket(malinaIP, malinaPORT);
                        SocketHand.setSocket(socket);
                    }else{
                        socket=SocketHand.getSocket();
                    }
                        br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        String data, cmd, msg;
                        String[] datasplit;
                        while ((data = br.readLine()) != null) {
                            datasplit = data.split(":");
                            cmd = datasplit[0];
                            msg = datasplit[1];

                            switch (cmd) {
                                case "TEMP":
                                    temperatureHand.setTemperatura(msg);
                                    break;
                            }
                        }

                    }catch(IOException ex)
                    {

                    }

            }
        }).start();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void oswietlenieclick(View view) {
        Intent intent = new Intent(MainActivity.this,OswietlenieActivity.class);
        startActivity(intent);
    }

    public void bezpieczenstwoclick(View view) {
        Intent intent = new Intent(MainActivity.this,BezpieczenstwoActivity.class);
        startActivity(intent);
    }

    public void komfortclick(View view) {
        Intent intent = new Intent(MainActivity.this,KomfortActivity.class);
        startActivity(intent);
    }

    public void koniecclick(View view) {

        this.finish();
        System.exit(0);
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Main Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }

}
