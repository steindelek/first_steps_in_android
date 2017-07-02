package com.example.stein.dragndrop;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewParent;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Gallery;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        final Button button_help = (Button) findViewById(R.id.button_help);
        button_help.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        LayoutInflater layoutInflater = (LayoutInflater) getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                        View popupview = layoutInflater.inflate(R.layout.help_layout, null);
                        final PopupWindow popupWindow = new PopupWindow(popupview, WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT);

                        Button button_close = (Button) popupview.findViewById(R.id.button_close);
                        button_close.setOnClickListener(
                                new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        popupWindow.dismiss();
                                    }
                                }
                        );
                        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);
                    }
                }
        );
    }

    public void game_start(View view){
        Intent game = new Intent(this, MainActivity.class);
        startActivity(game);
    }
}
