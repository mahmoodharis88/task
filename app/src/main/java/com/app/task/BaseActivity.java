package com.app.task;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseActivity extends AppCompatActivity {
    private State lifecycleState = null;
    public Dialog dialog;
//    public static InputMethodManager imeManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setLifecycleState(State.CREATED);
//        imeManager = (InputMethodManager) getApplicationContext().getSystemService(INPUT_METHOD_SERVICE);
    }



    public void setToast(String msg, Context context) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }


    @Override
    protected void onStart() {
        super.onStart();
        setLifecycleState(State.STARTED);
    }

    @Override
    protected void onResume() {
        super.onResume();
        setLifecycleState(State.RESUMED);
    }

    @Override
    protected void onPause() {
        super.onPause();

        setLifecycleState(State.PAUSED);
    }


    @Override
    protected void onStop() {
        super.onStop();
        setLifecycleState(State.STOPPED);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        setLifecycleState(State.DESTROYED);
    }

    /**
     * @return the lifecycleState
     */
    public State getLifecycleState() {
        return lifecycleState;
    }

    /**
     * @param lifecycleState the lifecycleState to set
     */
    public void setLifecycleState(State lifecycleState) {
        this.lifecycleState = lifecycleState;
    }

    /**
     * The possibles states of an activity lifecycle.
     */
    public static enum State {
        CREATED, STARTED, RESUMED, PAUSED, STOPPED, DESTROYED;
    }
}
