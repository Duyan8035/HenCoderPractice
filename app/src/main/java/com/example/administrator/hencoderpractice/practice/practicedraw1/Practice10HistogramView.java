package com.example.administrator.hencoderpractice.practice.practicedraw1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

import com.example.administrator.hencoderpractice.base.BaseView;

public class Practice10HistogramView extends BaseView {

    public Practice10HistogramView(Context context) {
        super(context);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画直方图

        paint.setStrokeWidth(3);
        paint.setColor(Color.WHITE);
        canvas.drawLines(new float[]{200, 100, 200, 800, 200, 800, 1200, 800}, paint);

        paint.setTextSize(30);
        canvas.drawText("Froyo", 250, 830, paint);
        canvas.drawText("GB", 350, 830, paint);
        canvas.drawText("ICS", 450, 830, paint);
        canvas.drawText("JB", 550, 830, paint);
        canvas.drawText("KitKat", 650, 830, paint);
        canvas.drawText("L", 750, 830, paint);
        canvas.drawText("M", 850, 830, paint);
    }
}
