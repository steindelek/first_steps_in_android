package com.example.stein.dragndrop;

import android.content.ClipData;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView img1, img2, img3;
    TextView info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);

        img1 = (ImageView) findViewById(R.id.img1);
        img2 = (ImageView) findViewById(R.id.img2);
        img3 = (ImageView) findViewById(R.id.img3);
        info = (TextView) findViewById(R.id.info);

        img2.setOnDragListener(
                new View.OnDragListener() {
                    @Override
                    public boolean onDrag(View v, DragEvent event) {
                        int action = event.getAction();
                        switch (action){
                            case DragEvent.ACTION_DRAG_ENDED:{
                                img1.setVisibility(View.VISIBLE);
                                img3.setVisibility(View.VISIBLE);

                            }

                            case DragEvent.ACTION_DRAG_STARTED:{
                                return true;
                            }

                            case DragEvent.ACTION_DROP:{
                                ClipData.Item item = event.getClipData().getItemAt(0);
                                String label = new String(item.getText().toString());
                                if (label.equals("krowa")){
                                    info.setText(R.string.success);
                                    return true;
                                }
                                else{
                                    info.setText(R.string.fail);
                                    return false;
                                }

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
                        img1.setVisibility(View.INVISIBLE);
                        return false;
                    }
                }
        );
        img3.setOnTouchListener(
                new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        ClipData data = ClipData.newPlainText("zwierze","droid");
                        View.DragShadowBuilder shadow = new View.DragShadowBuilder(img3);
                        v.startDrag(data, shadow, null, 0);
                        img3.setVisibility(View.INVISIBLE);
                        return false;

                    }
                }
        );

    }
}
