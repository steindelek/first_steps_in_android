package com.example.stein.dragndrop;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class Level_2 extends AppCompatActivity {

    // img(odd num) is movable object, img(even num) is goal [img1 -> img2]
    // surface is an area outside objects img(num)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_2);

        // img(odd num) is movable object, img(even num) is goal [img1 -> img2]
        final ImageView img1 = (ImageView) findViewById(R.id.img1);
        final ImageView img2 = (ImageView) findViewById(R.id.img2);
        final ImageView img3 = (ImageView) findViewById(R.id.img3);
        final ImageView img4 = (ImageView) findViewById(R.id.img4);

        Picasso.with(this).load("http://serwer1704039.home.pl/android/fitemall/monstertruck.png").error(R.drawable.poop).into(img1);
        Picasso.with(this).load("http://serwer1704039.home.pl/android/fitemall/monstertruck_tlo.png").error(R.drawable.poop).into(img2);
        Picasso.with(this).load("http://serwer1704039.home.pl/android/fitemall/grzyb.png").error(R.drawable.poop).into(img3);
        Picasso.with(this).load("http://serwer1704039.home.pl/android/fitemall/grzyb_tlo.png").error(R.drawable.poop).into(img4);


        // surface is an area outside objects img(num)
        SurfaceView back = (SurfaceView) findViewById(R.id.back);
        final TextView info = (TextView) findViewById(R.id.info);

        back.setOnDragListener(
                new View.OnDragListener() {
                    @Override
                    public boolean onDrag(View v, DragEvent event) {
                        int action = event.getAction();
                        switch (action){
                            case DragEvent.ACTION_DROP:{
                                ClipData.Item item = event.getClipData().getItemAt(0);
                                String label = new String(item.getText().toString());
                                if (label.equals("krowa")){
                                    img1.setVisibility(View.VISIBLE);
                                }
                                else if(label.equals("swinia")){
                                    img3.setVisibility(View.VISIBLE);
                                }


                            }
                        }
                        return true;
                    }
                }
        );

        img2.setOnDragListener(
                new View.OnDragListener() {
                    @Override
                    public boolean onDrag(View v, DragEvent event) {
                        int action = event.getAction();
                        switch (action){
                            case DragEvent.ACTION_DRAG_ENDED:{
                            }

                            case DragEvent.ACTION_DRAG_STARTED:{
                                return true;
                            }

                            case DragEvent.ACTION_DROP:{
                                ClipData.Item item = event.getClipData().getItemAt(0);
                                String label = new String(item.getText().toString());
                                Boolean ret;
                                if (label.equals("krowa")){
                                    info.setText(R.string.success);
                                    ret = true;
                                }
                                else{
                                    info.setText(R.string.fail);
                                    img3.setVisibility(View.VISIBLE);
                                    ret = false;
                                }
                                check_win(img1, img3, info);
                                return ret;

                            }
                            default:{
                                break;
                            }
                        }

                        return true;
                    }
                }
        );

        img4.setOnDragListener(
                new View.OnDragListener() {
                    @Override
                    public boolean onDrag(View v, DragEvent event) {
                        int action = event.getAction();
                        switch (action){
                            case DragEvent.ACTION_DRAG_ENDED:{
                            }
                            case DragEvent.ACTION_DRAG_STARTED:{
                                return true;
                            }

                            case DragEvent.ACTION_DROP:{
                                ClipData.Item item = event.getClipData().getItemAt(0);
                                String label = new String(item.getText().toString());
                                Boolean ret;
                                if (label.equals("swinia")){
                                    info.setText(R.string.success);
                                    ret = true;
                                }
                                else{
                                    info.setText(R.string.fail);
                                    img1.setVisibility(View.VISIBLE);
                                    ret = false;
                                }
                                check_win(img1, img3, info);
                                return ret;

                            }
                            default:{
                                break;
                            }
                        }

                        return true;
                    }
                }
        );



        img1.setOnTouchListener(
                new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        ClipData data = ClipData.newPlainText("zwierze","krowa");
                        View.DragShadowBuilder shadow = new View.DragShadowBuilder(img1);
                        v.startDrag(data, shadow, null, 0);
                        img1.setVisibility(View.GONE);
                        return false;
                    }
                }
        );
        img3.setOnTouchListener(
                new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        ClipData data = ClipData.newPlainText("zwierze","swinia");
                        View.DragShadowBuilder shadow = new View.DragShadowBuilder(img3);
                        v.startDrag(data, shadow, null, 0);
                        img3.setVisibility(View.GONE);
                        return false;

                    }
                }
        );
    }

    public void check_win(ImageView img1, ImageView img2, TextView info){
        if(img1.getVisibility() == View.GONE && img2.getVisibility() == View.GONE){
            info.setText(R.string.youwin);
            info.setTextSize(50);
        }
    }
}