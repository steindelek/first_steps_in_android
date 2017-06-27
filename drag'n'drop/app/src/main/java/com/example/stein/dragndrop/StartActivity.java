package com.example.stein.dragndrop;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        Button button_help = (Button) findViewById(R.id.button_help);

        Context context = getApplicationContext();
        CharSequence help = "The goal is to match objects with their colorful shadows ;)";
        final Toast toast = Toast.makeText(context, help, Toast.LENGTH_LONG);

        button_help.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        toast.show();
                    }
                }
        );
    }

    public void game_start(View view){
        Intent game = new Intent(this, MainActivity.class);
        startActivity(game);
    }
}
