package com.example.android.miwok;

import android.content.Context;
import android.content.DialogInterface;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {
    /** Handles the playback of all sound files **/
    private MediaPlayer mMediaPlayer;

    /** Handles Audio Focus when playing a sound file **/
    private AudioManager mAudioManager;

    /** Listener gets triggered when Audio Focus Changes **/
    private AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if(focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT||
                focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK){
                // AUDIOFOCUS_LOSS_TRANSIENT means we have lost focus only for a short amount of time
                // AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK means our application can play audio in the background at a lower volume
                // for our purposes we will restart playback from the beginning
                mMediaPlayer.pause();
                mMediaPlayer.seekTo(0);

            }else if (focusChange == AudioManager.AUDIOFOCUS_GAIN){
                //We have regained audio focus and are resuming playback
                mMediaPlayer.start();
            }else if (focusChange == AudioManager.AUDIOFOCUS_LOSS){
                //We have lost audio focus and will stop playback and release resources
                releaseMediaPlayer();
            }
        }
    };

    // This listener is triggered when audio has finished playback
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        //Initialize Audio Manager to request audio focus;
        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        final ArrayList<Word> words = new ArrayList<>();

        words.add(new Word("one", "lutti", R.drawable.number_one,R.raw.number_one));
        words.add(new Word("two" , "otiiko", R.drawable.number_two, R.raw.number_two));
        words.add(new Word( "three", "tolookosu", R.drawable.number_three, R.raw.number_three));
        words.add(new Word("four", "oyyisa", R.drawable.number_four, R.raw.number_four));
        words.add(new Word("five" , "massokka", R.drawable.number_five, R.raw.number_five));
        words.add(new Word( "six", "temmokka", R.drawable.number_six, R.raw.number_six));
        words.add(new Word("seven" , "kenekaku", R.drawable.number_seven, R.raw.number_seven));
        words.add(new Word( "eight", "kawinta", R.drawable.number_eight, R.raw.number_eight));
        words.add(new Word("nine" , "wo'e", R.drawable.number_nine, R.raw.number_nine));
        words.add(new Word( "ten", "na'aacha", R.drawable.number_ten, R.raw.number_ten));


        WordAdapter itemsAdapter = new WordAdapter(this,words, R.color.category_numbers);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Release mediaPlayer if it exists because we are about to play a different sound file
                releaseMediaPlayer();
                Word word = words.get(i);
                int focusRequest = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                if(focusRequest == AudioManager.AUDIOFOCUS_REQUEST_GRANTED){

                    mMediaPlayer = MediaPlayer.create( NumbersActivity.this, word.getAudioResourceId());
                    mMediaPlayer.start();
                    //Setup a listener so that we can stop and release the media player once the sound has finished playing
                    mMediaPlayer.setOnCompletionListener(mCompletionListener);
                }

            }
        });



        for( int i = 0 ; i < words.size(); i++ ){
        Log.v("NumbersArray", "Word at index " + i +": " + words.get(i));}


        //Find the rootview of the NumbersActivity




    }
    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;

            // Regardless of whether or not we were granted audio focus, abandon it. This also
            // unregisters the AudioFocusChangeListener so we don't get anymore callbacks.
            mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);

        }
    }

}