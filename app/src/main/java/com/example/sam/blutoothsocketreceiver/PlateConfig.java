package com.example.sam.blutoothsocketreceiver;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ScaleDrawable;
import android.view.View;
import android.widget.Button;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by niraq on 1/15/2018.
 */

//This class is for getting and setting the color of plates in FieldSetup.
public class PlateConfig {

    private Context context;
    private boolean isRed;

    private Button blueTopPlateButton;
    private Button blueBottomPlateButton;
    private Button scaleTopPlateButton;
    private Button scaleBottomPlateButton;
    private Button redTopPlateButton;
    private Button redBottomPlateButton;

    private Map<View, String> configMap;

    private String red;
    private String blue;

    //TODO: Not being used now, reimplement if time available.
    /*
    GradientDrawable blueDrawable;
    GradientDrawable redDrawable;
    */

    public PlateConfig(Context context, boolean isRed) {
        this.context = context;
        this.isRed = isRed;

        red = "#0000ff"; //0000ff
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

        //TODO: Not being used now, reimplement if time available.
        /* //Drawables used for setting border on buttons.
        blueDrawable = new GradientDrawable();
        blueDrawable.setColor(0xFF0000FF); // Changes this drawable to use a single color instead of a gradient
        blueDrawable.setCornerRadius(1);
        blueDrawable.setStroke(7, 0xFF252525);

        redDrawable = new GradientDrawable();
        redDrawable.setColor(0xFFFF0000); // Changes this drawable to use a single color instead of a gradient
        redDrawable.setCornerRadius(1);
        redDrawable.setStroke(7, 0xFF252525);
        */
    }

    public HashMap<String, String/*TODO: Figure out what this needs to be (ex Gson, etc.)*/> getConfig() {
        //TODO: Get configuration of plates.
        return null; //TODO: Make this not null.
    }

    public void swapColor(View button) {
        //TODO: This swaps color of two buttons.
        String oppositeButtonState;
        String oppositeButtonColor;

        if(isRed) {
            if(configMap.get(button).equals("red")) {
                button.setBackgroundColor(Color.parseColor(blue));
                //button.setBackgroundDrawable(blueDrawable);
                configMap.put(button, "blue");
                oppositeButtonState = "red";
                oppositeButtonColor = blue;
            } else {
                button.setBackgroundColor(Color.parseColor(red));
                //button.setBackgroundDrawable(blueDrawable);
                configMap.put(button, "red");
                oppositeButtonState = "red";
                oppositeButtonColor = blue;
            }
        } else {
            if(configMap.get(button).equals("blue")) {
                button.setBackgroundColor(Color.parseColor(red));
                //button.setBackgroundDrawable(redDrawable);
                configMap.put(button, "red");
                oppositeButtonState = "red";
                oppositeButtonColor = blue;
            } else {
                button.setBackgroundColor(Color.parseColor(blue));
                //button.setBackgroundDrawable(redDrawable);
                configMap.put(button, "blue");
                oppositeButtonState = "red";
                oppositeButtonColor = blue;
            }
        }

        switch(button.getId()) //TODO: Complete the action for each button.
        {
            case R.id.blueTopPlateButton:
                blueBottomPlateButton.setBackgroundColor(Color.parseColor(oppositeButtonColor));
                configMap.put(blueBottomPlateButton, oppositeButtonState);
                break;

            case R.id.blueBottomPlateButton:
                blueTopPlateButton.setBackgroundColor(Color.parseColor(oppositeButtonColor));
                configMap.put(blueTopPlateButton, oppositeButtonState);
                break;

            case R.id.scaleTopPlateButton:
                scaleBottomPlateButton.setBackgroundColor(Color.parseColor(oppositeButtonColor));
                configMap.put(scaleBottomPlateButton, oppositeButtonState);
                break;

            case R.id.scaleBottomPlateButton:
                scaleTopPlateButton.setBackgroundColor(Color.parseColor(oppositeButtonColor));
                configMap.put(scaleTopPlateButton, oppositeButtonState);
                break;

            case R.id.redTopPlateButton:
                redBottomPlateButton.setBackgroundColor(Color.parseColor(oppositeButtonColor));
                configMap.put(redBottomPlateButton, oppositeButtonState);
                break;

            case R.id.redBottomPlateButton:
                redTopPlateButton.setBackgroundColor(Color.parseColor(oppositeButtonColor));
                configMap.put(redTopPlateButton, oppositeButtonState);
                break;
        }

    }
}
