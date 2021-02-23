package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.C0131R;
import java.lang.ref.WeakReference;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class ViewStubCompat extends View {

    /* renamed from: a */
    private int f1606a;

    /* renamed from: b */
    private int f1607b;

    /* renamed from: c */
    private WeakReference<View> f1608c;

    /* renamed from: d */
    private LayoutInflater f1609d;

    /* renamed from: e */
    private OnInflateListener f1610e;

    public interface OnInflateListener {
        void onInflate(ViewStubCompat viewStubCompat, View view);
    }

    public ViewStubCompat(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
    }

    @SuppressLint({"MissingSuperCall"})
    public void draw(Canvas canvas) {
    }

    public int getInflatedId() {
        return this.f1607b;
    }

    public LayoutInflater getLayoutInflater() {
        return this.f1609d;
    }

    public int getLayoutResource() {
        return this.f1606a;
    }

    public View inflate() {
        ViewParent parent = getParent();
        if (!(parent instanceof ViewGroup)) {
            throw new IllegalStateException("ViewStub must have a non-null ViewGroup viewParent");
        } else if (this.f1606a != 0) {
            ViewGroup viewGroup = (ViewGroup) parent;
            LayoutInflater layoutInflater = this.f1609d;
            if (layoutInflater == null) {
                layoutInflater = LayoutInflater.from(getContext());
            }
            View inflate = layoutInflater.inflate(this.f1606a, viewGroup, false);
            int i = this.f1607b;
            if (i != -1) {
                inflate.setId(i);
            }
            int indexOfChild = viewGroup.indexOfChild(this);
            viewGroup.removeViewInLayout(this);
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams != null) {
                viewGroup.addView(inflate, indexOfChild, layoutParams);
            } else {
                viewGroup.addView(inflate, indexOfChild);
            }
            this.f1608c = new WeakReference<>(inflate);
            OnInflateListener onInflateListener = this.f1610e;
            if (onInflateListener != null) {
                onInflateListener.onInflate(this, inflate);
            }
            return inflate;
        } else {
            throw new IllegalArgumentException("ViewStub must have a valid layoutResource");
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        setMeasuredDimension(0, 0);
    }

    public void setInflatedId(int i) {
        this.f1607b = i;
    }

    public void setLayoutInflater(LayoutInflater layoutInflater) {
        this.f1609d = layoutInflater;
    }

    public void setLayoutResource(int i) {
        this.f1606a = i;
    }

    public void setOnInflateListener(OnInflateListener onInflateListener) {
        this.f1610e = onInflateListener;
    }

    public void setVisibility(int i) {
        WeakReference<View> weakReference = this.f1608c;
        if (weakReference != null) {
            View view = (View) weakReference.get();
            if (view != null) {
                view.setVisibility(i);
                return;
            }
            throw new IllegalStateException("setVisibility called on un-referenced view");
        }
        super.setVisibility(i);
        if (i == 0 || i == 4) {
            inflate();
        }
    }

    public ViewStubCompat(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1606a = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0131R.styleable.ViewStubCompat, i, 0);
        this.f1607b = obtainStyledAttributes.getResourceId(C0131R.styleable.ViewStubCompat_android_inflatedId, -1);
        this.f1606a = obtainStyledAttributes.getResourceId(C0131R.styleable.ViewStubCompat_android_layout, 0);
        setId(obtainStyledAttributes.getResourceId(C0131R.styleable.ViewStubCompat_android_id, -1));
        obtainStyledAttributes.recycle();
        setVisibility(8);
        setWillNotDraw(true);
    }
}
