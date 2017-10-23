package pl.legalnyplener.fitemall;

import android.content.ClipData;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.support.v7.app.AlertDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import java.util.Collections;

public class game extends AppCompatActivity {

    public ImageView o1, o2, o3, o4, o5, o6, d1, d2, d3, d4, d5, d6; // objects "o" and their destinations "d".
    public ImageView life1, life2, life3, life4, life5;
    public TextView points;
    private List<Integer> list = new ArrayList<>();
    public Random generator = new Random();
    public int score, life;
    private AdView adView;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_fragment);

        Bundle data = getIntent().getExtras();
        score = data.getInt("score");
        life = data.getInt("life");

        SurfaceView back = (SurfaceView)findViewById(R.id.surface);
        back.setBackgroundColor(Color.argb(255,generator.nextInt(80)+175,generator.nextInt(80)+175,generator.nextInt(80)+175));

        //MobileAds.initialize(getApplicationContext(), "ca-app-pub-8532606852973121~2171064099"); // Prawdziwe
        MobileAds.initialize(getApplicationContext(), "ca-app-pub-3940256099942544~3347511713"); // testowe


        adView = (AdView) findViewById(R.id.adView);
        //AdRequest adRequest = new AdRequest.Builder().build();
        AdRequest adRequest = new AdRequest.Builder().addTestDevice("33BE2250B43518CCDA7DE426D04EE232").build();
        adView.loadAd(adRequest);

        life1 = (ImageView) findViewById(R.id.life1);
        life2 = (ImageView) findViewById(R.id.life2);
        life3 = (ImageView) findViewById(R.id.life3);
        life4 = (ImageView) findViewById(R.id.life4);
        life5 = (ImageView) findViewById(R.id.life5);
        set_life();

        points = (TextView) findViewById(R.id.points);
        points.setText(String.valueOf(score)+" PTS");


        final MediaPlayer sound_StartDrag = MediaPlayer.create(this, R.raw.drag_start);
        final MediaPlayer sound_DropWrong = MediaPlayer.create(this, R.raw.drop_wrong);
        final MediaPlayer sound_DropRight = MediaPlayer.create(this, R.raw.drop_right);

        //################################################# randomize positions ###########
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

        draw_objects(o1, o2, o3, o4, o5, o6, d1, d2, d3, d4, d5, d6);

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
                                wrong_drop(sound_DropWrong);
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
                                    wrong_drop(sound_DropWrong);
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
                                    wrong_drop(sound_DropWrong);
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
                                    wrong_drop(sound_DropWrong);
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
                                    wrong_drop(sound_DropWrong);
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
                                    wrong_drop(sound_DropWrong);
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
                                    wrong_drop(sound_DropWrong);
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

    }

    //####################################################


    public void draw_objects(ImageView o1, ImageView o2, ImageView o3, ImageView o4, ImageView o5, ImageView o6, ImageView d1, ImageView d2, ImageView d3, ImageView d4, ImageView d5, ImageView d6){

        List<Integer> pngs = make_list_of_images(); //List of addresses of all images in resources

        Integer i = generator.nextInt(pngs.size());  // generate random image
        o1.setImageResource(pngs.get(i));            //set drawn image
        d1.setImageResource(pngs.get(i));
        pngs.remove(pngs.get(i));              // and remove it from List
        i = generator.nextInt(pngs.size());
        o2.setImageResource(pngs.get(i));
        d2.setImageResource(pngs.get(i));
        pngs.remove(pngs.get(i));               // WHY SIMPLE pngs.remove(i) do not work !?!?
        i = generator.nextInt(pngs.size());
        o3.setImageResource(pngs.get(i));
        d3.setImageResource(pngs.get(i));
        pngs.remove(pngs.get(i));
        i = generator.nextInt(pngs.size());
        o4.setImageResource(pngs.get(i));
        d4.setImageResource(pngs.get(i));
        pngs.remove(pngs.get(i));
        i = generator.nextInt(pngs.size());
        o5.setImageResource(pngs.get(i));
        d5.setImageResource(pngs.get(i));
        pngs.remove(pngs.get(i));
        i = generator.nextInt(pngs.size());
        o6.setImageResource(pngs.get(i));
        d6.setImageResource(pngs.get(i));

        // set random color of target field
        d1.setColorFilter(Color.argb(255,generator.nextInt(200),generator.nextInt(200),generator.nextInt(200)));
        d2.setColorFilter(Color.argb(255,generator.nextInt(200),generator.nextInt(200),generator.nextInt(200)));
        d3.setColorFilter(Color.argb(255,generator.nextInt(200),generator.nextInt(200),generator.nextInt(200)));
        d4.setColorFilter(Color.argb(255,generator.nextInt(200),generator.nextInt(200),generator.nextInt(200)));
        d5.setColorFilter(Color.argb(255,generator.nextInt(200),generator.nextInt(200),generator.nextInt(200)));
        d6.setColorFilter(Color.argb(255,generator.nextInt(200),generator.nextInt(200),generator.nextInt(200)));
    }

