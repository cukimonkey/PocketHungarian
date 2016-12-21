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
        elements.add(new Elements("Good morning","Jó napot", R.raw.jo_napot));
        elements.add(new Elements("Good evening","Jó estét", R.raw.jo_estet));
        elements.add(new Elements("Good night","Jó éjszakát", R.raw.jo_ejszakat));
        elements.add(new Elements("How are you?","Hogy vagy?", R.raw.hogy_vagy));
        elements.add(new Elements("Fine, thank you","Köszönöm jól", R.raw.koszonom_jol));
        elements.add(new Elements("What's your name?","Hogy hívnak?", R.raw.hogy_hivnak));
        elements.add(new Elements("My name is Edit.","Editnek hívnak", R.raw.editnek_hivnak));
        elements.add(new Elements("Do you speak English?","Beszélsz angolul?", R.raw.beszelsz_angolul));
        elements.add(new Elements("Yes, a little bit","Igen, egy picit", R.raw.igen_egy_picit));
        elements.add(new Elements("No, unfortunately I don't","Sajnos nem", R.raw.sajnos_nem));
        elements.add(new Elements("I don't understand","Nem értem", R.raw.nem_ertem));
        elements.add(new Elements("What's this?","Mi ez?", R.raw.mi_ez));
        elements.add(new Elements("It's a dictionary","Ez egy szótár", R.raw.ez_egy_szotar));
        elements.add(new Elements("Where is the post office?","Merre van a posta?", R.raw.merre_posta));
        elements.add(new Elements("Can you help me please, I'm lost","Tudnál segíteni, eltévedtem", R.raw.eltevedtem));
        elements.add(new Elements("Thank you!","Köszönöm", R.raw.koszonom));
        elements.add(new Elements("You're welcome","Szivesen", R.raw.szivesen));
        elements.add(new Elements("Is everything alright?","Minden rendben?", R.raw.minden_rendben));
        elements.add(new Elements("What are you doing?","Mit csinálsz?", R.raw.mit_csinalsz2));
        elements.add(new Elements("Goodbye","Viszont látásra", R.raw.viszont_latasra));
        elements.add(new Elements("How is the weather today?","Milyen idő van ma?", R.raw.milyen_ido));
        elements.add(new Elements("It's raining","Esik az eső", R.drawable.raining, R.raw.esik));
        elements.add(new Elements("The sun is shining","Süt a nap", R.drawable.sunny, R.raw.sut_nap));
        elements.add(new Elements("It's snowing","Esik a hó", R.drawable.snowing, R.raw.esik_ho));
        elements.add(new Elements("It's foggy","Köd van", R.drawable.foggy, R.raw.kod_van));

//  Create an {WordAdapter}, whose data source is a list of {Elements}s.
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
                    mediaPlayer = MediaPlayer.create(BasicConversation.this,newElements.getmAudioResourceId());
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
