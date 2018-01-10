package uk.co.alphaowl.universalcontroller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import io.github.controlwear.virtual.joystick.android.JoystickView;



public class JoystickControllerActivity extends AppCompatActivity {

    //private TextView mTextViewAngle;
    //private TextView mTextViewStrength;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joystick_controller);

        //mTextViewAngle = (TextView) findViewById(R.id.textView_angle);
        //mTextViewStrength = (TextView) findViewById(R.id.textView_strength);

        JoystickView joystickView = findViewById(R.id.joystickView);
        joystickView.setOnMoveListener(new JoystickView.OnMoveListener() {
            @Override
            public void onMove(int angle, int strength) {
                //mTextViewAngle.setText(angle + "°");
                //mTextViewStrength.setText(strength + "%");
            }
        });

    }


}
