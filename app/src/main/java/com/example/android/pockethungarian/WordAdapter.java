package com.example.android.pockethungarian;

import android.content.Context;
import android.media.MediaPlayer;
import android.provider.UserDictionary;
import android.support.v4.content.ContextCompat;
import android.text.InputType;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Orsi on 01/12/2016.
 */

public class WordAdapter extends ArrayAdapter {
    private int mColorId;
    public WordAdapter(Context context, List<Elements> objects) {
        super(context, 0, objects);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.view_element, parent, false);
        }

        Elements local_word = (Elements) getItem(position);


        ImageView imageView = (ImageView) listItemView.findViewById(R.id.icon_image_view);

        if (local_word.hasImage()) {
            imageView.setImageResource(local_word.getmImageId());
            imageView.setVisibility(View.VISIBLE);
            View layout = listItemView.findViewById(R.id.text_and_icon);
            int color = ContextCompat.getColor(getContext(),R.color.block_background);
            layout.setBackgroundColor(color);


        } else {
            imageView.setVisibility(View.GONE);
            View layout = listItemView.findViewById(R.id.text_and_icon);
            int color = ContextCompat.getColor(getContext(),R.color.text_background);
            layout.setBackgroundColor(color);


        }

        TextView englishTextView = (TextView) listItemView.findViewById(R.id.eng_text_views);
        englishTextView.setText(local_word.getEnglishTranslation());
        TextView hungarianTexView = (TextView) listItemView.findViewById(R.id.hun_text_views);
        hungarianTexView.setText(local_word.getmHungarianTranslation());

        return listItemView;
    }

}