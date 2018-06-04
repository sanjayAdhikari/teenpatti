package com.backspace.teenpatti.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.backspace.teenpatti.R;


/**
 * Created by Backspace on 10/9/2016.
 */
public class Splash extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Thread thread=new Thread(){
            @Override
            public void run() {
                try {

                    //work here
                    sleep(3000); //sleep for X seconds and then
                    startActivity(new Intent(getApplicationContext(),MainActivity.class)); //jump to player mode after 5 seconds
                    finish();//terminate thread
                } catch (InterruptedException e) {
                    e.printStackTrace(); //if sleep throws any exception
                }
            }
        };
        thread.start(); //call the thread
    }
}
