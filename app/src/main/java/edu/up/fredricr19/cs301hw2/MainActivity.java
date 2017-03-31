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

        //Gets height and width of the screen
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;

        //Defines the surfaceview
        view = (SurfaceView)findViewById(R.id.surfaceView);
        SurfaceHolder surfaceHolder = view.getHolder();
        surfaceHolder.setFixedSize(width, height/2); //Sets size of SurfaceView

        //Declares the seekbars
        redSeekbar = (SeekBar)findViewById(R.id.red);
        greenSeekbar = (SeekBar)findViewById(R.id.green);
        blueSeekbar = (SeekBar)findViewById(R.id.blue);

        //Sets max for seekbars
        redSeekbar.setMax(255);
        greenSeekbar.setMax(255);
        blueSeekbar.setMax(255);

        //Defines the seekbar listeners
        redSeekbar.setOnSeekBarChangeListener(this);
        greenSeekbar.setOnSeekBarChangeListener(this);
        blueSeekbar.setOnSeekBarChangeListener(this);

        view.invalidate();

        currColor = Color.argb(255, redVal, greenVal, blueVal);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        //Changes seekbar value
        if(seekBar == redSeekbar){
            redVal = progress;
        }else if(seekBar == greenSeekbar){
            greenVal = progress;
        }else if(seekBar == blueSeekbar){
            blueVal = progress;
        }

        //Changes currColor value
        currColor = Color.argb(255, redVal, greenVal, blueVal);

        //Invalidates the screen
        view.invalidate();
    }

    //Not used
    @Override
    public void onStartTrackingTouch(SeekBar seekBar) { }

    //Not used
    @Override
    public void onStopTrackingTouch(SeekBar seekBar) { }
}