package com.example.lukasz.smartdom;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class OswietlenieActivity extends AppCompatActivity {

    ToggleButton btn1,btn2,btn3,btn4,btn5,btnall;
    BufferedWriter brw;
    ImageView img;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oswietlenie);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        btn1 =(ToggleButton)findViewById(R.id.toggleButton2);
        btn2 =(ToggleButton)findViewById(R.id.toggleButton3);
        btn3 =(ToggleButton)findViewById(R.id.toggleButton4);
        btn4 =(ToggleButton)findViewById(R.id.toggleButton5);
        btn5 =(ToggleButton)findViewById(R.id.toggleButton6);
        btnall =(ToggleButton)findViewById(R.id.toggleButton);
        btn1.setChecked(oswietlenieHand.getB1());
        btn2.setChecked(oswietlenieHand.getB2());
        btn3.setChecked(oswietlenieHand.getB3());
        btn4.setChecked(oswietlenieHand.getB4());
        btn5.setChecked(oswietlenieHand.getB5());
        btnall.setChecked(oswietlenieHand.getB6());
        img = (ImageView)findViewById(R.id.imageView);

    }

    public void click(View view) {
        try {
            brw = new BufferedWriter(new OutputStreamWriter(SocketHand.getSocket().getOutputStream()));
            switch (view.getId()) {
                case R.id.toggleButton2:
                    if (btn1.isChecked())
                    {
                        brw.write("LED:0,1");
                        brw.newLine();
                        brw.flush();
                        oswietlenieHand.setB1(true);
                    }else
                    {
                        brw.write("LED:0,0");
                        brw.newLine();
                        brw.flush();
                        oswietlenieHand.setB1(false);
                    }
                        break;
                case R.id.toggleButton3:
                    if (btn2.isChecked())
                    {
                        brw.write("LED:1,1");
                        brw.newLine();
                        brw.flush();
                        oswietlenieHand.setB2(true);
                    }else
                    {
                        brw.write("LED:1,0");
                        brw.newLine();
                        brw.flush();
                        oswietlenieHand.setB2(false);
                    }
                    break;
                case R.id.toggleButton4:
                    if (btn3.isChecked())
                    {
                        brw.write("LED:2,1");
                        brw.newLine();
                        brw.flush();
                        oswietlenieHand.setB3(true);
                    }else
                    {
                        brw.write("LED:2,0");
                        brw.newLine();
                        brw.flush();
                        oswietlenieHand.setB3(false);
                    }
                    break;
                case R.id.toggleButton5:
                    if (btn4.isChecked())
                    {
                        brw.write("LED:3,1");
                        brw.newLine();
                        brw.flush();
                        oswietlenieHand.setB4(true);
                    }else
                    {
                        brw.write("LED:3,0");
                        brw.newLine();
                        brw.flush();
                        oswietlenieHand.setB4(false);
                    }
                    break;
                case R.id.toggleButton6:
                    if (btn5.isChecked())
                    {
                        brw.write("LED:4,1");
                        brw.newLine();
                        brw.flush();
                        oswietlenieHand.setB5(true);
                    }else
                    {
                        brw.write("LED:4,0");
                        brw.newLine();
                        brw.flush();
                        oswietlenieHand.setB5(false);
                    }
                    break;
                case R.id.toggleButton:
                    if (btnall.isChecked())
                    {
                        brw.write("LED:9,1");
                        brw.newLine();
                        brw.flush();
                        oswietlenieHand.setB6(true);
                    }else
                    {
                        brw.write("LED:9,0");
                        brw.newLine();
                        brw.flush();
                        oswietlenieHand.setB6(false);
                    }
                    break;
            }
        }catch(IOException ex)
        {

        }
    }

    }


