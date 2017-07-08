package com.example.stein.dragndrop;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class RankingActivity extends AppCompatActivity{

    public List<String> list = new ArrayList<>();

    public Integer score;
    public Button button_save;
    public EditText player_name;
    public TextView text_ranking;
    public DBhandler dbhandler = new DBhandler(this, null, null, 1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ranking_layout);

        Bundle data = getIntent().getExtras();
        score = data.getInt("score");

        ImageView logo = (ImageView) findViewById(R.id.Logo);
        draw_logo_colour(logo);

        player_name = (EditText)findViewById(R.id.PlayerName);
        button_save = (Button)findViewById(R.id.button_save);
        text_ranking = (TextView) findViewById(R.id.text_ranking);


        if(score > 0){
            //there was a game


        }
        else {
            //clean entry from menu
            show_ranking();
        }
    }

    public void draw_logo_colour(ImageView logo){
        Random generator = new Random();
        logo.setColorFilter(Color.argb(255,generator.nextInt(100),generator.nextInt(100),generator.nextInt(100)));
    }

    public void save_score(View view){
        Ranking newposition = new Ranking(player_name.getText().toString(), score);
        dbhandler.add_players_score(newposition);
        show_ranking();
    }

    public void show_ranking(){
        String rank  = " ";
        player_name.setVisibility(View.GONE);
        button_save.setVisibility(View.GONE);

        //String dbString = dbhandler.database_to_string();
        list = dbhandler.database_to_string();
        for(int i=0; i<list.size(); i++){
            rank = (rank + (list.get(i) + "\n"));
        }
        text_ranking.setText(rank);

        text_ranking.setVisibility(View.VISIBLE);

    }
}
