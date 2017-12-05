package uk.co.alphaowl.universalcontroller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class ChooseControllerActivity extends AppCompatActivity {

    ImageButton dpadButton;
    ImageButton joyStickButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_controller);
    }




    @Override
    protected void onResume() {
        super.onResume();

        joyStickButton= findViewById(R.id.btn_controller1);
        joyStickButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i = new Intent(getApplicationContext(),DpadControllerActivity.class);
                startActivity(i);
            }
        });

        dpadButton= findViewById(R.id.btn_controller2);
        dpadButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i = new Intent(getApplicationContext(),JoystickControllerActivity.class);
                startActivity(i);
            }
        });



    }

}

