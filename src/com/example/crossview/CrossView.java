package com.example.crossview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class CrossView extends View {

	public static final int DEFAULT_SIZE = 100;
	Paint mPaint = new Paint();
	float mPoints[] = { .5f, 0f, .5f, 1f, 0f, .5f, 1f, .5f };

	public CrossView(Context context, AttributeSet attrs) {
		super(context, attrs);
		mPaint.setAntiAlias(true);
		mPaint.setColor(0xFFFFFFFF);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		// TODO Auto-generated method stub
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		setMeasuredDimension(calculateMeasure(widthMeasureSpec),
				calculateMeasure(heightMeasureSpec));
	}

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);

		canvas.save();

		int scale = getWidth();

		canvas.scale(scale, scale);
		canvas.drawLines(mPoints, mPaint);

		canvas.restore();
	}

	int calculateMeasure(int measureSpec) {
		int result = (int) (DEFAULT_SIZE * getResources().getDisplayMetrics().density);
		int specMode = MeasureSpec.getMode(measureSpec);
		int specSize = MeasureSpec.getSize(measureSpec);

		if (specMode == MeasureSpec.EXACTLY) {
			result = specSize;
		} else if (specMode == MeasureSpec.AT_MOST) {
			result = Math.min(result, specSize);
		}
		return result;
	}

}
