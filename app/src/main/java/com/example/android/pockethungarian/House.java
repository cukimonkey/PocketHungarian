package com.example.android.pockethungarian;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class House extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);

//        Create an array list for the English, Hungrian translation, graphic images and audio
        final ArrayList<Elements> elements = new ArrayList<Elements>();
        elements.add(new Elements("living room","nappali", R.drawable.nappali));
        elements.add(new Elements("The lights are on in the living room","A nappaliban ég a villany"));
        elements.add(new Elements("kitchen","konyha", R.drawable.kitchen));
        elements.add(new Elements("Our kitchen is always tidy","A konyhánk mindig rendes"));
        elements.add(new Elements("bedroom","háló - hálószoba", R.drawable.halo));
        elements.add(new Elements("Someone is sleeping in the bedroom","Valaki alszik a hálóban"));
        elements.add(new Elements("bathroom","fürdőszoba", R.drawable.furdo));
        elements.add(new Elements("The bathroom is upstairs","A fürdőszoba az emeleten van"));
        elements.add(new Elements("hall","előszoba", R.drawable.eloszoba));
        elements.add(new Elements("It's dark in the hall","Sötét van az előszobában"));
        elements.add(new Elements("stairs","lépcsőház", R.drawable.lepcso));
        elements.add(new Elements("The stairs are narrow","A lépcsőház keskeny"));
        elements.add(new Elements("garage","garázs", R.drawable.garazs));
        elements.add(new Elements("There's a car parked in the garage","Egy autó parkol a garázsban"));
        elements.add(new Elements("garden","kert", R.drawable.kert));
        elements.add(new Elements("We're relaxing in the garden","A kertben pihenünk"));
        elements.add(new Elements("door","ajtó", R.drawable.ajto));
        elements.add(new Elements("Someone's at the door","Van valaki az ajtónál"));
        elements.add(new Elements("window","ablak", R.drawable.ablak));
        elements.add(new Elements("May I open the window?","Kinyithatnám az ablakot?"));
        elements.add(new Elements("bed","ágy", R.drawable.agy));
        elements.add(new Elements("This is a double bed","Ez egy dupla ágy"));
        elements.add(new Elements("table","asztal", R.drawable.asztal));
        elements.add(new Elements("The table is in the corner","Az asztal a sarokban van"));
        elements.add(new Elements("chair","szék", R.drawable.szek));
        elements.add(new Elements("The chair is broken","A szék törött"));
        elements.add(new Elements("cupboard","szekrény", R.drawable.szekreny));
        elements.add(new Elements("The cupboard is empty","A szekrény üres"));
        elements.add(new Elements("sofa","kanapé", R.drawable.kanape));
        elements.add(new Elements("This sofa is comfortable","Ez a kanapé kényelmes"));



        // Create an {@link WordAdapter}, whose data source is a list of {@link Elements}s. The
        // adapter knows how to create list items for each item in the list.
        WordAdapter adapter = new WordAdapter(this, elements);
        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_listyout file.
        ListView listView = (ListView) findViewById(R.id.list);



        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(adapter);
    }
}
