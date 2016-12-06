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

public class BasicConversation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);

//        Create an array list for the English, Hungrian translation, graphic images and audio
        final ArrayList<Elements> elements = new ArrayList<Elements>();
        elements.add(new Elements("Good morning","Jó napot"));
        elements.add(new Elements("Good evening","Jó estét"));
        elements.add(new Elements("Good night","Jó éjszakát"));
        elements.add(new Elements("How are you?","Hogy vagy?"));
        elements.add(new Elements("Fine, thank you","Köszönöm jól"));
        elements.add(new Elements("What's your name?","Hogy hívnak?"));
        elements.add(new Elements("My name is Edit.","Editnek hívnak"));
        elements.add(new Elements("Do you speak English?","Beszélsz angolul?"));
        elements.add(new Elements("Yes, a little bit","Igen, egy picit"));
        elements.add(new Elements("No, unfortunately I don't","Sajnos nem"));
        elements.add(new Elements("I don't understand","Nem értem"));
        elements.add(new Elements("What's this?","Mi ez?"));
        elements.add(new Elements("It's a dictionary","Ez egy szótár"));
        elements.add(new Elements("Where is the post office?","Merre van a posta?"));
        elements.add(new Elements("Can you help me please, I'm lost","Tudnál segíteni, eltévedtem"));
        elements.add(new Elements("Thank you!","Köszönöm"));
        elements.add(new Elements("You're welcome","Szivesen"));
        elements.add(new Elements("Is everything alright?","Minden rendben?"));
        elements.add(new Elements("What are you doing?","Mit csinálsz?"));
        elements.add(new Elements("Goodbye","Viszont látásra"));
        elements.add(new Elements("How is the weather today?","Milyen idő van ma?"));
        elements.add(new Elements("It's raining","Esik az eső", R.drawable.raining));
        elements.add(new Elements("The sun is shining","Süt a nap", R.drawable.sunny));
        elements.add(new Elements("It's snowing","Esik a hó", R.drawable.snowing));
        elements.add(new Elements("It's foggy","Köd van", R.drawable.foggy));

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
