package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzfh implements Application.ActivityLifecycleCallbacks, View.OnAttachStateChangeListener, ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener {

    /* renamed from: m */
    private static final Handler f16389m = new Handler(Looper.getMainLooper());

    /* renamed from: a */
    private final Context f16390a;

    /* renamed from: b */
    private Application f16391b;
    @Nullable

    /* renamed from: c */
    private final PowerManager f16392c;
    @Nullable

    /* renamed from: d */
    private final KeyguardManager f16393d;

    /* renamed from: e */
    private BroadcastReceiver f16394e;

    /* renamed from: f */
    private final zzey f16395f;

    /* renamed from: g */
    private WeakReference<ViewTreeObserver> f16396g;
    @Nullable

    /* renamed from: h */
    private WeakReference<View> f16397h;

    /* renamed from: i */
    private ka0 f16398i;

    /* renamed from: j */
    private byte f16399j = -1;

    /* renamed from: k */
    private int f16400k = -1;

    /* renamed from: l */
    private long f16401l = -3;

    public zzfh(Context context, zzey zzey) {
        Context applicationContext = context.getApplicationContext();
        this.f16390a = applicationContext;
        this.f16395f = zzey;
        this.f16392c = (PowerManager) applicationContext.getSystemService("power");
        this.f16393d = (KeyguardManager) applicationContext.getSystemService("keyguard");
        if (applicationContext instanceof Application) {
            this.f16391b = (Application) applicationContext;
            this.f16398i = new ka0((Application) applicationContext, this);
        }
        mo17796f((View) null);
    }

    @Nullable
    /* renamed from: a */
    private final View m8933a() {
        WeakReference<View> weakReference = this.f16397h;
        if (weakReference != null) {
            return (View) weakReference.get();
        }
        return null;
    }

    /* renamed from: b */
    private final void m8934b(Activity activity, int i) {
        Window window;
        if (this.f16397h != null && (window = activity.getWindow()) != null) {
            View peekDecorView = window.peekDecorView();
            View a = m8933a();
            if (a != null && peekDecorView != null && a.getRootView() == peekDecorView.getRootView()) {
                this.f16400k = i;
            }
        }
    }

    /* renamed from: d */
    private final void m8936d() {
        f16389m.post(new ed0(this));
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0064, code lost:
        if (r7 == false) goto L_0x0067;
     */
    /* renamed from: e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m8937e() {
        /*
            r9 = this;
            java.lang.ref.WeakReference<android.view.View> r0 = r9.f16397h
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            android.view.View r0 = r9.m8933a()
            r1 = -1
            r2 = -3
            if (r0 != 0) goto L_0x0013
            r9.f16401l = r2
            r9.f16399j = r1
            return
        L_0x0013:
            int r4 = r0.getVisibility()
            r5 = 1
            r6 = 0
            if (r4 == 0) goto L_0x001d
            r4 = 1
            goto L_0x001e
        L_0x001d:
            r4 = 0
        L_0x001e:
            boolean r7 = r0.isShown()
            if (r7 != 0) goto L_0x0027
            r4 = r4 | 2
            byte r4 = (byte) r4
        L_0x0027:
            android.os.PowerManager r7 = r9.f16392c
            if (r7 == 0) goto L_0x0034
            boolean r7 = r7.isScreenOn()
            if (r7 != 0) goto L_0x0034
            r4 = r4 | 4
            byte r4 = (byte) r4
        L_0x0034:
            com.google.android.gms.internal.ads.zzey r7 = r9.f16395f
            boolean r7 = r7.mo17775a()
            if (r7 != 0) goto L_0x0068
            android.app.KeyguardManager r7 = r9.f16393d
            if (r7 == 0) goto L_0x0067
            boolean r7 = r7.inKeyguardRestrictedInputMode()
            if (r7 == 0) goto L_0x0067
            android.app.Activity r7 = com.google.android.gms.internal.ads.zzff.zzd(r0)
            if (r7 == 0) goto L_0x0063
            android.view.Window r7 = r7.getWindow()
            if (r7 != 0) goto L_0x0054
            r7 = 0
            goto L_0x0058
        L_0x0054:
            android.view.WindowManager$LayoutParams r7 = r7.getAttributes()
        L_0x0058:
            if (r7 == 0) goto L_0x0063
            int r7 = r7.flags
            r8 = 524288(0x80000, float:7.34684E-40)
            r7 = r7 & r8
            if (r7 == 0) goto L_0x0063
            r7 = 1
            goto L_0x0064
        L_0x0063:
            r7 = 0
        L_0x0064:
            if (r7 == 0) goto L_0x0067
            goto L_0x0068
        L_0x0067:
            r5 = 0
        L_0x0068:
            if (r5 != 0) goto L_0x006d
            r4 = r4 | 8
            byte r4 = (byte) r4
        L_0x006d:
            android.graphics.Rect r5 = new android.graphics.Rect
            r5.<init>()
            boolean r5 = r0.getGlobalVisibleRect(r5)
            if (r5 != 0) goto L_0x007b
            r4 = r4 | 16
            byte r4 = (byte) r4
        L_0x007b:
            android.graphics.Rect r5 = new android.graphics.Rect
            r5.<init>()
            boolean r5 = r0.getLocalVisibleRect(r5)
            if (r5 != 0) goto L_0x0089
            r4 = r4 | 32
            byte r4 = (byte) r4
        L_0x0089:
            int r0 = r0.getWindowVisibility()
            int r5 = r9.f16400k
            if (r5 == r1) goto L_0x0092
            r0 = r5
        L_0x0092:
            if (r0 == 0) goto L_0x0097
            r0 = r4 | 64
            byte r4 = (byte) r0
        L_0x0097:
            byte r0 = r9.f16399j
            if (r0 == r4) goto L_0x00a9
            r9.f16399j = r4
            if (r4 != 0) goto L_0x00a4
            long r0 = android.os.SystemClock.elapsedRealtime()
            goto L_0x00a7
        L_0x00a4:
            long r0 = (long) r4
            long r0 = r2 - r0
        L_0x00a7:
            r9.f16401l = r0
        L_0x00a9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfh.m8937e():void");
    }

    /* renamed from: g */
    private final void m8938g(View view) {
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            this.f16396g = new WeakReference<>(viewTreeObserver);
            viewTreeObserver.addOnScrollChangedListener(this);
            viewTreeObserver.addOnGlobalLayoutListener(this);
        }
        if (this.f16394e == null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            dd0 dd0 = new dd0(this);
            this.f16394e = dd0;
            this.f16390a.registerReceiver(dd0, intentFilter);
        }
        Application application = this.f16391b;
        if (application != null) {
            try {
                application.registerActivityLifecycleCallbacks(this.f16398i);
            } catch (Exception unused) {
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(11:0|1|2|(3:4|(1:8)|9)|10|11|(1:13)|15|(3:17|18|19)|21|(3:23|24|26)(1:28)) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x001b */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0025 A[Catch:{ Exception -> 0x002c }] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0031 A[SYNTHETIC, Splitter:B:17:0x0031] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x003c A[SYNTHETIC, Splitter:B:23:0x003c] */
    /* JADX WARNING: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /* renamed from: h */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m8939h(android.view.View r4) {
        /*
            r3 = this;
            r0 = 0
            java.lang.ref.WeakReference<android.view.ViewTreeObserver> r1 = r3.f16396g     // Catch:{ Exception -> 0x001b }
            if (r1 == 0) goto L_0x001b
            java.lang.Object r1 = r1.get()     // Catch:{ Exception -> 0x001b }
            android.view.ViewTreeObserver r1 = (android.view.ViewTreeObserver) r1     // Catch:{ Exception -> 0x001b }
            if (r1 == 0) goto L_0x0019
            boolean r2 = r1.isAlive()     // Catch:{ Exception -> 0x001b }
            if (r2 == 0) goto L_0x0019
            r1.removeOnScrollChangedListener(r3)     // Catch:{ Exception -> 0x001b }
            r1.removeGlobalOnLayoutListener(r3)     // Catch:{ Exception -> 0x001b }
        L_0x0019:
            r3.f16396g = r0     // Catch:{ Exception -> 0x001b }
        L_0x001b:
            android.view.ViewTreeObserver r4 = r4.getViewTreeObserver()     // Catch:{ Exception -> 0x002c }
            boolean r1 = r4.isAlive()     // Catch:{ Exception -> 0x002c }
            if (r1 == 0) goto L_0x002d
            r4.removeOnScrollChangedListener(r3)     // Catch:{ Exception -> 0x002c }
            r4.removeGlobalOnLayoutListener(r3)     // Catch:{ Exception -> 0x002c }
            goto L_0x002d
        L_0x002c:
        L_0x002d:
            android.content.BroadcastReceiver r4 = r3.f16394e
            if (r4 == 0) goto L_0x0038
            android.content.Context r1 = r3.f16390a     // Catch:{ Exception -> 0x0036 }
            r1.unregisterReceiver(r4)     // Catch:{ Exception -> 0x0036 }
        L_0x0036:
            r3.f16394e = r0
        L_0x0038:
            android.app.Application r4 = r3.f16391b
            if (r4 == 0) goto L_0x0041
            com.google.android.gms.internal.ads.ka0 r0 = r3.f16398i     // Catch:{ Exception -> 0x0041 }
            r4.unregisterActivityLifecycleCallbacks(r0)     // Catch:{ Exception -> 0x0041 }
        L_0x0041:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfh.m8939h(android.view.View):void");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public final void mo17796f(View view) {
        View a = m8933a();
        if (a != null) {
            a.removeOnAttachStateChangeListener(this);
            m8939h(a);
        }
        this.f16397h = new WeakReference<>(view);
        if (view != null) {
            if ((view.getWindowToken() == null && view.getWindowVisibility() == 8) ? false : true) {
                m8938g(view);
            }
            view.addOnAttachStateChangeListener(this);
            this.f16401l = -2;
            return;
        }
        this.f16401l = -3;
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        m8934b(activity, 0);
        m8937e();
    }

    public final void onActivityDestroyed(Activity activity) {
        m8937e();
    }

    public final void onActivityPaused(Activity activity) {
        m8934b(activity, 4);
        m8937e();
    }

    public final void onActivityResumed(Activity activity) {
        m8934b(activity, 0);
        m8937e();
        m8936d();
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        m8937e();
    }

    public final void onActivityStarted(Activity activity) {
        m8934b(activity, 0);
        m8937e();
    }

    public final void onActivityStopped(Activity activity) {
        m8937e();
    }

    public final void onGlobalLayout() {
        m8937e();
    }

    public final void onScrollChanged() {
        m8937e();
    }

    public final void onViewAttachedToWindow(View view) {
        this.f16400k = -1;
        m8938g(view);
        m8937e();
    }

    public final void onViewDetachedFromWindow(View view) {
        this.f16400k = -1;
        m8937e();
        m8936d();
        m8939h(view);
    }

    public final long zzcu() {
        if (this.f16401l <= -2 && m8933a() == null) {
            this.f16401l = -3;
        }
        return this.f16401l;
    }
}
