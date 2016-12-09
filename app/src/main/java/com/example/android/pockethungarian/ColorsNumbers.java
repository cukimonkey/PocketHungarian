package com.example.android.pockethungarian;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsNumbers extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);

//        Create an array list for the English, Hungrian translation, graphic images and audio
        final ArrayList<Elements> elements = new ArrayList<Elements>();
        elements.add(new Elements("One","Egy", R.drawable.egy));
        elements.add(new Elements("Two","Kettő", R.drawable.ketto));
        elements.add(new Elements("Tree","Három", R.drawable.harom));
        elements.add(new Elements("Four","Négy", R.drawable.negy));
        elements.add(new Elements("Five","Öt", R.drawable.ot));
        elements.add(new Elements("Six","Hat", R.drawable.hat));
        elements.add(new Elements("Seven","Hét", R.drawable.het));
        elements.add(new Elements("Eight","Nyolc", R.drawable.nyolc));
        elements.add(new Elements("Nine","Kilenc", R.drawable.kilenc));
        elements.add(new Elements("Ten","Tíz", R.drawable.tiz));
        elements.add(new Elements("Eleven","Tizenegy", R.drawable.tizenegy));
        elements.add(new Elements("Twelve","Tizenkettő", R.drawable.tizenketto));
        elements.add(new Elements("Thirteen","Tizenhárom", R.drawable.tienharom));
        elements.add(new Elements("Fourteen","Tizennégy", R.drawable.tizennnegy));
        elements.add(new Elements("Fifteen","Tizenöt", R.drawable.tizenot));
        elements.add(new Elements("Sixteen","Tizenhat", R.drawable.tizenhat));
        elements.add(new Elements("Seventeen","Tizenhét", R.drawable.tizenhet));
        elements.add(new Elements("Eighteen","Tizennyolc", R.drawable.tizennyolc));
        elements.add(new Elements("Nineteen","Tizenkilenc", R.drawable.tizenkilenc));
        elements.add(new Elements("Twenty","Húsz", R.drawable.husz));
        elements.add(new Elements("Thirty","Harminc", R.drawable.harminc));
        elements.add(new Elements("Forty","Negyven", R.drawable.negyven));
        elements.add(new Elements("Fifty","Ötven", R.drawable.otven));
        elements.add(new Elements("Sixty","Hatvan", R.drawable.hatvan));
        elements.add(new Elements("Seventy","Hetven", R.drawable.hetven));
        elements.add(new Elements("Eighty","Nyolcvan", R.drawable.nyolcvan));
        elements.add(new Elements("Ninety","Kilencven", R.drawable.kilencven));
        elements.add(new Elements("Hundred","Száz", R.drawable.szaz));
        elements.add(new Elements("Black","Fekete", R.drawable.black));
        elements.add(new Elements("White","Fehér", R.drawable.feher));
        elements.add(new Elements("Green","Zöld", R.drawable.zold));
        elements.add(new Elements("Yellow","Sárga", R.drawable.sarga));
        elements.add(new Elements("Red","Piros / Vörös", R.drawable.piros));
        elements.add(new Elements("Blue","Kék", R.drawable.kek));
        elements.add(new Elements("Orange","Narancssárga", R.drawable.naracssarga));
        elements.add(new Elements("Brown","Barna", R.drawable.brown));
        elements.add(new Elements("Grey","Szürke", R.drawable.grey));
        elements.add(new Elements("Purple","Lila", R.drawable.purple));
        elements.add(new Elements("Pink","Rózsaszín", R.drawable.rozsaszin));
        elements.add(new Elements("Light","Világos"));
        elements.add(new Elements("Light-Blue","Világoskék", R.drawable.light_blue));
        elements.add(new Elements("Dark","Sötét"));
        elements.add(new Elements("Dark-Green","Sötétzöld", R.drawable.dark_green));




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
