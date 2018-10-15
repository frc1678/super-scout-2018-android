package com.example.sam.blutoothsocketreceiver;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;

import java.util.ArrayList;

public class QrDisplay extends ActionBarActivity {
    String matchNumber;
    String alliance;
    String allianceCompressed;
    String teamNumberOne;
    String teamNumberTwo;
    String teamNumberThree;
    String superNotesOne;
    String superNotesTwo;
    String superNotesThree;
    String score;
    String blueSwitch;
    String redSwitch;
    String scale;
    String  compressedData;
    String autoQuestCompressed;
    String faceBossCompressed;
    String blueSwitchCompressed;
    String redSwitchCompressed;
    String scaleCompressed;
    Integer boostForPowerUp;
    Integer forceForPowerUp;
    Integer levitateForPowerUp;
    Integer boostInVaultFinal;
    Integer forceInVaultFinal;
    Integer levitateInVaultFinal;
    Boolean didAutoQuest;
    Boolean didFaceBoss;
    ArrayList<String> teamOneDataName;
    ArrayList<String> teamOneDataScore;
    ArrayList<String> teamTwoDataName;
    ArrayList<String> teamTwoDataScore;
    ArrayList<String> teamThreeDataName;
    ArrayList<String> teamThreeDataScore;
    Activity context;
    TextView textView;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qr_display);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        intent = getIntent();
        getExtras();
        textView = (TextView)findViewById(R.id.qr_tv);
        createCompressedFormat();
        textView.setText(compressedData);
    }

    public void getExtras(){
        matchNumber = intent.getExtras().getString("matchNumber");
        alliance = intent.getExtras().getString("alliance");
        teamNumberOne = intent.getExtras().getString("teamNumberOne");
        teamNumberTwo = intent.getExtras().getString("teamNumberTwo");
        teamNumberThree = intent.getExtras().getString("teamNumberThree");

        superNotesOne = intent.getExtras().getString("superNotesOne");
        superNotesTwo = intent.getExtras().getString("superNotesTwo");
        superNotesThree = intent.getExtras().getString("superNotesThree");

        boostForPowerUp = intent.getExtras().getInt("boostForPowerUp");
        forceForPowerUp = intent.getExtras().getInt("forceForPowerUp");
        levitateForPowerUp = intent.getExtras().getInt("levitateForPowerUp");
        boostInVaultFinal = intent.getExtras().getInt("boostInVaultFinal");
        forceInVaultFinal = intent.getExtras().getInt("forceInVaultFinal");
        levitateInVaultFinal = intent.getExtras().getInt("levitateInVaultFinal");

        didAutoQuest = intent.getExtras().getBoolean("didAutoQuest");
        didFaceBoss = intent.getExtras().getBoolean("didFaceBoss");
        score = intent.getExtras().getString("score");

        blueSwitch = intent.getExtras().getString("blueSwitch");
        redSwitch = intent.getExtras().getString("redSwitch");
        scale = intent.getExtras().getString("scale");

        teamOneDataName = intent.getStringArrayListExtra("teamOneDataName");
        teamOneDataScore = intent.getStringArrayListExtra("teamOneDataScore");
        teamTwoDataName = intent.getStringArrayListExtra("teamTwoDataName");
        teamTwoDataScore = intent.getStringArrayListExtra("teamTwoDataScore");
        teamThreeDataName = intent.getStringArrayListExtra("teamThreeDataName");
        teamThreeDataScore = intent.getStringArrayListExtra("teamThreeDataScore");
    }

    public void createCompressedFormat(){
        if (alliance.equals("Blue Alliance")){
            allianceCompressed = "0";
        } else {
            allianceCompressed = "1"; }
        if (didAutoQuest.equals(false)){
            autoQuestCompressed = "0";
        } else {
            autoQuestCompressed = "1"; }
        if (didFaceBoss.equals(false)){
            faceBossCompressed = "0";
        } else {
            faceBossCompressed = "1"; }
        if (blueSwitch.equals("blue")){
            blueSwitchCompressed = "0";
        } else {
            blueSwitchCompressed = "1"; }
        if (redSwitch.equals("blue")){
            redSwitchCompressed = "0";
        } else {
            redSwitchCompressed = "1"; }
        if (scale.equals("blue")){
            scaleCompressed = "0";
        } else {
            scaleCompressed= "1"; }
        compressedData = "S$" + matchNumber + "_" + allianceCompressed + "|p(g" + boostForPowerUp.toString() + "h" + forceForPowerUp.toString() + "i" + levitateForPowerUp.toString() + "),v(g" + boostInVaultFinal.toString() + "h" + forceInVaultFinal.toString() + "i" + levitateInVaultFinal.toString() + "),q" + autoQuestCompressed + ",b" + faceBossCompressed + ",s" + score + ",r(d" + blueSwitchCompressed + "e" + scaleCompressed + "f" + redSwitchCompressed + "),t(" + "M" + teamNumberOne + "B" + teamOneDataScore.get(2) + "G" + teamOneDataScore.get(3) + "A" + teamOneDataScore.get(1) + "D" + teamOneDataScore.get(4) + "S" + teamOneDataScore.get(0) + "N[" + superNotesOne + "]," + "M" + teamNumberTwo + "B" + teamTwoDataScore.get(2) + "G" + teamTwoDataScore.get(3) + "A" + teamTwoDataScore.get(1) + "D" + teamTwoDataScore.get(4) + "S" + teamTwoDataScore.get(0) + "N[" + superNotesTwo + "]," + "M" + teamNumberThree + "B" + teamThreeDataScore.get(2) + "G" + teamThreeDataScore.get(3) + "A" + teamThreeDataScore.get(1) + "D" + teamThreeDataScore.get(4) + "S" + teamThreeDataScore.get(0) + "N[" + superNotesThree + "])";
    }


}
