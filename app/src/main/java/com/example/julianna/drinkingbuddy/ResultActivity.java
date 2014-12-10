package com.example.julianna.drinkingbuddy;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.RatingBar;
import android.widget.TextView;

/**
 * Created by Julianna on 28.11.2014.
 */
public class ResultActivity extends Activity{


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.result_activity);
//gir rating til bar-object
            RatingBar bar=(RatingBar)findViewById(R.id.ratingBar1);
//får textutseende
            TextView t=(TextView)findViewById(R.id.textResult);
//gir score
            Bundle b = getIntent().getExtras();
            int score= b.getInt("score");
//fremviser scorene
            bar.setRating(score);
            switch (score)
            {
                case 1: t.setText("Dette var ikke noe særlig bra! En riktig svar.");
                case 2: t.setText("Kanskje neste gang! Bare 2 riktige svar.");
                case 3: t.setText("Det ble bare 3 av 5 riktige.");
                case 4: t.setText("Nesten alle svarene ble riktige! 4 av 5. Prøv igjen!");
                case 5: t.setText ("Gratulerer! Du kunne alle svarene riktig!");
                    break;
            }
        }
        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
// Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.activity_result, menu);
            return true;
        }
    }
