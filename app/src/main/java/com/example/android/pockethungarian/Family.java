package com.example.android.pockethungarian;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class Family extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);

//        Create an array list for the English, Hungrian translation, graphic images and audio
            final ArrayList<Elements> elements = new ArrayList<Elements>();
        elements.add(new Elements("mother","anya", R.drawable.anya));
        elements.add(new Elements("My mother is a strong woman","Az anyám egy erős nő"));
        elements.add(new Elements("father","apa", R.drawable.apa));
        elements.add(new Elements("My father is a great cook","Az apám egy nagyszerű szakács"));
        elements.add(new Elements("grandmother","nagymama", R.drawable.nagymama));
        elements.add(new Elements("Your grandmother loves reading","A nagymamád szeret olvasni"));
        elements.add(new Elements("grandfather","nagypapa", R.drawable.nagypapa));
        elements.add(new Elements("Your grandfather likes rock music","A nagypapád szereti a rock zenét"));
        elements.add(new Elements("boy","fiú", R.drawable.fiu));
        elements.add(new Elements("The boys are playing soccer","A fiúk fociznak"));
        elements.add(new Elements("girl","lány", R.drawable.lany));
        elements.add(new Elements("The girls are dancing","A lányok táncolnak"));
        elements.add(new Elements("my son","fiam", R.drawable.fiu));
        elements.add(new Elements("My son is a doctor","A fiam egy orvos"));
        elements.add(new Elements("my daughter","lányom ", R.drawable.lany));
        elements.add(new Elements("My daughter is a police officer","A lányom egy rendőr"));
        elements.add(new Elements("younger brother","öccs", R.drawable.ocsi));
        elements.add(new Elements("Your younger brother is sleepy","Az öcséd álmos"));
        elements.add(new Elements("younger sister","húg", R.drawable.hug));
        elements.add(new Elements("My younger sister is sleeping","A hugom alszik"));
        elements.add(new Elements("older brother","báty", R.drawable.baty));
        elements.add(new Elements("My brother always protects me","A bátyám mindig megvéd"));
        elements.add(new Elements("older sister","nővér", R.drawable.nover));
        elements.add(new Elements("Her sister speaks Spanish","A nővére beszél spanyolul"));
        elements.add(new Elements("cousin","unokatestvér", R.drawable.unoka));
        elements.add(new Elements("Your cousin is sick","Az unokatestvéred beteg"));
        elements.add(new Elements("uncle","nagybácsi\n", R.drawable.nagybacsi));
        elements.add(new Elements("My uncle needs to go to the doctor","A nagybátyámnak orvoshoz kell mennie"));
        elements.add(new Elements("aunt","nagynéni", R.drawable.nagyneni));
        elements.add(new Elements("Her aunt is a nurse","A nagynénje egy ápoló"));
        elements.add(new Elements("nephew","unokaöccs", R.drawable.fiu));
        elements.add(new Elements("My nephew is often cold","A unokaöcsém gyakran fázik"));
        elements.add(new Elements("niece","unokahúg", R.drawable.lany));
        elements.add(new Elements("Your niece laughs loudly","Az unokahugod hangosan nevet"));
        elements.add(new Elements("mother-in-law","anyós", R.drawable.nagymama));
        elements.add(new Elements("Mother-in-laws are kind.","Az anyósok kedvesek"));
        elements.add(new Elements("father-in-low","após", R.drawable.apa));
        elements.add(new Elements("My father-in-law helps a lot","Az apósom sokat segít"));
        elements.add(new Elements("sister-in-law","sógornő", R.drawable.sogorno));
        elements.add(new Elements("Her sister-in-law loves animals","A sogornője szeretni az állatokat"));
        elements.add(new Elements("brother-in-low","sógor", R.drawable.nagybacsi));
        elements.add(new Elements("His brother-in-law doesn't eat meat","A sógora nem eszik húst"));
        elements.add(new Elements("grandson/granddaughter","unoka", R.drawable.ocsi));
        elements.add(new Elements("My grangson is great","Az unokám nagyszerű"));


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
