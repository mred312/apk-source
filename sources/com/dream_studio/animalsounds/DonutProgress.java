package com.dream_studio.animalsounds;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.app.NotificationCompat;

public class DonutProgress extends View {

    /* renamed from: A */
    private final int f6562A;

    /* renamed from: B */
    private final float f6563B;

    /* renamed from: C */
    private final float f6564C;

    /* renamed from: D */
    private final int f6565D;

    /* renamed from: E */
    private final Boolean f6566E;

    /* renamed from: a */
    private Paint f6567a;

    /* renamed from: b */
    private Paint f6568b;

    /* renamed from: c */
    private Paint f6569c;

    /* renamed from: d */
    private RectF f6570d;

    /* renamed from: e */
    private RectF f6571e;

    /* renamed from: f */
    private float f6572f;

    /* renamed from: g */
    private int f6573g;

    /* renamed from: h */
    private int f6574h;

    /* renamed from: i */
    private int f6575i;
    protected Paint innerBottomTextPaint;

    /* renamed from: j */
    private int f6576j;

    /* renamed from: k */
    private int f6577k;

    /* renamed from: l */
    private int f6578l;

    /* renamed from: m */
    private float f6579m;

    /* renamed from: n */
    private float f6580n;

    /* renamed from: o */
    private int f6581o;

    /* renamed from: p */
    private String f6582p;

    /* renamed from: q */
    private String f6583q;

    /* renamed from: r */
    private String f6584r;

    /* renamed from: s */
    private float f6585s;

    /* renamed from: t */
    private String f6586t;
    protected Paint textPaint;

    /* renamed from: u */
    private float f6587u;

    /* renamed from: v */
    private Boolean f6588v;

    /* renamed from: w */
    private final float f6589w;

    /* renamed from: x */
    private final int f6590x;

    /* renamed from: y */
    private final int f6591y;

    /* renamed from: z */
    private final int f6592z;

    public DonutProgress(Context context) {
        this(context, (AttributeSet) null);
    }

