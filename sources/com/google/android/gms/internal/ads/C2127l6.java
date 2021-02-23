package com.google.android.gms.internal.ads;

import android.view.View;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;

/* renamed from: com.google.android.gms.internal.ads.l6 */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
abstract class C2127l6 {

    /* renamed from: a */
    private final WeakReference<View> f9804a;

    public C2127l6(View view) {
        this.f9804a = new WeakReference<>(view);
    }

    /* renamed from: c */
    private final ViewTreeObserver m6442c() {
        ViewTreeObserver viewTreeObserver;
        View view = (View) this.f9804a.get();
        if (view == null || (viewTreeObserver = view.getViewTreeObserver()) == null || !viewTreeObserver.isAlive()) {
            return null;
        }
        return viewTreeObserver;
    }

    /* renamed from: a */
    public final void mo14375a() {
        ViewTreeObserver c = m6442c();
        if (c != null) {
            mo14298d(c);
        }
    }

    /* renamed from: b */
    public final void mo14376b() {
        ViewTreeObserver c = m6442c();
        if (c != null) {
            mo14299e(c);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public abstract void mo14298d(ViewTreeObserver viewTreeObserver);

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public abstract void mo14299e(ViewTreeObserver viewTreeObserver);
}
