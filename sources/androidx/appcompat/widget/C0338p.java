package androidx.appcompat.widget;

import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewConfigurationCompat;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* renamed from: androidx.appcompat.widget.p */
/* compiled from: TooltipCompatHandler */
class C0338p implements View.OnLongClickListener, View.OnHoverListener, View.OnAttachStateChangeListener {

    /* renamed from: j */
    private static C0338p f1714j;

    /* renamed from: k */
    private static C0338p f1715k;

    /* renamed from: a */
    private final View f1716a;

    /* renamed from: b */
    private final CharSequence f1717b;

    /* renamed from: c */
    private final int f1718c;

    /* renamed from: d */
    private final Runnable f1719d = new C0339a();

    /* renamed from: e */
    private final Runnable f1720e = new C0340b();

    /* renamed from: f */
    private int f1721f;

    /* renamed from: g */
    private int f1722g;

    /* renamed from: h */
    private C0341q f1723h;

    /* renamed from: i */
    private boolean f1724i;

    /* renamed from: androidx.appcompat.widget.p$a */
    /* compiled from: TooltipCompatHandler */
    class C0339a implements Runnable {
        C0339a() {
        }

        public void run() {
            C0338p.this.mo3085g(false);
        }
    }

    /* renamed from: androidx.appcompat.widget.p$b */
    /* compiled from: TooltipCompatHandler */
    class C0340b implements Runnable {
        C0340b() {
        }

        public void run() {
            C0338p.this.mo3084c();
        }
    }

    private C0338p(View view, CharSequence charSequence) {
        this.f1716a = view;
        this.f1717b = charSequence;
        this.f1718c = ViewConfigurationCompat.getScaledHoverSlop(ViewConfiguration.get(view.getContext()));
        m1163b();
        view.setOnLongClickListener(this);
        view.setOnHoverListener(this);
    }

    /* renamed from: a */
    private void m1162a() {
        this.f1716a.removeCallbacks(this.f1719d);
    }

    /* renamed from: b */
    private void m1163b() {
        this.f1721f = Integer.MAX_VALUE;
        this.f1722g = Integer.MAX_VALUE;
    }

    /* renamed from: d */
    private void m1164d() {
        this.f1716a.postDelayed(this.f1719d, (long) ViewConfiguration.getLongPressTimeout());
    }

    /* renamed from: e */
    private static void m1165e(C0338p pVar) {
        C0338p pVar2 = f1714j;
        if (pVar2 != null) {
            pVar2.m1162a();
        }
        f1714j = pVar;
        if (pVar != null) {
            pVar.m1164d();
        }
    }

    /* renamed from: f */
    public static void m1166f(View view, CharSequence charSequence) {
        C0338p pVar = f1714j;
        if (pVar != null && pVar.f1716a == view) {
            m1165e((C0338p) null);
        }
        if (TextUtils.isEmpty(charSequence)) {
            C0338p pVar2 = f1715k;
            if (pVar2 != null && pVar2.f1716a == view) {
                pVar2.mo3084c();
            }
            view.setOnLongClickListener((View.OnLongClickListener) null);
            view.setLongClickable(false);
            view.setOnHoverListener((View.OnHoverListener) null);
            return;
        }
        new C0338p(view, charSequence);
    }

    /* renamed from: h */
    private boolean m1167h(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (Math.abs(x - this.f1721f) <= this.f1718c && Math.abs(y - this.f1722g) <= this.f1718c) {
            return false;
        }
        this.f1721f = x;
        this.f1722g = y;
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo3084c() {
        if (f1715k == this) {
            f1715k = null;
            C0341q qVar = this.f1723h;
            if (qVar != null) {
                qVar.mo3092c();
                this.f1723h = null;
                m1163b();
                this.f1716a.removeOnAttachStateChangeListener(this);
            } else {
                Log.e("TooltipCompatHandler", "sActiveHandler.mPopup == null");
            }
        }
        if (f1714j == this) {
            m1165e((C0338p) null);
        }
        this.f1716a.removeCallbacks(this.f1720e);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public void mo3085g(boolean z) {
        long j;
        int i;
        long j2;
        if (ViewCompat.isAttachedToWindow(this.f1716a)) {
            m1165e((C0338p) null);
            C0338p pVar = f1715k;
            if (pVar != null) {
                pVar.mo3084c();
            }
            f1715k = this;
            this.f1724i = z;
            C0341q qVar = new C0341q(this.f1716a.getContext());
            this.f1723h = qVar;
            qVar.mo3094e(this.f1716a, this.f1721f, this.f1722g, this.f1724i, this.f1717b);
            this.f1716a.addOnAttachStateChangeListener(this);
            if (this.f1724i) {
                j = 2500;
            } else {
                if ((ViewCompat.getWindowSystemUiVisibility(this.f1716a) & 1) == 1) {
                    j2 = 3000;
                    i = ViewConfiguration.getLongPressTimeout();
                } else {
                    j2 = 15000;
                    i = ViewConfiguration.getLongPressTimeout();
                }
                j = j2 - ((long) i);
            }
            this.f1716a.removeCallbacks(this.f1720e);
            this.f1716a.postDelayed(this.f1720e, j);
        }
    }

    public boolean onHover(View view, MotionEvent motionEvent) {
        if (this.f1723h != null && this.f1724i) {
            return false;
        }
        AccessibilityManager accessibilityManager = (AccessibilityManager) this.f1716a.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 7) {
            if (action == 10) {
                m1163b();
                mo3084c();
            }
        } else if (this.f1716a.isEnabled() && this.f1723h == null && m1167h(motionEvent)) {
            m1165e(this);
        }
        return false;
    }

    public boolean onLongClick(View view) {
        this.f1721f = view.getWidth() / 2;
        this.f1722g = view.getHeight() / 2;
        mo3085g(true);
        return true;
    }

    public void onViewAttachedToWindow(View view) {
    }

    public void onViewDetachedFromWindow(View view) {
        mo3084c();
    }
}
