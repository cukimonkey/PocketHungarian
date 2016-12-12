package com.example.android.pockethungarian;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class Grocery extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);

//        Create an array list for the English, Hungrian translation, graphic images and audio
        final ArrayList<Elements> elements = new ArrayList<Elements>();
        elements.add(new Elements("Grocery Shop","Közért", R.drawable.kozert));
        elements.add(new Elements("Market","Piac", R.drawable.piac));
        elements.add(new Elements("Butcher","Hentes", R.drawable.hentes));
        elements.add(new Elements("Bakery","Pékség", R.drawable.pekseg));
        elements.add(new Elements("Green Grocer","Zöldséges", R.drawable.zoldseges));
        elements.add(new Elements("Icecream Shop","Fagyizó", R.drawable.fagyizo));
        elements.add(new Elements("Confectionery","Cukrászda", R.drawable.cukraszda));
        elements.add(new Elements("Pharmacy","Gyógyszertár", R.drawable.gyogyszertar));
        elements.add(new Elements("How much is it?","Mennyibe kerül?"));
        elements.add(new Elements("Can I pay with card?","Fizethetek kártyával?"));
        elements.add(new Elements("Bread","Kenyér", R.drawable.kenyer));
        elements.add(new Elements("Milk","Tej", R.drawable.tej));
        elements.add(new Elements("Cheese","Sajt", R.drawable.sajt));
        elements.add(new Elements("Pasta","Tészta", R.drawable.teszta));
        elements.add(new Elements("Sugar","Cukor", R.drawable.cukor));
        elements.add(new Elements("Flour","Liszt", R.drawable.liszt));
        elements.add(new Elements("Biscuit","Keksz", R.drawable.keksz));
        elements.add(new Elements("Cold Cut","Felvágott", R.drawable.felvagott));
        elements.add(new Elements("Chicken","Csirke", R.drawable.csirke));
        elements.add(new Elements("Pork","Sertés", R.drawable.sertes));
        elements.add(new Elements("Beef","Marha", R.drawable.marha));
        elements.add(new Elements("Fish","Hal", R.drawable.hal));
        elements.add(new Elements("Fruit","Gyümölcs", R.drawable.gyumolcs));
        elements.add(new Elements("Vegetable","Zöldség", R.drawable.zoldseg));
        elements.add(new Elements("Apple","Alma", R.drawable.alma));
        elements.add(new Elements("Pear","Körte", R.drawable.korte));
        elements.add(new Elements("Peach","Barack", R.drawable.barack));
        elements.add(new Elements("Banana","Banán", R.drawable.banan));
        elements.add(new Elements("Orange","Narancs", R.drawable.narancs));
        elements.add(new Elements("Carrot","Répa", R.drawable.repa));
        elements.add(new Elements("Cucumber","Uborka", R.drawable.uborka));
        elements.add(new Elements("Tomato","Paradicsom", R.drawable.paradicsom));
        elements.add(new Elements("Lettuce","Saláta", R.drawable.salata));
        elements.add(new Elements("Beetroot","Cékla", R.drawable.cekla));
        elements.add(new Elements("Paprika","Paprika", R.drawable.paprika));
        elements.add(new Elements("Radish","Retek", R.drawable.retek));








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
