package com.iesmb.horticulturamza;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button boton =  findViewById(R.id.buttonHello);
        boton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                ConnectivityManager connection= (ConnectivityManager)
                        getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo informacioN = connection.getActiveNetworkInfo();
                if(informacioN!= null && informacioN.isConnected()){
                    try{
                        URL url= new URL("https://swapi.co/api/people/1/");
                        try{
                            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                            try{
                                InputStream in = new BufferedInputStream(urlConnection.getInputStream());
                                int obj = in.read();
                                TextView textView = findViewById(R.id.tex);
                                textView.setText(obj);
                            }catch (IOException e){
                                e.printStackTrace();
                            }finally {
                                urlConnection.disconnect();
                            }
                        }catch (IOException em){
                            em.printStackTrace();
                        }
                    }catch (MalformedURLException ex){
                        ex.printStackTrace();
                    }

                }
            }
        });
    }
}
