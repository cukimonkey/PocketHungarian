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

public class House extends AppCompatActivity {
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
        elements.add(new Elements("living room","nappali", R.drawable.nappali, R.raw.nappali));
        elements.add(new Elements("The lights are on in the living room","A nappaliban ég a villany", R.raw.nappaliban_villany2));
        elements.add(new Elements("kitchen","konyha", R.drawable.kitchen, R.raw.konyha));
        elements.add(new Elements("Our kitchen is always tidy","A konyhánk mindig rendes", R.raw.konyhank_mindig));
        elements.add(new Elements("bedroom","háló - hálószoba", R.drawable.halo, R.raw.halo));
        elements.add(new Elements("Someone is sleeping in the bedroom","Valaki alszik a hálóban", R.raw.valaki_alszik));
        elements.add(new Elements("bathroom","fürdőszoba", R.drawable.furdo, R.raw.furdo));
        elements.add(new Elements("The bathroom is upstairs","A fürdőszoba az emeleten van", R.raw.furdo_emeleten));
        elements.add(new Elements("hall","előszoba", R.drawable.eloszoba, R.raw.eloszoba));
        elements.add(new Elements("It's dark in the hall","Sötét van az előszobában", R.raw.sotet_van_eloszoba));
        elements.add(new Elements("stairs","lépcsőház", R.drawable.lepcso, R.raw.lepcsohaz));
        elements.add(new Elements("The stairs are narrow","A lépcsőház keskeny", R.raw.lepcsohaz_keskeny));
        elements.add(new Elements("garage","garázs", R.drawable.garazs, R.raw.garazs));
        elements.add(new Elements("There's a car parked in the garage","Egy autó parkol a garázsban", R.raw.egy_auto_parkol));
        elements.add(new Elements("garden","kert", R.drawable.kert, R.raw.kert));
        elements.add(new Elements("We're relaxing in the garden","A kertben pihenünk", R.raw.kertben_pihenunnk));
        elements.add(new Elements("door","ajtó", R.drawable.ajto, R.raw.ajto));
        elements.add(new Elements("Someone's at the door","Van valaki az ajtónál", R.raw.van_valaki_ajto));
        elements.add(new Elements("window","ablak", R.drawable.ablak, R.raw.ablak));
        elements.add(new Elements("May I open the window?","Kinyithatnám az ablakot?", R.raw.kinyithatnam_ablakot));
        elements.add(new Elements("bed","ágy", R.drawable.agy, R.raw.agy));
        elements.add(new Elements("This is a double bed","Ez egy dupla ágy", R.raw.ez_egy_duplaagy));
        elements.add(new Elements("table","asztal", R.drawable.asztal, R.raw.asztal));
        elements.add(new Elements("The table is in the corner","Az asztal a sarokban van", R.raw.asztal_sarokban));
        elements.add(new Elements("chair","szék", R.drawable.szek, R.raw.szek));
        elements.add(new Elements("The chair is broken","A szék törött", R.raw.szek_torott));
        elements.add(new Elements("cupboard","szekrény", R.drawable.szekreny, R.raw.szekreny));
        elements.add(new Elements("The cupboard is empty","A szekrény üres", R.raw.szekreny_ures));
        elements.add(new Elements("sofa","kanapé", R.drawable.kanape, R.raw.kanape));
        elements.add(new Elements("This sofa is comfortable","Ez a kanapé kényelmes", R.raw.kanape_kenyelmes));



//   Create an {WordAdapter}, whose data source is a list of {Elements}s.
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
                    mediaPlayer = MediaPlayer.create(House.this,newElements.getmAudioResourceId());
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
