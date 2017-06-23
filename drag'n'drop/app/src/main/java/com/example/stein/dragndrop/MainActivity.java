package com.example.stein.dragndrop;

import android.content.ClipData;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageView img1, img2;
    TextView info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);

        img1 = (ImageView) findViewById(R.id.img1);
        img2 = (ImageView) findViewById(R.id.img2);
        info = (TextView) findViewById(R.id.info);

        img2.setOnDragListener(
                new View.OnDragListener() {
                    @Override
                    public boolean onDrag(View v, DragEvent event) {
                        int action = event.getAction();
                        switch (action){
                            case DragEvent.ACTION_DRAG_ENDED:{
                                info.setText(R.string.success);
                            }
                            case DragEvent.ACTION_DROP:{
                                info.setText(R.string.fail);
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
                        ClipData data = ClipData.newPlainText(" "," ");
                        View.DragShadowBuilder shadow = new View.DragShadowBuilder(img1);
                        v.startDrag(data, shadow, null, 0);
                        return false;
                    }
                }
        );

    }
}
