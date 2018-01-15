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
import android.widget.Button;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by niraq on 1/13/2018.
 */

public class FieldSetupPage extends AppCompatActivity{

    Activity context;
    Intent intent;
    Bundle bundle;
    Button blueTopPlateButton;
    Button blueBottomPlateButton;
    Button scaleTopPlateButton;
    Button scaleBottomPlateButton;
    Button redTopPlateButton;
    Button redBottomPlateButton;
    int red;
    int blue;
    Map<String, Map<View, String>> configurationMap; //TODO: Convert string to custom object w/ 3 values(?)
    boolean isRed; //TODO: Get value from extras.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fieldsetup);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        context = this;
        intent = getIntent();

        configurationMap = new HashMap<>();
        Map blueSwitchMap = new HashMap<View, String>();
        Map scaleMap = new HashMap<View, String>();
        Map redSwitchMap = new HashMap<View, String>();

        blueTopPlateButton = (Button) findViewById(R.id.blueTopPlateButton);
        blueSwitchMap.put(blueTopPlateButton, "noColor");
        blueBottomPlateButton = (Button) findViewById(R.id.blueBottomPlateButton);
        blueSwitchMap.put(blueBottomPlateButton, "noColor");
        configurationMap.put("blueSwitch", blueSwitchMap);

        scaleTopPlateButton = (Button) findViewById(R.id.scaleTopPlateButton);
        scaleMap.put(scaleTopPlateButton, "noColor");
        scaleBottomPlateButton = (Button) findViewById(R.id.scaleBottomPlateButton);
        scaleMap.put(scaleBottomPlateButton, "noColor");

        redTopPlateButton = (Button) findViewById(R.id.redTopPlateButton);
        redSwitchMap.put(redTopPlateButton, "noColor");
        redBottomPlateButton = (Button) findViewById(R.id.redBottomPlateButton);
        redSwitchMap.put(redBottomPlateButton, "noColor");

        red = 27391; //006aff
        blue = 16711680; //ff0000

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

    public void plateButtonPress(View plateButton)
    {
        if(isRed) {
            if(plateButtonMap.get(plateButton).equals("red")) {
                plateButton.setBackgroundColor(blue);
                plateButtonMap.put(plateButton, "blue");
                //TODO: Set color of opposite button.
            } else {
                plateButton.setBackgroundColor(red);
                plateButtonMap.put(plateButton, "red");
                //TODO: Set color of opposite button.
            }
        }


        /*switch(view.getId()) //TODO: Complete the action for each button.
        {
            case R.id.blueTopPlateButton:
                break;

            case R.id.blueBottomPlateButton:
                break;

            case R.id.scaleTopPlateButton:
                break;

            case R.id.scaleBottomPlateButton:
                break;

            case R.id.redTopPlateButton:
                break;

            case R.id.redBottomPlateButton:
                break;
        }*/
    }
}
