package com.example.sam.blutoothsocketreceiver;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.Button;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by niraq on 1/15/2018.
 */

//This class is for getting and setting the color of plates in FieldSetup.
public class PlateConfig {

    Context context;
    boolean isRed;

    Button blueTopPlateButton;
    Button blueBottomPlateButton;
    Button scaleTopPlateButton;
    Button scaleBottomPlateButton;
    Button redTopPlateButton;
    Button redBottomPlateButton;

    Map<View, String> configMap;

    String red;
    String blue;

    public PlateConfig(Context context, boolean isRed) {
        this.context = context;
        this.isRed = isRed;

        red = "#006aff"; //006aff
        blue = "#ff0000"; //ff0000

        configMap = new HashMap<>();

        blueTopPlateButton = (Button) ((Activity)context).findViewById(R.id.blueTopPlateButton);
        configMap.put(blueTopPlateButton, "noColor");
        blueBottomPlateButton = (Button) ((Activity)context).findViewById(R.id.blueBottomPlateButton);
        configMap.put(blueBottomPlateButton, "noColor");
        scaleTopPlateButton = (Button) ((Activity)context).findViewById(R.id.scaleTopPlateButton);
        configMap.put(scaleTopPlateButton, "noColor");
        scaleBottomPlateButton = (Button) ((Activity)context).findViewById(R.id.scaleBottomPlateButton);
        configMap.put(scaleBottomPlateButton, "noColor");
        redTopPlateButton = (Button) ((Activity)context).findViewById(R.id.redTopPlateButton);
        configMap.put(redTopPlateButton, "noColor");
        redBottomPlateButton = (Button) ((Activity)context).findViewById(R.id.redBottomPlateButton);
        configMap.put(redBottomPlateButton, "noColor");
    }

    public HashMap<String, String/*TODO: Figure out what this needs to be (ex Gson, etc.)*/> getConfig() {
        //TODO: Get configuration of plates.
        return null; //TODO: Make this not null.
    }

    public void swapColor(View button) {
        //TODO: This swaps color of two buttons.

        String oppositeButton;

        if(isRed) {
            if(configMap.get(button).equals("red")) {
                button.setBackgroundColor(Color.parseColor(blue));
                configMap.put(button, "blue");
                oppositeButton = "red";
            } else {
                button.setBackgroundColor(Color.parseColor(red));
                configMap.put(button, "red");
                oppositeButton = "blue";
            }
        } else {
            if(configMap.get(button).equals("blue")) {
                button.setBackgroundColor(Color.parseColor(red));
                configMap.put(button, "red");
                oppositeButton = "red";
            } else {
                button.setBackgroundColor(Color.parseColor(blue));
                configMap.put(button, "blue");
                oppositeButton = "blue";
            }
        }

        switch(button.getId()) //TODO: Complete the action for each button.
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
        }
    }
}
