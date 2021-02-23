package androidx.appcompat.widget;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.appcompat.C0131R;
import androidx.core.widget.PopupWindowCompat;

/* renamed from: androidx.appcompat.widget.e */
/* compiled from: AppCompatPopupWindow */
class C0320e extends PopupWindow {

    /* renamed from: b */
    private static final boolean f1625b = (Build.VERSION.SDK_INT < 21);

    /* renamed from: a */
    private boolean f1626a;

    public C0320e(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i, @StyleRes int i2) {
        super(context, attributeSet, i, i2);
        m1046a(context, attributeSet, i, i2);
    }

    /* renamed from: a */
    private void m1046a(Context context, AttributeSet attributeSet, int i, int i2) {
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, C0131R.styleable.PopupWindow, i, i2);
        int i3 = C0131R.styleable.PopupWindow_overlapAnchor;
        if (obtainStyledAttributes.hasValue(i3)) {
            m1047b(obtainStyledAttributes.getBoolean(i3, false));
        }
        setBackgroundDrawable(obtainStyledAttributes.getDrawable(C0131R.styleable.PopupWindow_android_popupBackground));
        obtainStyledAttributes.recycle();
    }

    /* renamed from: b */
    private void m1047b(boolean z) {
        if (f1625b) {
            this.f1626a = z;
        } else {
            PopupWindowCompat.setOverlapAnchor(this, z);
        }
    }

    public void showAsDropDown(View view, int i, int i2) {
        if (f1625b && this.f1626a) {
            i2 -= view.getHeight();
        }
        super.showAsDropDown(view, i, i2);
    }

    public void update(View view, int i, int i2, int i3, int i4) {
        if (f1625b && this.f1626a) {
            i2 -= view.getHeight();
        }
        super.update(view, i, i2, i3, i4);
    }

    public void showAsDropDown(View view, int i, int i2, int i3) {
        if (f1625b && this.f1626a) {
            i2 -= view.getHeight();
        }
        super.showAsDropDown(view, i, i2, i3);
    }
}
