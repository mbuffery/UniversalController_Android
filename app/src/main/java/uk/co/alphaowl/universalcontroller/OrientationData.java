package uk.co.alphaowl.universalcontroller;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.provider.SyncStateContract;

/**
 * Created by mbuffery on 11/28/2017.
 */

public class OrientationData implements SensorEventListener
{

        private SensorManager manager;
        private Sensor accelerometer;
        private Sensor magometer;

        private float[] accelOutput;
        private float[] magOutput;
        private float[] orientation;
        private float[] getOrientation()
        {
            return orientation;
        }

        private float[] startOrientation = null;
        public float[] getStartOrientation()
        {
            return startOrientation;
        }

        public void newGame ()
        {
            startOrientation = null;
        }

        public OrientationData(Context context)
        {
            manager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
            accelerometer = manager.getDefaultSensor(Sensor.TYPE_GRAVITY);
            magometer = manager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
        }

        public void register()
        {
            manager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_GAME);
            manager.registerListener(this, magometer, SensorManager.SENSOR_DELAY_GAME);
        }

        public void pause ()
        {
            manager.unregisterListener(this);
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }

        @Override
        public void onSensorChanged(SensorEvent event) {
            if(event.sensor.getType() == Sensor.TYPE_ACCELEROMETER)
            {
                accelOutput = event.values;
            }else if (event.sensor.getType() == Sensor.TYPE_MAGNETIC_FIELD)
            {
                magOutput = event.values;
            }
            if (accelOutput != null && magOutput != null)
            {
                float[] R = new float[9];
                float[] I = new float[9];
                boolean success = SensorManager.getRotationMatrix(R, I, accelOutput, magOutput);
                if (success)
                {
                    SensorManager.getOrientation(R, orientation);
                    if (startOrientation == null)
                    {
                        startOrientation = new float[orientation.length];
                        System.arraycopy(orientation, 0, startOrientation, 0, orientation.length);
                    }
                }
            }



        }

}
