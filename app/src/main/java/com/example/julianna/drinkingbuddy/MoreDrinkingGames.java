package com.example.julianna.drinkingbuddy;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

/**
 * Fragment Layout java fil til en listevisning
 * layouten blir hentet layoutmappas activity_more_drinking_games
 * innholdet blir hentet av MoreGames.java
 */

public class MoreDrinkingGames extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_drinking_games);
    }



}
