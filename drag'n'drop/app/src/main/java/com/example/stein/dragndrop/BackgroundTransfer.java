package pl.legalnyplener.fitemall;

import android.content.Context;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

public class BackgroundTransfer extends AsyncTask<Ranking, Void, ArrayList<Ranking>> {

    Context context;
    BackgroundTransfer(Context context){
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected ArrayList<Ranking> doInBackground(Ranking... params) {

        ArrayList<Ranking> ranking = new ArrayList<>();
        int position = params[0].get_score();
        if(position > 0){
            String url_save = "http://serwer1704039.home.pl/android/Kubatesty/datainsert.php";

            String name = params[0].get_player_name();
            int score = params[0].get_score();
            int image = params[0].get_img();

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

        }else{
            String url_get = "http://serwer1704039.home.pl/android/Kubatesty/datadownload.php";
            URL url = null;
            try {
                url = new URL(url_get);
                HttpURLConnection httpURLConection = (HttpURLConnection) url.openConnection();
                httpURLConection.setDoInput(true);
                InputStream stream = httpURLConection.getInputStream();
                BufferedReader bufrer = new BufferedReader(new InputStreamReader(stream, "iso-8859-1"));

                int max_position = 0;
                String line = " ";
                while (((line = bufrer.readLine()) != null) || max_position > 100){
                    String[] ranking_line = line.split("\\s+");
                    ranking.add(new Ranking(ranking_line[0], Integer.getInteger(ranking_line[1]), Integer.getInteger(ranking_line[2])));
                    max_position++;
                }
                bufrer.close();
                stream.close();
                httpURLConection.disconnect();
                return ranking;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        return null;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(ArrayList<Ranking> ranking) {
        mySQLhandler(ranking);
    }

    private ArrayList<Ranking> mySQLhandler(ArrayList<Ranking> ranking){
        return ranking;
    }
}
