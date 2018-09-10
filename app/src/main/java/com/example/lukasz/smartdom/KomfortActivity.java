package com.example.lukasz.smartdom;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

import org.w3c.dom.Text;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class KomfortActivity extends AppCompatActivity {

    Socket socket;
    ImageView img;
    TextView txt;
    EditText edtxt1,edtxt2;
    ToggleButton tBtn;
    float tmp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_komfort);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        img = (ImageView) findViewById(R.id.imageView3);
        txt = (TextView)findViewById(R.id.textView11);
        edtxt1= (EditText)findViewById(R.id.editText);
        edtxt2= (EditText)findViewById(R.id.editText2);
        tBtn = (ToggleButton)findViewById(R.id.toggleButton8);
        tBtn.setChecked(temperatureHand.getKontrola());
      //  edtxt1.setText(temperatureHand.getMin());
     //   edtxt2.setText(temperatureHand.getMax());
        txt.setText(temperatureHand.getTemperatura());
    }

    public void click(View view) {
        if(tBtn.isChecked())
        {
            if(edtxt1.getText()!=null && edtxt2.getText()!=null)
            {

                try {
                    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(SocketHand.getSocket().getOutputStream()));
                    bw.write("TEMP:"+edtxt1.getText()+","+edtxt2.getText()+",1");
                    bw.newLine();
                    bw.flush();
                    temperatureHand.setMin(Integer.parseInt(edtxt1.getText().toString()));
                    temperatureHand.setMax(Integer.parseInt(edtxt2.getText().toString()));
                    temperatureHand.setKontrola(true);
                }catch(IOException e)
                {

                }
            }
        }else
        {
            try {
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(SocketHand.getSocket().getOutputStream()));
                bw.write("TEMP:0,0,0");
                bw.newLine();
                bw.flush();
                temperatureHand.setKontrola(false);
            }catch(IOException e)
            {

            }
        }
    }
}

