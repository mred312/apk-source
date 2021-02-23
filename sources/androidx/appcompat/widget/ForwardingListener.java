package androidx.appcompat.widget;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.ShowableListMenu;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public abstract class ForwardingListener implements View.OnTouchListener, View.OnAttachStateChangeListener {

    /* renamed from: a */
    private final float f1271a;

    /* renamed from: b */
    private final int f1272b;

    /* renamed from: c */
    private final int f1273c;

    /* renamed from: d */
    final View f1274d;

    /* renamed from: e */
    private Runnable f1275e;

    /* renamed from: f */
    private Runnable f1276f;

    /* renamed from: g */
    private boolean f1277g;

    /* renamed from: h */
    private int f1278h;

    /* renamed from: i */
    private final int[] f1279i = new int[2];

    /* renamed from: androidx.appcompat.widget.ForwardingListener$a */
    private class C0268a implements Runnable {
        C0268a() {
        }

        public void run() {
            ViewParent parent = ForwardingListener.this.f1274d.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }
    }

    /* renamed from: androidx.appcompat.widget.ForwardingListener$b */
    private class C0269b implements Runnable {
        C0269b() {
        }

        public void run() {
            ForwardingListener.this.mo2439b();
        }
    }

    public ForwardingListener(View view) {
        this.f1274d = view;
        view.setLongClickable(true);
        view.addOnAttachStateChangeListener(this);
        this.f1271a = (float) ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        int tapTimeout = ViewConfiguration.getTapTimeout();
        this.f1272b = tapTimeout;
        this.f1273c = (tapTimeout + ViewConfiguration.getLongPressTimeout()) / 2;
    }

    /* renamed from: a */
    private void m854a() {
        Runnable runnable = this.f1276f;
        if (runnable != null) {
            this.f1274d.removeCallbacks(runnable);
        }
        Runnable runnable2 = this.f1275e;
        if (runnable2 != null) {
            this.f1274d.removeCallbacks(runnable2);
        }
    }

    /* renamed from: c */
    private boolean m855c(MotionEvent motionEvent) {
        C0330k kVar;
        View view = this.f1274d;
        ShowableListMenu popup = getPopup();
        if (popup == null || !popup.isShowing() || (kVar = (C0330k) popup.getListView()) == null || !kVar.isShown()) {
            return false;
        }
        MotionEvent obtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
        m858f(view, obtainNoHistory);
        m859g(kVar, obtainNoHistory);
        boolean onForwardedEvent = kVar.onForwardedEvent(obtainNoHistory, this.f1278h);
        obtainNoHistory.recycle();
        int actionMasked = motionEvent.getActionMasked();
        boolean z = (actionMasked == 1 || actionMasked == 3) ? false : true;
        if (!onForwardedEvent || !z) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0017, code lost:
        if (r1 != 3) goto L_0x006d;
     */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m856d(android.view.MotionEvent r6) {
        /*
            r5 = this;
            android.view.View r0 = r5.f1274d
            boolean r1 = r0.isEnabled()
            r2 = 0
            if (r1 != 0) goto L_0x000a
            return r2
        L_0x000a:
            int r1 = r6.getActionMasked()
            if (r1 == 0) goto L_0x0041
            r3 = 1
            if (r1 == r3) goto L_0x003d
            r4 = 2
            if (r1 == r4) goto L_0x001a
            r6 = 3
            if (r1 == r6) goto L_0x003d
            goto L_0x006d
        L_0x001a:
            int r1 = r5.f1278h
            int r1 = r6.findPointerIndex(r1)
            if (r1 < 0) goto L_0x006d
            float r4 = r6.getX(r1)
            float r6 = r6.getY(r1)
            float r1 = r5.f1271a
            boolean r6 = m857e(r0, r4, r6, r1)
            if (r6 != 0) goto L_0x006d
            r5.m854a()
            android.view.ViewParent r6 = r0.getParent()
            r6.requestDisallowInterceptTouchEvent(r3)
            return r3
        L_0x003d:
            r5.m854a()
            goto L_0x006d
        L_0x0041:
            int r6 = r6.getPointerId(r2)
            r5.f1278h = r6
            java.lang.Runnable r6 = r5.f1275e
            if (r6 != 0) goto L_0x0052
            androidx.appcompat.widget.ForwardingListener$a r6 = new androidx.appcompat.widget.ForwardingListener$a
            r6.<init>()
            r5.f1275e = r6
        L_0x0052:
            java.lang.Runnable r6 = r5.f1275e
            int r1 = r5.f1272b
            long r3 = (long) r1
            r0.postDelayed(r6, r3)
            java.lang.Runnable r6 = r5.f1276f
            if (r6 != 0) goto L_0x0065
            androidx.appcompat.widget.ForwardingListener$b r6 = new androidx.appcompat.widget.ForwardingListener$b
            r6.<init>()
            r5.f1276f = r6
        L_0x0065:
            java.lang.Runnable r6 = r5.f1276f
            int r1 = r5.f1273c
            long r3 = (long) r1
            r0.postDelayed(r6, r3)
        L_0x006d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ForwardingListener.m856d(android.view.MotionEvent):boolean");
    }

    /* renamed from: e */
    private static boolean m857e(View view, float f, float f2, float f3) {
        float f4 = -f3;
        return f >= f4 && f2 >= f4 && f < ((float) (view.getRight() - view.getLeft())) + f3 && f2 < ((float) (view.getBottom() - view.getTop())) + f3;
    }

    /* renamed from: f */
    private boolean m858f(View view, MotionEvent motionEvent) {
        int[] iArr = this.f1279i;
        view.getLocationOnScreen(iArr);
        motionEvent.offsetLocation((float) iArr[0], (float) iArr[1]);
        return true;
    }

    /* renamed from: g */
    private boolean m859g(View view, MotionEvent motionEvent) {
        int[] iArr = this.f1279i;
        view.getLocationOnScreen(iArr);
        motionEvent.offsetLocation((float) (-iArr[0]), (float) (-iArr[1]));
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo2439b() {
        m854a();
        View view = this.f1274d;
        if (view.isEnabled() && !view.isLongClickable() && onForwardingStarted()) {
            view.getParent().requestDisallowInterceptTouchEvent(true);
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
            view.onTouchEvent(obtain);
            obtain.recycle();
            this.f1277g = true;
        }
    }

    public abstract ShowableListMenu getPopup();

    /* access modifiers changed from: protected */
    public boolean onForwardingStarted() {
        ShowableListMenu popup = getPopup();
        if (popup == null || popup.isShowing()) {
            return true;
        }
        popup.show();
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean onForwardingStopped() {
        ShowableListMenu popup = getPopup();
        if (popup == null || !popup.isShowing()) {
            return true;
        }
        popup.dismiss();
        return true;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z;
        boolean z2 = this.f1277g;
        if (z2) {
            z = m855c(motionEvent) || !onForwardingStopped();
        } else {
            z = m856d(motionEvent) && onForwardingStarted();
            if (z) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                this.f1274d.onTouchEvent(obtain);
                obtain.recycle();
            }
        }
        this.f1277g = z;
        if (z || z2) {
            return true;
        }
        return false;
    }

    public void onViewAttachedToWindow(View view) {
    }

    public void onViewDetachedFromWindow(View view) {
        this.f1277g = false;
        this.f1278h = -1;
        Runnable runnable = this.f1275e;
        if (runnable != null) {
            this.f1274d.removeCallbacks(runnable);
        }
    }
}
