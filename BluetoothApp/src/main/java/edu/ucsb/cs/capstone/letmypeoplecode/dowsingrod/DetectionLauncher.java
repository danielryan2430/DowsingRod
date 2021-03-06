package edu.ucsb.cs.capstone.letmypeoplecode.dowsingrod;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;

import  edu.ucsb.cs.capstone.letmypeoplecode.dowsingrod.util.SystemUiHider;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 *
 * @see SystemUiHider
 */
public class DetectionLauncher extends Activity {
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detection_launcher);
        final View contentView = findViewById(R.id.fullscreen_content);

    }
    public void genSound(View view) {

        final NoiseGenerator noise = new NoiseGenerator();
        final Thread thread = new Thread(new Runnable() {
            public void run() {
                noise.genTone();
                handler.post(new Runnable() {

                    public void run() {
                        noise.playSound();
                    }
                });
            }
        });
        thread.start();
    }


}
