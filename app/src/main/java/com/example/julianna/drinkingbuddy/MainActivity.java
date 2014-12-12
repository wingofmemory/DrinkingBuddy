package com.example.julianna.drinkingbuddy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity implements View.OnClickListener
{

    Button button1, button2, button3, button4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);
        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(this);
        button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(this);
        button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(this);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void button1Click() {

        startActivity(new Intent("com.example.julianna.drinkingbuddy.GameOfWar"));}

    public void button2Click() {

        startActivity(new Intent("com.example.julianna.drinkingbuddy.MoreDrinkingGames"));}

    public void button3Click() {

        startActivity(new Intent("com.example.julianna.drinkingbuddy.QuizActivity"));}

    public void button4Click() {

        startActivity(new Intent("com.example.julianna.drinkingbuddy.DrinkOppskrifter"));}



    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.button1:
                button1Click();
                break;
            case R.id.button2:
                button2Click();
                break;
            case R.id.button3:
                button3Click();
                break;
            case R.id.button4:
                button4Click();
                break;

        }

    }


}
