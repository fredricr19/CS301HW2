package edu.up.fredricr19.cs301hw2;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.LinearLayout;
import android.widget.SeekBar;

public class MainActivity extends Activity implements SeekBar.OnSeekBarChangeListener {
    SurfaceView view;
    LinearLayout layout;

    SeekBar redSeekbar;
    SeekBar greenSeekbar;
    SeekBar blueSeekbar;

    int redVal = 0;
    int greenVal = 0;
    int blueVal = 0;

    int currColor;
    Paint paint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;

        view = (SurfaceView)findViewById(R.id.surfaceView);
        SurfaceHolder surfaceHolder = view.getHolder();
        surfaceHolder.setFixedSize(width, height/2);

        redSeekbar = (SeekBar)findViewById(R.id.red);
        greenSeekbar = (SeekBar)findViewById(R.id.green);
        blueSeekbar = (SeekBar)findViewById(R.id.blue);

        redSeekbar.setMax(255);
        greenSeekbar.setMax(255);
        blueSeekbar.setMax(255);

        redSeekbar.setOnSeekBarChangeListener(this);
        greenSeekbar.setOnSeekBarChangeListener(this);
        blueSeekbar.setOnSeekBarChangeListener(this);

        view.invalidate();

        currColor = Color.argb(255, redVal, greenVal, blueVal);
        //paint.setColor(currColor);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        if(seekBar == redSeekbar){
            redVal = progress;
        }else if(seekBar == greenSeekbar){
            greenVal = progress;
        }else if(seekBar == blueSeekbar){
            blueVal = progress;
        }

        currColor = Color.argb(255, redVal, greenVal, blueVal);
        //paint.setColor(currColor);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) { }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) { }
}