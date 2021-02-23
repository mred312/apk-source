package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.ads.formats.UnifiedNativeAdAssetNames;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzccv extends zzaet implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, zzcdy {

    /* renamed from: a */
    private final WeakReference<View> f14094a;

    /* renamed from: b */
    private final Map<String, WeakReference<View>> f14095b = new HashMap();

    /* renamed from: c */
    private final Map<String, WeakReference<View>> f14096c = new HashMap();

    /* renamed from: d */
    private final Map<String, WeakReference<View>> f14097d = new HashMap();
    @GuardedBy("this")

    /* renamed from: e */
    private zzcbt f14098e;

    /* renamed from: f */
    private zzqq f14099f;

    public zzccv(View view, HashMap<String, View> hashMap, HashMap<String, View> hashMap2) {
        view.setOnTouchListener(this);
        view.setOnClickListener(this);
        zzp.zzln();
        zzazy.zza(view, (ViewTreeObserver.OnGlobalLayoutListener) this);
        zzp.zzln();
        zzazy.zza(view, (ViewTreeObserver.OnScrollChangedListener) this);
        this.f14094a = new WeakReference<>(view);
        for (Map.Entry next : hashMap.entrySet()) {
            String str = (String) next.getKey();
            View view2 = (View) next.getValue();
            if (view2 != null) {
                this.f14095b.put(str, new WeakReference(view2));
                if (!NativeAd.ASSET_ADCHOICES_CONTAINER_VIEW.equals(str) && !UnifiedNativeAdAssetNames.ASSET_ADCHOICES_CONTAINER_VIEW.equals(str)) {
                    view2.setOnTouchListener(this);
                    view2.setClickable(true);
                    view2.setOnClickListener(this);
                }
            }
        }
        this.f14097d.putAll(this.f14095b);
        for (Map.Entry next2 : hashMap2.entrySet()) {
            View view3 = (View) next2.getValue();
            if (view3 != null) {
                this.f14096c.put((String) next2.getKey(), new WeakReference(view3));
                view3.setOnTouchListener(this);
                view3.setClickable(false);
            }
        }
        this.f14097d.putAll(this.f14096c);
        this.f14099f = new zzqq(view.getContext(), view);
    }

    public final synchronized void onClick(View view) {
        zzcbt zzcbt = this.f14098e;
        if (zzcbt != null) {
            zzcbt.zza(view, zzaiz(), zzaoe(), zzaof(), true);
        }
    }

    public final synchronized void onGlobalLayout() {
        zzcbt zzcbt = this.f14098e;
        if (zzcbt != null) {
            zzcbt.zzb(zzaiz(), zzaoe(), zzaof(), zzcbt.zzz(zzaiz()));
        }
    }

    public final synchronized void onScrollChanged() {
        zzcbt zzcbt = this.f14098e;
        if (zzcbt != null) {
            zzcbt.zzb(zzaiz(), zzaoe(), zzaof(), zzcbt.zzz(zzaiz()));
        }
    }

    public final synchronized boolean onTouch(View view, MotionEvent motionEvent) {
        zzcbt zzcbt = this.f14098e;
        if (zzcbt != null) {
            zzcbt.zza(view, motionEvent, zzaiz());
        }
        return false;
    }

    public final synchronized void unregisterNativeAd() {
        zzcbt zzcbt = this.f14098e;
        if (zzcbt != null) {
            zzcbt.zzb(this);
            this.f14098e = null;
        }
    }

    public final synchronized void zza(IObjectWrapper iObjectWrapper) {
        Object unwrap = ObjectWrapper.unwrap(iObjectWrapper);
        if (!(unwrap instanceof zzcbt)) {
            zzaza.zzfa("Not an instance of InternalNativeAd. This is most likely a transient error");
            return;
        }
        zzcbt zzcbt = this.f14098e;
        if (zzcbt != null) {
            zzcbt.zzb(this);
        }
        if (((zzcbt) unwrap).zzamx()) {
            zzcbt zzcbt2 = (zzcbt) unwrap;
            this.f14098e = zzcbt2;
            zzcbt2.zza((zzcdy) this);
            this.f14098e.zzaa(zzaiz());
            return;
        }
        zzaza.zzey("Your account must be enabled to use this feature. Talk to your account manager to request this feature for your account.");
    }

    @Nullable
    public final View zzaiz() {
        return (View) this.f14094a.get();
    }

    @Nullable
    public final FrameLayout zzaoc() {
        return null;
    }

    public final zzqq zzaod() {
        return this.f14099f;
    }

    public final synchronized Map<String, WeakReference<View>> zzaoe() {
        return this.f14097d;
    }

    public final synchronized Map<String, WeakReference<View>> zzaof() {
        return this.f14095b;
    }

    @Nullable
    public final synchronized Map<String, WeakReference<View>> zzaog() {
        return this.f14096c;
    }

    public final synchronized String zzaoh() {
        return NativeContentAd.ASSET_ATTRIBUTION_ICON_IMAGE;
    }

    @Nullable
    public final synchronized IObjectWrapper zzaoi() {
        return null;
    }

    public final synchronized void zze(IObjectWrapper iObjectWrapper) {
        if (this.f14098e != null) {
            Object unwrap = ObjectWrapper.unwrap(iObjectWrapper);
            if (!(unwrap instanceof View)) {
                zzaza.zzfa("Calling NativeAdViewHolderNonagonDelegate.setClickConfirmingView with wrong wrapped object");
            }
            this.f14098e.setClickConfirmingView((View) unwrap);
        }
    }

    public final synchronized View zzgc(String str) {
        WeakReference weakReference = this.f14097d.get(str);
        if (weakReference == null) {
            return null;
        }
        return (View) weakReference.get();
    }

    @Nullable
    public final synchronized JSONObject zzst() {
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0046, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zza(java.lang.String r2, android.view.View r3, boolean r4) {
        /*
            r1 = this;
            monitor-enter(r1)
            if (r3 != 0) goto L_0x0014
            java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r3 = r1.f14097d     // Catch:{ all -> 0x0047 }
            r3.remove(r2)     // Catch:{ all -> 0x0047 }
            java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r3 = r1.f14095b     // Catch:{ all -> 0x0047 }
            r3.remove(r2)     // Catch:{ all -> 0x0047 }
            java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r3 = r1.f14096c     // Catch:{ all -> 0x0047 }
            r3.remove(r2)     // Catch:{ all -> 0x0047 }
            monitor-exit(r1)
            return
        L_0x0014:
            java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r4 = r1.f14097d     // Catch:{ all -> 0x0047 }
            java.lang.ref.WeakReference r0 = new java.lang.ref.WeakReference     // Catch:{ all -> 0x0047 }
            r0.<init>(r3)     // Catch:{ all -> 0x0047 }
            r4.put(r2, r0)     // Catch:{ all -> 0x0047 }
            java.lang.String r4 = "1098"
            boolean r4 = r4.equals(r2)     // Catch:{ all -> 0x0047 }
            if (r4 != 0) goto L_0x0045
            java.lang.String r4 = "3011"
            boolean r4 = r4.equals(r2)     // Catch:{ all -> 0x0047 }
            if (r4 == 0) goto L_0x002f
            goto L_0x0045
        L_0x002f:
            java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r4 = r1.f14095b     // Catch:{ all -> 0x0047 }
            java.lang.ref.WeakReference r0 = new java.lang.ref.WeakReference     // Catch:{ all -> 0x0047 }
            r0.<init>(r3)     // Catch:{ all -> 0x0047 }
            r4.put(r2, r0)     // Catch:{ all -> 0x0047 }
            r2 = 1
            r3.setClickable(r2)     // Catch:{ all -> 0x0047 }
            r3.setOnClickListener(r1)     // Catch:{ all -> 0x0047 }
            r3.setOnTouchListener(r1)     // Catch:{ all -> 0x0047 }
            monitor-exit(r1)
            return
        L_0x0045:
            monitor-exit(r1)
            return
        L_0x0047:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzccv.zza(java.lang.String, android.view.View, boolean):void");
    }
}