    /* renamed from: a */
    private int m4804a(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode == 1073741824) {
            return size;
        }
        int i2 = this.f6565D;
        return mode == Integer.MIN_VALUE ? Math.min(i2, size) : i2;
    }

    public static float dp2px(Resources resources, float f) {
        return (f * resources.getDisplayMetrics().density) + 0.5f;
    }

    private float getProgressAngle() {
        return (((float) getProgress()) / ((float) this.f6576j)) * 360.0f;
    }

    public static float sp2px(Resources resources, float f) {
        return f * resources.getDisplayMetrics().scaledDensity;
    }

    public int getFinishedStrokeColor() {
        return this.f6577k;
    }

    public float getFinishedStrokeWidth() {
        return this.f6579m;
    }

    public int getInnerBackgroundColor() {
        return this.f6581o;
    }

    public String getInnerBottomText() {
        return this.f6586t;
    }

    public int getInnerBottomTextColor() {
        return this.f6574h;
    }

    public float getInnerBottomTextSize() {
        return this.f6585s;
    }

    public Boolean getInnerShowText() {
        return this.f6588v;
    }

    public int getMax() {
        return this.f6576j;
    }

    public String getPrefixText() {
        return this.f6582p;
    }

    public int getProgress() {
        return this.f6575i;
    }

    public String getSuffixText() {
        return this.f6583q;
    }

    public String getText() {
        return this.f6584r;
    }

    public int getTextColor() {
        return this.f6573g;
    }

    public float getTextSize() {
        return this.f6572f;
    }

    public int getUnfinishedStrokeColor() {
        return this.f6578l;
    }

    public float getUnfinishedStrokeWidth() {
        return this.f6580n;
    }

    /* access modifiers changed from: protected */
    public void initByAttributes(TypedArray typedArray) {
        this.f6577k = typedArray.getColor(1, this.f6590x);
        this.f6578l = typedArray.getColor(14, this.f6591y);
        this.f6573g = typedArray.getColor(12, this.f6592z);
        this.f6572f = typedArray.getDimension(13, this.f6563B);
        this.f6588v = Boolean.valueOf(typedArray.getBoolean(9, this.f6566E.booleanValue()));
        setMax(typedArray.getInt(6, 100));
        setProgress(typedArray.getInt(8, 0));
        this.f6579m = typedArray.getDimension(2, this.f6589w);
        this.f6580n = typedArray.getDimension(15, this.f6589w);
        if (typedArray.getString(7) != null) {
            this.f6582p = typedArray.getString(7);
        }
        if (typedArray.getString(10) != null) {
            this.f6583q = typedArray.getString(10);
        }
        if (typedArray.getString(11) != null) {
            this.f6584r = typedArray.getString(11);
        }
        this.f6581o = typedArray.getColor(0, 0);
        this.f6585s = typedArray.getDimension(5, this.f6564C);
        this.f6574h = typedArray.getColor(4, this.f6562A);
        this.f6586t = typedArray.getString(3);
    }

    /* access modifiers changed from: protected */
    public void initPainters() {
        TextPaint textPaint2 = new TextPaint();
        this.textPaint = textPaint2;
        textPaint2.setColor(this.f6573g);
        this.textPaint.setTextSize(this.f6572f);
        this.textPaint.setAntiAlias(true);
        TextPaint textPaint3 = new TextPaint();
        this.innerBottomTextPaint = textPaint3;
        textPaint3.setColor(this.f6574h);
        this.innerBottomTextPaint.setTextSize(this.f6585s);
        this.innerBottomTextPaint.setAntiAlias(true);
        Paint paint = new Paint();
        this.f6567a = paint;
        paint.setColor(this.f6577k);
        this.f6567a.setStyle(Paint.Style.STROKE);
        this.f6567a.setAntiAlias(true);
        this.f6567a.setStrokeWidth(this.f6579m);
        Paint paint2 = new Paint();
        this.f6568b = paint2;
        paint2.setColor(this.f6578l);
        this.f6568b.setStyle(Paint.Style.STROKE);
        this.f6568b.setAntiAlias(true);
        this.f6568b.setStrokeWidth(this.f6580n);
        Paint paint3 = new Paint();
        this.f6569c = paint3;
        paint3.setColor(this.f6581o);
        this.f6569c.setAntiAlias(true);
    }

    public void invalidate() {
        initPainters();
        super.invalidate();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float max = Math.max(this.f6579m, this.f6580n);
        this.f6570d.set(max, max, ((float) getWidth()) - max, ((float) getHeight()) - max);
        this.f6571e.set(max, max, ((float) getWidth()) - max, ((float) getHeight()) - max);
        canvas.drawCircle(((float) getWidth()) / 2.0f, ((float) getHeight()) / 2.0f, ((((float) getWidth()) - Math.min(this.f6579m, this.f6580n)) + Math.abs(this.f6579m - this.f6580n)) / 2.0f, this.f6569c);
        canvas.drawArc(this.f6570d, 0.0f, getProgressAngle(), false, this.f6567a);
        canvas.drawArc(this.f6571e, getProgressAngle(), 360.0f - getProgressAngle(), false, this.f6568b);
        if (this.f6588v.booleanValue()) {
            int i = this.f6576j - this.f6575i;
            String str = this.f6584r;
            if (str == null) {
                str = this.f6582p + i + this.f6583q;
            }
            if (!TextUtils.isEmpty(str)) {
                canvas.drawText(str, (((float) getWidth()) - this.textPaint.measureText(str)) / 2.0f, (((float) getWidth()) - (this.textPaint.descent() + this.textPaint.ascent())) / 2.0f, this.textPaint);
            }
            if (!TextUtils.isEmpty(getInnerBottomText())) {
                this.innerBottomTextPaint.setTextSize(this.f6585s);
                canvas.drawText(getInnerBottomText(), (((float) getWidth()) - this.innerBottomTextPaint.measureText(getInnerBottomText())) / 2.0f, (((float) getHeight()) - this.f6587u) - ((this.textPaint.descent() + this.textPaint.ascent()) / 2.0f), this.innerBottomTextPaint);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        setMeasuredDimension(m4804a(i), m4804a(i2));
        this.f6587u = (float) (getHeight() - ((getHeight() * 3) / 4));
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.f6573g = bundle.getInt("text_color");
            this.f6572f = bundle.getFloat("text_size");
            this.f6585s = bundle.getFloat("inner_bottom_text_size");
            this.f6586t = bundle.getString("inner_bottom_text");
            this.f6574h = bundle.getInt("inner_bottom_text_color");
            this.f6577k = bundle.getInt("finished_stroke_color");
            this.f6578l = bundle.getInt("unfinished_stroke_color");
            this.f6579m = bundle.getFloat("finished_stroke_width");
            this.f6580n = bundle.getFloat("unfinished_stroke_width");
            this.f6581o = bundle.getInt("inner_background_color");
            initPainters();
            setMax(bundle.getInt("max"));
            setProgress(bundle.getInt(NotificationCompat.CATEGORY_PROGRESS));
            this.f6582p = bundle.getString("prefix");
            this.f6583q = bundle.getString("suffix");
            this.f6584r = bundle.getString("text");
            this.f6588v = Boolean.valueOf(bundle.getBoolean("inner_show_text"));
            super.onRestoreInstanceState(bundle.getParcelable("saved_instance"));
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("saved_instance", super.onSaveInstanceState());
        bundle.putInt("text_color", getTextColor());
        bundle.putFloat("text_size", getTextSize());
        bundle.putFloat("inner_bottom_text_size", getInnerBottomTextSize());
        bundle.putFloat("inner_bottom_text_color", (float) getInnerBottomTextColor());
        bundle.putString("inner_bottom_text", getInnerBottomText());
        bundle.putInt("inner_bottom_text_color", getInnerBottomTextColor());
        bundle.putInt("finished_stroke_color", getFinishedStrokeColor());
        bundle.putInt("unfinished_stroke_color", getUnfinishedStrokeColor());
        bundle.putInt("max", getMax());
        bundle.putInt(NotificationCompat.CATEGORY_PROGRESS, getProgress());
        bundle.putString("suffix", getSuffixText());
        bundle.putString("prefix", getPrefixText());
        bundle.putString("text", getText());
        bundle.putFloat("finished_stroke_width", getFinishedStrokeWidth());
        bundle.putFloat("unfinished_stroke_width", getUnfinishedStrokeWidth());
        bundle.putInt("inner_background_color", getInnerBackgroundColor());
        bundle.putBoolean("inner_show_text", getInnerShowText().booleanValue());
        return bundle;
    }

    public void setFinishedStrokeColor(int i) {
        this.f6577k = i;
        invalidate();
    }

    public void setFinishedStrokeWidth(float f) {
        this.f6579m = f;
        invalidate();
    }

    public void setInnerBackgroundColor(int i) {
        this.f6581o = i;
        invalidate();
    }

    public void setInnerBottomText(String str) {
        this.f6586t = str;
        invalidate();
    }

    public void setInnerBottomTextColor(int i) {
        this.f6574h = i;
        invalidate();
    }

    public void setInnerBottomTextSize(float f) {
        this.f6585s = f;
        invalidate();
    }

    public void setMax(int i) {
        if (i > 0) {
            this.f6576j = i;
            invalidate();
        }
    }

    public void setPrefixText(String str) {
        this.f6582p = str;
        invalidate();
    }

    public void setProgress(int i) {
        this.f6575i = i;
        if (i > getMax()) {
            this.f6575i %= getMax();
        }
        invalidate();
    }

    public void setSuffixText(String str) {
        this.f6583q = str;
        invalidate();
    }

    public void setText(String str) {
        this.f6584r = str;
        invalidate();
    }

    public void setTextColor(int i) {
        this.f6573g = i;
        invalidate();
    }

    public void setTextSize(float f) {
        this.f6572f = f;
        invalidate();
    }

    public void setUnfinishedStrokeColor(int i) {
        this.f6578l = i;
        invalidate();
    }

    public void setUnfinishedStrokeWidth(float f) {
        this.f6580n = f;
        invalidate();
    }

    public DonutProgress(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DonutProgress(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f6570d = new RectF();
        this.f6571e = new RectF();
        this.f6575i = 0;
        this.f6582p = "";
        this.f6583q = "%";
        this.f6584r = null;
        this.f6590x = Color.rgb(66, 145, 241);
        this.f6591y = Color.rgb(204, 204, 204);
        this.f6592z = Color.rgb(66, 145, 241);
        this.f6562A = Color.rgb(66, 145, 241);
        this.f6566E = Boolean.FALSE;
        this.f6563B = sp2px(getResources(), 18.0f);
        this.f6565D = (int) dp2px(getResources(), 100.0f);
        this.f6589w = dp2px(getResources(), 10.0f);
        this.f6564C = sp2px(getResources(), 18.0f);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, C1441R.styleable.DonutProgress, i, 0);
        initByAttributes(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        initPainters();
    }
}
