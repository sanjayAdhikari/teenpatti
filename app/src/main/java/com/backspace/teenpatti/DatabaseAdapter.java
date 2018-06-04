package com.backspace.teenpatti;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by Backspace on 10/8/2016.
 */
public class DatabaseAdapter {
    public DatabaseHelper DBHelper;

    public DatabaseAdapter(Context context){
        DBHelper=new DatabaseHelper(context);
        Toast.makeText( context,"COnstrucutor wass called main ",Toast.LENGTH_LONG ).show();
    }

    public long addUser(String userValue,String passValue){
        SQLiteDatabase db=DBHelper.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(DBHelper.USERNAME,userValue);
        values.put(DBHelper.PASSWORD,passValue);
        long id=db.insert(DBHelper.TABLE_NAME,null,values);
        return id;
    }
    public String getAllData(){
        StringBuffer buffer=new StringBuffer();
        try{
            SQLiteDatabase db=DBHelper.getWritableDatabase();
            String[]  columns={DBHelper.UID,DBHelper.USERNAME,DBHelper.PASSWORD};
            Cursor cursor=db.query( DBHelper.TABLE_NAME,columns,null,null,null,null,null );
            while (cursor.moveToNext()){
                int id=cursor.getInt(0);
                String username=" "+cursor.getString( 1 );
                String password=" "+cursor.getString( 2 )+"\n";
                buffer.append( id+username+password );
            }
        }catch (Exception e){

        }
        return buffer.toString();
    }
    public boolean isAccountExist(String nameValue,String passValue){
        boolean is=false;
        SQLiteDatabase db=DBHelper.getWritableDatabase();
        String[] columns={DBHelper.UID};
        String[] selectionArgs={nameValue,passValue};
        Cursor cursor=db.query( DBHelper.TABLE_NAME,columns,DBHelper.USERNAME+" =? AND "+DBHelper.PASSWORD+" =?",selectionArgs,null,null,null );
        while (cursor.moveToNext()){
            is=true;
        }
        return is;
    }
    public int deleteThisAccount(String username){
        boolean is=false;
        SQLiteDatabase db=DBHelper.getWritableDatabase();
        String[] whereArgs={username};
        int count=db.delete( DBHelper.TABLE_NAME,DBHelper.USERNAME+" =?",whereArgs);
        return count;
    }
    public int updateThisAccount(String oldPassword,String newPassword){
        SQLiteDatabase db=DBHelper.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put( DBHelper.PASSWORD, newPassword );
        String[] whereArgs={oldPassword};
        int count=db.update( DBHelper.TABLE_NAME,values,DBHelper.PASSWORD+" =?",whereArgs);
        return count;

    }
    static class DatabaseHelper extends SQLiteOpenHelper {
        private static final String DATABASE_NAME="social";
        private static final int DATABASE_VERSION=1;
        private static final String TABLE_NAME="user";
        private static final String UID="_id";
        private static final String USERNAME="username";
        private static final String PASSWORD="password";
        private static final String DROP_TABLE="DROP TABLE IF EXISTS"+TABLE_NAME;
        private static final String CREATE_TABLE="CREATE TABLE "+TABLE_NAME+" ( "+UID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+USERNAME+" VARCHAR(30)," +
                ""+PASSWORD+" VARCHAR(30));";
        private Context context;
        public DatabaseHelper(Context context) {
            super(context, DATABASE_NAME,null,DATABASE_VERSION);
            Toast.makeText( context,"COnstrucutor wass called Second ",Toast.LENGTH_LONG ).show();
            this.context=context;
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            try{
                Toast.makeText( context,"onCreate was Called",Toast.LENGTH_SHORT).show();
                db.execSQL(CREATE_TABLE);
            }catch (Exception e){
                Toast.makeText( context,e+" ",Toast.LENGTH_LONG ).show();
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Toast.makeText( context,"onUpgrade was Called",Toast.LENGTH_SHORT).show();
            try{
                db.execSQL(DROP_TABLE);
                onCreate(db);
            }catch (Exception ex){
                Toast.makeText( context,ex+" ",Toast.LENGTH_LONG ).show();
            }
        }
    }
}
