package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.ads.formats.UnifiedNativeAdAssetNames;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzccy extends zzaem implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, zzcdy {
    public static final String[] zzgeb = {NativeAppInstallAd.ASSET_MEDIA_VIDEO, NativeContentAd.ASSET_MEDIA_VIDEO, UnifiedNativeAdAssetNames.ASSET_MEDIA_VIDEO};

    /* renamed from: a */
    private final String f14101a;
    @GuardedBy("this")

    /* renamed from: b */
    private Map<String, WeakReference<View>> f14102b = new HashMap();

    /* renamed from: c */
    private FrameLayout f14103c;

    /* renamed from: d */
    private FrameLayout f14104d;

    /* renamed from: e */
    private zzdzc f14105e;

    /* renamed from: f */
    private View f14106f;

    /* renamed from: g */
    private final int f14107g;
    @GuardedBy("this")

    /* renamed from: h */
    private zzcbt f14108h;

    /* renamed from: i */
    private zzqq f14109i;

    /* renamed from: j */
    private IObjectWrapper f14110j = null;

    /* renamed from: k */
    private zzaee f14111k;

    /* renamed from: l */
    private boolean f14112l;

    /* renamed from: m */
    private boolean f14113m = false;

    public zzccy(FrameLayout frameLayout, FrameLayout frameLayout2, int i) {
        String str;
        this.f14103c = frameLayout;
        this.f14104d = frameLayout2;
        this.f14107g = 203404000;
        String canonicalName = frameLayout.getClass().getCanonicalName();
        if ("com.google.android.gms.ads.formats.NativeContentAdView".equals(canonicalName)) {
            str = NativeContentAd.ASSET_ATTRIBUTION_ICON_IMAGE;
        } else if ("com.google.android.gms.ads.formats.NativeAppInstallAdView".equals(canonicalName)) {
            str = NativeAppInstallAd.ASSET_ATTRIBUTION_ICON_IMAGE;
        } else {
            "com.google.android.gms.ads.formats.UnifiedNativeAdView".equals(canonicalName);
            str = "3012";
        }
        this.f14101a = str;
        zzp.zzln();
        zzazy.zza((View) frameLayout, (ViewTreeObserver.OnGlobalLayoutListener) this);
        zzp.zzln();
        zzazy.zza((View) frameLayout, (ViewTreeObserver.OnScrollChangedListener) this);
        this.f14105e = zzazj.zzegt;
        this.f14109i = new zzqq(this.f14103c.getContext(), this.f14103c);
        frameLayout.setOnTouchListener(this);
        frameLayout.setOnClickListener(this);
    }

    /* renamed from: a */
    private final synchronized void m7920a() {
        this.f14105e.execute(new C2175mh(this));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final /* synthetic */ void mo16689b() {
        if (this.f14106f == null) {
            View view = new View(this.f14103c.getContext());
            this.f14106f = view;
            view.setLayoutParams(new FrameLayout.LayoutParams(-1, 0));
        }
        if (this.f14103c != this.f14106f.getParent()) {
            this.f14103c.addView(this.f14106f);
        }
    }

    public final synchronized void destroy() {
        if (!this.f14113m) {
            zzcbt zzcbt = this.f14108h;
            if (zzcbt != null) {
                zzcbt.zzb(this);
                this.f14108h = null;
            }
            this.f14102b.clear();
            this.f14103c.removeAllViews();
            this.f14104d.removeAllViews();
            this.f14102b = null;
            this.f14103c = null;
            this.f14104d = null;
            this.f14106f = null;
            this.f14109i = null;
            this.f14113m = true;
        }
    }

    public final synchronized void onClick(View view) {
        zzcbt zzcbt = this.f14108h;
        if (zzcbt != null) {
            zzcbt.cancelUnconfirmedClick();
            this.f14108h.zza(view, this.f14103c, zzaoe(), zzaof(), false);
        }
    }

    public final synchronized void onGlobalLayout() {
        zzcbt zzcbt = this.f14108h;
        if (zzcbt != null) {
            zzcbt.zzb(this.f14103c, zzaoe(), zzaof(), zzcbt.zzz(this.f14103c));
        }
    }

    public final synchronized void onScrollChanged() {
        zzcbt zzcbt = this.f14108h;
        if (zzcbt != null) {
            zzcbt.zzb(this.f14103c, zzaoe(), zzaof(), zzcbt.zzz(this.f14103c));
        }
    }

    public final synchronized boolean onTouch(View view, MotionEvent motionEvent) {
        zzcbt zzcbt = this.f14108h;
        if (zzcbt != null) {
            zzcbt.zza(view, motionEvent, (View) this.f14103c);
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0040, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zza(java.lang.String r2, android.view.View r3, boolean r4) {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r4 = r1.f14113m     // Catch:{ all -> 0x0041 }
            if (r4 == 0) goto L_0x0007
            monitor-exit(r1)
            return
        L_0x0007:
            if (r3 != 0) goto L_0x0010
            java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r3 = r1.f14102b     // Catch:{ all -> 0x0041 }
            r3.remove(r2)     // Catch:{ all -> 0x0041 }
            monitor-exit(r1)
            return
        L_0x0010:
            java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r4 = r1.f14102b     // Catch:{ all -> 0x0041 }
            java.lang.ref.WeakReference r0 = new java.lang.ref.WeakReference     // Catch:{ all -> 0x0041 }
            r0.<init>(r3)     // Catch:{ all -> 0x0041 }
            r4.put(r2, r0)     // Catch:{ all -> 0x0041 }
            java.lang.String r4 = "1098"
            boolean r4 = r4.equals(r2)     // Catch:{ all -> 0x0041 }
            if (r4 != 0) goto L_0x003f
            java.lang.String r4 = "3011"
            boolean r2 = r4.equals(r2)     // Catch:{ all -> 0x0041 }
            if (r2 == 0) goto L_0x002b
            goto L_0x003f
        L_0x002b:
            int r2 = r1.f14107g     // Catch:{ all -> 0x0041 }
            boolean r2 = com.google.android.gms.ads.internal.util.zzbq.zzdi(r2)     // Catch:{ all -> 0x0041 }
            if (r2 == 0) goto L_0x0036
            r3.setOnTouchListener(r1)     // Catch:{ all -> 0x0041 }
        L_0x0036:
            r2 = 1
            r3.setClickable(r2)     // Catch:{ all -> 0x0041 }
            r3.setOnClickListener(r1)     // Catch:{ all -> 0x0041 }
            monitor-exit(r1)
            return
        L_0x003f:
            monitor-exit(r1)
            return
        L_0x0041:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzccy.zza(java.lang.String, android.view.View, boolean):void");
    }

    public final /* synthetic */ View zzaiz() {
        return this.f14103c;
    }

    public final FrameLayout zzaoc() {
        return this.f14104d;
    }

    public final zzqq zzaod() {
        return this.f14109i;
    }

    public final synchronized Map<String, WeakReference<View>> zzaoe() {
        return this.f14102b;
    }

    public final synchronized Map<String, WeakReference<View>> zzaof() {
        return this.f14102b;
    }

    @Nullable
    public final synchronized Map<String, WeakReference<View>> zzaog() {
        return null;
    }

    public final synchronized String zzaoh() {
        return this.f14101a;
    }

    @Nullable
    public final IObjectWrapper zzaoi() {
        return this.f14110j;
    }

    public final synchronized void zzb(String str, IObjectWrapper iObjectWrapper) {
        zza(str, (View) ObjectWrapper.unwrap(iObjectWrapper), true);
    }

    public final synchronized void zzc(IObjectWrapper iObjectWrapper, int i) {
    }

    public final synchronized IObjectWrapper zzco(String str) {
        return ObjectWrapper.wrap(zzgc(str));
    }

    public final synchronized void zze(IObjectWrapper iObjectWrapper) {
        this.f14108h.setClickConfirmingView((View) ObjectWrapper.unwrap(iObjectWrapper));
    }

    public final void zzf(IObjectWrapper iObjectWrapper) {
        onTouch(this.f14103c, (MotionEvent) ObjectWrapper.unwrap(iObjectWrapper));
    }

    public final synchronized void zzg(IObjectWrapper iObjectWrapper) {
        if (!this.f14113m) {
            this.f14110j = iObjectWrapper;
        }
    }

    public final synchronized View zzgc(String str) {
        if (this.f14113m) {
            return null;
        }
        WeakReference weakReference = this.f14102b.get(str);
        if (weakReference == null) {
            return null;
        }
        return (View) weakReference.get();
    }

    @Nullable
    public final synchronized JSONObject zzst() {
        zzcbt zzcbt = this.f14108h;
        if (zzcbt == null) {
            return null;
        }
        return zzcbt.zza((View) this.f14103c, zzaoe(), zzaof());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0045, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zza(com.google.android.gms.dynamic.IObjectWrapper r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = r1.f14113m     // Catch:{ all -> 0x0046 }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r1)
            return
        L_0x0007:
            java.lang.Object r2 = com.google.android.gms.dynamic.ObjectWrapper.unwrap(r2)     // Catch:{ all -> 0x0046 }
            boolean r0 = r2 instanceof com.google.android.gms.internal.ads.zzcbt     // Catch:{ all -> 0x0046 }
            if (r0 != 0) goto L_0x0016
            java.lang.String r2 = "Not an instance of native engine. This is most likely a transient error"
            com.google.android.gms.internal.ads.zzaza.zzfa(r2)     // Catch:{ all -> 0x0046 }
            monitor-exit(r1)
            return
        L_0x0016:
            com.google.android.gms.internal.ads.zzcbt r0 = r1.f14108h     // Catch:{ all -> 0x0046 }
            if (r0 == 0) goto L_0x001d
            r0.zzb(r1)     // Catch:{ all -> 0x0046 }
        L_0x001d:
            r1.m7920a()     // Catch:{ all -> 0x0046 }
            com.google.android.gms.internal.ads.zzcbt r2 = (com.google.android.gms.internal.ads.zzcbt) r2     // Catch:{ all -> 0x0046 }
            r1.f14108h = r2     // Catch:{ all -> 0x0046 }
            r2.zza((com.google.android.gms.internal.ads.zzcdy) r1)     // Catch:{ all -> 0x0046 }
            com.google.android.gms.internal.ads.zzcbt r2 = r1.f14108h     // Catch:{ all -> 0x0046 }
            android.widget.FrameLayout r0 = r1.f14103c     // Catch:{ all -> 0x0046 }
            r2.zzaa(r0)     // Catch:{ all -> 0x0046 }
            com.google.android.gms.internal.ads.zzcbt r2 = r1.f14108h     // Catch:{ all -> 0x0046 }
            android.widget.FrameLayout r0 = r1.f14104d     // Catch:{ all -> 0x0046 }
            r2.zzab(r0)     // Catch:{ all -> 0x0046 }
            boolean r2 = r1.f14112l     // Catch:{ all -> 0x0046 }
            if (r2 == 0) goto L_0x0044
            com.google.android.gms.internal.ads.zzcbt r2 = r1.f14108h     // Catch:{ all -> 0x0046 }
            com.google.android.gms.internal.ads.zzcbz r2 = r2.zzamz()     // Catch:{ all -> 0x0046 }
            com.google.android.gms.internal.ads.zzaee r0 = r1.f14111k     // Catch:{ all -> 0x0046 }
            r2.zza(r0)     // Catch:{ all -> 0x0046 }
        L_0x0044:
            monitor-exit(r1)
            return
        L_0x0046:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzccy.zza(com.google.android.gms.dynamic.IObjectWrapper):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0018, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zza(com.google.android.gms.internal.ads.zzaee r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = r1.f14113m     // Catch:{ all -> 0x0019 }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r1)
            return
        L_0x0007:
            r0 = 1
            r1.f14112l = r0     // Catch:{ all -> 0x0019 }
            r1.f14111k = r2     // Catch:{ all -> 0x0019 }
            com.google.android.gms.internal.ads.zzcbt r0 = r1.f14108h     // Catch:{ all -> 0x0019 }
            if (r0 == 0) goto L_0x0017
            com.google.android.gms.internal.ads.zzcbz r0 = r0.zzamz()     // Catch:{ all -> 0x0019 }
            r0.zza(r2)     // Catch:{ all -> 0x0019 }
        L_0x0017:
            monitor-exit(r1)
            return
        L_0x0019:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzccy.zza(com.google.android.gms.internal.ads.zzaee):void");
    }
}
