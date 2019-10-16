package com.iesmb.horticulturamza;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.StrictMode;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private Button ubicarme;

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
                    try {
                        //URL url = new URL("https://www.google.com.ar");
                        URL url = new URL("https://swapi.co/api/people/1/");
                        //URL url = new URL("http://192.168.1.40:8080/regionalesMza/V1.0/companies/");
                        try {
                            HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
                            httpConn.setRequestMethod("GET");
                            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                            StrictMode.setThreadPolicy(policy);
                            InputStream inputStream = httpConn.getInputStream();
                            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                            String line = bufferedReader.readLine();
                            JsonObject obj = new JsonParser().parse(line).getAsJsonObject();
                            TextView textView = findViewById(R.id.tex);
                            textView.setText(obj.get("name").getAsString());
                            httpConn.disconnect();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        ubicarme= (Button) findViewById(R.id.buttonmap);

        ubicarme.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0){
                Intent inten = new Intent(MainActivity.this , Mapa.class);
                startActivity(inten);
            }
        });
    }
}
