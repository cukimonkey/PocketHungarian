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

public class Grocery extends AppCompatActivity {
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
        elements.add(new Elements("Grocery Shop","Közért", R.drawable.kozert, R.raw.kozert));
        elements.add(new Elements("Market","Piac", R.drawable.piac, R.raw.piac));
        elements.add(new Elements("Butcher","Hentes", R.drawable.hentes, R.raw.hentes));
        elements.add(new Elements("Bakery","Pékség", R.drawable.pekseg, R.raw.pekseg));
        elements.add(new Elements("Green Grocer","Zöldséges", R.drawable.zoldseges, R.raw.zoldseges));
        elements.add(new Elements("Icecream Shop","Fagyizó", R.drawable.fagyizo, R.raw.fagyizo));
        elements.add(new Elements("Confectionery","Cukrászda", R.drawable.cukraszda, R.raw.cukraszda));
        elements.add(new Elements("Pharmacy","Gyógyszertár", R.drawable.gyogyszertar, R.raw.gyogyszertar));
        elements.add(new Elements("How much is it?","Mennyibe kerül?", R.raw.mennyibe_kerul));
        elements.add(new Elements("Can I pay with card?","Fizethetek kártyával?", R.raw.fizethetek_kartyaval));
        elements.add(new Elements("Bread","Kenyér", R.drawable.kenyer, R.raw.kenyer));
        elements.add(new Elements("Milk","Tej", R.drawable.tej, R.raw.tej));
        elements.add(new Elements("Cheese","Sajt", R.drawable.sajt, R.raw.sajt));
        elements.add(new Elements("Pasta","Tészta", R.drawable.teszta, R.raw.teszta));
        elements.add(new Elements("Sugar","Cukor", R.drawable.cukor, R.raw.cukor));
        elements.add(new Elements("Flour","Liszt", R.drawable.liszt, R.raw.liszt));
        elements.add(new Elements("Biscuit","Keksz", R.drawable.keksz, R.raw.keksz));
        elements.add(new Elements("Cold Cut","Felvágott", R.drawable.felvagott, R.raw.felvagott));
        elements.add(new Elements("Chicken","Csirke", R.drawable.csirke, R.raw.csirke));
        elements.add(new Elements("Pork","Sertés", R.drawable.sertes, R.raw.sertes));
        elements.add(new Elements("Beef","Marha", R.drawable.marha, R.raw.marha));
        elements.add(new Elements("Fish","Hal", R.drawable.hal, R.raw.hal));
        elements.add(new Elements("Fruit","Gyümölcs", R.drawable.gyumolcs, R.raw.gyumolcs));
        elements.add(new Elements("Vegetable","Zöldség", R.drawable.zoldseg, R.raw.zoldseg));
        elements.add(new Elements("Apple","Alma", R.drawable.alma, R.raw.alma));
        elements.add(new Elements("Pear","Körte", R.drawable.korte, R.raw.korte));
        elements.add(new Elements("Peach","Barack", R.drawable.barack, R.raw.barack));
        elements.add(new Elements("Banana","Banán", R.drawable.banan, R.raw.banan));
        elements.add(new Elements("Orange","Narancs", R.drawable.narancs, R.raw.narancs));
        elements.add(new Elements("Carrot","Répa", R.drawable.repa, R.raw.repa));
        elements.add(new Elements("Cucumber","Uborka", R.drawable.uborka, R.raw.uborka));
        elements.add(new Elements("Tomato","Paradicsom", R.drawable.paradicsom, R.raw.paradicsom));
        elements.add(new Elements("Lettuce","Saláta", R.drawable.salata, R.raw.salata));
        elements.add(new Elements("Beetroot","Cékla", R.drawable.cekla, R.raw.cekla));
        elements.add(new Elements("Paprika","Paprika", R.drawable.paprika, R.raw.paprika));
        elements.add(new Elements("Radish","Retek", R.drawable.retek, R.raw.retek));

//  Create an {@link WordAdapter}, whose data source is a list of {@link Elements}s.
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
                    mediaPlayer = MediaPlayer.create(Grocery.this,newElements.getmAudioResourceId());
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
