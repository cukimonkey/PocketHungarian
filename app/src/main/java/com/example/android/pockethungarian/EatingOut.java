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

public class EatingOut extends AppCompatActivity {
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

//  Create an array list for the English, Hungrian translation, graphic images and audio
        final ArrayList<Elements> elements = new ArrayList<Elements>();
        elements.add(new Elements("Let's go to a restaurant!","Menjünk egy étterembe!", R.raw.menjunk_etterembe));
        elements.add(new Elements("I'm hungry","Éhes vagyok", R.raw.ehes_vagyok));
        elements.add(new Elements("Can you recommend a good café?","Ajánlanál egy jó kávézót?", R.raw.ajanlanal_kavezot));
        elements.add(new Elements("Can I have a glass of water","Kaphatnék egy pohár vizet?", R.raw.kaphatnek_pohar));
        elements.add(new Elements("Wine","Bor", R.drawable.bor, R.raw.bor));
        elements.add(new Elements("Do you like red wine?","Szereted a vörösbort?", R.raw.szereted_vorosbort));
        elements.add(new Elements("Beer","Sör", R.drawable.sor, R.raw.sor));
        elements.add(new Elements("Do you have beer on tap?","Van csapoltsör?", R.raw.van_csapolt_sor));
        elements.add(new Elements("Entrée","Előétel", R.drawable.eloetel2, R.raw.eloetel));
        elements.add(new Elements("The entree was a big portion","Az előétel nagy adag volt.", R.raw.eloetel_nagy));
        elements.add(new Elements("Soup","Leves", R.drawable.leves, R.raw.leves));
        elements.add(new Elements("This soup is a little bit spicy","Ez a leves kicsit csípős.", R.raw.leves_csipos));
        elements.add(new Elements("Main course","Főétel", R.drawable.foetel, R.raw.foetel));
        elements.add(new Elements("The main course is very filling","A főétel nagyon laktató", R.raw.foetel_laktato));
        elements.add(new Elements("Dessert","Desszert", R.drawable.desszert, R.raw.desszert));
        elements.add(new Elements("I ordered pancake for dessert","Palacsintát rendeltem desszertnek", R.raw.palacsintat_rendeltem));
        elements.add(new Elements("Excuse me, I'd like to order","Elnézést, rendelni szeretnék", R.raw.elnezest_rendelni));
        elements.add(new Elements("I'd like to taste the goulash soup","Megkóstolnám a gulyáslevest", R.raw.megkostolnam_gulyaslevest));
        elements.add(new Elements("It was very delicious","Nagyon finom volt", R.raw.nagyon_finom));
        elements.add(new Elements("Thank you","Köszönöm", R.raw.koszonom));

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
                    mediaPlayer = MediaPlayer.create(EatingOut.this,newElements.getmAudioResourceId());
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