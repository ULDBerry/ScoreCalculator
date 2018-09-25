package ie.ul.dave.scorecaclculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

     //Setup initial values to display
        mMessageColourPointsView = findViewById(R.id.message_colorptsfin);
        mMessageColourPointsView.setText(getString(R.string.message_colourpts,mColourPoints));

        mMessageTotalPointView = findViewById(R.id.message_totalpoints);
        mMessageTotalPointView.setText(getString(R.string.message_pointstotal, mPointsTotal));


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

    private void updateTotal(){
        mPointsTotal = mColourPoints;
        mMessageTotalPointView.setText(getString(R.string.message_pointstotal, mPointsTotal));

    }

}
