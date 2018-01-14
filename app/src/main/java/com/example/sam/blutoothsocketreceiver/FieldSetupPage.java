package com.example.sam.blutoothsocketreceiver;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

/**
 * Created by niraq on 1/13/2018.
 */

public class FieldSetupPage extends AppCompatActivity{

    Activity context;
    Intent intent;
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fieldsetup);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        context = this;
        intent = getIntent();

    }

    //TODO: Implement data loss warning when going back.

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.teleop, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.teleop) {
            if (false/* TODO: put in check condition for plate configuration being entered*/){
                Toast.makeText(context, "Select a configuration for each plate!", Toast.LENGTH_LONG).show();
            } else {
                //TODO: make intent for scout (and pass intent info from mainactivity here)
                Intent teleopIntent = new Intent(context, ScoutingPage.class);
                teleopIntent.putExtras(intent);
                //TODO: Add extras from this activity.
                startActivity(teleopIntent);
            }



        }
        return super.onOptionsItemSelected(item);
    }
}
