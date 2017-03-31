package edu.up.fredricr19.cs301hw2;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;

public class objectView extends SurfaceView implements View.OnTouchListener {
    CustomElement[] circles = new CustomElement[6];

    public objectView(Context context, AttributeSet attrs) {
        super(context, attrs);

        setBackgroundColor(0xFFFFFFFF);

        circles[0] = new CustomCircle("Left", 0xFF00FF00, 100, 100, 50);
        circles[1] = new CustomCircle("Right", 0xFF00FF00, 300, 100, 50);
        circles[2] = new CustomCircle("Middle", 0xFF00FF00, 200, 200, 50);
        circles[3] = new CustomCircle("BottomLeft", 0xFF00FF00, 100, 350, 50);
        circles[4] = new CustomCircle("BottomRight", 0xFF00FF00, 300, 350, 50);
    }

    @Override
    protected void onDraw(Canvas canvas){
        for(int i = 0; i < circles.length; i++){
            if(circles[i] == null) break;
            circles[i].drawMe(canvas);
        }
        this.invalidate();
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        for(CustomElement obj : circles) {
            if(obj.containsPoint((int)event.getX(), (int)event.getY())){
                obj = new CustomCircle(obj.getName(), new MainActivity().currColor, (int)event.getX(), (int)event.getY(), 50);
                return true;
            }
        }
        return false;
    }
}
