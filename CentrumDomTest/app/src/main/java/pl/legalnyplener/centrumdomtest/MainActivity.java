package pl.legalnyplener.centrumdomtest;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();


        Bundle data = new Bundle();
        data.putInt("cena", 250000);
        data.putString("foto_url", "http://centrumdom.pl/wp-content/uploads/2017/09/dsc08477and8more_tonemapped-kopiowanie-kopiowanie-553x553.jpg");
        data.putString("nazwa", "Dom jednorodzinny");
        data.putString("lokalizacja", "Droginia");
        OfferListElementFragment offerListElementFragment = new OfferListElementFragment();

        offerListElementFragment.setArguments(data);
        fragmentTransaction.replace(R.id.promo_1, offerListElementFragment).commit();
    }
}
