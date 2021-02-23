package androidx.appcompat.widget;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.appcompat.C0131R;
import com.google.firebase.crashlytics.internal.common.AbstractSpiCall;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* renamed from: androidx.appcompat.widget.q */
/* compiled from: TooltipPopup */
class C0341q {

    /* renamed from: a */
    private final Context f1727a;

    /* renamed from: b */
    private final View f1728b;

    /* renamed from: c */
    private final TextView f1729c;

    /* renamed from: d */
    private final WindowManager.LayoutParams f1730d;

    /* renamed from: e */
    private final Rect f1731e = new Rect();

    /* renamed from: f */
    private final int[] f1732f = new int[2];

    /* renamed from: g */
    private final int[] f1733g = new int[2];

    C0341q(@NonNull Context context) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.f1730d = layoutParams;
        this.f1727a = context;
        View inflate = LayoutInflater.from(context).inflate(C0131R.layout.abc_tooltip, (ViewGroup) null);
        this.f1728b = inflate;
        this.f1729c = (TextView) inflate.findViewById(C0131R.C0133id.message);
        layoutParams.setTitle(C0341q.class.getSimpleName());
        layoutParams.packageName = context.getPackageName();
        layoutParams.type = 1002;
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.format = -3;
        layoutParams.windowAnimations = C0131R.style.Animation_AppCompat_Tooltip;
        layoutParams.flags = 24;
    }

    /* renamed from: a */
    private void m1170a(View view, int i, int i2, boolean z, WindowManager.LayoutParams layoutParams) {
        int i3;
        int i4;
        layoutParams.token = view.getApplicationWindowToken();
        int dimensionPixelOffset = this.f1727a.getResources().getDimensionPixelOffset(C0131R.dimen.tooltip_precise_anchor_threshold);
        if (view.getWidth() < dimensionPixelOffset) {
            i = view.getWidth() / 2;
        }
        if (view.getHeight() >= dimensionPixelOffset) {
            int dimensionPixelOffset2 = this.f1727a.getResources().getDimensionPixelOffset(C0131R.dimen.tooltip_precise_anchor_extra_offset);
            i4 = i2 + dimensionPixelOffset2;
            i3 = i2 - dimensionPixelOffset2;
        } else {
            i4 = view.getHeight();
            i3 = 0;
        }
        layoutParams.gravity = 49;
        int dimensionPixelOffset3 = this.f1727a.getResources().getDimensionPixelOffset(z ? C0131R.dimen.tooltip_y_offset_touch : C0131R.dimen.tooltip_y_offset_non_touch);
        View b = m1171b(view);
        if (b == null) {
            Log.e("TooltipPopup", "Cannot find app view");
            return;
        }
        b.getWindowVisibleDisplayFrame(this.f1731e);
        Rect rect = this.f1731e;
        if (rect.left < 0 && rect.top < 0) {
            Resources resources = this.f1727a.getResources();
            int identifier = resources.getIdentifier("status_bar_height", "dimen", AbstractSpiCall.ANDROID_CLIENT_TYPE);
            int dimensionPixelSize = identifier != 0 ? resources.getDimensionPixelSize(identifier) : 0;
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            this.f1731e.set(0, dimensionPixelSize, displayMetrics.widthPixels, displayMetrics.heightPixels);
        }
        b.getLocationOnScreen(this.f1733g);
        view.getLocationOnScreen(this.f1732f);
        int[] iArr = this.f1732f;
        int i5 = iArr[0];
        int[] iArr2 = this.f1733g;
        iArr[0] = i5 - iArr2[0];
        iArr[1] = iArr[1] - iArr2[1];
        layoutParams.x = (iArr[0] + i) - (b.getWidth() / 2);
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.f1728b.measure(makeMeasureSpec, makeMeasureSpec);
        int measuredHeight = this.f1728b.getMeasuredHeight();
        int[] iArr3 = this.f1732f;
        int i6 = ((iArr3[1] + i3) - dimensionPixelOffset3) - measuredHeight;
        int i7 = iArr3[1] + i4 + dimensionPixelOffset3;
        if (z) {
            if (i6 >= 0) {
                layoutParams.y = i6;
            } else {
                layoutParams.y = i7;
            }
        } else if (measuredHeight + i7 <= this.f1731e.height()) {
            layoutParams.y = i7;
        } else {
            layoutParams.y = i6;
        }
    }

    /* renamed from: b */
    private static View m1171b(View view) {
        View rootView = view.getRootView();
        ViewGroup.LayoutParams layoutParams = rootView.getLayoutParams();
        if ((layoutParams instanceof WindowManager.LayoutParams) && ((WindowManager.LayoutParams) layoutParams).type == 2) {
            return rootView;
        }
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return ((Activity) context).getWindow().getDecorView();
            }
        }
        return rootView;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo3092c() {
        if (mo3093d()) {
            ((WindowManager) this.f1727a.getSystemService("window")).removeView(this.f1728b);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public boolean mo3093d() {
        return this.f1728b.getParent() != null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo3094e(View view, int i, int i2, boolean z, CharSequence charSequence) {
        if (mo3093d()) {
            mo3092c();
        }
        this.f1729c.setText(charSequence);
        m1170a(view, i, i2, z, this.f1730d);
        ((WindowManager) this.f1727a.getSystemService("window")).addView(this.f1728b, this.f1730d);
    }
}
