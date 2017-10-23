package com.example.stein.dragndrop;

import android.os.StrictMode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by stein on 27.07.2017.
 */

public class GetRankingSQL {

    public ArrayList<Ranking> get_Array(){

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        ArrayList<Ranking> ranking = new ArrayList<>();
        String url_get = "http://serwer1704039.home.pl/android/Kubatesty/datadownload.php";
        URL url;
        try {
            url = new URL(url_get);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setDoInput(true);
            InputStream stream = httpURLConnection.getInputStream();
            BufferedReader bufrer = new BufferedReader(new InputStreamReader(stream, "iso-8859-1"));

            String line = bufrer.readLine();
            String[] ranking_positions = line.split("@");
            for(int i = 0; i < ranking_positions.length; i++){
                String[] single_position = ranking_positions[i].split("\\s+");
                ranking.add(new Ranking(single_position[0], Integer.parseInt(single_position[1]), Integer.parseInt(single_position[2])));
            }
            bufrer.close();
            stream.close();
            httpURLConnection.disconnect();
            return ranking;

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ranking;
    }
}
