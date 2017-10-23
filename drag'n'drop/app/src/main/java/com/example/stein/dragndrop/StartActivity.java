package pl.legalnyplener.fitemall;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class StartActivity extends AppCompatActivity {

    public int score = 0;
    public int life = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        final Button button_help = (Button) findViewById(R.id.button_help);
        button_help.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        popup();
                    }
                }
        );
    }

    public void game_start(View view){
        Intent game = new Intent(this, game.class);
        game.putExtra("score", score);
        game.putExtra("life", life);
        startActivity(game);
    }

    public void popup() {
        AlertDialog.Builder adb = new AlertDialog.Builder(this);
        adb.setTitle(R.string.help_title);
        adb.setMessage(R.string.help_text);


        adb.setPositiveButton("Let's roll!", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {

                //### akcja  po przyciśnieciu przycisku 1 / przykład zmiana TextViev
                //tv.setText("You have clicked ok");
            }
        });
        // ########Przycisk Cancel #########
        // adb.setNegativeButton("Cancel", new DialogInterface.OnClickListener()
        // {
        //  public void onClick(DialogInterface dialog, int id)
        // ###akcja  po przyciśnieciu przycisku 2 / przykład zmiana TextViev
        //tv.setText("You have clicked Cancel");
        //   dialog.cancel();
        //}});

        adb.setIcon(R.drawable.img92);    // ikona popup
        adb.show();
    }

    public void goto_ranking(View view){
        Intent rank = new Intent(this, RankingActivity.class);
        rank.putExtra("score", score);
        startActivity(rank);

    }
}
