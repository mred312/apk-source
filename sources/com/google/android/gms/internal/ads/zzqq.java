package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.PowerManager;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.util.zzbs;
import com.google.android.gms.ads.internal.util.zzm;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.util.VisibleForTesting;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

@TargetApi(14)
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzqq implements Application.ActivityLifecycleCallbacks, View.OnAttachStateChangeListener, ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener {

    /* renamed from: p */
    private static final long f16895p = ((Long) zzwq.zzqe().zzd(zzabf.zzcpu)).longValue();

    /* renamed from: a */
    private final Context f16896a;

    /* renamed from: b */
    private Application f16897b;

    /* renamed from: c */
    private final WindowManager f16898c;

    /* renamed from: d */
    private final PowerManager f16899d;

    /* renamed from: e */
    private final KeyguardManager f16900e;
    @Nullable
    @VisibleForTesting

    /* renamed from: f */
    private BroadcastReceiver f16901f;

    /* renamed from: g */
    private WeakReference<ViewTreeObserver> f16902g;

    /* renamed from: h */
    private WeakReference<View> f16903h;

    /* renamed from: i */
    private gh0 f16904i;

    /* renamed from: j */
    private zzbs f16905j = new zzbs(f16895p);

    /* renamed from: k */
    private boolean f16906k = false;

    /* renamed from: l */
    private int f16907l = -1;

    /* renamed from: m */
    private final HashSet<zzqu> f16908m = new HashSet<>();

    /* renamed from: n */
    private final DisplayMetrics f16909n;

    /* renamed from: o */
    private final Rect f16910o;

    public zzqq(Context context, View view) {
        Context applicationContext = context.getApplicationContext();
        this.f16896a = applicationContext;
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        this.f16898c = windowManager;
        this.f16899d = (PowerManager) applicationContext.getSystemService("power");
        this.f16900e = (KeyguardManager) context.getSystemService("keyguard");
        if (applicationContext instanceof Application) {
            this.f16897b = (Application) applicationContext;
            this.f16904i = new gh0((Application) applicationContext, this);
        }
        this.f16909n = context.getResources().getDisplayMetrics();
        Rect rect = new Rect();
        this.f16910o = rect;
        rect.right = windowManager.getDefaultDisplay().getWidth();
        rect.bottom = windowManager.getDefaultDisplay().getHeight();
        WeakReference<View> weakReference = this.f16903h;
        View view2 = weakReference != null ? (View) weakReference.get() : null;
        if (view2 != null) {
            view2.removeOnAttachStateChangeListener(this);
            m9075h(view2);
        }
        this.f16903h = new WeakReference<>(view);
        if (view != null) {
            if (zzp.zzks().isAttachedToWindow(view)) {
                m9074g(view);
            }
            view.addOnAttachStateChangeListener(this);
        }
    }

    /* renamed from: a */
    private final Rect m9068a(Rect rect) {
        return new Rect(m9072e(rect.left), m9072e(rect.top), m9072e(rect.right), m9072e(rect.bottom));
    }

    /* renamed from: b */
    private final void m9069b(Activity activity, int i) {
        Window window;
        if (this.f16903h != null && (window = activity.getWindow()) != null) {
            View peekDecorView = window.peekDecorView();
            View view = (View) this.f16903h.get();
            if (view != null && peekDecorView != null && view.getRootView() == peekDecorView.getRootView()) {
                this.f16907l = i;
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00cf A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00d0  */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m9071d(int r32) {
        /*
            r31 = this;
            r1 = r31
            r2 = r32
            java.util.HashSet<com.google.android.gms.internal.ads.zzqu> r0 = r1.f16908m
            int r0 = r0.size()
            if (r0 != 0) goto L_0x000d
            return
        L_0x000d:
            java.lang.ref.WeakReference<android.view.View> r0 = r1.f16903h
            if (r0 != 0) goto L_0x0012
            return
        L_0x0012:
            java.lang.Object r0 = r0.get()
            r3 = r0
            android.view.View r3 = (android.view.View) r3
            r4 = 0
            r5 = 1
            if (r2 != r5) goto L_0x001f
            r6 = 1
            goto L_0x0020
        L_0x001f:
            r6 = 0
        L_0x0020:
            if (r3 != 0) goto L_0x0024
            r7 = 1
            goto L_0x0025
        L_0x0024:
            r7 = 0
        L_0x0025:
            android.graphics.Rect r8 = new android.graphics.Rect
            r8.<init>()
            android.graphics.Rect r9 = new android.graphics.Rect
            r9.<init>()
            android.graphics.Rect r10 = new android.graphics.Rect
            r10.<init>()
            android.graphics.Rect r11 = new android.graphics.Rect
            r11.<init>()
            r0 = 2
            int[] r12 = new int[r0]
            int[] r0 = new int[r0]
            if (r3 == 0) goto L_0x0075
            boolean r13 = r3.getGlobalVisibleRect(r9)
            boolean r14 = r3.getLocalVisibleRect(r10)
            r3.getHitRect(r11)
            r3.getLocationOnScreen(r12)     // Catch:{ Exception -> 0x0052 }
            r3.getLocationInWindow(r0)     // Catch:{ Exception -> 0x0052 }
            goto L_0x0058
        L_0x0052:
            r0 = move-exception
            java.lang.String r15 = "Failure getting view location."
            com.google.android.gms.internal.ads.zzaza.zzc(r15, r0)
        L_0x0058:
            r0 = r12[r4]
            r8.left = r0
            r12 = r12[r5]
            r8.top = r12
            int r12 = r3.getWidth()
            int r0 = r0 + r12
            r8.right = r0
            int r0 = r8.top
            int r12 = r3.getHeight()
            int r0 = r0 + r12
            r8.bottom = r0
            r24 = r13
            r26 = r14
            goto L_0x0079
        L_0x0075:
            r24 = 0
            r26 = 0
        L_0x0079:
            com.google.android.gms.internal.ads.zzaaq<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzabf.zzcpx
            com.google.android.gms.internal.ads.zzabb r12 = com.google.android.gms.internal.ads.zzwq.zzqe()
            java.lang.Object r0 = r12.zzd(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x0092
            if (r3 == 0) goto L_0x0092
            java.util.List r0 = r1.m9076i(r3)
            goto L_0x0096
        L_0x0092:
            java.util.List r0 = java.util.Collections.emptyList()
        L_0x0096:
            r30 = r0
            r0 = 8
            if (r3 == 0) goto L_0x00a1
            int r12 = r3.getWindowVisibility()
            goto L_0x00a3
        L_0x00a1:
            r12 = 8
        L_0x00a3:
            int r13 = r1.f16907l
            r14 = -1
            if (r13 == r14) goto L_0x00a9
            r12 = r13
        L_0x00a9:
            if (r7 != 0) goto L_0x00c0
            com.google.android.gms.ads.internal.zzp.zzkq()
            android.os.PowerManager r7 = r1.f16899d
            android.app.KeyguardManager r13 = r1.f16900e
            boolean r7 = com.google.android.gms.ads.internal.util.zzm.zza((android.view.View) r3, (android.os.PowerManager) r7, (android.app.KeyguardManager) r13)
            if (r7 == 0) goto L_0x00c0
            if (r24 == 0) goto L_0x00c0
            if (r26 == 0) goto L_0x00c0
            if (r12 != 0) goto L_0x00c0
            r7 = 1
            goto L_0x00c1
        L_0x00c0:
            r7 = 0
        L_0x00c1:
            if (r6 == 0) goto L_0x00d0
            com.google.android.gms.ads.internal.util.zzbs r6 = r1.f16905j
            boolean r6 = r6.tryAcquire()
            if (r6 != 0) goto L_0x00d0
            boolean r6 = r1.f16906k
            if (r7 != r6) goto L_0x00d0
            return
        L_0x00d0:
            if (r7 != 0) goto L_0x00d9
            boolean r6 = r1.f16906k
            if (r6 != 0) goto L_0x00d9
            if (r2 != r5) goto L_0x00d9
            return
        L_0x00d9:
            com.google.android.gms.internal.ads.zzqv r2 = new com.google.android.gms.internal.ads.zzqv
            com.google.android.gms.common.util.Clock r6 = com.google.android.gms.ads.internal.zzp.zzkx()
            long r16 = r6.elapsedRealtime()
            android.os.PowerManager r6 = r1.f16899d
            boolean r18 = r6.isScreenOn()
            if (r3 == 0) goto L_0x00f8
            com.google.android.gms.ads.internal.util.zzu r6 = com.google.android.gms.ads.internal.zzp.zzks()
            boolean r6 = r6.isAttachedToWindow(r3)
            if (r6 == 0) goto L_0x00f8
            r19 = 1
            goto L_0x00fa
        L_0x00f8:
            r19 = 0
        L_0x00fa:
            if (r3 == 0) goto L_0x0103
            int r0 = r3.getWindowVisibility()
            r20 = r0
            goto L_0x0105
        L_0x0103:
            r20 = 8
        L_0x0105:
            android.graphics.Rect r0 = r1.f16910o
            android.graphics.Rect r21 = r1.m9068a(r0)
            android.graphics.Rect r22 = r1.m9068a(r8)
            android.graphics.Rect r23 = r1.m9068a(r9)
            android.graphics.Rect r25 = r1.m9068a(r10)
            android.graphics.Rect r27 = r1.m9068a(r11)
            android.util.DisplayMetrics r0 = r1.f16909n
            float r0 = r0.density
            r15 = r2
            r28 = r0
            r29 = r7
            r15.<init>(r16, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30)
            java.util.HashSet<com.google.android.gms.internal.ads.zzqu> r0 = r1.f16908m
            java.util.Iterator r0 = r0.iterator()
        L_0x012d:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x013d
            java.lang.Object r3 = r0.next()
            com.google.android.gms.internal.ads.zzqu r3 = (com.google.android.gms.internal.ads.zzqu) r3
            r3.zza(r2)
            goto L_0x012d
        L_0x013d:
            r1.f16906k = r7
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzqq.m9071d(int):void");
    }

    /* renamed from: e */
    private final int m9072e(int i) {
        return (int) (((float) i) / this.f16909n.density);
    }

    /* renamed from: f */
    private final void m9073f() {
        zzm.zzedd.post(new eh0(this));
    }

    /* renamed from: g */
    private final void m9074g(View view) {
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            this.f16902g = new WeakReference<>(viewTreeObserver);
            viewTreeObserver.addOnScrollChangedListener(this);
            viewTreeObserver.addOnGlobalLayoutListener(this);
        }
        if (this.f16901f == null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            this.f16901f = new dh0(this);
            zzp.zzll().zza(this.f16896a, this.f16901f, intentFilter);
        }
        Application application = this.f16897b;
        if (application != null) {
            try {
                application.registerActivityLifecycleCallbacks(this.f16904i);
            } catch (Exception e) {
                zzaza.zzc("Error registering activity lifecycle callbacks.", e);
            }
        }
    }

    /* renamed from: h */
    private final void m9075h(View view) {
        try {
            WeakReference<ViewTreeObserver> weakReference = this.f16902g;
            if (weakReference != null) {
                ViewTreeObserver viewTreeObserver = (ViewTreeObserver) weakReference.get();
                if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                    viewTreeObserver.removeOnScrollChangedListener(this);
                    viewTreeObserver.removeGlobalOnLayoutListener(this);
                }
                this.f16902g = null;
            }
        } catch (Exception e) {
            zzaza.zzc("Error while unregistering listeners from the last ViewTreeObserver.", e);
        }
        try {
            ViewTreeObserver viewTreeObserver2 = view.getViewTreeObserver();
            if (viewTreeObserver2.isAlive()) {
                viewTreeObserver2.removeOnScrollChangedListener(this);
                viewTreeObserver2.removeGlobalOnLayoutListener(this);
            }
        } catch (Exception e2) {
            zzaza.zzc("Error while unregistering listeners from the ViewTreeObserver.", e2);
        }
        if (this.f16901f != null) {
            try {
                zzp.zzll().zza(this.f16896a, this.f16901f);
            } catch (IllegalStateException e3) {
                zzaza.zzc("Failed trying to unregister the receiver", e3);
            } catch (Exception e4) {
                zzp.zzku().zza(e4, "ActiveViewUnit.stopScreenStatusMonitoring");
            }
            this.f16901f = null;
        }
        Application application = this.f16897b;
        if (application != null) {
            try {
                application.unregisterActivityLifecycleCallbacks(this.f16904i);
            } catch (Exception e5) {
                zzaza.zzc("Error registering activity lifecycle callbacks.", e5);
            }
        }
    }

    /* renamed from: i */
    private final List<Rect> m9076i(View view) {
        try {
            ArrayList arrayList = new ArrayList();
            for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
                View view2 = (View) parent;
                Rect rect = new Rect();
                if (view2.isScrollContainer() && view2.getGlobalVisibleRect(rect)) {
                    arrayList.add(m9068a(rect));
                }
            }
            return arrayList;
        } catch (Exception e) {
            zzp.zzku().zza(e, "PositionWatcher.getParentScrollViewRects");
            return Collections.emptyList();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public final /* synthetic */ void mo18146j() {
        m9071d(3);
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        m9069b(activity, 0);
        m9071d(3);
        m9073f();
    }

    public final void onActivityDestroyed(Activity activity) {
        m9071d(3);
        m9073f();
    }

    public final void onActivityPaused(Activity activity) {
        m9069b(activity, 4);
        m9071d(3);
        m9073f();
    }

    public final void onActivityResumed(Activity activity) {
        m9069b(activity, 0);
        m9071d(3);
        m9073f();
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        m9071d(3);
        m9073f();
    }

    public final void onActivityStarted(Activity activity) {
        m9069b(activity, 0);
        m9071d(3);
        m9073f();
    }

    public final void onActivityStopped(Activity activity) {
        m9071d(3);
        m9073f();
    }

    public final void onGlobalLayout() {
        m9071d(2);
        m9073f();
    }

    public final void onScrollChanged() {
        m9071d(1);
    }

    public final void onViewAttachedToWindow(View view) {
        this.f16907l = -1;
        m9074g(view);
        m9071d(3);
    }

    public final void onViewDetachedFromWindow(View view) {
        this.f16907l = -1;
        m9071d(3);
        m9073f();
        m9075h(view);
    }

    public final void zza(zzqu zzqu) {
        this.f16908m.add(zzqu);
        m9071d(3);
    }

    public final void zzb(zzqu zzqu) {
        this.f16908m.remove(zzqu);
    }

    public final void zzen(long j) {
        this.f16905j.zzfb(j);
    }

    public final void zzls() {
        this.f16905j.zzfb(f16895p);
    }
}
