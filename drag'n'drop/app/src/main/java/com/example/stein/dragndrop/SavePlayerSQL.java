package com.example.stein.dragndrop;

import android.os.StrictMode;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by stein on 27.07.2017.
 */

public class SavePlayerSQL {

    public SavePlayerSQL(){

    }

    public void from_ranking(Ranking ranking){

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        String url_save = "http://serwer1704039.home.pl/android/Kubatesty/datainsert.php";

        String name = ranking.get_player_name();
        int score = ranking.get_score();
        int image = ranking.get_img();

        try {
            URL url = new URL(url_save);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            OutputStream stream = httpURLConnection.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(stream,"UTF-8" ));
            String data = URLEncoder.encode("name", "UTF-8") + "=" + URLEncoder.encode(name, "UTF-8") + "&" +
                    URLEncoder.encode("score", "UTF-8") + "=" + URLEncoder.encode(String.valueOf(score), "UTF-8") + "&" +
                    URLEncoder.encode("image", "UTF-8") + "=" + URLEncoder.encode(String.valueOf(image), "UTF-8");
            bufferedWriter.write(data);
            bufferedWriter.flush();
            bufferedWriter.close();
            stream.close();

            InputStream is = httpURLConnection.getInputStream();
            is.close();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
