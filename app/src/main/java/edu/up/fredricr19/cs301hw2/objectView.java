package edu.up.fredricr19.cs301hw2;

import android.content.Context;
import android.graphics.Canvas;
import android.view.SurfaceView;

public class objectView extends SurfaceView {
    CustomElement[] circles = new CustomElement[6];

    public objectView(Context context) {
        super(context);

        circles[0] = new CustomCircle("Left", 0xFF0000, 50, 50, 25);
        circles[1] = new CustomCircle("Right", 0xFF0000, 100, 50, 25);
    }

    @Override
    protected void onDraw(Canvas canvas){
        for(int i = 0; i < circles.length; i++){
            if(circles[i] == null) break;
            circles[i].drawMe(canvas);
        }
    }
}