// set back movable object to the origin place
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

// check_win checks if all movable objects are gone
    public void check_win(ImageView o1, ImageView o2, ImageView o3, ImageView o4, ImageView o5, ImageView o6){
        if(o1.getVisibility() == View.GONE && o2.getVisibility() == View.GONE && o3.getVisibility() == View.GONE && o4.getVisibility() == View.GONE && o5.getVisibility() == View.GONE && o6.getVisibility() == View.GONE){

            end_level_popup();
            //play win sound
        }
    }


    public void good_job(ImageView a, MediaPlayer sound){
        a.setColorFilter(0);
        score+=10;
        points.setText(String.valueOf(score)+ getText(R.string.pts));
        check_win(o1, o2, o3, o4, o5, o6);
        sound.start();
    }


    public void wrong_drop(MediaPlayer sound_DropWrong){
        life--;
        sound_DropWrong.start();
        set_life();
    }

// popup window at the end of level or lives
    public void end_level_popup() {
        final Intent rank = new Intent(this, RankingActivity.class); // set intent to RankingActivity
        AlertDialog.Builder adb = new AlertDialog.Builder(this); // Popup window builder
        if(life < 1){
            // if you die
            adb.setTitle(R.string.game_over);
            if(score > 0){
                adb.setMessage(getText(R.string.score) + " " + String.valueOf(score) + " " + getText(R.string.pts) + "\n" + getText(R.string.great_score));
                // set "save score" button
                adb.setPositiveButton(R.string.save_score, new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int id){
                        rank.putExtra("score", score); //add extras - score
                        startActivity(rank);           //launch RankingActivity
                        finish();
                    }
                });
            }else {
                adb.setMessage(getText(R.string.score) + " " + String.valueOf(score) + " " + getText(R.string.pts) + "\n");
            }

            adb.setNegativeButton(R.string.Try_again, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    goto_nextlevel(0, 5); // Restart with 0 pts and 5 lives
                }
            });
        }
        else{
            //when you win
            adb.setTitle(R.string.score);
            adb.setMessage(score+" pts\n" + getText(R.string.keepitup));


            //set a "next level" button
            adb.setPositiveButton(R.string.nextlevel, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    goto_nextlevel(score, life);
                }
            });
        }

        adb.setIcon(R.drawable.img81).show();    // popup window icon
        adb.show();
    }

//Go to next level method
    public void goto_nextlevel(int score, int life){
        Intent game = new Intent(this, game.class); // set intent to game activity
        game.putExtra("score", score); //add extras - score
        game.putExtra("life", life); // life level
        startActivity(game); // start
        finish();
    }

// Set life indicator and check if player dies
    public void set_life(){

        if(life < 5){
            life5.setVisibility(View.INVISIBLE);
        }
        if(life < 4){
            life4.setVisibility(View.INVISIBLE);
        }
        if(life < 3){
            life3.setVisibility(View.INVISIBLE);
        }
        if(life < 2){
            life2.setVisibility(View.INVISIBLE);

        }
        if(life < 1){
            life1.setVisibility(View.INVISIBLE);
            end_level_popup();
        }
    }

    public List<Integer> make_list_of_images(){
        List<Integer> img = new ArrayList<>();

        for(int i=1; i<108; i++){
            String png = "img"+String.valueOf(i);
            img.add(getResources().getIdentifier(png,"drawable", getPackageName()));
        }
        return img;
    }
}