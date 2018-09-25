package ie.ul.dave.scorecaclculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int mColourPoints = 0;
    private int mNearBallPoints = 0;
    private int mFarBallPoints = 0;
    private int mRobotHomePoints = 0;
    private int mWBPoints = 0;
    private int mPointsTotal = 0;
    private TextView mMessageColourPointsView;
    private TextView mMessageTotalPointView;
    private TextView mMessageNearBallPointsView;
    private EditText mNearBallEditTextView;
    private EditText mFareBallEditTextView;
    private EditText mRobotHomeEditTestView;


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

       mNearBallEditTextView = findViewById(R.id.mNearBallEditText);

    }

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
    public void button_reset(View view){
        mColourPoints = 0;
        mNearBallPoints = 0;
        mFarBallPoints = 0;
        mRobotHomePoints = 0;
        mWBPoints = 0;
        mPointsTotal = 0;
        updateColourPoints(mColourPoints);
        updateNearBallPointsDisplayed(mNearBallPoints);
        updateTotal();
    }

    public void button_update(View view){

        int nearBallDistanceFromEditText = 0;
        //Test for an integer
        try {
            nearBallDistanceFromEditText = Integer.parseInt(mNearBallEditTextView.getText().toString());
        } catch (NumberFormatException e)
        {
            nearBallDistanceFromEditText = 300;
        }

        if (nearBallDistanceFromEditText >=0 && nearBallDistanceFromEditText <= 5){
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





        updateTotal();

    }

    private void updateNearBallPointsDisplayed(int mNearBallPoints){
        int mNearBallPointsIn = mNearBallPoints;
        mMessageNearBallPointsView.setText(getString(R.string.message_nearballpoints,mNearBallPoints));
    }

    private void updateColourPoints(int mColourPoints){
        int mColourPointsIn = mColourPoints;
        mMessageColourPointsView.setText(getString(R.string.message_colourpts,mColourPointsIn));
    }

    //update the total
    private void updateTotal(){
        mPointsTotal = mColourPoints + mNearBallPoints;
        mMessageTotalPointView.setText(getString(R.string.message_pointstotal, mPointsTotal));

    }



}
