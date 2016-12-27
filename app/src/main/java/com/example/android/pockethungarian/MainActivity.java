package com.example.android.pockethungarian;

import android.support.v7.app.AppCompatActivity;

//This application is an easy tool to learn some Hungarian phrases and words. The purpose
//of the app was to teach useful expression with fun imaginary and audio materials.
//Created and illustrated by Ursula Armstrong, 2016

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
        View basics = (View) findViewById(R.id.basics);
        basics.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent basicIntent = new Intent(MainActivity.this,BasicConversation.class);
                startActivity(basicIntent);
            }
        });

//        Find a View and set up an onClickListener for Family Activity
        View family = (View) findViewById(R.id.family);
        family.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent familyIntent = new Intent(MainActivity.this,Family.class);
                startActivity(familyIntent);
            }
        });

//        Find a View and set up an onClickListener for House Activity
        View house = (View) findViewById(R.id.around_the_house);
        house.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent houseIntent = new Intent(MainActivity.this,House.class);
                startActivity(houseIntent);
            }
        });

//        Find a View and set up an onClickListener for ColorsNumbers Activity
        View colors = (View) findViewById(R.id.colors_and_numbers);
        colors.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent colorsIntent = new Intent(MainActivity.this,ColorsNumbers.class);
                startActivity(colorsIntent);
            }
        });

//        Find a View and set up an onClickListener for Grocery Activity
        View grocery = (View) findViewById(R.id.grocery_and_shops);
        grocery.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent groceryIntent = new Intent(MainActivity.this,Grocery.class);
                startActivity(groceryIntent);
            }
        });

//        Find a View and set up an onClickListener for EatingOut Activity
        View eatingOut = (View) findViewById(R.id.eating_out);
        eatingOut.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent eatingOutIntent = new Intent(MainActivity.this,EatingOut.class);
                startActivity(eatingOutIntent);
            }
        });

//        Find a View and set up an onClickListener for Accommodation Activity
        View accommodation = (View) findViewById(R.id.accommodation);
        accommodation.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent accommodationIntent = new Intent(MainActivity.this,Accommodation.class);
                startActivity(accommodationIntent);
            }
        });

    }
}
