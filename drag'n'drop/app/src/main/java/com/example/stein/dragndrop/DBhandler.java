package com.example.stein.dragndrop;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DBhandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "ranking.db";
    public static final String TABLE_RANKING = "ranking";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_SCORE = "score";


    public DBhandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_RANKING + "(" +
                COLUMN_NAME + " TEXT PRIMARY KEY, " +
                COLUMN_SCORE + " INTEGER " +
                ");";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_RANKING +";");
        onCreate(db);

    }

    public void add_players_score(Ranking ranking){

        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, ranking.get_player_name());
        //values.put(COLUMN_SCORE, ranking.get_score());

        SQLiteDatabase db = getWritableDatabase();

        db.insert(TABLE_RANKING, null, values);
        //db.insert(TABLE_RANKING, COLUMN_SCORE, values);
        db.close();

    }

    public void delete_player(String player){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_RANKING + " WHERE " + COLUMN_NAME + "=\"" + player + "\";");
    }

    public List<String> database_to_string(){
        List list = new ArrayList<>();
        String DBout = " ";
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_RANKING + " WHERE 1;";

        //create Cursor - database pointer
        Cursor cursor = db.rawQuery(query, null);
        // move cursor at the begining
        cursor.moveToFirst();

        while(!cursor.isAfterLast()){
            if(cursor.getString(cursor.getColumnIndex("name")) != null){
                DBout = cursor.getString(cursor.getColumnIndex("name"));
                list.add(cursor.getString(cursor.getColumnIndex("name")));
                cursor.moveToNext();

            }
        }
        db.close();
        return list;
    }
}
