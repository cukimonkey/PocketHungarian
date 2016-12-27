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
    private MediaPlayer mediaPlayer;
    private AudioManager mAudioManager;

    AudioManager.OnAudioFocusChangeListener afChangeListener =
            new AudioManager.OnAudioFocusChangeListener() {

                public void onAudioFocusChange(int focusChange) {
                    if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                            focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK
                            ) {
                        mediaPlayer.pause();
                        mediaPlayer.seekTo(0);
                    } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                        mediaPlayer.start();
                    } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                        releaseMediaPlayer();
                    }
                }
            };

    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener(){
        @Override
        public void onCompletion(MediaPlayer mp) {
        }
    };


    private void releaseMediaPlayer() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
            mAudioManager.abandonAudioFocus(afChangeListener);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);
        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

//   Create an array list for the English, Hungarian translation, graphic images and audio
        final ArrayList<Elements> elements = new ArrayList<Elements>();
        elements.add(new Elements("Passport","Útlevél", R.drawable.utlevel, R.raw.utlevel));
        elements.add(new Elements("Where is your passport?","Hol van az útleveled?", R.raw.hol_utleveled));
        elements.add(new Elements("Airport","Reptér", R.drawable.repter, R.raw.repter));
        elements.add(new Elements("We'd like to go to the airport","A reptérre szeretnénk menni", R.raw.repterre_szeretnenk));
        elements.add(new Elements("Train","Vonat", R.drawable.vonat, R.raw.vonat));
        elements.add(new Elements("Underground","Metró - Földalatti", R.drawable.metro, R.raw.metro));
        elements.add(new Elements("Tram","Villamos", R.drawable.villamos, R.raw.villamos));
        elements.add(new Elements("Ticket","Jegy", R.drawable.jegy, R.raw.jegy));
        elements.add(new Elements("How much it the return ticket","Mennyibe kerül a retúr jegy?", R.raw.mennyibe_kerul_jegy));
        elements.add(new Elements("Hotel","Szálloda", R.drawable.hotel, R.raw.szalloda02));
        elements.add(new Elements("Where is the hotel?","Merre van a szálloda?", R.raw.merre_van_szalloda));
        elements.add(new Elements("Single room","Egyszemélyes szoba", R.drawable.single_room, R.raw.egyszemelyes_szoba));
        elements.add(new Elements("Do you have room service?","Van szobaszervíz?", R.raw.van_szobaszerviz));
        elements.add(new Elements("The room is on the ground floor","A szoba a földszinten van", R.raw.szoba_foldszinten));
        elements.add(new Elements("Reception","Recepció", R.drawable.recepcio, R.raw.recepcio));
        elements.add(new Elements("Let's meet at the reception!","Találkozzunk a recepciónál!", R.raw.talalkozzunk_rec));
        elements.add(new Elements("Do you have vacancy?","Van szabad szobájuk?", R.raw.van_szabad_szoba));
        elements.add(new Elements("Sorry, we are fully booked","Sajnálom, tele vagyunk", R.raw.sajnalom_telev));
        elements.add(new Elements("Is there a bank nearby?","Van bank a közelben?", R.raw.van_bank_kozel));
        elements.add(new Elements("We'd like to check out","Kijelentkeznénk", R.raw.kijelentkeznenk));
        elements.add(new Elements("Can you call a cab for us?","Rendelne egy taxit nekünk?", R.raw.rendelne_taxit));

// Create a {WordAdapter}, whose data source is a list of {Elements}s.
        WordAdapter adapter = new WordAdapter(this, elements);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Elements newElements = elements.get(position);
                releaseMediaPlayer();
                int result = mAudioManager.requestAudioFocus(afChangeListener,
                        // Use the music stream.
                        AudioManager.STREAM_MUSIC,
                        // Request permanent focus.
                        AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    Toast.makeText(Accommodation.this, "Play", Toast.LENGTH_SHORT).show();
                    mediaPlayer = MediaPlayer.create(Accommodation.this,newElements.getmAudioResourceId());
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(mCompletionListener);
                }
            }
        });
    }
    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }
}

