package com.example.android.pockethungarian;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class EatingOut extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);

//        Create an array list for the English, Hungrian translation, graphic images and audio
        final ArrayList<Elements> elements = new ArrayList<Elements>();
        elements.add(new Elements("Let's go to a restaurant!","Menjünk egy étterembe!"));
        elements.add(new Elements("I'm hungry","Éhes vagyok"));
        elements.add(new Elements("Can you recommend a good café?","Ajánlanál egy jó kávézót?"));
        elements.add(new Elements("Entrée","Előétel", R.drawable.eloetel2));
        elements.add(new Elements("The entree was a big portion","Az előétel nagy adag volt."));
        elements.add(new Elements("Soup","Leves", R.drawable.leves));
        elements.add(new Elements("This soup is a little bit spicy","Ez a leves kicsit csípős."));
        elements.add(new Elements("Main course","Főétel", R.drawable.foetel));
        elements.add(new Elements("The main course is very fulfilling","A főétel nagyon laktató"));
        elements.add(new Elements("Dessert","Desszert", R.drawable.desszert));
        elements.add(new Elements("I ordered pancake for dessert","Palacsintát rendeltem desszertnek"));
        elements.add(new Elements("Excuse me, I'd like to order","Elnézést, rendelni szeretnék"));
        elements.add(new Elements("I'd like to taste the goulash soup","Megkóstolnám a gulyáslevest"));
        elements.add(new Elements("It was very delicious","Nagyon finom volt"));
        elements.add(new Elements("Can I have a glass of water","Kaphatnék egy pohár vizet?"));
        elements.add(new Elements("Wine","Bor", R.drawable.bor));
        elements.add(new Elements("Beer","Sör", R.drawable.sor));
        elements.add(new Elements("Thank you","Köszönöm"));


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
