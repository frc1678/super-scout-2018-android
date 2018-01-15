package com.example.sam.blutoothsocketreceiver;

/**
 * Created by niraq on 1/15/2018.
 */

//This class is for getting and setting the color of plates in FieldSetup.
public class PlateConfig {

    Context context;

    Button blueTopPlateButton;
    Button blueBottomPlateButton;
    Button scaleTopPlateButton;
    Button scaleBottomPlateButton;
    Button redTopPlateButton;
    Button redBottomPlateButton;

    public PlateConfig(Context context) {
        this.context = context;
        ((Activity)context).findViewById(R.id.text);

        blueTopPlateButton = (Button) ((Activity)context).findViewById(R.id.);
        blueBottomPlateButton = (Button) ((Activity)context).findViewById(R.id.);
        scaleTopPlateButton = (Button) ((Activity)context).findViewById(R.id.);
        scaleBottomPlateButton = (Button) ((Activity)context).findViewById(R.id.);
        redTopPlateButton = (Button) ((Activity)context).findViewById(R.id.);
        redBottomPlateButton = (Button) ((Activity)context).findViewById(R.id.);
    }
}
