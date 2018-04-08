package com.example.android.miwok;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        ArrayList<String> words = new ArrayList<String>();
        words.add("one");
        words.add("two");
        words.add("three");
        words.add("four");
        words.add("five");
        words.add("six");
        words.add("seven");
        words.add("eight");
        words.add("nine");
        words.add("ten");

        for( int i = 0 ; i < words.size(); i++ ){
        Log.v("NumbersArray", "Word at index " + i +": " + words.get(i));}

        //Find the rootview of the NumbersActivity
        LinearLayout rootView = findViewById(R.id.rootView);

        for (int i = 0; i < words.size() ; i++){
            TextView wordView = new TextView(this);
            wordView.setText(words.get(i));
            //Add child view to Root view
            rootView.addView(wordView);

        }


    }

}