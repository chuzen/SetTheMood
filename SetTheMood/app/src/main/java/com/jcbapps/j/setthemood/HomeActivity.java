package com.jcbapps.j.setthemood;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Home page of the list view of moods for the user to pick.
 */

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setTitle(R.string.home_title);
    }

    /*
        These methods each have a preloaded string inside each button function
        with the putExtra that will call the search for query method inside the MainActivity class
        for the list of the specific songs corresponding with that string depending
        with mood button the user chooses.
     */

    public void getHappy(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(Integer.toString(R.string.mood_key), "Happy");
        startActivity(intent);
    }

    public void getSad(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(Integer.toString(R.string.mood_key), "Sad");
        startActivity(intent);
    }

    public void getDrunk(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(Integer.toString(R.string.mood_key), "Drunk");
        startActivity(intent);
    }

    public void getAngry(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(Integer.toString(R.string.mood_key), "Angry");
        startActivity(intent);
    }

    public void getHigh(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(Integer.toString(R.string.mood_key), "High");
        startActivity(intent);
    }

    public void getExcited(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(Integer.toString(R.string.mood_key), "Excited");
        startActivity(intent);
    }

    public void getRelaxed(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(Integer.toString(R.string.mood_key), "Relaxed");
        startActivity(intent);
    }

    public void getLazy(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(Integer.toString(R.string.mood_key), "Lazy");
        startActivity(intent);
    }

}
