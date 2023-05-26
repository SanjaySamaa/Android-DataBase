package com.example.sqlliteexample;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    private Context context;
    static final String DB_NAME = "SANJAY1.DB";
    static final int DB_VERSION=1;
    static final String DB_TABLE = "USERS";
    static final String USER_ID = "_ID";
    static final String USER_NAME = "user_name";
    static final String USER_PASSWORD = "user_password";

    private static final String DB_QUERY_CREATE = "CREATE TABLE " + DB_TABLE + " (" + USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + USER_NAME + " TEXT, " + USER_PASSWORD + " TEXT);";

    public DbHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DB_QUERY_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + DB_TABLE);
    }
    void insertUsers(String uname, String upassword){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(USER_NAME,uname);
        contentValues.put(USER_PASSWORD,upassword);
        long response = database.insert(DB_TABLE,null,contentValues);
        if(response == -1){
            Toast.makeText(context, "ERROR", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(context, "SUCCESS", Toast.LENGTH_SHORT).show();
        }

    }
    void updateUsers(String uname, String upassword, String row_id){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(USER_NAME,uname);
        contentValues.put(USER_PASSWORD,upassword);
        long response = database.update(DB_NAME,contentValues,"_id=?",new String[]{row_id});
        if(response == -1) {
            Toast.makeText(context, "ERROR", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(context, "SUCESS", Toast.LENGTH_SHORT).show();
        }
    }
    void deleteUsers(String row_id){
        SQLiteDatabase database =  this.getWritableDatabase();
        long response = database.delete(DB_TABLE,"_id=?",new String[]{row_id});
        if(response == -1) {
            Toast.makeText(context, "ERROR", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(context, "SUCESS", Toast.LENGTH_SHORT).show();
        }


    }
    Cursor getAllData(){
        SQLiteDatabase database = this.getReadableDatabase();
        String query = "SELECT * FROM " + DB_TABLE;
        Cursor cursor = null;
        if(database != null){
            cursor = database.rawQuery(query,null);
        }
        return cursor;
    }


}
