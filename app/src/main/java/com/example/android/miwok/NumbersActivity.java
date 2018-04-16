package com.example.android.miwok;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        ArrayList<Word> words = new ArrayList<>();

        words.add(new Word("one", "lutti"));
        words.add(new Word("two" , "otiiko"));
        words.add(new Word( "three", "tolookosu"));
        words.add(new Word("four", "oyyisa"));
        words.add(new Word("five" , "massokka"));
        words.add(new Word( "six", "temmokka"));
        words.add(new Word("seven" , "kenekaku"));
        words.add(new Word( "eight", "kawinta"));
        words.add(new Word("nine" , "wo'e"));
        words.add(new Word( "ten", "na'aacha"));


        WordAdapter itemsAdapter = new WordAdapter(this,words);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);



        for( int i = 0 ; i < words.size(); i++ ){
        Log.v("NumbersArray", "Word at index " + i +": " + words.get(i));}

        //Find the rootview of the NumbersActivity




    }

}