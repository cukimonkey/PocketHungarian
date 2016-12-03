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
        elements.add(new Elements("Good morning","Jó napot", R.drawable.dialog02));
        elements.add(new Elements("Good evening","Jó estét", R.drawable.dialog02));
        elements.add(new Elements("Good night","Jó éjszakát", R.drawable.dialog02));
        elements.add(new Elements("How are you?","Hogy vagy?", R.drawable.dialog02));
        elements.add(new Elements("Fine, thank you","Köszönöm jól", R.drawable.dialog02));
        elements.add(new Elements("What's your name?","Hogy hívnak?", R.drawable.dialog02));
        elements.add(new Elements("My name is Edit.","Editnek hívnak", R.drawable.dialog02));
        elements.add(new Elements("Do you speak English?","Beszélsz angolul?", R.drawable.dialog02));
        elements.add(new Elements("Yes, a little bit","Igen, egy picit", R.drawable.dialog02));
        elements.add(new Elements("No, unfortunately I don't","Sajnos nem", R.drawable.dialog02));
        elements.add(new Elements("I don't understand","Nem értem", R.drawable.dialog02));
        elements.add(new Elements("What's this?","Mi ez?", R.drawable.dialog02));
        elements.add(new Elements("It's a dictionary","Ez egy szótár", R.drawable.dialog02));
        elements.add(new Elements("Where is the post office?","Merre van a posta?", R.drawable.dialog02));
        elements.add(new Elements("Can you help me please, I'm lost","Tudnál segíteni, eltévedtem", R.drawable.dialog02));
        elements.add(new Elements("Thank you!","Köszönöm", R.drawable.dialog02));
        elements.add(new Elements("You're welcome","Szivesen", R.drawable.dialog02));
        elements.add(new Elements("Is everything alright?","Minden rendben?", R.drawable.dialog02));
        elements.add(new Elements("What are you doing?","Mit csinálsz?", R.drawable.dialog02));
        elements.add(new Elements("Goodbye","Viszont látásra", R.drawable.dialog02));
        elements.add(new Elements("How is the weather today?","Milyen idő van ma?", R.drawable.dialog02));
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
