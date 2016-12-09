package com.example.android.pockethungarian;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Accommodation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);

//        Create an array list for the English, Hungrian translation, graphic images and audio
        final ArrayList<Elements> elements = new ArrayList<Elements>();
        elements.add(new Elements("Passport","Útlevél", R.drawable.utlevel));
        elements.add(new Elements("Where is your passport?","Hol van az útleveled?"));
        elements.add(new Elements("Airport","Reptér", R.drawable.repter));
        elements.add(new Elements("We'd like to go to the airport","A reptérre szeretnénk menni"));
        elements.add(new Elements("Train","Vonat", R.drawable.vonat));
        elements.add(new Elements("Underground","Metró - Földalatti", R.drawable.metro));
        elements.add(new Elements("Tram","Villamos", R.drawable.villamos));
        elements.add(new Elements("Ticket","Jegy", R.drawable.jegy));
        elements.add(new Elements("How much it the return ticket","Mennyibe kerül a retúr jegy?"));
        elements.add(new Elements("Hotel","Szálloda", R.drawable.hotel));
        elements.add(new Elements("Where is the hotel?","Merre van a szálloda?"));
        elements.add(new Elements("Single room","Egyszemélyes szoba", R.drawable.single_room));
        elements.add(new Elements("Do you have room service?","Van szobaszervíz?"));
        elements.add(new Elements("The room is on the ground floor","A szoba a földszinten van"));
        elements.add(new Elements("Reception","Recepció", R.drawable.recepcio));
        elements.add(new Elements("Let's meet at the reception!","Találkozzunk a recepciónál!"));
        elements.add(new Elements("Do you have vacancy?","Van szabad szobájuk?"));
        elements.add(new Elements("Sorry, we are fully booked","Sajnálom, tele vagyunk"));
        elements.add(new Elements("Is there a bank nearby?","Van bank a közelben?"));
        elements.add(new Elements("We'd like to check out","Kijelentkeznénk"));
        elements.add(new Elements("Can you call a cab for us?","Rendelne egy taxit nekünk?"));





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
