package com.example.stein.dragndrop;

import android.app.Activity;
import android.content.ClipData;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;

import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.security.acl.Group;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import java.util.Collections;

public class game extends AppCompatActivity {

    public ImageView o1, o2, o3, o4, o5, o6, d1, d2, d3, d4, d5, d6; // objects "o" and their destinations "d".
    private List<Integer> list = new ArrayList<>();

    public Random generator = new Random();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_fragment);

        SurfaceView back = (SurfaceView)findViewById(R.id.surface);
        back.setBackgroundColor(Color.argb(255,generator.nextInt(255),generator.nextInt(255),generator.nextInt(255)));

        final MediaPlayer sound_StartDrag = MediaPlayer.create(this, R.raw.drag_start);
        final MediaPlayer sound_DropWrong = MediaPlayer.create(this, R.raw.drop_wrong);
        final MediaPlayer sound_DropRight = MediaPlayer.create(this, R.raw.drop_right);

        //#################################################
        list.add(R.id.object1);
        list.add(R.id.object2);
        list.add(R.id.object3);
        list.add(R.id.object4);
        list.add(R.id.object5);
        list.add(R.id.object6);
        list.add(R.id.object7);
        list.add(R.id.object8);
        list.add(R.id.object9);
        list.add(R.id.object10);
        list.add(R.id.object11);
        list.add(R.id.object12);

        Collections.shuffle(list);

        o1 = (ImageView) findViewById((Integer)list.get(0));
        o2 = (ImageView) findViewById((Integer)list.get(1));
        o3 = (ImageView) findViewById((Integer)list.get(2));
        o4 = (ImageView) findViewById((Integer)list.get(3));
        o5 = (ImageView) findViewById((Integer)list.get(4));
        o6 = (ImageView) findViewById((Integer)list.get(5));
        d1 = (ImageView) findViewById((Integer)list.get(6));
        d2 = (ImageView) findViewById((Integer)list.get(7));
        d3 = (ImageView) findViewById((Integer)list.get(8));
        d4 = (ImageView) findViewById((Integer)list.get(9));
        d5 = (ImageView) findViewById((Integer)list.get(10));
        d6 = (ImageView) findViewById((Integer)list.get(11));

        draw_object_position(o1, o2, o3, o4, o5, o6, d1, d2, d3, d4, d5, d6);

        //####################################################

        back.setOnDragListener(
                new View.OnDragListener(){
                    @Override
                    public boolean onDrag(View v, DragEvent event) {
                        int action = event.getAction();
                        switch (action){
                            case DragEvent.ACTION_DROP:{
                                ClipData.Item item = event.getClipData().getItemAt(0);
                                String label = new String(item.getText().toString());
                                sound_DropWrong.start();
                                set_back_visability(label, o1, o2, o3, o4, o5, o6);
                            }
                        }
                        return true;
                    }
                }
        );

        d1.setOnDragListener(
                new View.OnDragListener() {
                    @Override
                    public boolean onDrag(View v, DragEvent event) {
                        int action = event.getAction();
                        switch (action){
                            case DragEvent.ACTION_DROP:{
                                ClipData.Item item = event.getClipData().getItemAt(0);
                                String label = new String(item.getText().toString());
                                if(label.equals("o1")){
                                    good_job(d1, sound_DropRight);
                                    check_win(o1, o2, o3, o4, o5, o6);
                                    return true;
                                }
                                else{
                                    sound_DropWrong.start();
                                    set_back_visability(label, o1, o2 ,o3, o4, o5, o6);
                                    return false;
                                }
                            }
                        }
                        return true;
                    }
                }
        );

        d2.setOnDragListener(
                new View.OnDragListener() {
                    @Override
                    public boolean onDrag(View v, DragEvent event) {
                        int action = event.getAction();
                        switch (action){
                            case DragEvent.ACTION_DROP:{
                                ClipData.Item item = event.getClipData().getItemAt(0);
                                String label = new String(item.getText().toString());
                                if(label.equals("o2")){
                                    good_job(d2, sound_DropRight);
                                    check_win(o1, o2, o3, o4, o5, o6);
                                    return true;
                                }
                                else{
                                    sound_DropWrong.start();
                                    set_back_visability(label, o1, o2 ,o3, o4, o5, o6);
                                    return false;
                                }
                            }
                        }
                        return true;
                    }
                }
        );

        d3.setOnDragListener(
                new View.OnDragListener() {
                    @Override
                    public boolean onDrag(View v, DragEvent event) {
                        int action = event.getAction();
                        switch (action){
                            case DragEvent.ACTION_DROP:{
                                ClipData.Item item = event.getClipData().getItemAt(0);
                                String label = new String(item.getText().toString());
                                if(label.equals("o3")){
                                    good_job(d3, sound_DropRight);
                                    check_win(o1, o2, o3, o4, o5, o6);
                                    return true;
                                }
                                else{
                                    sound_DropWrong.start();
                                    set_back_visability(label, o1, o2 ,o3, o4, o5, o6);
                                    return false;
                                }
                            }
                        }
                        return true;
                    }
                }
        );

        d4.setOnDragListener(
                new View.OnDragListener() {
                    @Override
                    public boolean onDrag(View v, DragEvent event) {
                        int action = event.getAction();
                        switch (action){
                            case DragEvent.ACTION_DROP:{
                                ClipData.Item item = event.getClipData().getItemAt(0);
                                String label = new String(item.getText().toString());
                                if(label.equals("o4")){
                                    good_job(d4, sound_DropRight);
                                    check_win(o1, o2, o3, o4, o5, o6);
                                    return true;
                                }
                                else{
                                    sound_DropWrong.start();
                                    set_back_visability(label, o1, o2 ,o3, o4, o5, o6);
                                    return false;
                                }
                            }
                        }
                        return true;
                    }
                }
        );

        d5.setOnDragListener(
                new View.OnDragListener() {
                    @Override
                    public boolean onDrag(View v, DragEvent event) {
                        int action = event.getAction();
                        switch (action){
                            case DragEvent.ACTION_DROP:{
                                ClipData.Item item = event.getClipData().getItemAt(0);
                                String label = new String(item.getText().toString());
                                if(label.equals("o5")){
                                    good_job(d5, sound_DropRight);
                                    check_win(o1, o2, o3, o4, o5, o6);
                                    return true;
                                }
                                else{
                                    sound_DropWrong.start();
                                    set_back_visability(label, o1, o2 ,o3, o4, o5, o6);
                                    return false;
                                }
                            }
                        }
                        return true;
                    }
                }
        );

        d6.setOnDragListener(
                new View.OnDragListener() {
                    @Override
                    public boolean onDrag(View v, DragEvent event) {
                        int action = event.getAction();
                        switch (action){
                            case DragEvent.ACTION_DROP:{
                                ClipData.Item item = event.getClipData().getItemAt(0);
                                String label = new String(item.getText().toString());
                                if(label.equals("o6")){
                                    good_job(d6, sound_DropRight);
                                    return true;
                                }
                                else{
                                    sound_DropWrong.start();
                                    set_back_visability(label, o1, o2 ,o3, o4, o5, o6);
                                    return false;
                                }
                            }
                        }
                        return true;
                    }
                }
        );


        //############################## SET ON TOUCH LISTENERS ##################################


        o1.setOnTouchListener(
                new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        ClipData data = ClipData.newPlainText("text", "o1");
                        View.DragShadowBuilder shadow = new View.DragShadowBuilder(o1);
                        v.startDrag(data, shadow, null, 0);
                        o1.setVisibility(View.GONE);
                        sound_StartDrag.start();
                        return false;
                    }
                }
        );

        o2.setOnTouchListener(
                new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        ClipData data = ClipData.newPlainText("text", "o2");
                        View.DragShadowBuilder shadow = new View.DragShadowBuilder(o2);
                        v.startDrag(data, shadow, null, 0);
                        o2.setVisibility(View.GONE);
                        sound_StartDrag.start();
                        return false;
                    }
                }
        );

        o3.setOnTouchListener(
                new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        ClipData data = ClipData.newPlainText("text", "o3");
                        View.DragShadowBuilder shadow = new View.DragShadowBuilder(o3);
                        v.startDrag(data, shadow, null, 0);
                        o3.setVisibility(View.GONE);
                        sound_StartDrag.start();
                        return false;
                    }
                }
        );

        o4.setOnTouchListener(
                new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        ClipData data = ClipData.newPlainText("text", "o4");
                        View.DragShadowBuilder shadow = new View.DragShadowBuilder(o4);
                        v.startDrag(data, shadow, null, 0);
                        o4.setVisibility(View.GONE);
                        sound_StartDrag.start();
                        return false;
                    }
                }
        );

        o5.setOnTouchListener(
                new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        ClipData data = ClipData.newPlainText("text", "o5");
                        View.DragShadowBuilder shadow = new View.DragShadowBuilder(o5);
                        v.startDrag(data, shadow, null, 0);
                        o5.setVisibility(View.GONE);
                        sound_StartDrag.start();
                        return false;
                    }
                }
        );

        o6.setOnTouchListener(
                new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        ClipData data = ClipData.newPlainText("text", "o6");
                        View.DragShadowBuilder shadow = new View.DragShadowBuilder(o6);
                        v.startDrag(data, shadow, null, 0);
                        o6.setVisibility(View.GONE);
                        sound_StartDrag.start();
                        return false;
                    }
                }
        );




        //####################################################





    }

    public void draw_object_position(ImageView o1, ImageView o2, ImageView o3, ImageView o4, ImageView o5, ImageView o6, ImageView d1, ImageView d2, ImageView d3, ImageView d4, ImageView d5, ImageView d6){

        o1.setImageResource(R.drawable.chick);
        o2.setImageResource(R.drawable.bull);
        o3.setImageResource(R.drawable.crab);
        o4.setImageResource(R.drawable.fox);
        o5.setImageResource(R.drawable.hedgehog);
        o6.setImageResource(R.drawable.hippopotamus);

        d1.setImageResource(R.drawable.chick);
        d2.setImageResource(R.drawable.bull);
        d3.setImageResource(R.drawable.crab);
        d4.setImageResource(R.drawable.fox);
        d5.setImageResource(R.drawable.hedgehog);
        d6.setImageResource(R.drawable.hippopotamus);

        d1.setColorFilter(Color.argb(255,generator.nextInt(255),generator.nextInt(255),generator.nextInt(255)));
        d2.setColorFilter(Color.argb(255,generator.nextInt(255),generator.nextInt(255),generator.nextInt(255)));
        d3.setColorFilter(Color.argb(255,generator.nextInt(255),generator.nextInt(255),generator.nextInt(255)));
        d4.setColorFilter(Color.argb(255,generator.nextInt(255),generator.nextInt(255),generator.nextInt(255)));
        d5.setColorFilter(Color.argb(255,generator.nextInt(255),generator.nextInt(255),generator.nextInt(255)));
        d6.setColorFilter(Color.argb(255,generator.nextInt(255),generator.nextInt(255),generator.nextInt(255)));

    }


    public void set_back_visability(String label, ImageView o1, ImageView o2, ImageView o3, ImageView o4, ImageView o5, ImageView o6) {
        if (label.equals("o1")) {
            o1.setVisibility(View.VISIBLE);
        } else if (label.equals("o2")) {
            o2.setVisibility(View.VISIBLE);
        } else if (label.equals("o3")) {
            o3.setVisibility(View.VISIBLE);
        } else if (label.equals("o4")) {
            o4.setVisibility(View.VISIBLE);
        } else if (label.equals("o5")) {
            o5.setVisibility(View.VISIBLE);
        } else{
            o6.setVisibility(View.VISIBLE);
        }
    }


    public void check_win(ImageView o1, ImageView o2, ImageView o3, ImageView o4, ImageView o5, ImageView o6){
        if(o1.getVisibility() == View.GONE && o2.getVisibility() == View.GONE && o3.getVisibility() == View.GONE && o4.getVisibility() == View.GONE && o5.getVisibility() == View.GONE && o6.getVisibility() == View.GONE){


            Intent game = new Intent(this, StartActivity.class);
            startActivity(game);


            //play win sound


        }
    }


    public void good_job(ImageView a, MediaPlayer sound){
        a.setColorFilter(0);
        check_win(o1, o2, o3, o4, o5, o6);
        sound.start();

    }

}