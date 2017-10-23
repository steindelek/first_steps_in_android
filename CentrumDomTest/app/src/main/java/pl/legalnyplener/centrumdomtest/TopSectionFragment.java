package pl.legalnyplener.centrumdomtest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by stein on 25.09.2017.
 */

public class TopSectionFragment extends Fragment {

    private ImageView logo, plus, catalog, mail, burger, act_plus, act_catalog, act_mail, act_burger;
    private int button_id = 0;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.top_section_fragment, container, false);

        logo = (ImageView) view.findViewById(R.id.logo);
        plus = (ImageView) view.findViewById(R.id.plus);
        catalog = (ImageView) view.findViewById(R.id.catalog);
        mail = (ImageView) view.findViewById(R.id.mail);
        burger = (ImageView) view.findViewById(R.id.burger);

        act_plus = (ImageView) view.findViewById(R.id.activation_plus);
        act_catalog = (ImageView) view.findViewById(R.id.activation_catalog);
        act_mail = (ImageView) view.findViewById(R.id.activation_mail);
        act_burger = (ImageView) view.findViewById(R.id.activation_burger);

        active_button();

        logo.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        button_id = 0;
                        active_button();
                        return false;
                    }
                }
        );

        plus.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                button_id = 1;
                active_button();
                return false;
            }
        });

        catalog.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                button_id = 2;
                active_button();
                return false;
            }
        });

        mail.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                button_id = 3;
                active_button();
                return false;
            }
        });

        burger.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                button_id = 4;
                active_button();
                return false;
            }
        });

        return view;
    }

    private void active_button(){

        act_plus.setVisibility(View.INVISIBLE);
        act_catalog.setVisibility(View.INVISIBLE);
        act_mail.setVisibility(View.INVISIBLE);
        act_burger.setVisibility(View.INVISIBLE);

        switch (button_id){
            case 1:  act_plus.setVisibility(View.VISIBLE);
                break;
            case 2: act_catalog.setVisibility(View.VISIBLE);
                break;
            case 3: act_mail.setVisibility(View.VISIBLE);
                break;
            case 4: act_burger.setVisibility(View.VISIBLE);
                break;
            default:{
                break;
            }
        }
    }
}
