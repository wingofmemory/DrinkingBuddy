package com.example.julianna.drinkingbuddy;

import java.util.ArrayList;
import java.util.List;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Julianna on 28.11.2014.
 */
public class DbHelper extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "TVogFilmQuiz";
    // tasks table name
    private static final String TABLE_QUEST = "quest";
    // tasks Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_QUES = "question";
    private static final String KEY_ANSWER = "answer"; //correct option
    private static final String KEY_OPTA= "opta"; //option a
    private static final String KEY_OPTB= "optb"; //option b
    private static final String KEY_OPTC= "optc"; //option c
    private SQLiteDatabase dbase;
    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        dbase=db;
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_QUEST + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
                + " TEXT, " + KEY_ANSWER+ " TEXT, "+KEY_OPTA +" TEXT, "
                +KEY_OPTB +" TEXT, "+KEY_OPTC+" TEXT)";
        db.execSQL(sql);
        addQuestions();
        //db.close();
    }
    private void addQuestions()
    {
        Question q1=new Question("I hvilken serie finner du familien Harper?","Family Guy", "Two and Half Man", "The Simpsons", "Two And A Half Man");
        this.addQuestion(q1);
        Question q2=new Question("I hvilken serier finner du brødrene Stefan og Damon Salvatore?", "Smallville", "Top Chef", "The Vampire Diaries", "The Vampire Diaries");
        this.addQuestion(q2);
        Question q3=new Question("I hvilken serier finner du Stewie Griffin?", "American Dad", "Family Guy", "The Big Bang Theory", "Family Guy" );
        this.addQuestion(q3);
        Question q4=new Question("Hva heter barna til Homer Simpson?", "Bart, Lisa og Marge", "Lisa, Maggie og Bart", "Millhouse, Lisa og Anna",  "Lisa, Maggie og Bart ");
        this.addQuestion(q4);
        Question q5=new Question("Hva heter sønnen til Walter White i Breaking Bad?", "Walter Jr", "Jesse", "Mike", "Walter Jr");
        this.addQuestion(q5);


        Question q6=new Question("Hva heter Rambo til fornavn?","John","Jim","Jay","John");
        this.addQuestion(q6);
        Question q7=new Question("Hvem har regissert filmen Django Unchained?","Martin Scorsese","Quentin Tarantino","Sean Penn","Quentin Tarantino");
        this.addQuestion(q7);
        Question q8=new Question("Hva heter skuespilleren som spilte Bridget Jones?","Renée Zellweger","Jennifer Aniston","Monica Belucci","Renée Zellweger");
        this.addQuestion(q8);
        Question q9=new Question("Hvem hadde rollen som den lille jenta i E.T.?","Reese Witherspoon","Drew Barrymore","Uma Thurman","Drew Barrymore");
        this.addQuestion(q9);
        Question q10=new Question("Hvilken filmfigur hadde den kjente replikken: Dead or alive, you're coming with me!","Judge Dredd","James Bond","Robocop","Robocop");
        this.addQuestion(q10);
        Question q11=new Question("Hva var svaret på alt, ifølge filmen Haikerens guide til galaksen?","40","42","44","42");
        this.addQuestion(q11);


    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUEST);
        // Create tables again
        onCreate(db);
    }
    // Adding new question
    public void addQuestion(Question quest) {
        //SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_QUES, quest.getQUESTION());
        values.put(KEY_ANSWER, quest.getANSWER());
        values.put(KEY_OPTA, quest.getOPTA());
        values.put(KEY_OPTB, quest.getOPTB());
        values.put(KEY_OPTC, quest.getOPTC());
        // Inserting Row
        dbase.insert(TABLE_QUEST, null, values);
    }
    public List<Question> getAllQuestions() {
        List<Question> quesList = new ArrayList<Question>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_QUEST;
        dbase=this.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Question quest = new Question();
                quest.setID(cursor.getInt(0));
                quest.setQUESTION(cursor.getString(1));
                quest.setANSWER(cursor.getString(2));
                quest.setOPTA(cursor.getString(3));
                quest.setOPTB(cursor.getString(4));
                quest.setOPTC(cursor.getString(5));
                quesList.add(quest);
            } while (cursor.moveToNext());
        }
        // return quest list
        return quesList;
    }
    public int rowcount()
    {
        int row=0;
        String selectQuery = "SELECT  * FROM " + TABLE_QUEST;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        row=cursor.getCount();
        return row;
    }

}
