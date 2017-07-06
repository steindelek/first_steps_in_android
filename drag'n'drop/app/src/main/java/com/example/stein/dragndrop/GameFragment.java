package com.example.stein.dragndrop;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.app.Activity;

import com.squareup.picasso.Picasso;

import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;


public class GameFragment extends Fragment {


    private ImageView o1, o2, o3, o4, o5, o6, d1, d2, d3, d4, d5, d6; // objects "o" and their destinations "d".
    private SurfaceView back; //Surface - area outside imageviews.



    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.game_fragment, container, false);

        draw_object_position(view, o1, o2, o3, o4, o5, o6, d1, d2, d3, d4, d5, d6);

        //############################### SET ON DROP LISTENERS ###################################

        back.setOnDragListener(
                new View.OnDragListener(){
                    @Override
                    public boolean onDrag(View v, DragEvent event) {
                        int action = event.getAction();
                        switch (action){
                            case DragEvent.ACTION_DROP:{
                                ClipData.Item item = event.getClipData().getItemAt(0);
                                String label = new String(item.getText().toString());
                                sound_surface_drop();
                                set_back_visability(view, label, o1, o2, o3, o4, o5, o6);
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
                                    sound_good_job();
                                    check_win(view, o1, o2, o3, o4, o5, o6);
                                    return true;
                                }
                                else{
                                    sound_wrond_drop();
                                    set_back_visability(view, label, o1, o2 ,o3, o4, o5, o6);
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
                                    sound_good_job();
                                    check_win(view, o1, o2, o3, o4, o5, o6);
                                    return true;
                                }
                                else{
                                    sound_wrond_drop();
                                    set_back_visability(view, label, o1, o2 ,o3, o4, o5, o6);
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
                                    sound_good_job();
                                    check_win(view, o1, o2, o3, o4, o5, o6);
                                    return true;
                                }
                                else{
                                    sound_wrond_drop();
                                    set_back_visability(view, label, o1, o2 ,o3, o4, o5, o6);
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
                                    sound_good_job();
                                    check_win(view, o1, o2, o3, o4, o5, o6);
                                    return true;
                                }
                                else{
                                    sound_wrond_drop();
                                    set_back_visability(view, label, o1, o2 ,o3, o4, o5, o6);
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
                                    sound_good_job();
                                    check_win(view, o1, o2, o3, o4, o5, o6);
                                    return true;
                                }
                                else{
                                    sound_wrond_drop();
                                    set_back_visability(view, label, o1, o2 ,o3, o4, o5, o6);
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
                                    sound_good_job();
                                    check_win(view, o1, o2, o3, o4, o5, o6);
                                    return true;
                                }
                                else{
                                    sound_wrond_drop();
                                    set_back_visability(view, label, o1, o2 ,o3, o4, o5, o6);
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
                        sound_start_drag();
                        return false;
                    }
                }
        );

        o2.setOnTouchListener(
                new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        ClipData data = ClipData.newPlainText("text", "o2");
                        View.DragShadowBuilder shadow = new View.DragShadowBuilder(o1);
                        v.startDrag(data, shadow, null, 0);
                        o1.setVisibility(View.GONE);
                        sound_start_drag();
                        return false;
                    }
                }
        );

        o3.setOnTouchListener(
                new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        ClipData data = ClipData.newPlainText("text", "o3");
                        View.DragShadowBuilder shadow = new View.DragShadowBuilder(o1);
                        v.startDrag(data, shadow, null, 0);
                        o1.setVisibility(View.GONE);
                        sound_start_drag();
                        return false;
                    }
                }
        );

        o4.setOnTouchListener(
                new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        ClipData data = ClipData.newPlainText("text", "o4");
                        View.DragShadowBuilder shadow = new View.DragShadowBuilder(o1);
                        v.startDrag(data, shadow, null, 0);
                        o1.setVisibility(View.GONE);
                        sound_start_drag();
                        return false;
                    }
                }
        );

        o5.setOnTouchListener(
                new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        ClipData data = ClipData.newPlainText("text", "o5");
                        View.DragShadowBuilder shadow = new View.DragShadowBuilder(o1);
                        v.startDrag(data, shadow, null, 0);
                        o1.setVisibility(View.GONE);
                        sound_start_drag();
                        return false;
                    }
                }
        );

        o6.setOnTouchListener(
                new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        ClipData data = ClipData.newPlainText("text", "o6");
                        View.DragShadowBuilder shadow = new View.DragShadowBuilder(o1);
                        v.startDrag(data, shadow, null, 0);
                        o1.setVisibility(View.GONE);
                        sound_start_drag();
                        return false;
                    }
                }
        );

        //return view;

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    public void draw_object_position(View view, ImageView o1, ImageView o2, ImageView o3, ImageView o4, ImageView o5, ImageView o6, ImageView d1, ImageView d2, ImageView d3, ImageView d4, ImageView d5, ImageView d6){

        List<Integer> list = new ArrayList<>();
        list.add(1, R.id.object1);
        list.add(2, R.id.object2);
        list.add(3, R.id.object3);
        list.add(4, R.id.object4);
        list.add(5, R.id.object5);
        list.add(6, R.id.object6);
        list.add(7, R.id.object7);
        list.add(8, R.id.object8);
        list.add(9, R.id.object9);
        list.add(10, R.id.object10);
        list.add(11, R.id.object11);
        list.add(12, R.id.object12);

        o1 = (ImageView) view.findViewById((Integer)list.get(0));
        o2 = (ImageView) view.findViewById((Integer)list.get(1));
        o3 = (ImageView) view.findViewById((Integer)list.get(2));
        o4 = (ImageView) view.findViewById((Integer)list.get(3));
        o5 = (ImageView) view.findViewById((Integer)list.get(4));
        o6 = (ImageView) view.findViewById((Integer)list.get(5));
        d1 = (ImageView) view.findViewById((Integer)list.get(6));
        d2 = (ImageView) view.findViewById((Integer)list.get(7));
        d3 = (ImageView) view.findViewById((Integer)list.get(8));
        d4 = (ImageView) view.findViewById((Integer)list.get(9));
        d5 = (ImageView) view.findViewById((Integer)list.get(10));
        d6 = (ImageView) view.findViewById((Integer)list.get(11));

        o1.setImageResource(R.drawable.poop);
        o2.setImageResource(R.drawable.zycie);
        o3.setImageResource(R.drawable.zycie);
        o4.setImageResource(R.drawable.zycie);
        o5.setImageResource(R.drawable.zycie);
        o6.setImageResource(R.drawable.zycie);
        d1.setImageResource(R.drawable.poop);
        d2.setImageResource(R.drawable.zycie);
        d3.setImageResource(R.drawable.poop);
        d4.setImageResource(R.drawable.zycie);
        d5.setImageResource(R.drawable.zycie);
        d6.setImageResource(R.drawable.zycie);

    }


    public void set_back_visability(View view, String label, ImageView o1, ImageView o2, ImageView o3, ImageView o4, ImageView o5, ImageView o6) {
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


    public void check_win(View view, ImageView o1, ImageView o2, ImageView o3, ImageView o4, ImageView o5, ImageView o6){
        if(o1.getVisibility() == View.GONE && o2.getVisibility() == View.GONE && o3.getVisibility() == View.GONE && o4.getVisibility() == View.GONE && o5.getVisibility() == View.GONE && o6.getVisibility() == View.GONE){



            //kill fragment and show button "next level".


            //play win sound


        }
    }



    public void sound_good_job(){

        //goodJob sound ;)
    }

    public void sound_surface_drop(){
        // drop on surface sound :/
    }

    public void sound_wrond_drop(){
        //fail sound :(
    }

    public void sound_start_drag(){
        // whip sound :P
    }


}
