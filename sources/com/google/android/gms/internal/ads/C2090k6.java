package com.google.android.gms.internal.ads;

import android.view.View;
import android.view.ViewTreeObserver;
import com.google.android.gms.ads.internal.zzp;
import java.lang.ref.WeakReference;

/* renamed from: com.google.android.gms.internal.ads.k6 */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C2090k6 extends C2127l6 implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: b */
    private final WeakReference<ViewTreeObserver.OnGlobalLayoutListener> f9567b;

    public C2090k6(View view, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        super(view);
        this.f9567b = new WeakReference<>(onGlobalLayoutListener);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public final void mo14298d(ViewTreeObserver viewTreeObserver) {
        viewTreeObserver.addOnGlobalLayoutListener(this);
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public final void mo14299e(ViewTreeObserver viewTreeObserver) {
        zzp.zzks();
        viewTreeObserver.removeOnGlobalLayoutListener(this);
    }

    public final void onGlobalLayout() {
        ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = (ViewTreeObserver.OnGlobalLayoutListener) this.f9567b.get();
        if (onGlobalLayoutListener != null) {
            onGlobalLayoutListener.onGlobalLayout();
        } else {
            mo14376b();
        }
    }
}
