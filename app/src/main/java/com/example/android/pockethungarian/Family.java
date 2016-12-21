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

public class Family extends AppCompatActivity {
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
        elements.add(new Elements("mother","anya", R.drawable.anya, R.raw.anya));
        elements.add(new Elements("My mother is a strong woman","Az anyám egy erős nő", R.raw.anyam_eros));
        elements.add(new Elements("father","apa", R.drawable.apa, R.raw.apa));
        elements.add(new Elements("My father is a great cook","Az apám egy nagyszerű szakács", R.raw.apam_szakacs));
        elements.add(new Elements("grandmother","nagymama", R.drawable.nagymama, R.raw.nagymama));
        elements.add(new Elements("Your grandmother loves reading","A nagymamád szeret olvasni", R.raw.nagymamad_szeret));
        elements.add(new Elements("grandfather","nagypapa", R.drawable.nagypapa, R.raw.nagypapa));
        elements.add(new Elements("Your grandfather likes rock music","A nagypapád szereti a rock zenét", R.raw.nagypapad_szereti));
        elements.add(new Elements("boy","fiú", R.drawable.fiu, R.raw.fiu));
        elements.add(new Elements("The boys are playing soccer","A fiúk fociznak", R.raw.fiuk_fociznak));
        elements.add(new Elements("girl","lány", R.drawable.lany, R.raw.lany));
        elements.add(new Elements("The girls are dancing","A lányok táncolnak", R.raw.lanyok_tancolnak));
        elements.add(new Elements("my son","fiam", R.drawable.fiu, R.raw.fiam));
        elements.add(new Elements("My son is a doctor","A fiam egy orvos", R.raw.fiam_orvos));
        elements.add(new Elements("my daughter","lányom ", R.drawable.lany, R.raw.lanyom));
        elements.add(new Elements("My daughter is a police officer","A lányom egy rendőr", R.raw.lanyom_rendor));
        elements.add(new Elements("younger brother","öccs", R.drawable.ocsi, R.raw.occs));
        elements.add(new Elements("Your younger brother is sleepy","Az öcséd álmos", R.raw.ocsed_almos));
        elements.add(new Elements("younger sister","húg", R.drawable.hug, R.raw.hug));
        elements.add(new Elements("My younger sister is sleeping","A hugom alszik", R.raw.hugom_alszik));
        elements.add(new Elements("older brother","báty", R.drawable.baty, R.raw.baty));
        elements.add(new Elements("My brother always protects me","A bátyám mindig megvéd", R.raw.batyam_megved));
        elements.add(new Elements("older sister","nővér", R.drawable.nover, R.raw.nover));
        elements.add(new Elements("Her sister speaks Spanish","A nővére beszél spanyolul", R.raw.novere_spanyolul));
        elements.add(new Elements("cousin","unokatestvér", R.drawable.unoka, R.raw.unokatestver));
        elements.add(new Elements("Your cousin is sick","Az unokatestvéred beteg", R.raw.unokatestvered_beteg));
        elements.add(new Elements("uncle","nagybácsi\n", R.drawable.nagybacsi, R.raw.nagybacsi));
        elements.add(new Elements("My uncle needs to go to the doctor","A nagybátyámnak orvoshoz kell mennie", R.raw.nagybatyamnak_orvoshoz));
        elements.add(new Elements("aunt","nagynéni", R.drawable.nagyneni, R.raw.nagyneni));
        elements.add(new Elements("Her aunt is a nurse","A nagynénje egy ápoló", R.raw.nagyneni_apolo));
        elements.add(new Elements("nephew","unokaöccs", R.drawable.fiu, R.raw.unokaoccs));
        elements.add(new Elements("My nephew is often cold","A unokaöcsém gyakran fázik", R.raw.unokaocsem_fazik));
        elements.add(new Elements("niece","unokahúg", R.drawable.lany, R.raw.unokahug));
        elements.add(new Elements("Your niece laughs loudly","Az unokahugod hangosan nevet", R.raw.unokahugod_nevet));
        elements.add(new Elements("mother-in-law","anyós", R.drawable.nagymama, R.raw.anyos));
        elements.add(new Elements("Mother-in-laws are kind.","Az anyósok kedvesek", R.raw.anyosok_kedvesek));
        elements.add(new Elements("father-in-low","após", R.drawable.apa, R.raw.apos));
        elements.add(new Elements("My father-in-law helps a lot","Az apósom sokat segít", R.raw.aposom_segit));
        elements.add(new Elements("sister-in-law","sógornő", R.drawable.sogorno, R.raw.sogorno));
        elements.add(new Elements("Her sister-in-law loves animals","A sogornője szeretni az állatokat", R.raw.sogornoe_szereti));
        elements.add(new Elements("brother-in-low","sógor", R.drawable.nagybacsi, R.raw.sogor));
        elements.add(new Elements("His brother-in-law doesn't eat meat","A sógora nem eszik húst", R.raw.sogor_nemeszik));
        elements.add(new Elements("grandson/granddaughter","unoka", R.drawable.ocsi, R.raw.unoka));
        elements.add(new Elements("My grangson is great","Az unokám nagyszerű", R.raw.unokam_nagyszeru));


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
                    mediaPlayer = MediaPlayer.create(Family.this,newElements.getmAudioResourceId());
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
