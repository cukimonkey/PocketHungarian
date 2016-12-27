package com.example.android.pockethungarian;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ColorsNumbers extends AppCompatActivity {
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

//  Create an array list for the English, Hungarian translation, graphic images and audio
        final ArrayList<Elements> elements = new ArrayList<Elements>();
        elements.add(new Elements("One","Egy", R.drawable.egy, R.raw.egy));
        elements.add(new Elements("Two","Kettő", R.drawable.ketto, R.raw.ketto));
        elements.add(new Elements("Tree","Három", R.drawable.harom, R.raw.harom));
        elements.add(new Elements("Four","Négy", R.drawable.negy, R.raw.negy));
        elements.add(new Elements("Five","Öt", R.drawable.ot, R.raw.ot));
        elements.add(new Elements("Six","Hat", R.drawable.hat, R.raw.hat));
        elements.add(new Elements("Seven","Hét", R.drawable.het, R.raw.het));
        elements.add(new Elements("Eight","Nyolc", R.drawable.nyolc, R.raw.nyolc));
        elements.add(new Elements("Nine","Kilenc", R.drawable.kilenc, R.raw.kilenc));
        elements.add(new Elements("Ten","Tíz", R.drawable.tiz, R.raw.tiz));
        elements.add(new Elements("Eleven","Tizenegy", R.drawable.tizenegy, R.raw.tizenegy));
        elements.add(new Elements("Twelve","Tizenkettő", R.drawable.tizenketto, R.raw.tizenketto));
        elements.add(new Elements("Thirteen","Tizenhárom", R.drawable.tienharom, R.raw.tizenharom));
        elements.add(new Elements("Fourteen","Tizennégy", R.drawable.tizennnegy, R.raw.tizennegy));
        elements.add(new Elements("Fifteen","Tizenöt", R.drawable.tizenot, R.raw.tizenot));
        elements.add(new Elements("Sixteen","Tizenhat", R.drawable.tizenhat, R.raw.tizenhat));
        elements.add(new Elements("Seventeen","Tizenhét", R.drawable.tizenhet, R.raw.tizenhet));
        elements.add(new Elements("Eighteen","Tizennyolc", R.drawable.tizennyolc, R.raw.tizennyolc));
        elements.add(new Elements("Nineteen","Tizenkilenc", R.drawable.tizenkilenc, R.raw.tizenkilenc));
        elements.add(new Elements("Twenty","Húsz", R.drawable.husz, R.raw.husz));
        elements.add(new Elements("Thirty","Harminc", R.drawable.harminc, R.raw.harminc));
        elements.add(new Elements("Forty","Negyven", R.drawable.negyven, R.raw.negyven));
        elements.add(new Elements("Fifty","Ötven", R.drawable.otven, R.raw.otven));
        elements.add(new Elements("Sixty","Hatvan", R.drawable.hatvan, R.raw.hatvan));
        elements.add(new Elements("Seventy","Hetven", R.drawable.hetven, R.raw.hetven));
        elements.add(new Elements("Eighty","Nyolcvan", R.drawable.nyolcvan, R.raw.nyolcvan));
        elements.add(new Elements("Ninety","Kilencven", R.drawable.kilencven, R.raw.kilencven));
        elements.add(new Elements("Hundred","Száz", R.drawable.szaz, R.raw.szaz));
        elements.add(new Elements("Black","Fekete", R.drawable.black, R.raw.fekete));
        elements.add(new Elements("White","Fehér", R.drawable.feher, R.raw.feher));
        elements.add(new Elements("Green","Zöld", R.drawable.zold, R.raw.zold));
        elements.add(new Elements("Yellow","Sárga", R.drawable.sarga, R.raw.sarga));
        elements.add(new Elements("Red","Piros / Vörös", R.drawable.piros, R.raw.piros2));
        elements.add(new Elements("Blue","Kék", R.drawable.kek, R.raw.kek));
        elements.add(new Elements("Orange","Narancssárga", R.drawable.naracssarga, R.raw.naracssarga));
        elements.add(new Elements("Brown","Barna", R.drawable.brown, R.raw.barna));
        elements.add(new Elements("Grey","Szürke", R.drawable.grey, R.raw.szurke));
        elements.add(new Elements("Purple","Lila", R.drawable.purple, R.raw.lila3));
        elements.add(new Elements("Pink","Rózsaszín", R.drawable.rozsaszin, R.raw.rozsaszin));
        elements.add(new Elements("Light","Világos", R.raw.vilagos));
        elements.add(new Elements("Light-Blue","Világoskék", R.drawable.light_blue, R.raw.vilagoskek));
        elements.add(new Elements("Dark","Sötét", R.raw.sotet));
        elements.add(new Elements("Dark-Green","Sötétzöld", R.drawable.dark_green, R.raw.sotetzold));

        // Create an {WordAdapter}, whose data source is a list of {Elements}s.

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
                    mediaPlayer = MediaPlayer.create(ColorsNumbers.this,newElements.getmAudioResourceId());
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

