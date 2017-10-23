package pl.legalnyplener.centrumdomtest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by stein on 25.09.2017.
 */

public class OfferListElementFragment extends Fragment {
    private ImageView element_foto;
    private TextView element_nazwa, element_lokaliazacja, element_cena;

    public OfferListElementFragment(){
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.offer_list_element, container, false);

        try{
            Bundle data = getArguments();
            String foto_url = data.getString("foto_url");
            String nazwa = data.getString("nazwa");
            String lokalizacja = data.getString("lokalizacja");
            int cena = data.getInt("cena");

            element_foto = (ImageView) view.findViewById(R.id.element_foto);
            element_nazwa = (TextView) view.findViewById(R.id.element_tytul);
            element_lokaliazacja = (TextView) view.findViewById(R.id.element_lokalizacja);
            element_cena = (TextView) view.findViewById(R.id.element_cena);

            Picasso.with(getActivity().getApplicationContext()).load(foto_url).placeholder(R.drawable.photo).error(R.drawable.photo).into(element_foto);
            element_nazwa.setText(nazwa);
            element_lokaliazacja.setText(lokalizacja);
            element_cena.setText(String.valueOf(cena) + " zł");
        }catch (Exception e){
            e.printStackTrace();
        }

        return view;
    }
}
