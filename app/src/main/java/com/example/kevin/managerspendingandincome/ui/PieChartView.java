package com.example.kevin.managerspendingandincome.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.kevin.managerspendingandincome.javabean.AssetsEntity;
import com.example.kevin.managerspendingandincome.utils.Print;

import java.util.List;

/**
 * Created by kevin on 2018/3/31.
 * https://github.com/yinkaiwen
 */

public class PieChartView extends View {
    private static final String tag = PieChartView.class.getSimpleName();

    private RectF mRectF;
    private Paint mPaint;
    private int mWidth;
    private int mHeight;

    private List<AssetsEntity> mData;
    public static final int[] sPaintColor = {
            0xFFCCFF00, 0xFF6495ED, 0xFFE32636, 0xFF800000, 0xFF808000, 0xFFFF8C69, 0xFF808080,
            0xFFE6B800, 0xFF7CFC00
    };

    public PieChartView(Context context) {
        super(context);
        init();
    }

    public PieChartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PieChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mRectF = new RectF();

        mPaint = new Paint();
        mPaint.setAntiAlias(true);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        mWidth = w - getPaddingLeft() - getPaddingRight();
        mHeight = h - getPaddingTop() - getPaddingBottom();

        float mRadius = (float) (Math.min(w, h) / 2 * 0.7);
        mRectF.left = -mRadius;
        mRectF.right = mRadius;
        mRectF.top = -mRadius;
        mRectF.bottom = mRadius;

        setMinimumHeight(mWidth);
        Print.d(tag, String.format("宽： %s,高：%s", mWidth, mHeight));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mData == null || mData.size() == 0)
            return;

        canvas.translate(mWidth / 2, mHeight / 2);
//        mPaint.setColor(sPaintColor[2]);
//        canvas.drawArc(mRectF, 0, 360, true, mPaint);
        drawArc(canvas);
    }

    /**
     * 绘制饼状图
     *
     * @param canvas
     */
    private void drawArc(Canvas canvas) {
        float total = getTotalFromData();

        float startAngle = 0f;
        float sweepAngle;

        for (int i = 0; i < mData.size(); i++) {

            float f = mData.get(i).data;
            sweepAngle = f / total * 360;
            setPaintColor(i);
            Print.d(tag, String.format("start : %s , sweep : %s", startAngle, sweepAngle));
            canvas.drawArc(mRectF, startAngle, sweepAngle, true, mPaint);
            startAngle += sweepAngle;
        }

    }


    private float getTotalFromData() {
        float total = 0;
        for (AssetsEntity e : mData) {
            total += e.data;
        }
        return total;
    }

    private void setPaintColor(int index) {
        mPaint.setColor(sPaintColor[index % sPaintColor.length]);
    }

    public void setData(@NonNull List<AssetsEntity> data) {
        mData = data;
    }
}
