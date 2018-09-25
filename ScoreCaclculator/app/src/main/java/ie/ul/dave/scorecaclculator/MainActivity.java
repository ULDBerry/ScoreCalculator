package ie.ul.dave.scorecaclculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Variables to be used int he application
    private int mColourPoints = 0;
    private int mNearBallPoints = 0;
    private int mFarBallPoints = 0;
    private int mRobotHomePoints = 0;
    private int mWBPoints = 0;
    private int mPointsTotal = 0;

    //TextViews
    private TextView mMessageColourPointsView;
    private TextView mMessageTotalPointView;
    private TextView mMessageNearBallPointsView;
    private TextView mMessageFarBallPointsView;
    private TextView mMessageRobotHomePointsView;
    private TextView mMessageWBPointsView;

    //EditTexts
    private EditText mNearBallEditTextView;
    private EditText mFarBallEditTextView;
    private EditText mRobotHomeEditTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

     //Setup initial values to display
        mMessageColourPointsView = findViewById(R.id.message_colorptsfin);
        mMessageColourPointsView.setText(getString(R.string.message_colourpts,mColourPoints));

        mMessageTotalPointView = findViewById(R.id.message_totalpoints);
        mMessageTotalPointView.setText(getString(R.string.message_pointstotal, mPointsTotal));

       mMessageNearBallPointsView = findViewById(R.id.message_nearballint);
       mMessageNearBallPointsView.setText(getString(R.string.message_nearballpoints,mNearBallPoints));

        mMessageFarBallPointsView = findViewById(R.id.message_farballint);
        mMessageFarBallPointsView.setText(getString(R.string.message_farballpoints,mFarBallPoints));

        mMessageRobotHomePointsView = findViewById(R.id.message_robothomeint);
        mMessageRobotHomePointsView.setText(getString(R.string.message_robothomepoints,mRobotHomePoints));

        mMessageWBPointsView = findViewById(R.id.message_wbpointsint);
        mMessageWBPointsView.setText(getString(R.string.message_wbpoints,mWBPoints));


        //Get whats is typed in
       mNearBallEditTextView = findViewById(R.id.mNearBallEditText);
       mFarBallEditTextView = findViewById(R.id.mFarBallEditText);
       mRobotHomeEditTextView = findViewById(R.id.mRobotHomeEditText);

    }

    //Button methods
    public void button_fixes3(View view){
        mColourPoints = 0;
        mMessageColourPointsView.setText(getString(R.string.message_colourpts,mColourPoints));
        updateTotal();
    }

    public void button_fixes2(View view){
        mColourPoints = 25;
        mMessageColourPointsView.setText(getString(R.string.message_colourpts,mColourPoints));
        updateTotal();
    }

    public void button_fixes1(View view){
        mColourPoints = 75;
        mMessageColourPointsView.setText(getString(R.string.message_colourpts,mColourPoints));
        updateTotal();
    }

    public void button_fixes0(View view){
        mColourPoints = 150;
        mMessageColourPointsView.setText(getString(R.string.message_colourpts,mColourPoints));
        updateTotal();
    }

    public void button_wbfailure(View view){
        mWBPoints = 0;
        updateWhiteBallPointsDisplayed(mWBPoints);
        updateTotal();
    }
    public void button_wbsuccess(View view){
        mWBPoints = 60;
        updateWhiteBallPointsDisplayed(mWBPoints);
        updateTotal();
    }

    public void button_reset(View view){

        //Set everything to Zero
        mColourPoints = 0;
        mNearBallPoints = 0;
        mFarBallPoints = 0;
        mRobotHomePoints = 0;
        mWBPoints = 0;
        mPointsTotal = 0;

        //Reset the edit text
        mNearBallEditTextView.setText("");
        mFarBallEditTextView.setText("");
        mRobotHomeEditTextView.setText("");

        //Update the points displayed
        updateColourPoints(mColourPoints);
        updateNearBallPointsDisplayed(mNearBallPoints);
        updateFarBallPointsDisplayed(mFarBallPoints);
        updateRobotHomePointsDisplayed(mRobotHomePoints);
        updateWhiteBallPointsDisplayed(mWBPoints);
        updateTotal();
    }

    // Update the distance scores
    public void button_update(View view){

        int nearBallDistanceFromEditText = 0;
        int farBallDistanceFromEditText = 0;
        int robotHomeDistanceFromEditText = 0;

        //Test for an integer nearBall
        try {
            nearBallDistanceFromEditText = Integer.parseInt(mNearBallEditTextView.getText().toString());
        } catch (NumberFormatException e)
        {
            nearBallDistanceFromEditText = 300;
        }

        if (nearBallDistanceFromEditText <= 5){
            mNearBallPoints = 110;
        } else if (nearBallDistanceFromEditText > 5 && nearBallDistanceFromEditText <= 10) {
            mNearBallPoints = 100;
        } else if (nearBallDistanceFromEditText > 10 && nearBallDistanceFromEditText <= 20) {
            mNearBallPoints = 80;
        } else if (nearBallDistanceFromEditText > 20 && nearBallDistanceFromEditText <= 30) {
            mNearBallPoints = 50;
        } else if (nearBallDistanceFromEditText > 30 && nearBallDistanceFromEditText <= 45) {
            mNearBallPoints = 10;
        } else if  (nearBallDistanceFromEditText > 45) {
            mNearBallPoints = 0;
        }
        updateNearBallPointsDisplayed(mNearBallPoints);

        //Test for an integer nearRobotHome
        try {
            robotHomeDistanceFromEditText = Integer.parseInt(mRobotHomeEditTextView.getText().toString());
        } catch (NumberFormatException e)
        {
            robotHomeDistanceFromEditText = 300;
        }

        if (robotHomeDistanceFromEditText <= 5){
            mRobotHomePoints = 110;
        } else if (robotHomeDistanceFromEditText > 5 && robotHomeDistanceFromEditText <= 10) {
            mRobotHomePoints = 100;
        } else if (robotHomeDistanceFromEditText > 10 && robotHomeDistanceFromEditText <= 20) {
            mRobotHomePoints = 80;
        } else if (robotHomeDistanceFromEditText > 20 && robotHomeDistanceFromEditText <= 30) {
            mRobotHomePoints = 50;
        } else if (robotHomeDistanceFromEditText > 30 && robotHomeDistanceFromEditText <= 45) {
            mRobotHomePoints = 10;
        } else if  (robotHomeDistanceFromEditText > 45) {
            mRobotHomePoints = 0;
        }
        updateRobotHomePointsDisplayed(mRobotHomePoints);

        //Test for an integer farBall
        try {
            farBallDistanceFromEditText = Integer.parseInt(mFarBallEditTextView.getText().toString());
        } catch (NumberFormatException e)
        {
            farBallDistanceFromEditText = 300;
        }

        if (farBallDistanceFromEditText <= 5){
            mFarBallPoints = 220;
        } else if (farBallDistanceFromEditText > 5 && farBallDistanceFromEditText <= 10) {
            mFarBallPoints = 200;
        } else if (farBallDistanceFromEditText > 10 && farBallDistanceFromEditText <= 20) {
            mFarBallPoints = 160;
        } else if (farBallDistanceFromEditText > 20 && farBallDistanceFromEditText <= 30) {
            mFarBallPoints = 100;
        } else if (farBallDistanceFromEditText > 30 && farBallDistanceFromEditText <= 45) {
            mFarBallPoints = 20;
        } else if  (farBallDistanceFromEditText > 45) {
            mFarBallPoints = 0;
        }
        updateFarBallPointsDisplayed(mFarBallPoints);
        updateTotal();
    }

    //Methods to update what is displayed
    private void updateNearBallPointsDisplayed(int mNearBallPoints){
        int mNearBallPointsIn = mNearBallPoints;
        mMessageNearBallPointsView.setText(getString(R.string.message_nearballpoints,mNearBallPoints));
    }

    private void updateFarBallPointsDisplayed(int mFarBallPoints){
        int mFarBallPointsIn = mFarBallPoints;
        mMessageFarBallPointsView.setText(getString(R.string.message_farballpoints,mFarBallPoints));
    }

    private void updateRobotHomePointsDisplayed(int mRobotHomePoints){
        int mRobotHomePointsIn = mRobotHomePoints;
        mMessageRobotHomePointsView.setText(getString(R.string.message_robothomepoints,mRobotHomePoints));
    }

    private void updateWhiteBallPointsDisplayed(int mWBPoints){
        int mWBPointsIn = mWBPoints;
        mMessageWBPointsView.setText(getString(R.string.message_wbpoints, mWBPoints));
    }

    private void updateColourPoints(int mColourPoints){
        int mColourPointsIn = mColourPoints;
        mMessageColourPointsView.setText(getString(R.string.message_colourpts,mColourPointsIn));
    }

    //update the total
    private void updateTotal(){
        mPointsTotal = mColourPoints + mNearBallPoints + mFarBallPoints + mRobotHomePoints + mWBPoints;
        mMessageTotalPointView.setText(getString(R.string.message_pointstotal, mPointsTotal));

    }

}
