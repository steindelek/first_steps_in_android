package com.example.stein.dragndrop;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.app.Activity;
import android.

import com.squareup.picasso.Picasso;


public class GameFragment extends Fragment {

    private ImageView object1, object2, object3, object4, object5, object6, object7, object8, object9, object10, object11, object12;



    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.game_fragment, container, false);


        object1 = (ImageView) view.findViewById(R.id.object1);
        object2 = (ImageView) view.findViewById(R.id.object2);
        object3 = (ImageView) view.findViewById(R.id.object3);
        object4 = (ImageView) view.findViewById(R.id.object4);
        object5 = (ImageView) view.findViewById(R.id.object5);
        object6 = (ImageView) view.findViewById(R.id.object6);
        object7 = (ImageView) view.findViewById(R.id.object7);
        object8 = (ImageView) view.findViewById(R.id.object8);
        object9 = (ImageView) view.findViewById(R.id.object9);
        object10 = (ImageView) view.findViewById(R.id.object10);
        object11 = (ImageView) view.findViewById(R.id.object11);
        object12 = (ImageView) view.findViewById(R.id.object12);

        // ####################################  12 OnDragListeners and 12 onTouchListeners ?!  -- help!
        // if end with "tlo" Touch else Drag

        //########################################
        //   oooooh maybe: static java class and changing xml ?!
        // always "object1 -> objest2", changing posytion of object1 and objest2
        // object2.adress = objest1.adress + "_tlo"




        return view;

        //return super.onCreateView(inflater, container, savedInstanceState);
    }
}
