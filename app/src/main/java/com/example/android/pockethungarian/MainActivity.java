package com.example.android.pockethungarian;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Find a View and set up an onClickListener for BasicConversation Activity
        TextView basics = (TextView) findViewById(R.id.basics);
        basics.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent basicIntent = new Intent(MainActivity.this,BasicConversation.class);
                startActivity(basicIntent);
                Toast.makeText(view.getContext(),"Basic Conversation",Toast.LENGTH_SHORT).show();
            }
        });

//        Find a View and set up an onClickListener for Family Activity
        TextView family = (TextView) findViewById(R.id.family);
        family.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent familyIntent = new Intent(MainActivity.this,Family.class);
                startActivity(familyIntent);
                Toast.makeText(view.getContext(),"Family",Toast.LENGTH_SHORT).show();
            }
        });

//        Find a View and set up an onClickListener for House Activity
        TextView house = (TextView) findViewById(R.id.around_the_house);
        house.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent houseIntent = new Intent(MainActivity.this,House.class);
                startActivity(houseIntent);
                Toast.makeText(view.getContext(),"Around the house",Toast.LENGTH_SHORT).show();
            }
        });

//        Find a View and set up an onClickListener for ColorsNumbers Activity
        TextView colors = (TextView) findViewById(R.id.colors_and_numbers);
        colors.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent colorsIntent = new Intent(MainActivity.this,ColorsNumbers.class);
                startActivity(colorsIntent);
                Toast.makeText(view.getContext(),"Colors and Numbers",Toast.LENGTH_SHORT).show();
            }
        });

//        Find a View and set up an onClickListener for Grocery Activity
        TextView grocery = (TextView) findViewById(R.id.grocery_and_shops);
        grocery.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent groceryIntent = new Intent(MainActivity.this,Grocery.class);
                startActivity(groceryIntent);
                Toast.makeText(view.getContext(),"Grocery and shops",Toast.LENGTH_SHORT).show();
            }
        });

//        Find a View and set up an onClickListener for EatingOut Activity
        TextView eatingOut = (TextView) findViewById(R.id.eating_out);
        eatingOut.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent eatingOutIntent = new Intent(MainActivity.this,EatingOut.class);
                startActivity(eatingOutIntent);
                Toast.makeText(view.getContext(),"Eating out",Toast.LENGTH_SHORT).show();
            }
        });

//        Find a View and set up an onClickListener for Accommodation Activity
        TextView accomodation = (TextView) findViewById(R.id.accomodation);
        accomodation.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent accomodationIntent = new Intent(MainActivity.this,Accommodation.class);
                startActivity(accomodationIntent);
                Toast.makeText(view.getContext(),"Accommodation",Toast.LENGTH_SHORT).show();
            }
        });

    }
}
